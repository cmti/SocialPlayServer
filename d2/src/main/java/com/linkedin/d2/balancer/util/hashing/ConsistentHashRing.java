/*
   Copyright (c) 2012 LinkedIn Corp.

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/

package com.linkedin.d2.balancer.util.hashing;

import static com.linkedin.d2.discovery.util.LogUtil.debug;
import static com.linkedin.d2.discovery.util.LogUtil.error;
import static com.linkedin.d2.discovery.util.LogUtil.warn;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Implements a point-based consistent hash ring. When an object is added to the ring, an
 * arbitrary amount of points are specified for that item. When "get" is called, a key is
 * given. Based on the key, the algorithm will deterministically pick an object in the
 * ring with probability based on the number of points it has relative to the total amount
 * points in the ring.
 *
 * @param <T>
 */
public class ConsistentHashRing<T> implements Ring<T>
{
  private static final Logger  _log = LoggerFactory.getLogger(ConsistentHashRing.class);
  private static final Charset UTF8 = Charset.forName("UTF-8");

  private final MessageDigest  _md;
  private final SortedSet<Point<T>> _points;

  private T[]                  _objects;
  private int[]                _ring;

  public ConsistentHashRing(Map<T, Integer> pointMap)
  {
    _points = new TreeSet<Point<T>>();

    try
    {
      _md = MessageDigest.getInstance("MD5");
    }
    catch (NoSuchAlgorithmException e)
    {
      error(_log, "unable to get md5 hash function");

      throw new RuntimeException(e);
    }

    add(pointMap);
  }

  public ConsistentHashRing(Map<T, Integer> pointMap, MessageDigest md)
  {
    _points = new TreeSet<Point<T>>();
    _md = md;

    add(pointMap);
  }

  /**
   * Add objects to the ring with the specified number of points.
   */
  @SuppressWarnings("unchecked")
  protected void add(Map<T, Integer> pointMap)
  {
    for (Entry<T, Integer> point : pointMap.entrySet())
    {
      T t = point.getKey();
      int points = point.getValue();

      if (t == null)
      {
        warn(_log, "tried to add a null value to consistent hash ring");

        throw new NullPointerException("null values in hash ring are unsupported");
      }

      byte[] bytesToHash = t.toString().getBytes(UTF8);

      // start the bytes to hash as the node's uri
      byte[] hash = null;

      for (int i = 0; i < points; ++i)
      {
        int iMod4 = i % 4;
        int iMod4TimesFour = iMod4 * 4;

        // if we've used the same hash 4 times, reset it
        if (iMod4 == 0)
        {
          hash = _md.digest(bytesToHash);

          // Roll the new hash as the next set of bytes to hash. This way we continue
          // generating unique hashes for a given client URI.
          bytesToHash = hash;
        }

        // compute a hash from MIN_INT to MAX_INT
        int hashInt =
            hash[iMod4TimesFour] + (hash[iMod4TimesFour + 1] << 8)
                + (hash[iMod4TimesFour + 2] << 16) + (hash[iMod4TimesFour + 3] << 24);

        _points.add(new Point<T>(t, hashInt));
      }
    }

    _objects = (T[]) new Object[_points.size()];
    _ring = new int[_points.size()];

    int i = 0;

    for (Point<T> point : _points)
    {
      _objects[i] = point.getT();
      _ring[i] = point.getHash();
      ++i;
    }

    debug(_log, "re-initializing consistent hash ring with items: ", _objects);
  }

  private int getIndex(int key)
  {
    debug(_log, "searching for hash in ring of size ", _ring.length, " using hash: ", key);

    int index = Arrays.binarySearch(_ring, key);

    // if the index is negative, then no exact match was found, and the search function is
    // returning (-(insertionPoint) - 1).
    if (index < 0)
    {
      index = Math.abs(index + 1);
    }

    index = index % _objects.length;

    return index;
  }

  /**
   * Deterministically pick an object in the ring based on the specified key. As long as
   * the ring doesn't change, the same key will always yield the same object.
   */
  public T get(int key)
  {
    if (_objects.length <= 0)
    {
      debug(_log, "get called on a hash ring with nothing in it");

      return null;
    }

    int index = getIndex(key);

    return _objects[index];
  }

  /**
   * Get a ConsistentHashRingIterator starting from a specified point.
   *
   * @param key The iteration will start from the point corresponded by this key
   * @return An Iterator with no objects when the hash ring is empty
   */
  @Override
  public Iterator<T> getIterator(int key)
  {
    if (_objects.length <= 0)
    {
      debug(_log, "get called on a hash ring with nothing in it");

      return new ConsistentHashRingIterator<T>(_objects, 0);
    }

    int from = getIndex(key);

    return new ConsistentHashRingIterator<T>(_objects, from);
  }

  public Set<Point<T>> getPoints()
  {
    return _points;
  }

  public Object[] getObjects()
  {
    return _objects;
  }

  public int[] getRing()
  {
    return _ring;
  }

  String printRingArea()
  {
    if (_points != null && !_points.isEmpty())
    {
      Map<T, Double> coverageMap = new HashMap<T, Double>();
      Double curr = new Double(Integer.MIN_VALUE);
      T firstElement = null;
      //we know points are sortedSet and the iterator is iterating from low to high
      for (Point<T> point : _points)
      {
        if (firstElement == null)
        {
          firstElement = point.getT();
        }
        Double currentCoverage = point.getHash() - curr;
        curr = new Double(point.getHash());
        Double area = coverageMap.get(point.getT());
        if (area == null)
        {
          area = 0.0;
        }
        area += currentCoverage;
        coverageMap.put(point.getT(), area);
      }
      //don't forget to take into account the last chunk of area
      Double remainingArea = new Double(Integer.MAX_VALUE - curr);
      Double area = coverageMap.get(firstElement);
      area += remainingArea;
      coverageMap.put(firstElement, area);
      StringBuilder builder = new StringBuilder();
      builder.append("Area percentage in the hash ring is [");
      Double sizeOfInt = new Double(Integer.MAX_VALUE) - new Double(Integer.MIN_VALUE);
      for (Map.Entry<T, Double> entry : coverageMap.entrySet())
      {
        Double percentage = entry.getValue() * 100 / sizeOfInt;
        builder.append(String.format("%s=%.2f%%, ",entry.getKey(), percentage));
      }
      builder.append("]");
      return builder.toString();
    }
    return "Ring is currently null or empty";
  }

  @Override
  public String toString()
  {
    return "ConsistentHashRing [_md=" + _md + printRingArea() + "]";
  }

  /**
   * A wrapper class that associates an object with a given point (hash) in the ring.
   */
  public static class Point<T> implements Comparable<Point<T>>
  {
    private final T   _t;
    private final int _hash;

    public Point(T t, int hash)
    {
      _t = t;
      _hash = hash;
    }

    public T getT()
    {
      return _t;
    }

    public int getHash()
    {
      return _hash;
    }

    @Override
    public int compareTo(Point<T> o)
    {
      return (_hash < o._hash) ? -1 : ((_hash == o._hash) ? 0 : 1);
    }

    @Override
    public String toString()
    {
      return "Point [_hash=" + _hash + ", _t=" + _t + "]";
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object o)
    {
      if (o == null || !(o instanceof Point))
      {
        return false;
      }
      Point<T> p = (Point<T>) o;
      return _t.equals(p._t) && _hash == p._hash;
    }

    @Override
    public int hashCode()
    {
      int hashCode = _t == null ? 1 : _t.hashCode() * 31;
      hashCode = 31 * hashCode * _hash;
      return hashCode;
    }
  }

  @SuppressWarnings("unchecked")
  @Override
  public boolean equals(Object o)
  {
    if (o == null || !(o instanceof  ConsistentHashRing))
    {
      return false;
    }
    ConsistentHashRing<T> ring = (ConsistentHashRing<T>) o;
    return this._points.equals(ring._points) &&
        Arrays.equals(_objects, ring._objects) &&
        Arrays.equals(_ring, ring._ring);
  }

  @Override
  public int hashCode()
  {
    int hashCode = _points == null ? 1 : _points.hashCode() * 31;
    hashCode = 31 * hashCode * (_objects == null ? 1 : _objects.hashCode());
    hashCode = 31 * hashCode * (_ring == null ? 1 : _ring.hashCode());
    return hashCode;
  }
}

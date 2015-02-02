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

/**
 * $Id: $
 */

package com.linkedin.restli.client;


import com.linkedin.data.schema.PathSpec;
import com.linkedin.data.template.DataTemplateUtil;
import com.linkedin.restli.client.base.BuilderBase;
import com.linkedin.restli.common.CompoundKey;
import com.linkedin.restli.common.ResourceSpec;
import com.linkedin.restli.common.RestConstants;
import com.linkedin.util.ArgumentUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


/**
 * @author Josh Walker
 * @version $Revision: $
 */

public abstract class AbstractRequestBuilder<K, V, R extends Request<?>> extends BuilderBase implements RequestBuilder<R>
{
  protected static final char HEADER_DELIMITER = ',';

  protected final ResourceSpec        _resourceSpec;
  protected final CompoundKey         _assocKey    = new CompoundKey();
  protected final Map<String, Object> _pathKeys    = new HashMap<String, Object>();
  protected final Map<String, Object> _queryParams = new HashMap<String, Object>();
  protected Map<String, String>       _headers     = new HashMap<String, String>();

  @Deprecated
  protected AbstractRequestBuilder(String baseURITemplate, ResourceSpec resourceSpec)
  {
    this(baseURITemplate, resourceSpec, RestliRequestOptions.DEFAULT_OPTIONS);
  }

  protected AbstractRequestBuilder(String baseUriTemplate, ResourceSpec resourceSpec, RestliRequestOptions requestOptions)
  {
    super(baseUriTemplate, requestOptions);
    _resourceSpec = resourceSpec;
    _requestOptions = requestOptions;
  }

  /**
   * Create a header with the specified value if there is no existing name
   * Otherwise, overwrite the existing header with the specified value to the existing value
   *
   * @param name name of the header
   * @param value value of the header
   * @return this {@link AbstractRequestBuilder}
   */
  @Deprecated
  public AbstractRequestBuilder<K, V, R> header(String name, String value)
  {
    return setHeader(name, value);
  }

  /**
   * Create a header with the specified value if there is no existing name.
   * Otherwise, append the specified value to the existing value, delimited by comma
   *
   * @param name name of the header
   * @param value value of the header. If null, this method is no-op.
   */
  public AbstractRequestBuilder<K, V, R> addHeader(String name, String value)
  {
    if (value != null)
    {
      final String currValue = _headers.get(name);
      final String newValue = currValue == null ? value : currValue + HEADER_DELIMITER + value;
      _headers.put(name, newValue);
    }

    return this;
  }

  /**
   * Create a header with the specified value if there is no existing name
   * Otherwise, overwrite the existing header with the specified value to the existing value
   *
   * @param name name of the header
   * @param value value of the header
   */
  public AbstractRequestBuilder<K, V, R> setHeader(String name, String value)
  {
    _headers.put(name, value);

    return this;
  }

  /**
   * Use the specified headers to replace the existing headers
   * All old headers will be lost
   *
   * @param headers new headers
   */
  public AbstractRequestBuilder<K, V, R> setHeaders(Map<String, String> headers)
  {
    _headers = new HashMap<String, String>(headers);
    return this;
  }

  public AbstractRequestBuilder<K, V, R> setReqParam(String key, Object value)
  {
    ArgumentUtil.notNull(value, "value");
    return setParam(key, value);
  }

  public AbstractRequestBuilder<K, V, R> setParam(String key, Object value)
  {
    if (value == null)
    {
      return this;
    }
    _queryParams.put(key, value);
    return this;
  }

  public AbstractRequestBuilder<K, V, R> addReqParam(String key, Object value)
  {
    ArgumentUtil.notNull(value, "value");
    return addParam(key, value);
  }

  @SuppressWarnings("unchecked")
  public AbstractRequestBuilder<K, V, R> addParam(String key, Object value)
  {
    if (value == null)
    {
      return this;
    }

    final Object existingData = _queryParams.get(key);
    if (existingData == null)
    {
      final Collection<Object> newData = new ArrayList<Object>();
      newData.add(value);
      setParam(key, newData);
    }
    else if (existingData instanceof Collection)
    {
      ((Collection<Object>) existingData).add(value);
    }
    else if (existingData instanceof Iterable)
    {
      final Collection<Object> newData = new ArrayList<Object>();
      for (Object d : (Iterable) existingData)
      {
        newData.add(d);
      }
      newData.add(value);
      setParam(key, newData);
    }
    else
    {
      throw new IllegalStateException("Query parameter is already set to non-iterable value. Reset with null value then add new query parameter.");
    }

    return this;
  }

  public AbstractRequestBuilder<K, V, R> pathKey(String name, Object value)
  {
    _pathKeys.put(name, value);
    return this;
  }

  /**
   * Sets {@link RestliRequestOptions} for this {@link Request}.
   * This method overrides any {@link RestliRequestOptions} that have already been set for this {@link Request}.
   * The recommended way to use this method would be to get the original {@link RestliRequestOptions} using the
   * {@link #getRequestOptions()} method, creating a new {@link RestliRequestOptionsBuilder} using the
   * {@link RestliRequestOptionsBuilder#RestliRequestOptionsBuilder(RestliRequestOptions)} constructor, modifying
   * the option you want to change, calling the {@link com.linkedin.restli.client.RestliRequestOptionsBuilder#build()}
   * method and setting that as the {@link RestliRequestOptions} for this method.
   *
   * @param options
   * @return
   */
  public AbstractRequestBuilder<K, V, R> setRequestOptions(RestliRequestOptions options)
  {
    _requestOptions = options;
    return this;
  }

  /**
   * To be called from the extending BatchXXXRequestBuilder classes that implement
   * ids(K...) or inputs()
   *
   * @param ids
   */
  protected final void addKeys(Collection<K> ids)
  {
    if (ids == null)
    {
      throw new IllegalArgumentException("null ids");
    }

    Set<Object> allIds = new HashSet<Object>();
    for (K id : ids)
    {
      addKey(allIds, id);
    }

    @SuppressWarnings("unchecked")
    Collection<K> existingIds = (Collection<K>) _queryParams.get(RestConstants.QUERY_BATCH_IDS_PARAM);
    if (existingIds != null && !existingIds.isEmpty())
    {
      allIds.addAll(existingIds);
    }

    _queryParams.put(RestConstants.QUERY_BATCH_IDS_PARAM, allIds);
  }

  private void addKey(Set<Object> ids, Object id)
  {
    if (id == null)
    {
      throw new IllegalArgumentException("Null key");
    }

    ids.add(id);
  }

  /**
   * Add an individual key to the DataList of keys, which will be later resolved into a collection
   * of individual query parameters.
   */
  protected final void addKey(K id)
  {
    addKeys(Collections.singletonList(id));
  }

  /**
   * @deprecated Please use {@link #pathKey(String, Object)} instead.
   * @param key
   * @param value
   */
  @Deprecated
  protected void addPathKey(String key, Object value)
  {
    if (value == null)
    {
      throw new IllegalArgumentException("Path key must be non-null");
    }
    _pathKeys.put(key, DataTemplateUtil.stringify(value));
  }

  protected void addAssocKey(String key, Object value)
  {
    _assocKey.append(key, value);
  }

  protected void addFields(PathSpec... fieldPaths)
  {
    if (_queryParams.containsKey(RestConstants.FIELDS_PARAM))
    {
      throw new IllegalStateException("Entity projection fields already set on this request: "
                                          + _queryParams.get(RestConstants.FIELDS_PARAM));
    }
    setParam(RestConstants.FIELDS_PARAM, fieldPaths);
  }

  protected void addMetadataFields(PathSpec... fieldPaths)
  {
    if (_queryParams.containsKey(RestConstants.METADATA_FIELDS_PARAM))
    {
      throw new IllegalStateException("Metadata projection fields already set on this request: "
          + _queryParams.get(RestConstants.METADATA_FIELDS_PARAM));
    }
    setParam(RestConstants.METADATA_FIELDS_PARAM, fieldPaths);
  }

  protected void addPagingFields(PathSpec... fieldPaths)
  {
    if (_queryParams.containsKey(RestConstants.PAGING_FIELDS_PARAM))
    {
      throw new IllegalStateException("Paging projection fields already set on this request: "
          + _queryParams.get(RestConstants.PAGING_FIELDS_PARAM));
    }
    setParam(RestConstants.PAGING_FIELDS_PARAM, fieldPaths);
  }

  @Override
  public String toString()
  {
    final StringBuilder sb = new StringBuilder();
    sb.append(getClass().getName());
    sb.append("{_assocKey=").append(_assocKey);
    sb.append(", _baseURITemplate='").append(getBaseUriTemplate()).append('\'');
    sb.append(", _headers=").append(_headers);
    sb.append(", _pathKeys=").append(_pathKeys);
    sb.append(", _resourceSpec=").append(_resourceSpec);
    sb.append(", _queryParams=").append(getBoundedString(_queryParams, 32));
    sb.append('}');
    return sb.toString();
  }

  private static String getBoundedString(Map<?, ?> map, int maxEntryCount)
  {
    if (map == null || map.size() < maxEntryCount)
    {
      return String.valueOf(map);
    }

    return new ArrayList<Map.Entry<?, ?>>(map.entrySet()).subList(0, maxEntryCount).toString() + " (truncated)";
  }
}

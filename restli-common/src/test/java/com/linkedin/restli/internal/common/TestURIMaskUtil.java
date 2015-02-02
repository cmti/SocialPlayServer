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
package com.linkedin.restli.internal.common;

import static com.linkedin.data.TestUtil.dataMapFromString;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

import com.linkedin.data.DataMap;
import com.linkedin.data.transform.filter.request.MaskTree;

/**
 *
 * @author jodzga
 *
 */
public class TestURIMaskUtil
{

  public static final String[][] TESTS = new String[][] {
    {
      /*description:*/    "Simple positve mask.",
      /*mask in JSON:*/   "{'aaa': 1, 'bbb': 1, 'ccc': 1}",
      /*mask in URI:*/    "aaa,bbb,ccc",
    },
    {
      /*description:*/    "Simple negative mask.",
      /*mask in JSON:*/   "{'aaa': 0, 'bbb': 0, 'ccc': 0}",
      /*mask in URI:*/    "-aaa,-bbb,-ccc",
    },
    {
      /*description:*/    "Nested positve mask.",
      /*mask in JSON:*/   "{'aaa': 1, 'bbb': { 'ccc': 1}}",
      /*mask in URI:*/    "aaa,bbb:(ccc)",
    },
    {
      /*description:*/    "Nested negative mask.",
      /*mask in JSON:*/   "{'aaa': 1, 'bbb': { 'ccc': 0}}",
      /*mask in URI:*/    "aaa,bbb:(-ccc)",
    },
    {
      /*description:*/    "Simple positive wildcard mask.",
      /*mask in JSON:*/   "{'$*': 1 }",
      /*mask in URI:*/    "$*",
    },
    {
      /*description:*/    "Simple negative wildcard mask.",
      /*mask in JSON:*/   "{'$*': 0 }",
      /*mask in URI:*/    "-$*",
    },
    {
      /*description:*/    "Test mixed positive and negative mask.",
      /*mask in JSON:*/   "{'a': 1, 'b': { '$*': 1, 'c': 0 } }",
      /*mask in URI:*/    "a,b:($*,-c)",
    },
    {
      /*description:*/    "Test deeply nested mixed positive and negative mask.",
      /*mask in JSON:*/   "{'a': { '$*': { '$*': 1, 'e': 0 }, 'b': { 'c': { 'd': 0 }}}, 'e': { 'f': { 'g': 0 }}}",
      /*mask in URI:*/    "a:($*:($*,-e),b:(c:(-d))),e:(f:(-g))",
    },
  };

  private void executeSingleTestCase(String jsonMask, String uriMask, String description) throws IllegalMaskException,
      IOException
  {
    testEncodingToURI(jsonMask, uriMask, description);
    testDeodingFromURI(jsonMask, uriMask, description);
  }

  private void testDeodingFromURI(String jsonMask, String uriMask, String description) throws IllegalMaskException,
      IOException
  {
    MaskTree decoded = URIMaskUtil.decodeMaskUriFormat(new StringBuilder(uriMask));
    DataMap expectedMask = dataMapFromString(jsonMask.replace('\'', '"'));
    assertEquals(decoded.getDataMap().toString(),
                 expectedMask.toString(),
                 "Decoding test case failed: \n" + description + "\nmask in URI: "
                     + uriMask + "\nexcpected: " + expectedMask.toString() + "\nactual: "
                     + decoded.toString());
  }

  /**
   * This method returns URI mask where all fields at the same level are sorted lexicographically.
   * It is used to check if two masks are equivalent.
   */
  private String inSortedOrder(String uriMask)
  {
    StringBuilder sb = new StringBuilder();
    List<String> tlf = getTopLevelFileds(uriMask);
    Collections.sort(tlf);
    for (String s : tlf)
      sb.append(handleField(s));
    return sb.toString();
  }

  private List<String> getTopLevelFileds(String s)
  {
    List<String> tlf = new ArrayList<String>();
    int i = 0;
    int openingBrackets = 0;
    int closingBrackets = 0;
    int endOfLastSegment = 0;
    while (i < s.length())
    {
      if (s.charAt(i) == ',')
      {
        if (openingBrackets < closingBrackets)
          throw new IllegalStateException("parsing error, more closing brackets than opening brackets");
        // if (openingBrackets > closingBrackets) -> this case can be ignored
        if (openingBrackets == closingBrackets)
        {
          tlf.add(s.substring(endOfLastSegment, i));
          endOfLastSegment = i + 1;
        }
      }
      else if (s.charAt(i) == '(')
      {
        openingBrackets++;
      }
      else if (s.charAt(i) == ')')
      {
        closingBrackets++;
      }
      i++;
    }
    // handle last segment
    if (endOfLastSegment < s.length())
      tlf.add(s.substring(endOfLastSegment, s.length()));

    return tlf;
  }

  private Object handleField(String s)
  {
    if (s.contains(":("))
    {
      int endOfFieldName = s.indexOf(":(");
      String fieldName = s.substring(0, endOfFieldName);
      String content = s.substring(endOfFieldName + 2, s.length() - 1);
      return fieldName + ":(" + inSortedOrder(content) + ")";
    }
    else
    {
      return s;
    }
  }

  private void testEncodingToURI(String jsonMask, String uriMask, String description) throws IOException
  {
    String encoded = URIMaskUtil.encodeMaskForURI(new MaskTree(dataMapFromString(jsonMask.replace('\'', '"'))));

    //to check if two masks are equivalent they are first transformed into their sorted representation
    assertEquals(inSortedOrder(encoded),
                 inSortedOrder(uriMask),
                 "Encoding test case failed: \n" + description + "\nmask in JSON: "
                     + jsonMask + "\nexcpected: " + uriMask + "\nactual: "
                     + encoded);
  }

  @Test
  public void test() throws Exception
  {
    for (String[] testCase : TESTS)
      executeSingleTestCase(testCase[1], testCase[2], testCase[0]);
  }

}

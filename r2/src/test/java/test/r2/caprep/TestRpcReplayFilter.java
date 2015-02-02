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

/* $Id$ */
package test.r2.caprep;

import com.linkedin.r2.message.Request;
import com.linkedin.r2.message.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.linkedin.r2.testutils.filter.FilterUtil;

/**
 * @author Chris Pettitt
 * @version $Revision$
 */
public class TestRpcReplayFilter extends AbstractReplayFilterTest
{
  // TODO: Pseudo-test to get gradle working with TestNG
  @Test
  public void psuedoTest()
  {
    Assert.assertTrue(true);
  }

  @Override
  @SuppressWarnings("deprecation")
  protected Request request()
  {
    return FilterUtil.simpleRpcRequest();
  }

  @Override
  @SuppressWarnings("deprecation")
  protected Response response()
  {
    return FilterUtil.simpleRpcResponse();
  }
}

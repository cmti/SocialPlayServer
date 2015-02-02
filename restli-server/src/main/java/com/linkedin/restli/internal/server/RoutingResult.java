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

package com.linkedin.restli.internal.server;

import com.linkedin.restli.internal.server.model.ResourceMethodDescriptor;
import com.linkedin.restli.server.ResourceContext;

public class RoutingResult
{
  private final ResourceContext          _context;
  private final ResourceMethodDescriptor _methodDescriptor;

  /**
   * Constructor.
   *
   * @param context {@link ResourceContext}
   * @param methodDescriptor {@link ResourceMethodDescriptor}
   */
  public RoutingResult(ResourceContext context, ResourceMethodDescriptor methodDescriptor)
  {
    _context = context;
    _methodDescriptor = methodDescriptor;
  }

  public ResourceContext getContext()
  {
    return _context;
  }

  public ResourceMethodDescriptor getResourceMethod()
  {
    return _methodDescriptor;
  }

  @Override
  public String toString()
  {
    return _methodDescriptor.toString();
  }
}

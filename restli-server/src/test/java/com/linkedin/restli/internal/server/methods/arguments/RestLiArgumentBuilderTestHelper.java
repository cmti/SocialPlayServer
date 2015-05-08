/*
   Copyright (c) 2014 LinkedIn Corp.

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

package com.linkedin.restli.internal.server.methods.arguments;

import com.linkedin.data.ByteString;
import com.linkedin.data.schema.RecordDataSchema;
import com.linkedin.data.template.RecordTemplate;
import com.linkedin.data.transform.filter.request.MaskTree;
import com.linkedin.r2.message.rest.RestRequest;
import com.linkedin.restli.common.ProtocolVersion;
import com.linkedin.restli.common.RestConstants;
import com.linkedin.restli.internal.server.PathKeysImpl;
import com.linkedin.restli.internal.server.RoutingResult;
import com.linkedin.restli.internal.server.model.Parameter;
import com.linkedin.restli.internal.server.model.ResourceMethodDescriptor;
import com.linkedin.restli.internal.server.model.ResourceModel;
import com.linkedin.restli.server.Key;
import com.linkedin.restli.server.PathKeys;
import com.linkedin.restli.server.ResourceContext;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;


/**
 * @author Soojung Ha
 */
// TODO : Use builder pattern for getMock* methods
public class RestLiArgumentBuilderTestHelper
{
  @DataProvider
  private static Object[][] failureEntityData()
  {
    return new Object[][]
        {
            {
                "{\"a\":\"xyz\",\"b\":123"
            },
            {
                "{\"a\":\"xyz\",\"b\"123}"
            },
            {
                "{a\":\"xyz\",\"b\"123}"
            }
        };
  }

  public static RestRequest getMockRequest(boolean returnHeaders, String entity, int getEntityCount)
  {
    RestRequest mockRequest = createMock(RestRequest.class);
    if (returnHeaders)
    {
      expect(mockRequest.getHeaders()).andReturn(Collections.<String, String>emptyMap());
    }
    if (entity != null)
    {
      expect(mockRequest.getHeader("Content-Type")).andReturn("application/json");
      expect(mockRequest.getEntity()).andReturn(ByteString.copy(entity.getBytes())).times(getEntityCount);
    }
    replay(mockRequest);
    return mockRequest;
  }

  public static RestRequest getMockRequest(String entity, ProtocolVersion version)
  {
    RestRequest mockRequest = createMock(RestRequest.class);
    Map<String, String> headers = new HashMap<String, String>();
    headers.put(RestConstants.HEADER_RESTLI_PROTOCOL_VERSION, version.toString());
    expect(mockRequest.getHeaders()).andReturn(headers);
    if (entity != null)
    {
      expect(mockRequest.getHeader("Content-Type")).andReturn("application/json");
      expect(mockRequest.getEntity()).andReturn(ByteString.copy(entity.getBytes()));
    }
    replay(mockRequest);
    return mockRequest;
  }

  public static ResourceModel getMockResourceModel(Class<? extends RecordTemplate> valueClass, Key key, boolean returnNullKey)
  {
    ResourceModel model = createMock(ResourceModel.class);
    if (valueClass != null)
    {
      expect((Class) model.getValueClass()).andReturn(valueClass);
    }
    if (key != null || returnNullKey)
    {
      expect(model.getPrimaryKey()).andReturn(key);
    }
    if (key != null)
    {
      expect(model.getKeyName()).andReturn(key.getName());
    }
    replay(model);
    return model;
  }

  public static ResourceMethodDescriptor getMockResourceMethodDescriptor(ResourceModel model, Parameter<?> param)
  {
    List<Parameter<?>> paramList = new ArrayList<Parameter<?>>();
    if (param != null)
    {
      paramList.add(param);
    }
    return getMockResourceMethodDescriptor(model, 1, paramList);
  }

  public static ResourceMethodDescriptor getMockResourceMethodDescriptor(ResourceModel model, int getResourceModelCount, List<Parameter<?>> paramList)
  {
    ResourceMethodDescriptor descriptor = createMock(ResourceMethodDescriptor.class);
    if (model != null)
    {
      expect(descriptor.getResourceModel()).andReturn(model).times(getResourceModelCount);
    }
    if (paramList != null)
    {
      expect(descriptor.getParameters()).andReturn(paramList);
    }
    replay(descriptor);
    return descriptor;
  }

  public static ResourceMethodDescriptor getMockResourceMethodDescriptor(ResourceModel model, List<Parameter<?>> paramList, String actionName, RecordDataSchema dataSchema)
  {
    ResourceMethodDescriptor descriptor = createMock(ResourceMethodDescriptor.class);
    if (model != null)
    {
      expect(descriptor.getResourceModel()).andReturn(model);
    }
    expect(descriptor.getRequestDataSchema()).andReturn(dataSchema);
    if (actionName != null)
    {
      expect(descriptor.getActionName()).andReturn(actionName);
    }
    if (paramList != null)
    {
      expect(descriptor.getParameters()).andReturn(paramList);
    }
    replay(descriptor);
    return descriptor;
  }

  public static ResourceContext getMockResourceContext()
  {
    ResourceContext context = createMock(ResourceContext.class);
    PathKeysImpl pathKeys = new PathKeysImpl();
    expect(context.getPathKeys()).andReturn(pathKeys);
    replay(context);
    return context;
  }

  public static ResourceContext getMockResourceContext(String keyName, Object keyValue, Set<Object> batchKeys)
  {
    return getMockResourceContext(keyName, keyValue, batchKeys, null);
  }

  public static ResourceContext getMockResourceContext(String keyName, Object keyValue, Set<Object> batchKeys,
                                                       Map<String, String> headers)
  {
    ResourceContext context = createMock(ResourceContext.class);
    if (keyName != null || batchKeys != null)
    {
      PathKeysImpl pathKeys = new PathKeysImpl();
      if (keyName != null)
      {
        pathKeys.append(keyName, keyValue);
      }
      if (batchKeys != null)
      {
        pathKeys.setBatchKeys(batchKeys);
      }
      expect(context.getPathKeys()).andReturn(pathKeys);
    }
    if (headers != null)
    {
      expect(context.getRequestHeaders()).andReturn(headers);
    }
    replay(context);
    return context;
  }

  public static ResourceContext getMockResourceContext(PathKeys pathKeys, boolean returnStructuredParameter)
  {
    ResourceContext context = createMock(ResourceContext.class);
    if (pathKeys != null)
    {
      expect(context.getPathKeys()).andReturn(pathKeys);
    }
    if (returnStructuredParameter)
    {
      expect(context.getStructuredParameter("")).andReturn(null);
    }
    replay(context);
    return context;
  }

  public static ResourceContext getMockResourceContext(Map<String, String> parameters)
  {
    ResourceContext context = createMock(ResourceContext.class);
    for (String key : parameters.keySet())
    {
      expect(context.getParameter(key)).andReturn(parameters.get(key));
    }
    replay(context);
    return context;
  }

  public static ResourceContext getMockResourceContext(Map<String, String> parameters, MaskTree projectionMask,
                                                       MaskTree metadataMask, MaskTree pagingMask)
  {
    ResourceContext context = createMock(ResourceContext.class);
    for (String key : parameters.keySet())
    {
      expect(context.getParameter(key)).andReturn(parameters.get(key));
    }
    expect(context.getProjectionMask()).andReturn(projectionMask);
    expect(context.getMetadataProjectionMask()).andReturn(metadataMask);
    expect(context.getPagingProjectionMask()).andReturn(pagingMask);
    replay(context);
    return context;
  }

  public static ResourceContext getMockResourceContext(String parameterKey, List<String> parameterValues)
  {
    ResourceContext context = createMock(ResourceContext.class);
    expect(context.getParameter(parameterKey)).andReturn(parameterValues.get(0));
    expect(context.getParameterValues(parameterKey)).andReturn(parameterValues);
    replay(context);
    return context;
  }

  public static ResourceContext getMockResourceContextWithStructuredParameter(
      String parameterKey, String parameterValue, Object structuredParameter)
  {
    ResourceContext context = createMock(ResourceContext.class);
    expect(context.getParameter(parameterKey)).andReturn(parameterValue);
    expect(context.getStructuredParameter(parameterKey)).andReturn(structuredParameter);
    replay(context);
    return context;
  }

  public static RoutingResult getMockRoutingResult()
  {
    RoutingResult mockRoutingResult = createMock(RoutingResult.class);
    replay(mockRoutingResult);
    return mockRoutingResult;
  }

  public static RoutingResult getMockRoutingResult(ResourceMethodDescriptor descriptor, int getResourceMethodCount,
                                                   ResourceContext context, int getContextCount)
  {
    RoutingResult mockRoutingResult = createMock(RoutingResult.class);
    if (descriptor != null)
    {
      expect(mockRoutingResult.getResourceMethod()).andReturn(descriptor).times(getResourceMethodCount);
    }
    if (context != null)
    {
      expect(mockRoutingResult.getContext()).andReturn(context).times(getContextCount);
    }
    replay(mockRoutingResult);
    return mockRoutingResult;
  }
}
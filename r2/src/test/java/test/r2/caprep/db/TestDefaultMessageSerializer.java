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
package test.r2.caprep.db;

import com.linkedin.data.ByteString;
import com.linkedin.r2.caprep.db.DefaultMessageSerializer;
import com.linkedin.r2.caprep.db.MessageSerializer;
import com.linkedin.r2.message.Message;
import com.linkedin.r2.message.Request;
import com.linkedin.r2.message.Response;
import com.linkedin.r2.message.rest.RestMethod;
import com.linkedin.r2.message.rest.RestRequest;
import com.linkedin.r2.message.rest.RestRequestBuilder;
import com.linkedin.r2.message.rest.RestResponse;
import com.linkedin.r2.message.rest.RestResponseBuilder;
import com.linkedin.r2.message.rest.RestStatus;
import com.linkedin.r2.message.rpc.RpcRequest;
import com.linkedin.r2.message.rpc.RpcRequestBuilder;
import com.linkedin.r2.message.rpc.RpcResponse;
import com.linkedin.r2.message.rpc.RpcResponseBuilder;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

/**
 * @author Chris Pettitt
 * @version $Revision$
 */
public class TestDefaultMessageSerializer
{
  private MessageSerializer _serializer;

  @BeforeMethod
  public void setUp()
  {
    _serializer = new DefaultMessageSerializer();
  }

  @Test
  @SuppressWarnings("deprecation")
  public void testSimpleRpcReq() throws IOException
  {
    final RpcRequest expected = new RpcRequestBuilder(URI.create("http://localhost:1234"))
            .build();
    assertMsgEquals(expected, _serializer.readRpcRequest(getResource("simple-rpc-req.txt")));
  }

  @Test
  public void testSimpleRestReq() throws IOException
  {
    final RestRequest expected = new RestRequestBuilder(URI.create("http://localhost:1234"))
            .build();
    assertMsgEquals(expected, _serializer.readRestRequest(getResource("simple-rest-req.txt")));
  }

  @Test
  public void testRestReqWithHeaders() throws IOException
  {
    final RestRequest expected = new RestRequestBuilder(URI.create("http://localhost:1234"))
            .setHeader("field-name1", "field-val1")
            .setHeader("field-name2", "field-val2")
            .build();
    assertMsgEquals(expected, _serializer.readRestRequest(getResource("rest-req-with-headers.txt")));
  }

  @Test
  public void testRestReqWithHeaderMultiValue1() throws IOException
  {
    final RestRequest expected = new RestRequestBuilder(URI.create("http://localhost:1234"))
            .addHeaderValue("field-name1", "field-val1")
            .addHeaderValue("field-name1", "field-val2")
            .build();
    assertMsgEquals(expected, _serializer.readRestRequest(getResource("rest-req-with-header-multi-value1.txt")));
  }

  @Test
  public void testRestReqWithHeaderMultiValue2() throws IOException
  {
    final RestRequest expected = new RestRequestBuilder(URI.create("http://localhost:1234"))
            .addHeaderValue("field-name1", "field-val1")
            .addHeaderValue("field-name1", "field-val2")
            .build();
    assertMsgEquals(expected, _serializer.readRestRequest(getResource("rest-req-with-header-multi-value2.txt")));
  }

  @Test
  @SuppressWarnings("deprecation")
  public void testRpcReqWithEntity() throws IOException
  {
    final RpcRequest expected = new RpcRequestBuilder(URI.create("http://localhost:1234"))
            .setEntity(ByteString.copyString("This is a simple entity!", "ASCII"))
            .build();
    assertMsgEquals(expected, _serializer.readRpcRequest(getResource("rpc-req-with-entity.txt")));
  }

  @Test
  public void testRestReqWithEntity() throws IOException
  {
    final RestRequest expected = new RestRequestBuilder(URI.create("http://localhost:1234"))
            .setEntity(ByteString.copyString("This is a simple entity!", "ASCII"))
            .setHeader("field-name1", "field-val1")
            .setHeader("field-name2", "field-val2")
            .build();
    assertMsgEquals(expected, _serializer.readRestRequest(getResource("rest-req-with-entity.txt")));
  }

  @Test
  public void testSimpleRestRes() throws IOException
  {
    final RestResponse expected = new RestResponseBuilder()
            .build();
    assertMsgEquals(expected, _serializer.readRestResponse(getResource("simple-rest-res.txt")));
  }

  @Test
  public void testRpcReqWithEmptyHeaderValue() throws IOException
  {
    final RestRequest expected = new RestRequestBuilder(URI.create("http://localhost:1234"))
            .setHeader("field-name1", "")
            .build();
    assertMsgEquals(expected, _serializer.readRestRequest(getResource("rest-req-with-empty-header-value.txt")));
  }

  @Test
  public void testRestReqWithUppercaseHeaderNames() throws IOException
  {
    // Note that we're using lowercase field names here. We expect that canonicalization will
    // treat these the same
    final RestRequest expected = new RestRequestBuilder(URI.create("http://localhost:1234"))
            .setHeader("field-name1", "field-val1")
            .setHeader("field-name2", "field-val2")
            .build();
    assertMsgEquals(expected, _serializer.readRestRequest(getResource("rest-req-with-uppercase-header-names.txt")));
  }

  @Test
  public void testRestReqWithMultilineHeader() throws IOException
  {
    final RestRequest expected = new RestRequestBuilder(URI.create("http://localhost:1234"))
            .setHeader("field-name1", "field-val1\ncontinuation-of-last-field:abc")
            .build();

    assertMsgEquals(expected, _serializer.readRestRequest(getResource("rest-req-with-multiline-header.txt")));
  }

  @Test
  public void testRestReqWithMalformedHeader() throws Exception
  {
    expectIOException(new ThrowingRunnable()
    {
      @Override
      public void run() throws Exception
      {
        _serializer.readRestRequest(getResource("rest-req-with-malformed-header.txt"));
      }
    });
  }

  @Test
  public void testRpcResWith500StatusCode() throws Exception
  {
    expectIOException(new ThrowingRunnable()
    {
      @Override
      public void run() throws Exception
      {
        _serializer.readRestRequest(getResource("rpc-res-with-500-status-code.txt"));
      }
    });
  }

  @Test
  public void testRestReqWithExtraSpaceInReqLine() throws Exception
  {
    expectIOException(new ThrowingRunnable()
    {
      @Override
      public void run() throws Exception
      {
        _serializer.readRestRequest(getResource("rest-req-with-extra-space-in-req-line.txt"));
      }
    });
  }

  @Test
  public void testRestResWithExtraSpaceInStatusLine() throws Exception
  {
    expectIOException(new ThrowingRunnable()
    {
      @Override
      public void run() throws Exception
      {
        _serializer.readRestResponse(getResource("rest-res-with-extra-space-in-status-line.txt"));
      }
    });
  }

  @Test
  public void testRpcReqWithGet() throws Exception
  {
    expectIOException(new ThrowingRunnable()
    {
      @Override
      @SuppressWarnings("deprecation")
      public void run() throws Exception
      {
        _serializer.readRpcRequest(getResource("rpc-req-with-get.txt"));
      }
    });
  }

  @Test
  public void testRpcReqMissingVersion() throws Exception
  {
    expectIOException(new ThrowingRunnable()
    {
      @Override
      @SuppressWarnings("deprecation")
      public void run() throws Exception
      {
        _serializer.readRpcRequest(getResource("rpc-req-missing-version.txt"));
      }
    });
  }

  @Test
  public void testRestReqMissingVersion() throws Exception
  {
    expectIOException(new ThrowingRunnable()
    {
      @Override
      public void run() throws Exception
      {
        _serializer.readRestRequest(getResource("rest-req-missing-version.txt"));
      }
    });
  }

  @Test
  public void testRpcRequestReversible1() throws IOException
  {
    final RpcRequest req = createRpcRequest();
    assertMsgEquals(req, readRpcReq(writeReq(req)));
  }

  @Test
  @SuppressWarnings("deprecation")
  public void testRpcRequestReversible2() throws IOException
  {
    final RpcRequest req = createRpcRequest().builder()
            .setEntity(new byte[] {1,2,3,4})
            .build();
    assertMsgEquals(req, readRpcReq(writeReq(req)));
  }

  @Test
  public void testRpcResponseReversible1() throws IOException
  {
    final RpcResponse res = createRpcResponse();
    assertMsgEquals(res, readRpcRes(writeRes(res)));
  }

  @Test
  @SuppressWarnings("deprecation")
  public void testRpcResponseReversible2() throws IOException
  {
    final RpcResponse res = createRpcResponse().builder()
            .setEntity(new byte[] {1,2,3,4})
            .build();
    assertMsgEquals(res, readRpcRes(writeRes(res)));
  }

  @Test
  public void testRestRequestReversible1() throws IOException
  {
    final RestRequest req = createRestRequest();
    assertMsgEquals(req, readRestReq(writeReq(req)));
  }

  @Test
  public void testRestRequestReversible2() throws IOException
  {
    final RestRequest req = createRestRequest().builder()
            .setMethod(RestMethod.POST)
            .build();
    assertMsgEquals(req, readRestReq(writeReq(req)));
  }

  @Test
  public void testRestRequestReversible3() throws IOException
  {
    final RestRequest req = createRestRequest().builder()
            .setEntity(new byte[] {1,2,3,4})
            .build();
    assertMsgEquals(req, readRestReq(writeReq(req)));
  }

  @Test
  public void testRestRequestReversible4() throws IOException
  {
    final RestRequest req = createRestRequest().builder()
            .setHeader("field-key1", "field-val1")
            .setHeader("field-key2", "field-val2")
            .build();
    assertMsgEquals(req, readRestReq(writeReq(req)));
  }

  @Test
  public void testRestRequestReversible5() throws IOException
  {
    final RestRequest req = createRestRequest().builder()
            .setHeader("field-key1", "multi-line\nfield-value\nhere")
            .build();
    assertMsgEquals(req, readRestReq(writeReq(req)));
  }

  @Test
  public void testRestResponseReversible1() throws IOException
  {
    final RestResponse res = createRestResponse();
    assertMsgEquals(res, readRestRes(writeRes(res)));
  }

  @Test
  public void testRestResponseReversible2() throws IOException
  {
    final RestResponse res = createRestResponse().builder()
            .setStatus(RestStatus.INTERNAL_SERVER_ERROR)
            .build();
    assertMsgEquals(res, readRestRes(writeRes(res)));
  }

  @Test
  public void testRestResponseReversible3() throws IOException
  {
    final RestResponse res = createRestResponse().builder()
            .setEntity(new byte[] {1,2,3,4})
            .build();
    assertMsgEquals(res, readRestRes(writeRes(res)));
  }

  @Test
  public void testRestResponseReversible4() throws IOException
  {
    final RestResponse res = createRestResponse().builder()
            .setHeader("field-key1", "field-val1")
            .setHeader("field-key2", "field-val2")
            .build();
    assertMsgEquals(res, readRestRes(writeRes(res)));
  }

  @Test
  public void testRestResponseReversible5() throws IOException
  {
    final RestResponse res = createRestResponse().builder()
            .addHeaderValue("field-key1", "field-val1")
            .addHeaderValue("field-key1", "field-val2")
            .build();
    assertMsgEquals(res, readRestRes(writeRes(res)));
  }

  @SuppressWarnings("deprecation")
  private RpcRequest createRpcRequest()
  {
    return new RpcRequestBuilder(URI.create("http://linkedin.com")).build();
  }

  @SuppressWarnings("deprecation")
  private RpcResponse createRpcResponse()
  {
    return new RpcResponseBuilder().build();
  }

  private RestRequest createRestRequest()
  {
    return new RestRequestBuilder(URI.create("http://linkedin.com")).build();
  }

  private RestResponse createRestResponse()
  {
    return new RestResponseBuilder().build();
  }

  private byte[] writeReq(Request req) throws IOException
  {
    final ByteArrayOutputStream baos = new ByteArrayOutputStream();
    _serializer.writeRequest(baos, req);
    return baos.toByteArray();
  }

  private byte[] writeRes(Response res) throws IOException
  {
    final ByteArrayOutputStream baos = new ByteArrayOutputStream();
    _serializer.writeResponse(baos, res);
    return baos.toByteArray();
  }

  @SuppressWarnings("deprecation")
  private RpcRequest readRpcReq(byte[] bytes) throws IOException
  {
    return _serializer.readRpcRequest(new ByteArrayInputStream(bytes));
  }

  @SuppressWarnings("deprecation")
  private RpcResponse readRpcRes(byte[] bytes) throws IOException
  {
    return _serializer.readRpcResponse(new ByteArrayInputStream(bytes));
  }

  private RestRequest readRestReq(byte[] bytes) throws IOException
  {
    return _serializer.readRestRequest(new ByteArrayInputStream(bytes));
  }

  private RestResponse readRestRes(byte[] bytes) throws IOException
  {
    return _serializer.readRestResponse(new ByteArrayInputStream(bytes));
  }

  private void assertMsgEquals(Message expected, Message actual)
  {
    Assert.assertEquals(actual.builder().buildCanonical(), expected.builder().buildCanonical());
  }

  private InputStream getResource(String name)
  {
    final InputStream in = Thread.currentThread()
            .getContextClassLoader()
            .getResourceAsStream("test/r2/caprep/db/" + name);
    if (in == null)
    {
      throw new RuntimeException("No such resource: " + name);
    }
    return in;
  }

  private void expectIOException(ThrowingRunnable runnable) throws Exception
  {
    try
    {
      runnable.run();
      Assert.fail("Should have thrown IOException");
    }
    catch(IOException e)
    {
      // Expected case
    }
  }

  private static interface ThrowingRunnable
  {
    void run() throws Exception;
  }
}

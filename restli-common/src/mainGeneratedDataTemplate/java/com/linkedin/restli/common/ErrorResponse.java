
package com.linkedin.restli.common;

import java.util.List;
import javax.annotation.Generated;
import com.linkedin.data.DataMap;
import com.linkedin.data.schema.PathSpec;
import com.linkedin.data.schema.RecordDataSchema;
import com.linkedin.data.template.DataTemplateUtil;
import com.linkedin.data.template.GetMode;
import com.linkedin.data.template.RecordTemplate;
import com.linkedin.data.template.SetMode;


/**
 * A generic ErrorResponse
 * 
 */
@Generated(value = "com.linkedin.pegasus.generator.PegasusDataTemplateGenerator", comments = "LinkedIn Data Template. Generated from /Users/jianli/git/SocialPlayServer/restli-common/src/main/pegasus/com/linkedin/restli/common/ErrorResponse.pdsc.", date = "Thu May 07 23:46:42 PDT 2015")
public class ErrorResponse
    extends RecordTemplate
{

    private final static ErrorResponse.Fields _fields = new ErrorResponse.Fields();
    private final static RecordDataSchema SCHEMA = ((RecordDataSchema) DataTemplateUtil.parseSchema("{\"type\":\"record\",\"name\":\"ErrorResponse\",\"namespace\":\"com.linkedin.restli.common\",\"doc\":\"A generic ErrorResponse\",\"fields\":[{\"name\":\"status\",\"type\":\"int\",\"doc\":\"The HTTP status code\"},{\"name\":\"serviceErrorCode\",\"type\":\"int\",\"doc\":\"An service-specific error code (documented in prose)\",\"optional\":true},{\"name\":\"message\",\"type\":\"string\",\"doc\":\"A human-readable explanation of the error\",\"optional\":true},{\"name\":\"exceptionClass\",\"type\":\"string\",\"doc\":\"The FQCN of the exception thrown by the server (included the case of a server fault)\"},{\"name\":\"stackTrace\",\"type\":\"string\",\"doc\":\"The full (??) stack trace (included the case of a server fault)\"},{\"name\":\"errorDetails\",\"type\":{\"type\":\"record\",\"name\":\"ErrorDetails\",\"fields\":[]},\"optional\":true}]}"));
    private final static RecordDataSchema.Field FIELD_Status = SCHEMA.getField("status");
    private final static RecordDataSchema.Field FIELD_ServiceErrorCode = SCHEMA.getField("serviceErrorCode");
    private final static RecordDataSchema.Field FIELD_Message = SCHEMA.getField("message");
    private final static RecordDataSchema.Field FIELD_ExceptionClass = SCHEMA.getField("exceptionClass");
    private final static RecordDataSchema.Field FIELD_StackTrace = SCHEMA.getField("stackTrace");
    private final static RecordDataSchema.Field FIELD_ErrorDetails = SCHEMA.getField("errorDetails");

    public ErrorResponse() {
        super(new DataMap(), SCHEMA);
    }

    public ErrorResponse(DataMap data) {
        super(data, SCHEMA);
    }

    public static ErrorResponse.Fields fields() {
        return _fields;
    }

    /**
     * Existence checker for status
     * 
     * @see Fields#status
     */
    public boolean hasStatus() {
        return contains(FIELD_Status);
    }

    /**
     * Remover for status
     * 
     * @see Fields#status
     */
    public void removeStatus() {
        remove(FIELD_Status);
    }

    /**
     * Getter for status
     * 
     * @see Fields#status
     */
    public Integer getStatus(GetMode mode) {
        return obtainDirect(FIELD_Status, Integer.class, mode);
    }

    /**
     * Getter for status
     * 
     * @see Fields#status
     */
    public Integer getStatus() {
        return getStatus(GetMode.STRICT);
    }

    /**
     * Setter for status
     * 
     * @see Fields#status
     */
    public ErrorResponse setStatus(Integer value, SetMode mode) {
        putDirect(FIELD_Status, Integer.class, Integer.class, value, mode);
        return this;
    }

    /**
     * Setter for status
     * 
     * @see Fields#status
     */
    public ErrorResponse setStatus(Integer value) {
        putDirect(FIELD_Status, Integer.class, Integer.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    /**
     * Setter for status
     * 
     * @see Fields#status
     */
    public ErrorResponse setStatus(int value) {
        putDirect(FIELD_Status, Integer.class, Integer.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    /**
     * Existence checker for serviceErrorCode
     * 
     * @see Fields#serviceErrorCode
     */
    public boolean hasServiceErrorCode() {
        return contains(FIELD_ServiceErrorCode);
    }

    /**
     * Remover for serviceErrorCode
     * 
     * @see Fields#serviceErrorCode
     */
    public void removeServiceErrorCode() {
        remove(FIELD_ServiceErrorCode);
    }

    /**
     * Getter for serviceErrorCode
     * 
     * @see Fields#serviceErrorCode
     */
    public Integer getServiceErrorCode(GetMode mode) {
        return obtainDirect(FIELD_ServiceErrorCode, Integer.class, mode);
    }

    /**
     * Getter for serviceErrorCode
     * 
     * @see Fields#serviceErrorCode
     */
    public Integer getServiceErrorCode() {
        return getServiceErrorCode(GetMode.STRICT);
    }

    /**
     * Setter for serviceErrorCode
     * 
     * @see Fields#serviceErrorCode
     */
    public ErrorResponse setServiceErrorCode(Integer value, SetMode mode) {
        putDirect(FIELD_ServiceErrorCode, Integer.class, Integer.class, value, mode);
        return this;
    }

    /**
     * Setter for serviceErrorCode
     * 
     * @see Fields#serviceErrorCode
     */
    public ErrorResponse setServiceErrorCode(Integer value) {
        putDirect(FIELD_ServiceErrorCode, Integer.class, Integer.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    /**
     * Setter for serviceErrorCode
     * 
     * @see Fields#serviceErrorCode
     */
    public ErrorResponse setServiceErrorCode(int value) {
        putDirect(FIELD_ServiceErrorCode, Integer.class, Integer.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    /**
     * Existence checker for message
     * 
     * @see Fields#message
     */
    public boolean hasMessage() {
        return contains(FIELD_Message);
    }

    /**
     * Remover for message
     * 
     * @see Fields#message
     */
    public void removeMessage() {
        remove(FIELD_Message);
    }

    /**
     * Getter for message
     * 
     * @see Fields#message
     */
    public String getMessage(GetMode mode) {
        return obtainDirect(FIELD_Message, String.class, mode);
    }

    /**
     * Getter for message
     * 
     * @see Fields#message
     */
    public String getMessage() {
        return getMessage(GetMode.STRICT);
    }

    /**
     * Setter for message
     * 
     * @see Fields#message
     */
    public ErrorResponse setMessage(String value, SetMode mode) {
        putDirect(FIELD_Message, String.class, String.class, value, mode);
        return this;
    }

    /**
     * Setter for message
     * 
     * @see Fields#message
     */
    public ErrorResponse setMessage(String value) {
        putDirect(FIELD_Message, String.class, String.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    /**
     * Existence checker for exceptionClass
     * 
     * @see Fields#exceptionClass
     */
    public boolean hasExceptionClass() {
        return contains(FIELD_ExceptionClass);
    }

    /**
     * Remover for exceptionClass
     * 
     * @see Fields#exceptionClass
     */
    public void removeExceptionClass() {
        remove(FIELD_ExceptionClass);
    }

    /**
     * Getter for exceptionClass
     * 
     * @see Fields#exceptionClass
     */
    public String getExceptionClass(GetMode mode) {
        return obtainDirect(FIELD_ExceptionClass, String.class, mode);
    }

    /**
     * Getter for exceptionClass
     * 
     * @see Fields#exceptionClass
     */
    public String getExceptionClass() {
        return getExceptionClass(GetMode.STRICT);
    }

    /**
     * Setter for exceptionClass
     * 
     * @see Fields#exceptionClass
     */
    public ErrorResponse setExceptionClass(String value, SetMode mode) {
        putDirect(FIELD_ExceptionClass, String.class, String.class, value, mode);
        return this;
    }

    /**
     * Setter for exceptionClass
     * 
     * @see Fields#exceptionClass
     */
    public ErrorResponse setExceptionClass(String value) {
        putDirect(FIELD_ExceptionClass, String.class, String.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    /**
     * Existence checker for stackTrace
     * 
     * @see Fields#stackTrace
     */
    public boolean hasStackTrace() {
        return contains(FIELD_StackTrace);
    }

    /**
     * Remover for stackTrace
     * 
     * @see Fields#stackTrace
     */
    public void removeStackTrace() {
        remove(FIELD_StackTrace);
    }

    /**
     * Getter for stackTrace
     * 
     * @see Fields#stackTrace
     */
    public String getStackTrace(GetMode mode) {
        return obtainDirect(FIELD_StackTrace, String.class, mode);
    }

    /**
     * Getter for stackTrace
     * 
     * @see Fields#stackTrace
     */
    public String getStackTrace() {
        return getStackTrace(GetMode.STRICT);
    }

    /**
     * Setter for stackTrace
     * 
     * @see Fields#stackTrace
     */
    public ErrorResponse setStackTrace(String value, SetMode mode) {
        putDirect(FIELD_StackTrace, String.class, String.class, value, mode);
        return this;
    }

    /**
     * Setter for stackTrace
     * 
     * @see Fields#stackTrace
     */
    public ErrorResponse setStackTrace(String value) {
        putDirect(FIELD_StackTrace, String.class, String.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    /**
     * Existence checker for errorDetails
     * 
     * @see Fields#errorDetails
     */
    public boolean hasErrorDetails() {
        return contains(FIELD_ErrorDetails);
    }

    /**
     * Remover for errorDetails
     * 
     * @see Fields#errorDetails
     */
    public void removeErrorDetails() {
        remove(FIELD_ErrorDetails);
    }

    /**
     * Getter for errorDetails
     * 
     * @see Fields#errorDetails
     */
    public ErrorDetails getErrorDetails(GetMode mode) {
        return obtainWrapped(FIELD_ErrorDetails, ErrorDetails.class, mode);
    }

    /**
     * Getter for errorDetails
     * 
     * @see Fields#errorDetails
     */
    public ErrorDetails getErrorDetails() {
        return getErrorDetails(GetMode.STRICT);
    }

    /**
     * Setter for errorDetails
     * 
     * @see Fields#errorDetails
     */
    public ErrorResponse setErrorDetails(ErrorDetails value, SetMode mode) {
        putWrapped(FIELD_ErrorDetails, ErrorDetails.class, value, mode);
        return this;
    }

    /**
     * Setter for errorDetails
     * 
     * @see Fields#errorDetails
     */
    public ErrorResponse setErrorDetails(ErrorDetails value) {
        putWrapped(FIELD_ErrorDetails, ErrorDetails.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    @Override
    public ErrorResponse clone()
        throws CloneNotSupportedException
    {
        return ((ErrorResponse) super.clone());
    }

    @Override
    public ErrorResponse copy()
        throws CloneNotSupportedException
    {
        return ((ErrorResponse) super.copy());
    }

    public static class Fields
        extends PathSpec
    {


        public Fields(List<String> path, String name) {
            super(path, name);
        }

        public Fields() {
            super();
        }

        /**
         * The HTTP status code
         * 
         */
        public PathSpec status() {
            return new PathSpec(getPathComponents(), "status");
        }

        /**
         * An service-specific error code (documented in prose)
         * 
         */
        public PathSpec serviceErrorCode() {
            return new PathSpec(getPathComponents(), "serviceErrorCode");
        }

        /**
         * A human-readable explanation of the error
         * 
         */
        public PathSpec message() {
            return new PathSpec(getPathComponents(), "message");
        }

        /**
         * The FQCN of the exception thrown by the server (included the case of a server fault)
         * 
         */
        public PathSpec exceptionClass() {
            return new PathSpec(getPathComponents(), "exceptionClass");
        }

        /**
         * The full (??) stack trace (included the case of a server fault)
         * 
         */
        public PathSpec stackTrace() {
            return new PathSpec(getPathComponents(), "stackTrace");
        }

        public com.linkedin.restli.common.ErrorDetails.Fields errorDetails() {
            return new com.linkedin.restli.common.ErrorDetails.Fields(getPathComponents(), "errorDetails");
        }

    }

}

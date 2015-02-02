
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
 * A rest.li update status.
 * 
 */
@Generated(value = "com.linkedin.pegasus.generator.PegasusDataTemplateGenerator", comments = "LinkedIn Data Template. Generated from /Users/jianli/workspaces/SocialPlayServer/restli-common/src/main/pegasus/com/linkedin/restli/common/UpdateStatus.pdsc.", date = "Wed Jan 14 22:36:03 PST 2015")
public class UpdateStatus
    extends RecordTemplate
{

    private final static UpdateStatus.Fields _fields = new UpdateStatus.Fields();
    private final static RecordDataSchema SCHEMA = ((RecordDataSchema) DataTemplateUtil.parseSchema("{\"type\":\"record\",\"name\":\"UpdateStatus\",\"namespace\":\"com.linkedin.restli.common\",\"doc\":\"A rest.li update status.\",\"fields\":[{\"name\":\"status\",\"type\":\"int\"},{\"name\":\"error\",\"type\":{\"type\":\"record\",\"name\":\"ErrorResponse\",\"doc\":\"A generic ErrorResponse\",\"fields\":[{\"name\":\"status\",\"type\":\"int\",\"doc\":\"The HTTP status code\"},{\"name\":\"serviceErrorCode\",\"type\":\"int\",\"doc\":\"An service-specific error code (documented in prose)\",\"optional\":true},{\"name\":\"message\",\"type\":\"string\",\"doc\":\"A human-readable explanation of the error\",\"optional\":true},{\"name\":\"exceptionClass\",\"type\":\"string\",\"doc\":\"The FQCN of the exception thrown by the server (included the case of a server fault)\"},{\"name\":\"stackTrace\",\"type\":\"string\",\"doc\":\"The full (??) stack trace (included the case of a server fault)\"},{\"name\":\"errorDetails\",\"type\":{\"type\":\"record\",\"name\":\"ErrorDetails\",\"fields\":[]},\"optional\":true}]},\"optional\":true}]}"));
    private final static RecordDataSchema.Field FIELD_Status = SCHEMA.getField("status");
    private final static RecordDataSchema.Field FIELD_Error = SCHEMA.getField("error");

    public UpdateStatus() {
        super(new DataMap(), SCHEMA);
    }

    public UpdateStatus(DataMap data) {
        super(data, SCHEMA);
    }

    public static UpdateStatus.Fields fields() {
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
    public UpdateStatus setStatus(Integer value, SetMode mode) {
        putDirect(FIELD_Status, Integer.class, Integer.class, value, mode);
        return this;
    }

    /**
     * Setter for status
     * 
     * @see Fields#status
     */
    public UpdateStatus setStatus(Integer value) {
        putDirect(FIELD_Status, Integer.class, Integer.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    /**
     * Setter for status
     * 
     * @see Fields#status
     */
    public UpdateStatus setStatus(int value) {
        putDirect(FIELD_Status, Integer.class, Integer.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    /**
     * Existence checker for error
     * 
     * @see Fields#error
     */
    public boolean hasError() {
        return contains(FIELD_Error);
    }

    /**
     * Remover for error
     * 
     * @see Fields#error
     */
    public void removeError() {
        remove(FIELD_Error);
    }

    /**
     * Getter for error
     * 
     * @see Fields#error
     */
    public ErrorResponse getError(GetMode mode) {
        return obtainWrapped(FIELD_Error, ErrorResponse.class, mode);
    }

    /**
     * Getter for error
     * 
     * @see Fields#error
     */
    public ErrorResponse getError() {
        return getError(GetMode.STRICT);
    }

    /**
     * Setter for error
     * 
     * @see Fields#error
     */
    public UpdateStatus setError(ErrorResponse value, SetMode mode) {
        putWrapped(FIELD_Error, ErrorResponse.class, value, mode);
        return this;
    }

    /**
     * Setter for error
     * 
     * @see Fields#error
     */
    public UpdateStatus setError(ErrorResponse value) {
        putWrapped(FIELD_Error, ErrorResponse.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    @Override
    public UpdateStatus clone()
        throws CloneNotSupportedException
    {
        return ((UpdateStatus) super.clone());
    }

    @Override
    public UpdateStatus copy()
        throws CloneNotSupportedException
    {
        return ((UpdateStatus) super.copy());
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

        public PathSpec status() {
            return new PathSpec(getPathComponents(), "status");
        }

        public com.linkedin.restli.common.ErrorResponse.Fields error() {
            return new com.linkedin.restli.common.ErrorResponse.Fields(getPathComponents(), "error");
        }

    }

}

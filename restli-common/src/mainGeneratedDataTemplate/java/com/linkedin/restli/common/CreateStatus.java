
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
 * A rest.li create status.
 * 
 */
@Generated(value = "com.linkedin.pegasus.generator.PegasusDataTemplateGenerator", comments = "LinkedIn Data Template. Generated from /Users/jianli/git/SocialPlayServer/restli-common/src/main/pegasus/com/linkedin/restli/common/CreateStatus.pdsc.", date = "Thu May 07 23:46:42 PDT 2015")
public class CreateStatus
    extends RecordTemplate
{

    private final static CreateStatus.Fields _fields = new CreateStatus.Fields();
    private final static RecordDataSchema SCHEMA = ((RecordDataSchema) DataTemplateUtil.parseSchema("{\"type\":\"record\",\"name\":\"CreateStatus\",\"namespace\":\"com.linkedin.restli.common\",\"doc\":\"A rest.li create status.\",\"fields\":[{\"name\":\"status\",\"type\":\"int\"},{\"name\":\"id\",\"type\":\"string\",\"optional\":true,\"deprecated\":\"The serialized form of the returned key. You can get a strongly-typed form of the key by casting CreateStatus to CreateIdStatus and calling .getKey()\"},{\"name\":\"error\",\"type\":{\"type\":\"record\",\"name\":\"ErrorResponse\",\"doc\":\"A generic ErrorResponse\",\"fields\":[{\"name\":\"status\",\"type\":\"int\",\"doc\":\"The HTTP status code\"},{\"name\":\"serviceErrorCode\",\"type\":\"int\",\"doc\":\"An service-specific error code (documented in prose)\",\"optional\":true},{\"name\":\"message\",\"type\":\"string\",\"doc\":\"A human-readable explanation of the error\",\"optional\":true},{\"name\":\"exceptionClass\",\"type\":\"string\",\"doc\":\"The FQCN of the exception thrown by the server (included the case of a server fault)\"},{\"name\":\"stackTrace\",\"type\":\"string\",\"doc\":\"The full (??) stack trace (included the case of a server fault)\"},{\"name\":\"errorDetails\",\"type\":{\"type\":\"record\",\"name\":\"ErrorDetails\",\"fields\":[]},\"optional\":true}]},\"optional\":true}]}"));
    private final static RecordDataSchema.Field FIELD_Status = SCHEMA.getField("status");
    private final static RecordDataSchema.Field FIELD_Id = SCHEMA.getField("id");
    private final static RecordDataSchema.Field FIELD_Error = SCHEMA.getField("error");

    public CreateStatus() {
        super(new DataMap(), SCHEMA);
    }

    public CreateStatus(DataMap data) {
        super(data, SCHEMA);
    }

    public static CreateStatus.Fields fields() {
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
    public CreateStatus setStatus(Integer value, SetMode mode) {
        putDirect(FIELD_Status, Integer.class, Integer.class, value, mode);
        return this;
    }

    /**
     * Setter for status
     * 
     * @see Fields#status
     */
    public CreateStatus setStatus(Integer value) {
        putDirect(FIELD_Status, Integer.class, Integer.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    /**
     * Setter for status
     * 
     * @see Fields#status
     */
    public CreateStatus setStatus(int value) {
        putDirect(FIELD_Status, Integer.class, Integer.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    /**
     * Existence checker for id
     * 
     * @deprecated
     *     The serialized form of the returned key. You can get a strongly-typed form of the key by casting CreateStatus to CreateIdStatus and calling .getKey()
     * @see Fields#id
     */
    @Deprecated
    public boolean hasId() {
        return contains(FIELD_Id);
    }

    /**
     * Remover for id
     * 
     * @deprecated
     *     The serialized form of the returned key. You can get a strongly-typed form of the key by casting CreateStatus to CreateIdStatus and calling .getKey()
     * @see Fields#id
     */
    @Deprecated
    public void removeId() {
        remove(FIELD_Id);
    }

    /**
     * Getter for id
     * 
     * @deprecated
     *     The serialized form of the returned key. You can get a strongly-typed form of the key by casting CreateStatus to CreateIdStatus and calling .getKey()
     * @see Fields#id
     */
    @Deprecated
    public String getId(GetMode mode) {
        return obtainDirect(FIELD_Id, String.class, mode);
    }

    /**
     * Getter for id
     * 
     * @deprecated
     *     The serialized form of the returned key. You can get a strongly-typed form of the key by casting CreateStatus to CreateIdStatus and calling .getKey()
     * @see Fields#id
     */
    @Deprecated
    public String getId() {
        return getId(GetMode.STRICT);
    }

    /**
     * Setter for id
     * 
     * @deprecated
     *     The serialized form of the returned key. You can get a strongly-typed form of the key by casting CreateStatus to CreateIdStatus and calling .getKey()
     * @see Fields#id
     */
    @Deprecated
    public CreateStatus setId(String value, SetMode mode) {
        putDirect(FIELD_Id, String.class, String.class, value, mode);
        return this;
    }

    /**
     * Setter for id
     * 
     * @deprecated
     *     The serialized form of the returned key. You can get a strongly-typed form of the key by casting CreateStatus to CreateIdStatus and calling .getKey()
     * @see Fields#id
     */
    @Deprecated
    public CreateStatus setId(String value) {
        putDirect(FIELD_Id, String.class, String.class, value, SetMode.DISALLOW_NULL);
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
    public CreateStatus setError(ErrorResponse value, SetMode mode) {
        putWrapped(FIELD_Error, ErrorResponse.class, value, mode);
        return this;
    }

    /**
     * Setter for error
     * 
     * @see Fields#error
     */
    public CreateStatus setError(ErrorResponse value) {
        putWrapped(FIELD_Error, ErrorResponse.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    @Override
    public CreateStatus clone()
        throws CloneNotSupportedException
    {
        return ((CreateStatus) super.clone());
    }

    @Override
    public CreateStatus copy()
        throws CloneNotSupportedException
    {
        return ((CreateStatus) super.copy());
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

        /**
         * 
         * @deprecated
         *     The serialized form of the returned key. You can get a strongly-typed form of the key by casting CreateStatus to CreateIdStatus and calling .getKey()
         */
        @Deprecated
        public PathSpec id() {
            return new PathSpec(getPathComponents(), "id");
        }

        public com.linkedin.restli.common.ErrorResponse.Fields error() {
            return new com.linkedin.restli.common.ErrorResponse.Fields(getPathComponents(), "error");
        }

    }

}

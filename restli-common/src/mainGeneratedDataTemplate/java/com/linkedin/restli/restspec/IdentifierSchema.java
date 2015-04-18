
package com.linkedin.restli.restspec;

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
 * 
 * 
 */
@Generated(value = "com.linkedin.pegasus.generator.PegasusDataTemplateGenerator", comments = "LinkedIn Data Template. Generated from /Users/jianli/git/SocialPlayServer/restli-common/src/main/pegasus/com/linkedin/restli/restspec/IdentifierSchema.pdsc.", date = "Fri Apr 17 15:52:47 PDT 2015")
public class IdentifierSchema
    extends RecordTemplate
{

    private final static IdentifierSchema.Fields _fields = new IdentifierSchema.Fields();
    private final static RecordDataSchema SCHEMA = ((RecordDataSchema) DataTemplateUtil.parseSchema("{\"type\":\"record\",\"name\":\"IdentifierSchema\",\"namespace\":\"com.linkedin.restli.restspec\",\"fields\":[{\"name\":\"name\",\"type\":\"string\",\"doc\":\"name of the identifier\"},{\"name\":\"type\",\"type\":\"string\",\"doc\":\"avro type of the identifier\"},{\"name\":\"params\",\"type\":\"string\",\"doc\":\"avro type of the identifier parameters\",\"optional\":true}]}"));
    private final static RecordDataSchema.Field FIELD_Name = SCHEMA.getField("name");
    private final static RecordDataSchema.Field FIELD_Type = SCHEMA.getField("type");
    private final static RecordDataSchema.Field FIELD_Params = SCHEMA.getField("params");

    public IdentifierSchema() {
        super(new DataMap(), SCHEMA);
    }

    public IdentifierSchema(DataMap data) {
        super(data, SCHEMA);
    }

    public static IdentifierSchema.Fields fields() {
        return _fields;
    }

    /**
     * Existence checker for name
     * 
     * @see Fields#name
     */
    public boolean hasName() {
        return contains(FIELD_Name);
    }

    /**
     * Remover for name
     * 
     * @see Fields#name
     */
    public void removeName() {
        remove(FIELD_Name);
    }

    /**
     * Getter for name
     * 
     * @see Fields#name
     */
    public String getName(GetMode mode) {
        return obtainDirect(FIELD_Name, String.class, mode);
    }

    /**
     * Getter for name
     * 
     * @see Fields#name
     */
    public String getName() {
        return getName(GetMode.STRICT);
    }

    /**
     * Setter for name
     * 
     * @see Fields#name
     */
    public IdentifierSchema setName(String value, SetMode mode) {
        putDirect(FIELD_Name, String.class, String.class, value, mode);
        return this;
    }

    /**
     * Setter for name
     * 
     * @see Fields#name
     */
    public IdentifierSchema setName(String value) {
        putDirect(FIELD_Name, String.class, String.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    /**
     * Existence checker for type
     * 
     * @see Fields#type
     */
    public boolean hasType() {
        return contains(FIELD_Type);
    }

    /**
     * Remover for type
     * 
     * @see Fields#type
     */
    public void removeType() {
        remove(FIELD_Type);
    }

    /**
     * Getter for type
     * 
     * @see Fields#type
     */
    public String getType(GetMode mode) {
        return obtainDirect(FIELD_Type, String.class, mode);
    }

    /**
     * Getter for type
     * 
     * @see Fields#type
     */
    public String getType() {
        return getType(GetMode.STRICT);
    }

    /**
     * Setter for type
     * 
     * @see Fields#type
     */
    public IdentifierSchema setType(String value, SetMode mode) {
        putDirect(FIELD_Type, String.class, String.class, value, mode);
        return this;
    }

    /**
     * Setter for type
     * 
     * @see Fields#type
     */
    public IdentifierSchema setType(String value) {
        putDirect(FIELD_Type, String.class, String.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    /**
     * Existence checker for params
     * 
     * @see Fields#params
     */
    public boolean hasParams() {
        return contains(FIELD_Params);
    }

    /**
     * Remover for params
     * 
     * @see Fields#params
     */
    public void removeParams() {
        remove(FIELD_Params);
    }

    /**
     * Getter for params
     * 
     * @see Fields#params
     */
    public String getParams(GetMode mode) {
        return obtainDirect(FIELD_Params, String.class, mode);
    }

    /**
     * Getter for params
     * 
     * @see Fields#params
     */
    public String getParams() {
        return getParams(GetMode.STRICT);
    }

    /**
     * Setter for params
     * 
     * @see Fields#params
     */
    public IdentifierSchema setParams(String value, SetMode mode) {
        putDirect(FIELD_Params, String.class, String.class, value, mode);
        return this;
    }

    /**
     * Setter for params
     * 
     * @see Fields#params
     */
    public IdentifierSchema setParams(String value) {
        putDirect(FIELD_Params, String.class, String.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    @Override
    public IdentifierSchema clone()
        throws CloneNotSupportedException
    {
        return ((IdentifierSchema) super.clone());
    }

    @Override
    public IdentifierSchema copy()
        throws CloneNotSupportedException
    {
        return ((IdentifierSchema) super.copy());
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
         * name of the identifier
         * 
         */
        public PathSpec name() {
            return new PathSpec(getPathComponents(), "name");
        }

        /**
         * avro type of the identifier
         * 
         */
        public PathSpec type() {
            return new PathSpec(getPathComponents(), "type");
        }

        /**
         * avro type of the identifier parameters
         * 
         */
        public PathSpec params() {
            return new PathSpec(getPathComponents(), "params");
        }

    }

}

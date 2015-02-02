
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
@Generated(value = "com.linkedin.pegasus.generator.PegasusDataTemplateGenerator", comments = "LinkedIn Data Template. Generated from /Users/jianli/workspaces/SocialPlayServer/restli-common/src/main/pegasus/com/linkedin/restli/restspec/AssocKeySchema.pdsc.", date = "Wed Jan 14 22:36:03 PST 2015")
public class AssocKeySchema
    extends RecordTemplate
{

    private final static AssocKeySchema.Fields _fields = new AssocKeySchema.Fields();
    private final static RecordDataSchema SCHEMA = ((RecordDataSchema) DataTemplateUtil.parseSchema("{\"type\":\"record\",\"name\":\"AssocKeySchema\",\"namespace\":\"com.linkedin.restli.restspec\",\"fields\":[{\"name\":\"name\",\"type\":\"string\",\"doc\":\"name of association key\"},{\"name\":\"type\",\"type\":\"string\",\"doc\":\"avro type of association key\"}]}"));
    private final static RecordDataSchema.Field FIELD_Name = SCHEMA.getField("name");
    private final static RecordDataSchema.Field FIELD_Type = SCHEMA.getField("type");

    public AssocKeySchema() {
        super(new DataMap(), SCHEMA);
    }

    public AssocKeySchema(DataMap data) {
        super(data, SCHEMA);
    }

    public static AssocKeySchema.Fields fields() {
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
    public AssocKeySchema setName(String value, SetMode mode) {
        putDirect(FIELD_Name, String.class, String.class, value, mode);
        return this;
    }

    /**
     * Setter for name
     * 
     * @see Fields#name
     */
    public AssocKeySchema setName(String value) {
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
    public AssocKeySchema setType(String value, SetMode mode) {
        putDirect(FIELD_Type, String.class, String.class, value, mode);
        return this;
    }

    /**
     * Setter for type
     * 
     * @see Fields#type
     */
    public AssocKeySchema setType(String value) {
        putDirect(FIELD_Type, String.class, String.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    @Override
    public AssocKeySchema clone()
        throws CloneNotSupportedException
    {
        return ((AssocKeySchema) super.clone());
    }

    @Override
    public AssocKeySchema copy()
        throws CloneNotSupportedException
    {
        return ((AssocKeySchema) super.copy());
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
         * name of association key
         * 
         */
        public PathSpec name() {
            return new PathSpec(getPathComponents(), "name");
        }

        /**
         * avro type of association key
         * 
         */
        public PathSpec type() {
            return new PathSpec(getPathComponents(), "type");
        }

    }

}

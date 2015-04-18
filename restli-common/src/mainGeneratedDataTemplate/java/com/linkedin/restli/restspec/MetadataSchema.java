
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
@Generated(value = "com.linkedin.pegasus.generator.PegasusDataTemplateGenerator", comments = "LinkedIn Data Template. Generated from /Users/jianli/git/SocialPlayServer/restli-common/src/main/pegasus/com/linkedin/restli/restspec/MetadataSchema.pdsc.", date = "Fri Apr 17 15:52:47 PDT 2015")
public class MetadataSchema
    extends RecordTemplate
{

    private final static MetadataSchema.Fields _fields = new MetadataSchema.Fields();
    private final static RecordDataSchema SCHEMA = ((RecordDataSchema) DataTemplateUtil.parseSchema("{\"type\":\"record\",\"name\":\"MetadataSchema\",\"namespace\":\"com.linkedin.restli.restspec\",\"fields\":[{\"name\":\"type\",\"type\":\"string\",\"doc\":\"pegasus type of the metadata\"}]}"));
    private final static RecordDataSchema.Field FIELD_Type = SCHEMA.getField("type");

    public MetadataSchema() {
        super(new DataMap(), SCHEMA);
    }

    public MetadataSchema(DataMap data) {
        super(data, SCHEMA);
    }

    public static MetadataSchema.Fields fields() {
        return _fields;
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
    public MetadataSchema setType(String value, SetMode mode) {
        putDirect(FIELD_Type, String.class, String.class, value, mode);
        return this;
    }

    /**
     * Setter for type
     * 
     * @see Fields#type
     */
    public MetadataSchema setType(String value) {
        putDirect(FIELD_Type, String.class, String.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    @Override
    public MetadataSchema clone()
        throws CloneNotSupportedException
    {
        return ((MetadataSchema) super.clone());
    }

    @Override
    public MetadataSchema copy()
        throws CloneNotSupportedException
    {
        return ((MetadataSchema) super.copy());
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
         * pegasus type of the metadata
         * 
         */
        public PathSpec type() {
            return new PathSpec(getPathComponents(), "type");
        }

    }

}

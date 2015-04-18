
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
 * Custom annotation for idl
 * 
 */
@Generated(value = "com.linkedin.pegasus.generator.PegasusDataTemplateGenerator", comments = "LinkedIn Data Template. Generated from /Users/jianli/git/SocialPlayServer/restli-common/src/main/pegasus/com/linkedin/restli/restspec/CustomAnnotationSchema.pdsc.", date = "Fri Apr 17 15:52:47 PDT 2015")
public class CustomAnnotationSchema
    extends RecordTemplate
{

    private final static CustomAnnotationSchema.Fields _fields = new CustomAnnotationSchema.Fields();
    private final static RecordDataSchema SCHEMA = ((RecordDataSchema) DataTemplateUtil.parseSchema("{\"type\":\"record\",\"name\":\"CustomAnnotationSchema\",\"namespace\":\"com.linkedin.restli.restspec\",\"doc\":\"Custom annotation for idl\",\"fields\":[{\"name\":\"annotations\",\"type\":{\"type\":\"map\",\"values\":{\"type\":\"record\",\"name\":\"CustomAnnotationContentSchema\",\"doc\":\"Unstructured record that represents arbitrary custom annotations for idl. Actual content is always a map with annotation's overridable member name as key and member value as value\",\"fields\":[]}},\"doc\":\"custom annotation data\",\"optional\":true}]}"));
    private final static RecordDataSchema.Field FIELD_Annotations = SCHEMA.getField("annotations");

    public CustomAnnotationSchema() {
        super(new DataMap(), SCHEMA);
    }

    public CustomAnnotationSchema(DataMap data) {
        super(data, SCHEMA);
    }

    public static CustomAnnotationSchema.Fields fields() {
        return _fields;
    }

    /**
     * Existence checker for annotations
     * 
     * @see Fields#annotations
     */
    public boolean hasAnnotations() {
        return contains(FIELD_Annotations);
    }

    /**
     * Remover for annotations
     * 
     * @see Fields#annotations
     */
    public void removeAnnotations() {
        remove(FIELD_Annotations);
    }

    /**
     * Getter for annotations
     * 
     * @see Fields#annotations
     */
    public CustomAnnotationContentSchemaMap getAnnotations(GetMode mode) {
        return obtainWrapped(FIELD_Annotations, CustomAnnotationContentSchemaMap.class, mode);
    }

    /**
     * Getter for annotations
     * 
     * @see Fields#annotations
     */
    public CustomAnnotationContentSchemaMap getAnnotations() {
        return getAnnotations(GetMode.STRICT);
    }

    /**
     * Setter for annotations
     * 
     * @see Fields#annotations
     */
    public CustomAnnotationSchema setAnnotations(CustomAnnotationContentSchemaMap value, SetMode mode) {
        putWrapped(FIELD_Annotations, CustomAnnotationContentSchemaMap.class, value, mode);
        return this;
    }

    /**
     * Setter for annotations
     * 
     * @see Fields#annotations
     */
    public CustomAnnotationSchema setAnnotations(CustomAnnotationContentSchemaMap value) {
        putWrapped(FIELD_Annotations, CustomAnnotationContentSchemaMap.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    @Override
    public CustomAnnotationSchema clone()
        throws CloneNotSupportedException
    {
        return ((CustomAnnotationSchema) super.clone());
    }

    @Override
    public CustomAnnotationSchema copy()
        throws CloneNotSupportedException
    {
        return ((CustomAnnotationSchema) super.copy());
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
         * custom annotation data
         * 
         */
        public com.linkedin.restli.restspec.CustomAnnotationContentSchemaMap.Fields annotations() {
            return new com.linkedin.restli.restspec.CustomAnnotationContentSchemaMap.Fields(getPathComponents(), "annotations");
        }

    }

}

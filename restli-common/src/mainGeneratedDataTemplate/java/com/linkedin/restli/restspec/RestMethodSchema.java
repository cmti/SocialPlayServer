
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
@Generated(value = "com.linkedin.pegasus.generator.PegasusDataTemplateGenerator", comments = "LinkedIn Data Template. Generated from /Users/jianli/git/SocialPlayServer/restli-common/src/main/pegasus/com/linkedin/restli/restspec/RestMethodSchema.pdsc.", date = "Thu May 07 23:46:42 PDT 2015")
public class RestMethodSchema
    extends RecordTemplate
{

    private final static RestMethodSchema.Fields _fields = new RestMethodSchema.Fields();
    private final static RecordDataSchema SCHEMA = ((RecordDataSchema) DataTemplateUtil.parseSchema("{\"type\":\"record\",\"name\":\"RestMethodSchema\",\"namespace\":\"com.linkedin.restli.restspec\",\"include\":[{\"type\":\"record\",\"name\":\"CustomAnnotationSchema\",\"doc\":\"Custom annotation for idl\",\"fields\":[{\"name\":\"annotations\",\"type\":{\"type\":\"map\",\"values\":{\"type\":\"record\",\"name\":\"CustomAnnotationContentSchema\",\"doc\":\"Unstructured record that represents arbitrary custom annotations for idl. Actual content is always a map with annotation's overridable member name as key and member value as value\",\"fields\":[]}},\"doc\":\"custom annotation data\",\"optional\":true}]}],\"fields\":[{\"name\":\"method\",\"type\":\"string\",\"doc\":\"method type for this rest method\"},{\"name\":\"doc\",\"type\":\"string\",\"doc\":\"Documentation for this finder\",\"optional\":true},{\"name\":\"parameters\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"ParameterSchema\",\"include\":[\"CustomAnnotationSchema\"],\"fields\":[{\"name\":\"name\",\"type\":\"string\",\"doc\":\"name of this parameter\"},{\"name\":\"type\",\"type\":\"string\",\"doc\":\"avro type of this parameter\"},{\"name\":\"items\",\"type\":\"string\",\"doc\":\"type of individual items, if this is an array parameter (used for finder parameters)\",\"optional\":true},{\"name\":\"optional\",\"type\":\"boolean\",\"doc\":\"indicates whether this parameter is optional.  omitted for required parameters\",\"optional\":true},{\"name\":\"default\",\"type\":\"string\",\"doc\":\"indicates the default value for this parameter\",\"optional\":true},{\"name\":\"doc\",\"type\":\"string\",\"doc\":\"Documentation for this parameter\",\"optional\":true}]}},\"doc\":\"list of query parameters for this method\",\"optional\":true}]}"));
    private final static RecordDataSchema.Field FIELD_Annotations = SCHEMA.getField("annotations");
    private final static RecordDataSchema.Field FIELD_Method = SCHEMA.getField("method");
    private final static RecordDataSchema.Field FIELD_Doc = SCHEMA.getField("doc");
    private final static RecordDataSchema.Field FIELD_Parameters = SCHEMA.getField("parameters");

    public RestMethodSchema() {
        super(new DataMap(), SCHEMA);
    }

    public RestMethodSchema(DataMap data) {
        super(data, SCHEMA);
    }

    public static RestMethodSchema.Fields fields() {
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
    public RestMethodSchema setAnnotations(CustomAnnotationContentSchemaMap value, SetMode mode) {
        putWrapped(FIELD_Annotations, CustomAnnotationContentSchemaMap.class, value, mode);
        return this;
    }

    /**
     * Setter for annotations
     * 
     * @see Fields#annotations
     */
    public RestMethodSchema setAnnotations(CustomAnnotationContentSchemaMap value) {
        putWrapped(FIELD_Annotations, CustomAnnotationContentSchemaMap.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    /**
     * Existence checker for method
     * 
     * @see Fields#method
     */
    public boolean hasMethod() {
        return contains(FIELD_Method);
    }

    /**
     * Remover for method
     * 
     * @see Fields#method
     */
    public void removeMethod() {
        remove(FIELD_Method);
    }

    /**
     * Getter for method
     * 
     * @see Fields#method
     */
    public String getMethod(GetMode mode) {
        return obtainDirect(FIELD_Method, String.class, mode);
    }

    /**
     * Getter for method
     * 
     * @see Fields#method
     */
    public String getMethod() {
        return getMethod(GetMode.STRICT);
    }

    /**
     * Setter for method
     * 
     * @see Fields#method
     */
    public RestMethodSchema setMethod(String value, SetMode mode) {
        putDirect(FIELD_Method, String.class, String.class, value, mode);
        return this;
    }

    /**
     * Setter for method
     * 
     * @see Fields#method
     */
    public RestMethodSchema setMethod(String value) {
        putDirect(FIELD_Method, String.class, String.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    /**
     * Existence checker for doc
     * 
     * @see Fields#doc
     */
    public boolean hasDoc() {
        return contains(FIELD_Doc);
    }

    /**
     * Remover for doc
     * 
     * @see Fields#doc
     */
    public void removeDoc() {
        remove(FIELD_Doc);
    }

    /**
     * Getter for doc
     * 
     * @see Fields#doc
     */
    public String getDoc(GetMode mode) {
        return obtainDirect(FIELD_Doc, String.class, mode);
    }

    /**
     * Getter for doc
     * 
     * @see Fields#doc
     */
    public String getDoc() {
        return getDoc(GetMode.STRICT);
    }

    /**
     * Setter for doc
     * 
     * @see Fields#doc
     */
    public RestMethodSchema setDoc(String value, SetMode mode) {
        putDirect(FIELD_Doc, String.class, String.class, value, mode);
        return this;
    }

    /**
     * Setter for doc
     * 
     * @see Fields#doc
     */
    public RestMethodSchema setDoc(String value) {
        putDirect(FIELD_Doc, String.class, String.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    /**
     * Existence checker for parameters
     * 
     * @see Fields#parameters
     */
    public boolean hasParameters() {
        return contains(FIELD_Parameters);
    }

    /**
     * Remover for parameters
     * 
     * @see Fields#parameters
     */
    public void removeParameters() {
        remove(FIELD_Parameters);
    }

    /**
     * Getter for parameters
     * 
     * @see Fields#parameters
     */
    public ParameterSchemaArray getParameters(GetMode mode) {
        return obtainWrapped(FIELD_Parameters, ParameterSchemaArray.class, mode);
    }

    /**
     * Getter for parameters
     * 
     * @see Fields#parameters
     */
    public ParameterSchemaArray getParameters() {
        return getParameters(GetMode.STRICT);
    }

    /**
     * Setter for parameters
     * 
     * @see Fields#parameters
     */
    public RestMethodSchema setParameters(ParameterSchemaArray value, SetMode mode) {
        putWrapped(FIELD_Parameters, ParameterSchemaArray.class, value, mode);
        return this;
    }

    /**
     * Setter for parameters
     * 
     * @see Fields#parameters
     */
    public RestMethodSchema setParameters(ParameterSchemaArray value) {
        putWrapped(FIELD_Parameters, ParameterSchemaArray.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    @Override
    public RestMethodSchema clone()
        throws CloneNotSupportedException
    {
        return ((RestMethodSchema) super.clone());
    }

    @Override
    public RestMethodSchema copy()
        throws CloneNotSupportedException
    {
        return ((RestMethodSchema) super.copy());
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

        /**
         * method type for this rest method
         * 
         */
        public PathSpec method() {
            return new PathSpec(getPathComponents(), "method");
        }

        /**
         * Documentation for this finder
         * 
         */
        public PathSpec doc() {
            return new PathSpec(getPathComponents(), "doc");
        }

        /**
         * list of query parameters for this method
         * 
         */
        public com.linkedin.restli.restspec.ParameterSchemaArray.Fields parameters() {
            return new com.linkedin.restli.restspec.ParameterSchemaArray.Fields(getPathComponents(), "parameters");
        }

    }

}


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
@Generated(value = "com.linkedin.pegasus.generator.PegasusDataTemplateGenerator", comments = "LinkedIn Data Template. Generated from /Users/jianli/workspaces/SocialPlayServer/restli-common/src/main/pegasus/com/linkedin/restli/restspec/ParameterSchema.pdsc.", date = "Wed Jan 14 22:36:03 PST 2015")
public class ParameterSchema
    extends RecordTemplate
{

    private final static ParameterSchema.Fields _fields = new ParameterSchema.Fields();
    private final static RecordDataSchema SCHEMA = ((RecordDataSchema) DataTemplateUtil.parseSchema("{\"type\":\"record\",\"name\":\"ParameterSchema\",\"namespace\":\"com.linkedin.restli.restspec\",\"include\":[{\"type\":\"record\",\"name\":\"CustomAnnotationSchema\",\"doc\":\"Custom annotation for idl\",\"fields\":[{\"name\":\"annotations\",\"type\":{\"type\":\"map\",\"values\":{\"type\":\"record\",\"name\":\"CustomAnnotationContentSchema\",\"doc\":\"Unstructured record that represents arbitrary custom annotations for idl. Actual content is always a map with annotation's overridable member name as key and member value as value\",\"fields\":[]}},\"doc\":\"custom annotation data\",\"optional\":true}]}],\"fields\":[{\"name\":\"name\",\"type\":\"string\",\"doc\":\"name of this parameter\"},{\"name\":\"type\",\"type\":\"string\",\"doc\":\"avro type of this parameter\"},{\"name\":\"items\",\"type\":\"string\",\"doc\":\"type of individual items, if this is an array parameter (used for finder parameters)\",\"optional\":true},{\"name\":\"optional\",\"type\":\"boolean\",\"doc\":\"indicates whether this parameter is optional.  omitted for required parameters\",\"optional\":true},{\"name\":\"default\",\"type\":\"string\",\"doc\":\"indicates the default value for this parameter\",\"optional\":true},{\"name\":\"doc\",\"type\":\"string\",\"doc\":\"Documentation for this parameter\",\"optional\":true}]}"));
    private final static RecordDataSchema.Field FIELD_Annotations = SCHEMA.getField("annotations");
    private final static RecordDataSchema.Field FIELD_Name = SCHEMA.getField("name");
    private final static RecordDataSchema.Field FIELD_Type = SCHEMA.getField("type");
    private final static RecordDataSchema.Field FIELD_Items = SCHEMA.getField("items");
    private final static RecordDataSchema.Field FIELD_Optional = SCHEMA.getField("optional");
    private final static RecordDataSchema.Field FIELD_Default = SCHEMA.getField("default");
    private final static RecordDataSchema.Field FIELD_Doc = SCHEMA.getField("doc");

    public ParameterSchema() {
        super(new DataMap(), SCHEMA);
    }

    public ParameterSchema(DataMap data) {
        super(data, SCHEMA);
    }

    public static ParameterSchema.Fields fields() {
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
    public ParameterSchema setAnnotations(CustomAnnotationContentSchemaMap value, SetMode mode) {
        putWrapped(FIELD_Annotations, CustomAnnotationContentSchemaMap.class, value, mode);
        return this;
    }

    /**
     * Setter for annotations
     * 
     * @see Fields#annotations
     */
    public ParameterSchema setAnnotations(CustomAnnotationContentSchemaMap value) {
        putWrapped(FIELD_Annotations, CustomAnnotationContentSchemaMap.class, value, SetMode.DISALLOW_NULL);
        return this;
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
    public ParameterSchema setName(String value, SetMode mode) {
        putDirect(FIELD_Name, String.class, String.class, value, mode);
        return this;
    }

    /**
     * Setter for name
     * 
     * @see Fields#name
     */
    public ParameterSchema setName(String value) {
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
    public ParameterSchema setType(String value, SetMode mode) {
        putDirect(FIELD_Type, String.class, String.class, value, mode);
        return this;
    }

    /**
     * Setter for type
     * 
     * @see Fields#type
     */
    public ParameterSchema setType(String value) {
        putDirect(FIELD_Type, String.class, String.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    /**
     * Existence checker for items
     * 
     * @see Fields#items
     */
    public boolean hasItems() {
        return contains(FIELD_Items);
    }

    /**
     * Remover for items
     * 
     * @see Fields#items
     */
    public void removeItems() {
        remove(FIELD_Items);
    }

    /**
     * Getter for items
     * 
     * @see Fields#items
     */
    public String getItems(GetMode mode) {
        return obtainDirect(FIELD_Items, String.class, mode);
    }

    /**
     * Getter for items
     * 
     * @see Fields#items
     */
    public String getItems() {
        return getItems(GetMode.STRICT);
    }

    /**
     * Setter for items
     * 
     * @see Fields#items
     */
    public ParameterSchema setItems(String value, SetMode mode) {
        putDirect(FIELD_Items, String.class, String.class, value, mode);
        return this;
    }

    /**
     * Setter for items
     * 
     * @see Fields#items
     */
    public ParameterSchema setItems(String value) {
        putDirect(FIELD_Items, String.class, String.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    /**
     * Existence checker for optional
     * 
     * @see Fields#optional
     */
    public boolean hasOptional() {
        return contains(FIELD_Optional);
    }

    /**
     * Remover for optional
     * 
     * @see Fields#optional
     */
    public void removeOptional() {
        remove(FIELD_Optional);
    }

    /**
     * Getter for optional
     * 
     * @see Fields#optional
     */
    public Boolean isOptional(GetMode mode) {
        return obtainDirect(FIELD_Optional, Boolean.class, mode);
    }

    /**
     * Getter for optional
     * 
     * @see Fields#optional
     */
    public Boolean isOptional() {
        return isOptional(GetMode.STRICT);
    }

    /**
     * Setter for optional
     * 
     * @see Fields#optional
     */
    public ParameterSchema setOptional(Boolean value, SetMode mode) {
        putDirect(FIELD_Optional, Boolean.class, Boolean.class, value, mode);
        return this;
    }

    /**
     * Setter for optional
     * 
     * @see Fields#optional
     */
    public ParameterSchema setOptional(Boolean value) {
        putDirect(FIELD_Optional, Boolean.class, Boolean.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    /**
     * Setter for optional
     * 
     * @see Fields#optional
     */
    public ParameterSchema setOptional(boolean value) {
        putDirect(FIELD_Optional, Boolean.class, Boolean.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    /**
     * Existence checker for default
     * 
     * @see Fields#default_
     */
    public boolean hasDefault() {
        return contains(FIELD_Default);
    }

    /**
     * Remover for default
     * 
     * @see Fields#default_
     */
    public void removeDefault() {
        remove(FIELD_Default);
    }

    /**
     * Getter for default
     * 
     * @see Fields#default_
     */
    public String getDefault(GetMode mode) {
        return obtainDirect(FIELD_Default, String.class, mode);
    }

    /**
     * Getter for default
     * 
     * @see Fields#default_
     */
    public String getDefault() {
        return getDefault(GetMode.STRICT);
    }

    /**
     * Setter for default
     * 
     * @see Fields#default_
     */
    public ParameterSchema setDefault(String value, SetMode mode) {
        putDirect(FIELD_Default, String.class, String.class, value, mode);
        return this;
    }

    /**
     * Setter for default
     * 
     * @see Fields#default_
     */
    public ParameterSchema setDefault(String value) {
        putDirect(FIELD_Default, String.class, String.class, value, SetMode.DISALLOW_NULL);
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
    public ParameterSchema setDoc(String value, SetMode mode) {
        putDirect(FIELD_Doc, String.class, String.class, value, mode);
        return this;
    }

    /**
     * Setter for doc
     * 
     * @see Fields#doc
     */
    public ParameterSchema setDoc(String value) {
        putDirect(FIELD_Doc, String.class, String.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    @Override
    public ParameterSchema clone()
        throws CloneNotSupportedException
    {
        return ((ParameterSchema) super.clone());
    }

    @Override
    public ParameterSchema copy()
        throws CloneNotSupportedException
    {
        return ((ParameterSchema) super.copy());
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
         * name of this parameter
         * 
         */
        public PathSpec name() {
            return new PathSpec(getPathComponents(), "name");
        }

        /**
         * avro type of this parameter
         * 
         */
        public PathSpec type() {
            return new PathSpec(getPathComponents(), "type");
        }

        /**
         * type of individual items, if this is an array parameter (used for finder parameters)
         * 
         */
        public PathSpec items() {
            return new PathSpec(getPathComponents(), "items");
        }

        /**
         * indicates whether this parameter is optional.  omitted for required parameters
         * 
         */
        public PathSpec optional() {
            return new PathSpec(getPathComponents(), "optional");
        }

        /**
         * indicates the default value for this parameter
         * 
         */
        public PathSpec default_() {
            return new PathSpec(getPathComponents(), "default");
        }

        /**
         * Documentation for this parameter
         * 
         */
        public PathSpec doc() {
            return new PathSpec(getPathComponents(), "doc");
        }

    }

}

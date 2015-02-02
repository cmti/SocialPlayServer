
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
import com.linkedin.data.template.StringArray;


/**
 * 
 * 
 */
@Generated(value = "com.linkedin.pegasus.generator.PegasusDataTemplateGenerator", comments = "LinkedIn Data Template. Generated from /Users/jianli/workspaces/SocialPlayServer/restli-common/src/main/pegasus/com/linkedin/restli/restspec/ActionSchema.pdsc.", date = "Wed Jan 14 22:36:03 PST 2015")
public class ActionSchema
    extends RecordTemplate
{

    private final static ActionSchema.Fields _fields = new ActionSchema.Fields();
    private final static RecordDataSchema SCHEMA = ((RecordDataSchema) DataTemplateUtil.parseSchema("{\"type\":\"record\",\"name\":\"ActionSchema\",\"namespace\":\"com.linkedin.restli.restspec\",\"include\":[{\"type\":\"record\",\"name\":\"CustomAnnotationSchema\",\"doc\":\"Custom annotation for idl\",\"fields\":[{\"name\":\"annotations\",\"type\":{\"type\":\"map\",\"values\":{\"type\":\"record\",\"name\":\"CustomAnnotationContentSchema\",\"doc\":\"Unstructured record that represents arbitrary custom annotations for idl. Actual content is always a map with annotation's overridable member name as key and member value as value\",\"fields\":[]}},\"doc\":\"custom annotation data\",\"optional\":true}]}],\"fields\":[{\"name\":\"name\",\"type\":\"string\",\"doc\":\"name of this action\"},{\"name\":\"doc\",\"type\":\"string\",\"doc\":\"Documentation for this action\",\"optional\":true},{\"name\":\"parameters\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"ParameterSchema\",\"include\":[\"CustomAnnotationSchema\"],\"fields\":[{\"name\":\"name\",\"type\":\"string\",\"doc\":\"name of this parameter\"},{\"name\":\"type\",\"type\":\"string\",\"doc\":\"avro type of this parameter\"},{\"name\":\"items\",\"type\":\"string\",\"doc\":\"type of individual items, if this is an array parameter (used for finder parameters)\",\"optional\":true},{\"name\":\"optional\",\"type\":\"boolean\",\"doc\":\"indicates whether this parameter is optional.  omitted for required parameters\",\"optional\":true},{\"name\":\"default\",\"type\":\"string\",\"doc\":\"indicates the default value for this parameter\",\"optional\":true},{\"name\":\"doc\",\"type\":\"string\",\"doc\":\"Documentation for this parameter\",\"optional\":true}]}},\"doc\":\"parameters for this action\",\"optional\":true},{\"name\":\"returns\",\"type\":\"string\",\"doc\":\"avro type of this action's return value\",\"optional\":true},{\"name\":\"throws\",\"type\":{\"type\":\"array\",\"items\":\"string\"},\"doc\":\"list of exception types thrown by this action\",\"optional\":true}]}"));
    private final static RecordDataSchema.Field FIELD_Annotations = SCHEMA.getField("annotations");
    private final static RecordDataSchema.Field FIELD_Name = SCHEMA.getField("name");
    private final static RecordDataSchema.Field FIELD_Doc = SCHEMA.getField("doc");
    private final static RecordDataSchema.Field FIELD_Parameters = SCHEMA.getField("parameters");
    private final static RecordDataSchema.Field FIELD_Returns = SCHEMA.getField("returns");
    private final static RecordDataSchema.Field FIELD_Throws = SCHEMA.getField("throws");

    public ActionSchema() {
        super(new DataMap(), SCHEMA);
    }

    public ActionSchema(DataMap data) {
        super(data, SCHEMA);
    }

    public static ActionSchema.Fields fields() {
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
    public ActionSchema setAnnotations(CustomAnnotationContentSchemaMap value, SetMode mode) {
        putWrapped(FIELD_Annotations, CustomAnnotationContentSchemaMap.class, value, mode);
        return this;
    }

    /**
     * Setter for annotations
     * 
     * @see Fields#annotations
     */
    public ActionSchema setAnnotations(CustomAnnotationContentSchemaMap value) {
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
    public ActionSchema setName(String value, SetMode mode) {
        putDirect(FIELD_Name, String.class, String.class, value, mode);
        return this;
    }

    /**
     * Setter for name
     * 
     * @see Fields#name
     */
    public ActionSchema setName(String value) {
        putDirect(FIELD_Name, String.class, String.class, value, SetMode.DISALLOW_NULL);
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
    public ActionSchema setDoc(String value, SetMode mode) {
        putDirect(FIELD_Doc, String.class, String.class, value, mode);
        return this;
    }

    /**
     * Setter for doc
     * 
     * @see Fields#doc
     */
    public ActionSchema setDoc(String value) {
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
    public ActionSchema setParameters(ParameterSchemaArray value, SetMode mode) {
        putWrapped(FIELD_Parameters, ParameterSchemaArray.class, value, mode);
        return this;
    }

    /**
     * Setter for parameters
     * 
     * @see Fields#parameters
     */
    public ActionSchema setParameters(ParameterSchemaArray value) {
        putWrapped(FIELD_Parameters, ParameterSchemaArray.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    /**
     * Existence checker for returns
     * 
     * @see Fields#returns
     */
    public boolean hasReturns() {
        return contains(FIELD_Returns);
    }

    /**
     * Remover for returns
     * 
     * @see Fields#returns
     */
    public void removeReturns() {
        remove(FIELD_Returns);
    }

    /**
     * Getter for returns
     * 
     * @see Fields#returns
     */
    public String getReturns(GetMode mode) {
        return obtainDirect(FIELD_Returns, String.class, mode);
    }

    /**
     * Getter for returns
     * 
     * @see Fields#returns
     */
    public String getReturns() {
        return getReturns(GetMode.STRICT);
    }

    /**
     * Setter for returns
     * 
     * @see Fields#returns
     */
    public ActionSchema setReturns(String value, SetMode mode) {
        putDirect(FIELD_Returns, String.class, String.class, value, mode);
        return this;
    }

    /**
     * Setter for returns
     * 
     * @see Fields#returns
     */
    public ActionSchema setReturns(String value) {
        putDirect(FIELD_Returns, String.class, String.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    /**
     * Existence checker for throws
     * 
     * @see Fields#throws_
     */
    public boolean hasThrows() {
        return contains(FIELD_Throws);
    }

    /**
     * Remover for throws
     * 
     * @see Fields#throws_
     */
    public void removeThrows() {
        remove(FIELD_Throws);
    }

    /**
     * Getter for throws
     * 
     * @see Fields#throws_
     */
    public StringArray getThrows(GetMode mode) {
        return obtainWrapped(FIELD_Throws, StringArray.class, mode);
    }

    /**
     * Getter for throws
     * 
     * @see Fields#throws_
     */
    public StringArray getThrows() {
        return getThrows(GetMode.STRICT);
    }

    /**
     * Setter for throws
     * 
     * @see Fields#throws_
     */
    public ActionSchema setThrows(StringArray value, SetMode mode) {
        putWrapped(FIELD_Throws, StringArray.class, value, mode);
        return this;
    }

    /**
     * Setter for throws
     * 
     * @see Fields#throws_
     */
    public ActionSchema setThrows(StringArray value) {
        putWrapped(FIELD_Throws, StringArray.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    @Override
    public ActionSchema clone()
        throws CloneNotSupportedException
    {
        return ((ActionSchema) super.clone());
    }

    @Override
    public ActionSchema copy()
        throws CloneNotSupportedException
    {
        return ((ActionSchema) super.copy());
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
         * name of this action
         * 
         */
        public PathSpec name() {
            return new PathSpec(getPathComponents(), "name");
        }

        /**
         * Documentation for this action
         * 
         */
        public PathSpec doc() {
            return new PathSpec(getPathComponents(), "doc");
        }

        /**
         * parameters for this action
         * 
         */
        public com.linkedin.restli.restspec.ParameterSchemaArray.Fields parameters() {
            return new com.linkedin.restli.restspec.ParameterSchemaArray.Fields(getPathComponents(), "parameters");
        }

        /**
         * avro type of this action's return value
         * 
         */
        public PathSpec returns() {
            return new PathSpec(getPathComponents(), "returns");
        }

        /**
         * list of exception types thrown by this action
         * 
         */
        public PathSpec throws_() {
            return new PathSpec(getPathComponents(), "throws");
        }

    }

}

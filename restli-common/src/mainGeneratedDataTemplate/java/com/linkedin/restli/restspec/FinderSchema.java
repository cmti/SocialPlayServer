
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
@Generated(value = "com.linkedin.pegasus.generator.PegasusDataTemplateGenerator", comments = "LinkedIn Data Template. Generated from /Users/jianli/git/SocialPlayServer/restli-common/src/main/pegasus/com/linkedin/restli/restspec/FinderSchema.pdsc.", date = "Thu May 07 23:46:42 PDT 2015")
public class FinderSchema
    extends RecordTemplate
{

    private final static FinderSchema.Fields _fields = new FinderSchema.Fields();
    private final static RecordDataSchema SCHEMA = ((RecordDataSchema) DataTemplateUtil.parseSchema("{\"type\":\"record\",\"name\":\"FinderSchema\",\"namespace\":\"com.linkedin.restli.restspec\",\"include\":[{\"type\":\"record\",\"name\":\"CustomAnnotationSchema\",\"doc\":\"Custom annotation for idl\",\"fields\":[{\"name\":\"annotations\",\"type\":{\"type\":\"map\",\"values\":{\"type\":\"record\",\"name\":\"CustomAnnotationContentSchema\",\"doc\":\"Unstructured record that represents arbitrary custom annotations for idl. Actual content is always a map with annotation's overridable member name as key and member value as value\",\"fields\":[]}},\"doc\":\"custom annotation data\",\"optional\":true}]}],\"fields\":[{\"name\":\"name\",\"type\":\"string\",\"doc\":\"name of this finder - not required if this is the default finder\",\"optional\":true},{\"name\":\"doc\",\"type\":\"string\",\"doc\":\"Documentation for this finder\",\"optional\":true},{\"name\":\"parameters\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"ParameterSchema\",\"include\":[\"CustomAnnotationSchema\"],\"fields\":[{\"name\":\"name\",\"type\":\"string\",\"doc\":\"name of this parameter\"},{\"name\":\"type\",\"type\":\"string\",\"doc\":\"avro type of this parameter\"},{\"name\":\"items\",\"type\":\"string\",\"doc\":\"type of individual items, if this is an array parameter (used for finder parameters)\",\"optional\":true},{\"name\":\"optional\",\"type\":\"boolean\",\"doc\":\"indicates whether this parameter is optional.  omitted for required parameters\",\"optional\":true},{\"name\":\"default\",\"type\":\"string\",\"doc\":\"indicates the default value for this parameter\",\"optional\":true},{\"name\":\"doc\",\"type\":\"string\",\"doc\":\"Documentation for this parameter\",\"optional\":true}]}},\"doc\":\"list of query parameters for this finder\",\"optional\":true},{\"name\":\"metadata\",\"type\":{\"type\":\"record\",\"name\":\"MetadataSchema\",\"fields\":[{\"name\":\"type\",\"type\":\"string\",\"doc\":\"pegasus type of the metadata\"}]},\"doc\":\"describes the collection-level metadata returned by this finder\",\"optional\":true},{\"name\":\"assocKey\",\"type\":\"string\",\"doc\":\"association key for this finder - only present if this finder takes a single association key\",\"optional\":true},{\"name\":\"assocKeys\",\"type\":{\"type\":\"array\",\"items\":\"string\"},\"doc\":\"list of association keys for this finder - only present if this finder takes multiple association keys\",\"optional\":true}]}"));
    private final static RecordDataSchema.Field FIELD_Annotations = SCHEMA.getField("annotations");
    private final static RecordDataSchema.Field FIELD_Name = SCHEMA.getField("name");
    private final static RecordDataSchema.Field FIELD_Doc = SCHEMA.getField("doc");
    private final static RecordDataSchema.Field FIELD_Parameters = SCHEMA.getField("parameters");
    private final static RecordDataSchema.Field FIELD_Metadata = SCHEMA.getField("metadata");
    private final static RecordDataSchema.Field FIELD_AssocKey = SCHEMA.getField("assocKey");
    private final static RecordDataSchema.Field FIELD_AssocKeys = SCHEMA.getField("assocKeys");

    public FinderSchema() {
        super(new DataMap(), SCHEMA);
    }

    public FinderSchema(DataMap data) {
        super(data, SCHEMA);
    }

    public static FinderSchema.Fields fields() {
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
    public FinderSchema setAnnotations(CustomAnnotationContentSchemaMap value, SetMode mode) {
        putWrapped(FIELD_Annotations, CustomAnnotationContentSchemaMap.class, value, mode);
        return this;
    }

    /**
     * Setter for annotations
     * 
     * @see Fields#annotations
     */
    public FinderSchema setAnnotations(CustomAnnotationContentSchemaMap value) {
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
    public FinderSchema setName(String value, SetMode mode) {
        putDirect(FIELD_Name, String.class, String.class, value, mode);
        return this;
    }

    /**
     * Setter for name
     * 
     * @see Fields#name
     */
    public FinderSchema setName(String value) {
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
    public FinderSchema setDoc(String value, SetMode mode) {
        putDirect(FIELD_Doc, String.class, String.class, value, mode);
        return this;
    }

    /**
     * Setter for doc
     * 
     * @see Fields#doc
     */
    public FinderSchema setDoc(String value) {
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
    public FinderSchema setParameters(ParameterSchemaArray value, SetMode mode) {
        putWrapped(FIELD_Parameters, ParameterSchemaArray.class, value, mode);
        return this;
    }

    /**
     * Setter for parameters
     * 
     * @see Fields#parameters
     */
    public FinderSchema setParameters(ParameterSchemaArray value) {
        putWrapped(FIELD_Parameters, ParameterSchemaArray.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    /**
     * Existence checker for metadata
     * 
     * @see Fields#metadata
     */
    public boolean hasMetadata() {
        return contains(FIELD_Metadata);
    }

    /**
     * Remover for metadata
     * 
     * @see Fields#metadata
     */
    public void removeMetadata() {
        remove(FIELD_Metadata);
    }

    /**
     * Getter for metadata
     * 
     * @see Fields#metadata
     */
    public MetadataSchema getMetadata(GetMode mode) {
        return obtainWrapped(FIELD_Metadata, MetadataSchema.class, mode);
    }

    /**
     * Getter for metadata
     * 
     * @see Fields#metadata
     */
    public MetadataSchema getMetadata() {
        return getMetadata(GetMode.STRICT);
    }

    /**
     * Setter for metadata
     * 
     * @see Fields#metadata
     */
    public FinderSchema setMetadata(MetadataSchema value, SetMode mode) {
        putWrapped(FIELD_Metadata, MetadataSchema.class, value, mode);
        return this;
    }

    /**
     * Setter for metadata
     * 
     * @see Fields#metadata
     */
    public FinderSchema setMetadata(MetadataSchema value) {
        putWrapped(FIELD_Metadata, MetadataSchema.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    /**
     * Existence checker for assocKey
     * 
     * @see Fields#assocKey
     */
    public boolean hasAssocKey() {
        return contains(FIELD_AssocKey);
    }

    /**
     * Remover for assocKey
     * 
     * @see Fields#assocKey
     */
    public void removeAssocKey() {
        remove(FIELD_AssocKey);
    }

    /**
     * Getter for assocKey
     * 
     * @see Fields#assocKey
     */
    public String getAssocKey(GetMode mode) {
        return obtainDirect(FIELD_AssocKey, String.class, mode);
    }

    /**
     * Getter for assocKey
     * 
     * @see Fields#assocKey
     */
    public String getAssocKey() {
        return getAssocKey(GetMode.STRICT);
    }

    /**
     * Setter for assocKey
     * 
     * @see Fields#assocKey
     */
    public FinderSchema setAssocKey(String value, SetMode mode) {
        putDirect(FIELD_AssocKey, String.class, String.class, value, mode);
        return this;
    }

    /**
     * Setter for assocKey
     * 
     * @see Fields#assocKey
     */
    public FinderSchema setAssocKey(String value) {
        putDirect(FIELD_AssocKey, String.class, String.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    /**
     * Existence checker for assocKeys
     * 
     * @see Fields#assocKeys
     */
    public boolean hasAssocKeys() {
        return contains(FIELD_AssocKeys);
    }

    /**
     * Remover for assocKeys
     * 
     * @see Fields#assocKeys
     */
    public void removeAssocKeys() {
        remove(FIELD_AssocKeys);
    }

    /**
     * Getter for assocKeys
     * 
     * @see Fields#assocKeys
     */
    public StringArray getAssocKeys(GetMode mode) {
        return obtainWrapped(FIELD_AssocKeys, StringArray.class, mode);
    }

    /**
     * Getter for assocKeys
     * 
     * @see Fields#assocKeys
     */
    public StringArray getAssocKeys() {
        return getAssocKeys(GetMode.STRICT);
    }

    /**
     * Setter for assocKeys
     * 
     * @see Fields#assocKeys
     */
    public FinderSchema setAssocKeys(StringArray value, SetMode mode) {
        putWrapped(FIELD_AssocKeys, StringArray.class, value, mode);
        return this;
    }

    /**
     * Setter for assocKeys
     * 
     * @see Fields#assocKeys
     */
    public FinderSchema setAssocKeys(StringArray value) {
        putWrapped(FIELD_AssocKeys, StringArray.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    @Override
    public FinderSchema clone()
        throws CloneNotSupportedException
    {
        return ((FinderSchema) super.clone());
    }

    @Override
    public FinderSchema copy()
        throws CloneNotSupportedException
    {
        return ((FinderSchema) super.copy());
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
         * name of this finder - not required if this is the default finder
         * 
         */
        public PathSpec name() {
            return new PathSpec(getPathComponents(), "name");
        }

        /**
         * Documentation for this finder
         * 
         */
        public PathSpec doc() {
            return new PathSpec(getPathComponents(), "doc");
        }

        /**
         * list of query parameters for this finder
         * 
         */
        public com.linkedin.restli.restspec.ParameterSchemaArray.Fields parameters() {
            return new com.linkedin.restli.restspec.ParameterSchemaArray.Fields(getPathComponents(), "parameters");
        }

        /**
         * describes the collection-level metadata returned by this finder
         * 
         */
        public com.linkedin.restli.restspec.MetadataSchema.Fields metadata() {
            return new com.linkedin.restli.restspec.MetadataSchema.Fields(getPathComponents(), "metadata");
        }

        /**
         * association key for this finder - only present if this finder takes a single association key
         * 
         */
        public PathSpec assocKey() {
            return new PathSpec(getPathComponents(), "assocKey");
        }

        /**
         * list of association keys for this finder - only present if this finder takes multiple association keys
         * 
         */
        public PathSpec assocKeys() {
            return new PathSpec(getPathComponents(), "assocKeys");
        }

    }

}

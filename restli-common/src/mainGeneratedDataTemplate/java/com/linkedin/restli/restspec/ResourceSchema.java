
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
@Generated(value = "com.linkedin.pegasus.generator.PegasusDataTemplateGenerator", comments = "LinkedIn Data Template. Generated from /Users/jianli/git/SocialPlayServer/restli-common/src/main/pegasus/com/linkedin/restli/restspec/ResourceSchema.pdsc.", date = "Fri Apr 17 15:52:47 PDT 2015")
public class ResourceSchema
    extends RecordTemplate
{

    private final static ResourceSchema.Fields _fields = new ResourceSchema.Fields();
    private final static RecordDataSchema SCHEMA = ((RecordDataSchema) DataTemplateUtil.parseSchema("{\"type\":\"record\",\"name\":\"ResourceSchema\",\"namespace\":\"com.linkedin.restli.restspec\",\"include\":[{\"type\":\"record\",\"name\":\"CustomAnnotationSchema\",\"doc\":\"Custom annotation for idl\",\"fields\":[{\"name\":\"annotations\",\"type\":{\"type\":\"map\",\"values\":{\"type\":\"record\",\"name\":\"CustomAnnotationContentSchema\",\"doc\":\"Unstructured record that represents arbitrary custom annotations for idl. Actual content is always a map with annotation's overridable member name as key and member value as value\",\"fields\":[]}},\"doc\":\"custom annotation data\",\"optional\":true}]}],\"fields\":[{\"name\":\"name\",\"type\":\"string\",\"doc\":\"name of the resource\"},{\"name\":\"namespace\",\"type\":\"string\",\"doc\":\"namespace of the resource\",\"optional\":true},{\"name\":\"path\",\"type\":\"string\",\"doc\":\"URI template for accessing the resource\"},{\"name\":\"schema\",\"type\":\"string\",\"doc\":\"Java-style fully-qualified class name for entities of this resource\",\"optional\":true},{\"name\":\"doc\",\"type\":\"string\",\"doc\":\"Documentation for this resource\",\"optional\":true},{\"name\":\"collection\",\"type\":{\"type\":\"record\",\"name\":\"CollectionSchema\",\"fields\":[{\"name\":\"identifier\",\"type\":{\"type\":\"record\",\"name\":\"IdentifierSchema\",\"fields\":[{\"name\":\"name\",\"type\":\"string\",\"doc\":\"name of the identifier\"},{\"name\":\"type\",\"type\":\"string\",\"doc\":\"avro type of the identifier\"},{\"name\":\"params\",\"type\":\"string\",\"doc\":\"avro type of the identifier parameters\",\"optional\":true}]},\"doc\":\"details of the identifier (key) for this collection\"},{\"name\":\"supports\",\"type\":{\"type\":\"array\",\"items\":\"string\"},\"doc\":\"basic rest.li methods supported by this resource, e.g., create, get, update, delete, batch_get\"},{\"name\":\"methods\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"RestMethodSchema\",\"include\":[\"CustomAnnotationSchema\"],\"fields\":[{\"name\":\"method\",\"type\":\"string\",\"doc\":\"method type for this rest method\"},{\"name\":\"doc\",\"type\":\"string\",\"doc\":\"Documentation for this finder\",\"optional\":true},{\"name\":\"parameters\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"ParameterSchema\",\"include\":[\"CustomAnnotationSchema\"],\"fields\":[{\"name\":\"name\",\"type\":\"string\",\"doc\":\"name of this parameter\"},{\"name\":\"type\",\"type\":\"string\",\"doc\":\"avro type of this parameter\"},{\"name\":\"items\",\"type\":\"string\",\"doc\":\"type of individual items, if this is an array parameter (used for finder parameters)\",\"optional\":true},{\"name\":\"optional\",\"type\":\"boolean\",\"doc\":\"indicates whether this parameter is optional.  omitted for required parameters\",\"optional\":true},{\"name\":\"default\",\"type\":\"string\",\"doc\":\"indicates the default value for this parameter\",\"optional\":true},{\"name\":\"doc\",\"type\":\"string\",\"doc\":\"Documentation for this parameter\",\"optional\":true}]}},\"doc\":\"list of query parameters for this method\",\"optional\":true}]}},\"doc\":\"details on rest methods supported by this collection\",\"optional\":true},{\"name\":\"finders\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"FinderSchema\",\"include\":[\"CustomAnnotationSchema\"],\"fields\":[{\"name\":\"name\",\"type\":\"string\",\"doc\":\"name of this finder - not required if this is the default finder\",\"optional\":true},{\"name\":\"doc\",\"type\":\"string\",\"doc\":\"Documentation for this finder\",\"optional\":true},{\"name\":\"parameters\",\"type\":{\"type\":\"array\",\"items\":\"ParameterSchema\"},\"doc\":\"list of query parameters for this finder\",\"optional\":true},{\"name\":\"metadata\",\"type\":{\"type\":\"record\",\"name\":\"MetadataSchema\",\"fields\":[{\"name\":\"type\",\"type\":\"string\",\"doc\":\"pegasus type of the metadata\"}]},\"doc\":\"describes the collection-level metadata returned by this finder\",\"optional\":true},{\"name\":\"assocKey\",\"type\":\"string\",\"doc\":\"association key for this finder - only present if this finder takes a single association key\",\"optional\":true},{\"name\":\"assocKeys\",\"type\":{\"type\":\"array\",\"items\":\"string\"},\"doc\":\"list of association keys for this finder - only present if this finder takes multiple association keys\",\"optional\":true}]}},\"doc\":\"list of finders supported by this collection\",\"optional\":true},{\"name\":\"actions\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"ActionSchema\",\"include\":[\"CustomAnnotationSchema\"],\"fields\":[{\"name\":\"name\",\"type\":\"string\",\"doc\":\"name of this action\"},{\"name\":\"doc\",\"type\":\"string\",\"doc\":\"Documentation for this action\",\"optional\":true},{\"name\":\"parameters\",\"type\":{\"type\":\"array\",\"items\":\"ParameterSchema\"},\"doc\":\"parameters for this action\",\"optional\":true},{\"name\":\"returns\",\"type\":\"string\",\"doc\":\"avro type of this action's return value\",\"optional\":true},{\"name\":\"throws\",\"type\":{\"type\":\"array\",\"items\":\"string\"},\"doc\":\"list of exception types thrown by this action\",\"optional\":true}]}},\"doc\":\"list of actions supported by this collection\",\"optional\":true},{\"name\":\"entity\",\"type\":{\"type\":\"record\",\"name\":\"EntitySchema\",\"fields\":[{\"name\":\"path\",\"type\":\"string\",\"doc\":\"URI template for accessing this entity\"},{\"name\":\"actions\",\"type\":{\"type\":\"array\",\"items\":\"ActionSchema\"},\"doc\":\"list of actions supported by this entity\",\"optional\":true},{\"name\":\"subresources\",\"type\":{\"type\":\"array\",\"items\":\"ResourceSchema\"},\"doc\":\"list of subresources accessible via this entity\",\"optional\":true}]},\"doc\":\"details of the entity provided by this collection\"}]},\"doc\":\"details of collection, if this resource is a collection\",\"optional\":true},{\"name\":\"association\",\"type\":{\"type\":\"record\",\"name\":\"AssociationSchema\",\"fields\":[{\"name\":\"identifier\",\"type\":\"string\",\"doc\":\"name of the identifier (key) for this collection\",\"optional\":true},{\"name\":\"assocKeys\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"AssocKeySchema\",\"fields\":[{\"name\":\"name\",\"type\":\"string\",\"doc\":\"name of association key\"},{\"name\":\"type\",\"type\":\"string\",\"doc\":\"avro type of association key\"}]}},\"doc\":\"list of association keys for this association\"},{\"name\":\"supports\",\"type\":{\"type\":\"array\",\"items\":\"string\"},\"doc\":\"list of rest.li methods supported by this association, e.g., get, update, delete, batch_get\"},{\"name\":\"methods\",\"type\":{\"type\":\"array\",\"items\":\"RestMethodSchema\"},\"doc\":\"details on rest methods supported by this association\",\"optional\":true},{\"name\":\"finders\",\"type\":{\"type\":\"array\",\"items\":\"FinderSchema\"},\"doc\":\"list of finders supported by this association\",\"optional\":true},{\"name\":\"actions\",\"type\":{\"type\":\"array\",\"items\":\"ActionSchema\"},\"doc\":\"list of actions supported by this association\",\"optional\":true},{\"name\":\"entity\",\"type\":\"EntitySchema\",\"doc\":\"details on the entities contained in this association\"}]},\"doc\":\"details of association, if this resource is an association\",\"optional\":true},{\"name\":\"actionsSet\",\"type\":{\"type\":\"record\",\"name\":\"ActionsSetSchema\",\"fields\":[{\"name\":\"actions\",\"type\":{\"type\":\"array\",\"items\":\"ActionSchema\"},\"doc\":\"list of actions supported by this action set\"}]},\"doc\":\"details of action set, if this resource is an action set\",\"optional\":true},{\"name\":\"simple\",\"type\":{\"type\":\"record\",\"name\":\"SimpleSchema\",\"fields\":[{\"name\":\"supports\",\"type\":{\"type\":\"array\",\"items\":\"string\"},\"doc\":\"basic rest.li methods supported by this resource, e.g. get, update, delete\"},{\"name\":\"methods\",\"type\":{\"type\":\"array\",\"items\":\"RestMethodSchema\"},\"doc\":\"details on rest methods supported by this simple resource\",\"optional\":true},{\"name\":\"actions\",\"type\":{\"type\":\"array\",\"items\":\"ActionSchema\"},\"doc\":\"list of actions supported by this simple resource\",\"optional\":true},{\"name\":\"entity\",\"type\":\"EntitySchema\",\"doc\":\"details of the entity provided by this simple resource\"}]},\"doc\":\"details of simple resource, if this resource is a simple resource\",\"optional\":true}]}"));
    private final static RecordDataSchema.Field FIELD_Annotations = SCHEMA.getField("annotations");
    private final static RecordDataSchema.Field FIELD_Name = SCHEMA.getField("name");
    private final static RecordDataSchema.Field FIELD_Namespace = SCHEMA.getField("namespace");
    private final static RecordDataSchema.Field FIELD_Path = SCHEMA.getField("path");
    private final static RecordDataSchema.Field FIELD_Schema = SCHEMA.getField("schema");
    private final static RecordDataSchema.Field FIELD_Doc = SCHEMA.getField("doc");
    private final static RecordDataSchema.Field FIELD_Collection = SCHEMA.getField("collection");
    private final static RecordDataSchema.Field FIELD_Association = SCHEMA.getField("association");
    private final static RecordDataSchema.Field FIELD_ActionsSet = SCHEMA.getField("actionsSet");
    private final static RecordDataSchema.Field FIELD_Simple = SCHEMA.getField("simple");

    public ResourceSchema() {
        super(new DataMap(), SCHEMA);
    }

    public ResourceSchema(DataMap data) {
        super(data, SCHEMA);
    }

    public static ResourceSchema.Fields fields() {
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
    public ResourceSchema setAnnotations(CustomAnnotationContentSchemaMap value, SetMode mode) {
        putWrapped(FIELD_Annotations, CustomAnnotationContentSchemaMap.class, value, mode);
        return this;
    }

    /**
     * Setter for annotations
     * 
     * @see Fields#annotations
     */
    public ResourceSchema setAnnotations(CustomAnnotationContentSchemaMap value) {
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
    public ResourceSchema setName(String value, SetMode mode) {
        putDirect(FIELD_Name, String.class, String.class, value, mode);
        return this;
    }

    /**
     * Setter for name
     * 
     * @see Fields#name
     */
    public ResourceSchema setName(String value) {
        putDirect(FIELD_Name, String.class, String.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    /**
     * Existence checker for namespace
     * 
     * @see Fields#namespace
     */
    public boolean hasNamespace() {
        return contains(FIELD_Namespace);
    }

    /**
     * Remover for namespace
     * 
     * @see Fields#namespace
     */
    public void removeNamespace() {
        remove(FIELD_Namespace);
    }

    /**
     * Getter for namespace
     * 
     * @see Fields#namespace
     */
    public String getNamespace(GetMode mode) {
        return obtainDirect(FIELD_Namespace, String.class, mode);
    }

    /**
     * Getter for namespace
     * 
     * @see Fields#namespace
     */
    public String getNamespace() {
        return getNamespace(GetMode.STRICT);
    }

    /**
     * Setter for namespace
     * 
     * @see Fields#namespace
     */
    public ResourceSchema setNamespace(String value, SetMode mode) {
        putDirect(FIELD_Namespace, String.class, String.class, value, mode);
        return this;
    }

    /**
     * Setter for namespace
     * 
     * @see Fields#namespace
     */
    public ResourceSchema setNamespace(String value) {
        putDirect(FIELD_Namespace, String.class, String.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    /**
     * Existence checker for path
     * 
     * @see Fields#path
     */
    public boolean hasPath() {
        return contains(FIELD_Path);
    }

    /**
     * Remover for path
     * 
     * @see Fields#path
     */
    public void removePath() {
        remove(FIELD_Path);
    }

    /**
     * Getter for path
     * 
     * @see Fields#path
     */
    public String getPath(GetMode mode) {
        return obtainDirect(FIELD_Path, String.class, mode);
    }

    /**
     * Getter for path
     * 
     * @see Fields#path
     */
    public String getPath() {
        return getPath(GetMode.STRICT);
    }

    /**
     * Setter for path
     * 
     * @see Fields#path
     */
    public ResourceSchema setPath(String value, SetMode mode) {
        putDirect(FIELD_Path, String.class, String.class, value, mode);
        return this;
    }

    /**
     * Setter for path
     * 
     * @see Fields#path
     */
    public ResourceSchema setPath(String value) {
        putDirect(FIELD_Path, String.class, String.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    /**
     * Existence checker for schema
     * 
     * @see Fields#schema
     */
    public boolean hasSchema() {
        return contains(FIELD_Schema);
    }

    /**
     * Remover for schema
     * 
     * @see Fields#schema
     */
    public void removeSchema() {
        remove(FIELD_Schema);
    }

    /**
     * Getter for schema
     * 
     * @see Fields#schema
     */
    public String getSchema(GetMode mode) {
        return obtainDirect(FIELD_Schema, String.class, mode);
    }

    /**
     * Getter for schema
     * 
     * @see Fields#schema
     */
    public String getSchema() {
        return getSchema(GetMode.STRICT);
    }

    /**
     * Setter for schema
     * 
     * @see Fields#schema
     */
    public ResourceSchema setSchema(String value, SetMode mode) {
        putDirect(FIELD_Schema, String.class, String.class, value, mode);
        return this;
    }

    /**
     * Setter for schema
     * 
     * @see Fields#schema
     */
    public ResourceSchema setSchema(String value) {
        putDirect(FIELD_Schema, String.class, String.class, value, SetMode.DISALLOW_NULL);
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
    public ResourceSchema setDoc(String value, SetMode mode) {
        putDirect(FIELD_Doc, String.class, String.class, value, mode);
        return this;
    }

    /**
     * Setter for doc
     * 
     * @see Fields#doc
     */
    public ResourceSchema setDoc(String value) {
        putDirect(FIELD_Doc, String.class, String.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    /**
     * Existence checker for collection
     * 
     * @see Fields#collection
     */
    public boolean hasCollection() {
        return contains(FIELD_Collection);
    }

    /**
     * Remover for collection
     * 
     * @see Fields#collection
     */
    public void removeCollection() {
        remove(FIELD_Collection);
    }

    /**
     * Getter for collection
     * 
     * @see Fields#collection
     */
    public CollectionSchema getCollection(GetMode mode) {
        return obtainWrapped(FIELD_Collection, CollectionSchema.class, mode);
    }

    /**
     * Getter for collection
     * 
     * @see Fields#collection
     */
    public CollectionSchema getCollection() {
        return getCollection(GetMode.STRICT);
    }

    /**
     * Setter for collection
     * 
     * @see Fields#collection
     */
    public ResourceSchema setCollection(CollectionSchema value, SetMode mode) {
        putWrapped(FIELD_Collection, CollectionSchema.class, value, mode);
        return this;
    }

    /**
     * Setter for collection
     * 
     * @see Fields#collection
     */
    public ResourceSchema setCollection(CollectionSchema value) {
        putWrapped(FIELD_Collection, CollectionSchema.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    /**
     * Existence checker for association
     * 
     * @see Fields#association
     */
    public boolean hasAssociation() {
        return contains(FIELD_Association);
    }

    /**
     * Remover for association
     * 
     * @see Fields#association
     */
    public void removeAssociation() {
        remove(FIELD_Association);
    }

    /**
     * Getter for association
     * 
     * @see Fields#association
     */
    public AssociationSchema getAssociation(GetMode mode) {
        return obtainWrapped(FIELD_Association, AssociationSchema.class, mode);
    }

    /**
     * Getter for association
     * 
     * @see Fields#association
     */
    public AssociationSchema getAssociation() {
        return getAssociation(GetMode.STRICT);
    }

    /**
     * Setter for association
     * 
     * @see Fields#association
     */
    public ResourceSchema setAssociation(AssociationSchema value, SetMode mode) {
        putWrapped(FIELD_Association, AssociationSchema.class, value, mode);
        return this;
    }

    /**
     * Setter for association
     * 
     * @see Fields#association
     */
    public ResourceSchema setAssociation(AssociationSchema value) {
        putWrapped(FIELD_Association, AssociationSchema.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    /**
     * Existence checker for actionsSet
     * 
     * @see Fields#actionsSet
     */
    public boolean hasActionsSet() {
        return contains(FIELD_ActionsSet);
    }

    /**
     * Remover for actionsSet
     * 
     * @see Fields#actionsSet
     */
    public void removeActionsSet() {
        remove(FIELD_ActionsSet);
    }

    /**
     * Getter for actionsSet
     * 
     * @see Fields#actionsSet
     */
    public ActionsSetSchema getActionsSet(GetMode mode) {
        return obtainWrapped(FIELD_ActionsSet, ActionsSetSchema.class, mode);
    }

    /**
     * Getter for actionsSet
     * 
     * @see Fields#actionsSet
     */
    public ActionsSetSchema getActionsSet() {
        return getActionsSet(GetMode.STRICT);
    }

    /**
     * Setter for actionsSet
     * 
     * @see Fields#actionsSet
     */
    public ResourceSchema setActionsSet(ActionsSetSchema value, SetMode mode) {
        putWrapped(FIELD_ActionsSet, ActionsSetSchema.class, value, mode);
        return this;
    }

    /**
     * Setter for actionsSet
     * 
     * @see Fields#actionsSet
     */
    public ResourceSchema setActionsSet(ActionsSetSchema value) {
        putWrapped(FIELD_ActionsSet, ActionsSetSchema.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    /**
     * Existence checker for simple
     * 
     * @see Fields#simple
     */
    public boolean hasSimple() {
        return contains(FIELD_Simple);
    }

    /**
     * Remover for simple
     * 
     * @see Fields#simple
     */
    public void removeSimple() {
        remove(FIELD_Simple);
    }

    /**
     * Getter for simple
     * 
     * @see Fields#simple
     */
    public SimpleSchema getSimple(GetMode mode) {
        return obtainWrapped(FIELD_Simple, SimpleSchema.class, mode);
    }

    /**
     * Getter for simple
     * 
     * @see Fields#simple
     */
    public SimpleSchema getSimple() {
        return getSimple(GetMode.STRICT);
    }

    /**
     * Setter for simple
     * 
     * @see Fields#simple
     */
    public ResourceSchema setSimple(SimpleSchema value, SetMode mode) {
        putWrapped(FIELD_Simple, SimpleSchema.class, value, mode);
        return this;
    }

    /**
     * Setter for simple
     * 
     * @see Fields#simple
     */
    public ResourceSchema setSimple(SimpleSchema value) {
        putWrapped(FIELD_Simple, SimpleSchema.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    @Override
    public ResourceSchema clone()
        throws CloneNotSupportedException
    {
        return ((ResourceSchema) super.clone());
    }

    @Override
    public ResourceSchema copy()
        throws CloneNotSupportedException
    {
        return ((ResourceSchema) super.copy());
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
         * name of the resource
         * 
         */
        public PathSpec name() {
            return new PathSpec(getPathComponents(), "name");
        }

        /**
         * namespace of the resource
         * 
         */
        public PathSpec namespace() {
            return new PathSpec(getPathComponents(), "namespace");
        }

        /**
         * URI template for accessing the resource
         * 
         */
        public PathSpec path() {
            return new PathSpec(getPathComponents(), "path");
        }

        /**
         * Java-style fully-qualified class name for entities of this resource
         * 
         */
        public PathSpec schema() {
            return new PathSpec(getPathComponents(), "schema");
        }

        /**
         * Documentation for this resource
         * 
         */
        public PathSpec doc() {
            return new PathSpec(getPathComponents(), "doc");
        }

        /**
         * details of collection, if this resource is a collection
         * 
         */
        public com.linkedin.restli.restspec.CollectionSchema.Fields collection() {
            return new com.linkedin.restli.restspec.CollectionSchema.Fields(getPathComponents(), "collection");
        }

        /**
         * details of association, if this resource is an association
         * 
         */
        public com.linkedin.restli.restspec.AssociationSchema.Fields association() {
            return new com.linkedin.restli.restspec.AssociationSchema.Fields(getPathComponents(), "association");
        }

        /**
         * details of action set, if this resource is an action set
         * 
         */
        public com.linkedin.restli.restspec.ActionsSetSchema.Fields actionsSet() {
            return new com.linkedin.restli.restspec.ActionsSetSchema.Fields(getPathComponents(), "actionsSet");
        }

        /**
         * details of simple resource, if this resource is a simple resource
         * 
         */
        public com.linkedin.restli.restspec.SimpleSchema.Fields simple() {
            return new com.linkedin.restli.restspec.SimpleSchema.Fields(getPathComponents(), "simple");
        }

    }

}

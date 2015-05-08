
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
@Generated(value = "com.linkedin.pegasus.generator.PegasusDataTemplateGenerator", comments = "LinkedIn Data Template. Generated from /Users/jianli/git/SocialPlayServer/restli-common/src/main/pegasus/com/linkedin/restli/restspec/EntitySchema.pdsc.", date = "Thu May 07 23:46:42 PDT 2015")
public class EntitySchema
    extends RecordTemplate
{

    private final static EntitySchema.Fields _fields = new EntitySchema.Fields();
    private final static RecordDataSchema SCHEMA = ((RecordDataSchema) DataTemplateUtil.parseSchema("{\"type\":\"record\",\"name\":\"EntitySchema\",\"namespace\":\"com.linkedin.restli.restspec\",\"fields\":[{\"name\":\"path\",\"type\":\"string\",\"doc\":\"URI template for accessing this entity\"},{\"name\":\"actions\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"ActionSchema\",\"include\":[{\"type\":\"record\",\"name\":\"CustomAnnotationSchema\",\"doc\":\"Custom annotation for idl\",\"fields\":[{\"name\":\"annotations\",\"type\":{\"type\":\"map\",\"values\":{\"type\":\"record\",\"name\":\"CustomAnnotationContentSchema\",\"doc\":\"Unstructured record that represents arbitrary custom annotations for idl. Actual content is always a map with annotation's overridable member name as key and member value as value\",\"fields\":[]}},\"doc\":\"custom annotation data\",\"optional\":true}]}],\"fields\":[{\"name\":\"name\",\"type\":\"string\",\"doc\":\"name of this action\"},{\"name\":\"doc\",\"type\":\"string\",\"doc\":\"Documentation for this action\",\"optional\":true},{\"name\":\"parameters\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"ParameterSchema\",\"include\":[\"CustomAnnotationSchema\"],\"fields\":[{\"name\":\"name\",\"type\":\"string\",\"doc\":\"name of this parameter\"},{\"name\":\"type\",\"type\":\"string\",\"doc\":\"avro type of this parameter\"},{\"name\":\"items\",\"type\":\"string\",\"doc\":\"type of individual items, if this is an array parameter (used for finder parameters)\",\"optional\":true},{\"name\":\"optional\",\"type\":\"boolean\",\"doc\":\"indicates whether this parameter is optional.  omitted for required parameters\",\"optional\":true},{\"name\":\"default\",\"type\":\"string\",\"doc\":\"indicates the default value for this parameter\",\"optional\":true},{\"name\":\"doc\",\"type\":\"string\",\"doc\":\"Documentation for this parameter\",\"optional\":true}]}},\"doc\":\"parameters for this action\",\"optional\":true},{\"name\":\"returns\",\"type\":\"string\",\"doc\":\"avro type of this action's return value\",\"optional\":true},{\"name\":\"throws\",\"type\":{\"type\":\"array\",\"items\":\"string\"},\"doc\":\"list of exception types thrown by this action\",\"optional\":true}]}},\"doc\":\"list of actions supported by this entity\",\"optional\":true},{\"name\":\"subresources\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"ResourceSchema\",\"include\":[\"CustomAnnotationSchema\"],\"fields\":[{\"name\":\"name\",\"type\":\"string\",\"doc\":\"name of the resource\"},{\"name\":\"namespace\",\"type\":\"string\",\"doc\":\"namespace of the resource\",\"optional\":true},{\"name\":\"path\",\"type\":\"string\",\"doc\":\"URI template for accessing the resource\"},{\"name\":\"schema\",\"type\":\"string\",\"doc\":\"Java-style fully-qualified class name for entities of this resource\",\"optional\":true},{\"name\":\"doc\",\"type\":\"string\",\"doc\":\"Documentation for this resource\",\"optional\":true},{\"name\":\"collection\",\"type\":{\"type\":\"record\",\"name\":\"CollectionSchema\",\"fields\":[{\"name\":\"identifier\",\"type\":{\"type\":\"record\",\"name\":\"IdentifierSchema\",\"fields\":[{\"name\":\"name\",\"type\":\"string\",\"doc\":\"name of the identifier\"},{\"name\":\"type\",\"type\":\"string\",\"doc\":\"avro type of the identifier\"},{\"name\":\"params\",\"type\":\"string\",\"doc\":\"avro type of the identifier parameters\",\"optional\":true}]},\"doc\":\"details of the identifier (key) for this collection\"},{\"name\":\"supports\",\"type\":{\"type\":\"array\",\"items\":\"string\"},\"doc\":\"basic rest.li methods supported by this resource, e.g., create, get, update, delete, batch_get\"},{\"name\":\"methods\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"RestMethodSchema\",\"include\":[\"CustomAnnotationSchema\"],\"fields\":[{\"name\":\"method\",\"type\":\"string\",\"doc\":\"method type for this rest method\"},{\"name\":\"doc\",\"type\":\"string\",\"doc\":\"Documentation for this finder\",\"optional\":true},{\"name\":\"parameters\",\"type\":{\"type\":\"array\",\"items\":\"ParameterSchema\"},\"doc\":\"list of query parameters for this method\",\"optional\":true}]}},\"doc\":\"details on rest methods supported by this collection\",\"optional\":true},{\"name\":\"finders\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"FinderSchema\",\"include\":[\"CustomAnnotationSchema\"],\"fields\":[{\"name\":\"name\",\"type\":\"string\",\"doc\":\"name of this finder - not required if this is the default finder\",\"optional\":true},{\"name\":\"doc\",\"type\":\"string\",\"doc\":\"Documentation for this finder\",\"optional\":true},{\"name\":\"parameters\",\"type\":{\"type\":\"array\",\"items\":\"ParameterSchema\"},\"doc\":\"list of query parameters for this finder\",\"optional\":true},{\"name\":\"metadata\",\"type\":{\"type\":\"record\",\"name\":\"MetadataSchema\",\"fields\":[{\"name\":\"type\",\"type\":\"string\",\"doc\":\"pegasus type of the metadata\"}]},\"doc\":\"describes the collection-level metadata returned by this finder\",\"optional\":true},{\"name\":\"assocKey\",\"type\":\"string\",\"doc\":\"association key for this finder - only present if this finder takes a single association key\",\"optional\":true},{\"name\":\"assocKeys\",\"type\":{\"type\":\"array\",\"items\":\"string\"},\"doc\":\"list of association keys for this finder - only present if this finder takes multiple association keys\",\"optional\":true}]}},\"doc\":\"list of finders supported by this collection\",\"optional\":true},{\"name\":\"actions\",\"type\":{\"type\":\"array\",\"items\":\"ActionSchema\"},\"doc\":\"list of actions supported by this collection\",\"optional\":true},{\"name\":\"entity\",\"type\":\"EntitySchema\",\"doc\":\"details of the entity provided by this collection\"}]},\"doc\":\"details of collection, if this resource is a collection\",\"optional\":true},{\"name\":\"association\",\"type\":{\"type\":\"record\",\"name\":\"AssociationSchema\",\"fields\":[{\"name\":\"identifier\",\"type\":\"string\",\"doc\":\"name of the identifier (key) for this collection\",\"optional\":true},{\"name\":\"assocKeys\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"AssocKeySchema\",\"fields\":[{\"name\":\"name\",\"type\":\"string\",\"doc\":\"name of association key\"},{\"name\":\"type\",\"type\":\"string\",\"doc\":\"avro type of association key\"}]}},\"doc\":\"list of association keys for this association\"},{\"name\":\"supports\",\"type\":{\"type\":\"array\",\"items\":\"string\"},\"doc\":\"list of rest.li methods supported by this association, e.g., get, update, delete, batch_get\"},{\"name\":\"methods\",\"type\":{\"type\":\"array\",\"items\":\"RestMethodSchema\"},\"doc\":\"details on rest methods supported by this association\",\"optional\":true},{\"name\":\"finders\",\"type\":{\"type\":\"array\",\"items\":\"FinderSchema\"},\"doc\":\"list of finders supported by this association\",\"optional\":true},{\"name\":\"actions\",\"type\":{\"type\":\"array\",\"items\":\"ActionSchema\"},\"doc\":\"list of actions supported by this association\",\"optional\":true},{\"name\":\"entity\",\"type\":\"EntitySchema\",\"doc\":\"details on the entities contained in this association\"}]},\"doc\":\"details of association, if this resource is an association\",\"optional\":true},{\"name\":\"actionsSet\",\"type\":{\"type\":\"record\",\"name\":\"ActionsSetSchema\",\"fields\":[{\"name\":\"actions\",\"type\":{\"type\":\"array\",\"items\":\"ActionSchema\"},\"doc\":\"list of actions supported by this action set\"}]},\"doc\":\"details of action set, if this resource is an action set\",\"optional\":true},{\"name\":\"simple\",\"type\":{\"type\":\"record\",\"name\":\"SimpleSchema\",\"fields\":[{\"name\":\"supports\",\"type\":{\"type\":\"array\",\"items\":\"string\"},\"doc\":\"basic rest.li methods supported by this resource, e.g. get, update, delete\"},{\"name\":\"methods\",\"type\":{\"type\":\"array\",\"items\":\"RestMethodSchema\"},\"doc\":\"details on rest methods supported by this simple resource\",\"optional\":true},{\"name\":\"actions\",\"type\":{\"type\":\"array\",\"items\":\"ActionSchema\"},\"doc\":\"list of actions supported by this simple resource\",\"optional\":true},{\"name\":\"entity\",\"type\":\"EntitySchema\",\"doc\":\"details of the entity provided by this simple resource\"}]},\"doc\":\"details of simple resource, if this resource is a simple resource\",\"optional\":true}]}},\"doc\":\"list of subresources accessible via this entity\",\"optional\":true}]}"));
    private final static RecordDataSchema.Field FIELD_Path = SCHEMA.getField("path");
    private final static RecordDataSchema.Field FIELD_Actions = SCHEMA.getField("actions");
    private final static RecordDataSchema.Field FIELD_Subresources = SCHEMA.getField("subresources");

    public EntitySchema() {
        super(new DataMap(), SCHEMA);
    }

    public EntitySchema(DataMap data) {
        super(data, SCHEMA);
    }

    public static EntitySchema.Fields fields() {
        return _fields;
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
    public EntitySchema setPath(String value, SetMode mode) {
        putDirect(FIELD_Path, String.class, String.class, value, mode);
        return this;
    }

    /**
     * Setter for path
     * 
     * @see Fields#path
     */
    public EntitySchema setPath(String value) {
        putDirect(FIELD_Path, String.class, String.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    /**
     * Existence checker for actions
     * 
     * @see Fields#actions
     */
    public boolean hasActions() {
        return contains(FIELD_Actions);
    }

    /**
     * Remover for actions
     * 
     * @see Fields#actions
     */
    public void removeActions() {
        remove(FIELD_Actions);
    }

    /**
     * Getter for actions
     * 
     * @see Fields#actions
     */
    public ActionSchemaArray getActions(GetMode mode) {
        return obtainWrapped(FIELD_Actions, ActionSchemaArray.class, mode);
    }

    /**
     * Getter for actions
     * 
     * @see Fields#actions
     */
    public ActionSchemaArray getActions() {
        return getActions(GetMode.STRICT);
    }

    /**
     * Setter for actions
     * 
     * @see Fields#actions
     */
    public EntitySchema setActions(ActionSchemaArray value, SetMode mode) {
        putWrapped(FIELD_Actions, ActionSchemaArray.class, value, mode);
        return this;
    }

    /**
     * Setter for actions
     * 
     * @see Fields#actions
     */
    public EntitySchema setActions(ActionSchemaArray value) {
        putWrapped(FIELD_Actions, ActionSchemaArray.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    /**
     * Existence checker for subresources
     * 
     * @see Fields#subresources
     */
    public boolean hasSubresources() {
        return contains(FIELD_Subresources);
    }

    /**
     * Remover for subresources
     * 
     * @see Fields#subresources
     */
    public void removeSubresources() {
        remove(FIELD_Subresources);
    }

    /**
     * Getter for subresources
     * 
     * @see Fields#subresources
     */
    public ResourceSchemaArray getSubresources(GetMode mode) {
        return obtainWrapped(FIELD_Subresources, ResourceSchemaArray.class, mode);
    }

    /**
     * Getter for subresources
     * 
     * @see Fields#subresources
     */
    public ResourceSchemaArray getSubresources() {
        return getSubresources(GetMode.STRICT);
    }

    /**
     * Setter for subresources
     * 
     * @see Fields#subresources
     */
    public EntitySchema setSubresources(ResourceSchemaArray value, SetMode mode) {
        putWrapped(FIELD_Subresources, ResourceSchemaArray.class, value, mode);
        return this;
    }

    /**
     * Setter for subresources
     * 
     * @see Fields#subresources
     */
    public EntitySchema setSubresources(ResourceSchemaArray value) {
        putWrapped(FIELD_Subresources, ResourceSchemaArray.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    @Override
    public EntitySchema clone()
        throws CloneNotSupportedException
    {
        return ((EntitySchema) super.clone());
    }

    @Override
    public EntitySchema copy()
        throws CloneNotSupportedException
    {
        return ((EntitySchema) super.copy());
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
         * URI template for accessing this entity
         * 
         */
        public PathSpec path() {
            return new PathSpec(getPathComponents(), "path");
        }

        /**
         * list of actions supported by this entity
         * 
         */
        public com.linkedin.restli.restspec.ActionSchemaArray.Fields actions() {
            return new com.linkedin.restli.restspec.ActionSchemaArray.Fields(getPathComponents(), "actions");
        }

        /**
         * list of subresources accessible via this entity
         * 
         */
        public com.linkedin.restli.restspec.ResourceSchemaArray.Fields subresources() {
            return new com.linkedin.restli.restspec.ResourceSchemaArray.Fields(getPathComponents(), "subresources");
        }

    }

}


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
@Generated(value = "com.linkedin.pegasus.generator.PegasusDataTemplateGenerator", comments = "LinkedIn Data Template. Generated from /Users/jianli/git/SocialPlayServer/restli-common/src/main/pegasus/com/linkedin/restli/restspec/AssociationSchema.pdsc.", date = "Fri Apr 17 15:52:47 PDT 2015")
public class AssociationSchema
    extends RecordTemplate
{

    private final static AssociationSchema.Fields _fields = new AssociationSchema.Fields();
    private final static RecordDataSchema SCHEMA = ((RecordDataSchema) DataTemplateUtil.parseSchema("{\"type\":\"record\",\"name\":\"AssociationSchema\",\"namespace\":\"com.linkedin.restli.restspec\",\"fields\":[{\"name\":\"identifier\",\"type\":\"string\",\"doc\":\"name of the identifier (key) for this collection\",\"optional\":true},{\"name\":\"assocKeys\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"AssocKeySchema\",\"fields\":[{\"name\":\"name\",\"type\":\"string\",\"doc\":\"name of association key\"},{\"name\":\"type\",\"type\":\"string\",\"doc\":\"avro type of association key\"}]}},\"doc\":\"list of association keys for this association\"},{\"name\":\"supports\",\"type\":{\"type\":\"array\",\"items\":\"string\"},\"doc\":\"list of rest.li methods supported by this association, e.g., get, update, delete, batch_get\"},{\"name\":\"methods\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"RestMethodSchema\",\"include\":[{\"type\":\"record\",\"name\":\"CustomAnnotationSchema\",\"doc\":\"Custom annotation for idl\",\"fields\":[{\"name\":\"annotations\",\"type\":{\"type\":\"map\",\"values\":{\"type\":\"record\",\"name\":\"CustomAnnotationContentSchema\",\"doc\":\"Unstructured record that represents arbitrary custom annotations for idl. Actual content is always a map with annotation's overridable member name as key and member value as value\",\"fields\":[]}},\"doc\":\"custom annotation data\",\"optional\":true}]}],\"fields\":[{\"name\":\"method\",\"type\":\"string\",\"doc\":\"method type for this rest method\"},{\"name\":\"doc\",\"type\":\"string\",\"doc\":\"Documentation for this finder\",\"optional\":true},{\"name\":\"parameters\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"ParameterSchema\",\"include\":[\"CustomAnnotationSchema\"],\"fields\":[{\"name\":\"name\",\"type\":\"string\",\"doc\":\"name of this parameter\"},{\"name\":\"type\",\"type\":\"string\",\"doc\":\"avro type of this parameter\"},{\"name\":\"items\",\"type\":\"string\",\"doc\":\"type of individual items, if this is an array parameter (used for finder parameters)\",\"optional\":true},{\"name\":\"optional\",\"type\":\"boolean\",\"doc\":\"indicates whether this parameter is optional.  omitted for required parameters\",\"optional\":true},{\"name\":\"default\",\"type\":\"string\",\"doc\":\"indicates the default value for this parameter\",\"optional\":true},{\"name\":\"doc\",\"type\":\"string\",\"doc\":\"Documentation for this parameter\",\"optional\":true}]}},\"doc\":\"list of query parameters for this method\",\"optional\":true}]}},\"doc\":\"details on rest methods supported by this association\",\"optional\":true},{\"name\":\"finders\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"FinderSchema\",\"include\":[\"CustomAnnotationSchema\"],\"fields\":[{\"name\":\"name\",\"type\":\"string\",\"doc\":\"name of this finder - not required if this is the default finder\",\"optional\":true},{\"name\":\"doc\",\"type\":\"string\",\"doc\":\"Documentation for this finder\",\"optional\":true},{\"name\":\"parameters\",\"type\":{\"type\":\"array\",\"items\":\"ParameterSchema\"},\"doc\":\"list of query parameters for this finder\",\"optional\":true},{\"name\":\"metadata\",\"type\":{\"type\":\"record\",\"name\":\"MetadataSchema\",\"fields\":[{\"name\":\"type\",\"type\":\"string\",\"doc\":\"pegasus type of the metadata\"}]},\"doc\":\"describes the collection-level metadata returned by this finder\",\"optional\":true},{\"name\":\"assocKey\",\"type\":\"string\",\"doc\":\"association key for this finder - only present if this finder takes a single association key\",\"optional\":true},{\"name\":\"assocKeys\",\"type\":{\"type\":\"array\",\"items\":\"string\"},\"doc\":\"list of association keys for this finder - only present if this finder takes multiple association keys\",\"optional\":true}]}},\"doc\":\"list of finders supported by this association\",\"optional\":true},{\"name\":\"actions\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"ActionSchema\",\"include\":[\"CustomAnnotationSchema\"],\"fields\":[{\"name\":\"name\",\"type\":\"string\",\"doc\":\"name of this action\"},{\"name\":\"doc\",\"type\":\"string\",\"doc\":\"Documentation for this action\",\"optional\":true},{\"name\":\"parameters\",\"type\":{\"type\":\"array\",\"items\":\"ParameterSchema\"},\"doc\":\"parameters for this action\",\"optional\":true},{\"name\":\"returns\",\"type\":\"string\",\"doc\":\"avro type of this action's return value\",\"optional\":true},{\"name\":\"throws\",\"type\":{\"type\":\"array\",\"items\":\"string\"},\"doc\":\"list of exception types thrown by this action\",\"optional\":true}]}},\"doc\":\"list of actions supported by this association\",\"optional\":true},{\"name\":\"entity\",\"type\":{\"type\":\"record\",\"name\":\"EntitySchema\",\"fields\":[{\"name\":\"path\",\"type\":\"string\",\"doc\":\"URI template for accessing this entity\"},{\"name\":\"actions\",\"type\":{\"type\":\"array\",\"items\":\"ActionSchema\"},\"doc\":\"list of actions supported by this entity\",\"optional\":true},{\"name\":\"subresources\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"ResourceSchema\",\"include\":[\"CustomAnnotationSchema\"],\"fields\":[{\"name\":\"name\",\"type\":\"string\",\"doc\":\"name of the resource\"},{\"name\":\"namespace\",\"type\":\"string\",\"doc\":\"namespace of the resource\",\"optional\":true},{\"name\":\"path\",\"type\":\"string\",\"doc\":\"URI template for accessing the resource\"},{\"name\":\"schema\",\"type\":\"string\",\"doc\":\"Java-style fully-qualified class name for entities of this resource\",\"optional\":true},{\"name\":\"doc\",\"type\":\"string\",\"doc\":\"Documentation for this resource\",\"optional\":true},{\"name\":\"collection\",\"type\":{\"type\":\"record\",\"name\":\"CollectionSchema\",\"fields\":[{\"name\":\"identifier\",\"type\":{\"type\":\"record\",\"name\":\"IdentifierSchema\",\"fields\":[{\"name\":\"name\",\"type\":\"string\",\"doc\":\"name of the identifier\"},{\"name\":\"type\",\"type\":\"string\",\"doc\":\"avro type of the identifier\"},{\"name\":\"params\",\"type\":\"string\",\"doc\":\"avro type of the identifier parameters\",\"optional\":true}]},\"doc\":\"details of the identifier (key) for this collection\"},{\"name\":\"supports\",\"type\":{\"type\":\"array\",\"items\":\"string\"},\"doc\":\"basic rest.li methods supported by this resource, e.g., create, get, update, delete, batch_get\"},{\"name\":\"methods\",\"type\":{\"type\":\"array\",\"items\":\"RestMethodSchema\"},\"doc\":\"details on rest methods supported by this collection\",\"optional\":true},{\"name\":\"finders\",\"type\":{\"type\":\"array\",\"items\":\"FinderSchema\"},\"doc\":\"list of finders supported by this collection\",\"optional\":true},{\"name\":\"actions\",\"type\":{\"type\":\"array\",\"items\":\"ActionSchema\"},\"doc\":\"list of actions supported by this collection\",\"optional\":true},{\"name\":\"entity\",\"type\":\"EntitySchema\",\"doc\":\"details of the entity provided by this collection\"}]},\"doc\":\"details of collection, if this resource is a collection\",\"optional\":true},{\"name\":\"association\",\"type\":\"AssociationSchema\",\"doc\":\"details of association, if this resource is an association\",\"optional\":true},{\"name\":\"actionsSet\",\"type\":{\"type\":\"record\",\"name\":\"ActionsSetSchema\",\"fields\":[{\"name\":\"actions\",\"type\":{\"type\":\"array\",\"items\":\"ActionSchema\"},\"doc\":\"list of actions supported by this action set\"}]},\"doc\":\"details of action set, if this resource is an action set\",\"optional\":true},{\"name\":\"simple\",\"type\":{\"type\":\"record\",\"name\":\"SimpleSchema\",\"fields\":[{\"name\":\"supports\",\"type\":{\"type\":\"array\",\"items\":\"string\"},\"doc\":\"basic rest.li methods supported by this resource, e.g. get, update, delete\"},{\"name\":\"methods\",\"type\":{\"type\":\"array\",\"items\":\"RestMethodSchema\"},\"doc\":\"details on rest methods supported by this simple resource\",\"optional\":true},{\"name\":\"actions\",\"type\":{\"type\":\"array\",\"items\":\"ActionSchema\"},\"doc\":\"list of actions supported by this simple resource\",\"optional\":true},{\"name\":\"entity\",\"type\":\"EntitySchema\",\"doc\":\"details of the entity provided by this simple resource\"}]},\"doc\":\"details of simple resource, if this resource is a simple resource\",\"optional\":true}]}},\"doc\":\"list of subresources accessible via this entity\",\"optional\":true}]},\"doc\":\"details on the entities contained in this association\"}]}"));
    private final static RecordDataSchema.Field FIELD_Identifier = SCHEMA.getField("identifier");
    private final static RecordDataSchema.Field FIELD_AssocKeys = SCHEMA.getField("assocKeys");
    private final static RecordDataSchema.Field FIELD_Supports = SCHEMA.getField("supports");
    private final static RecordDataSchema.Field FIELD_Methods = SCHEMA.getField("methods");
    private final static RecordDataSchema.Field FIELD_Finders = SCHEMA.getField("finders");
    private final static RecordDataSchema.Field FIELD_Actions = SCHEMA.getField("actions");
    private final static RecordDataSchema.Field FIELD_Entity = SCHEMA.getField("entity");

    public AssociationSchema() {
        super(new DataMap(), SCHEMA);
    }

    public AssociationSchema(DataMap data) {
        super(data, SCHEMA);
    }

    public static AssociationSchema.Fields fields() {
        return _fields;
    }

    /**
     * Existence checker for identifier
     * 
     * @see Fields#identifier
     */
    public boolean hasIdentifier() {
        return contains(FIELD_Identifier);
    }

    /**
     * Remover for identifier
     * 
     * @see Fields#identifier
     */
    public void removeIdentifier() {
        remove(FIELD_Identifier);
    }

    /**
     * Getter for identifier
     * 
     * @see Fields#identifier
     */
    public String getIdentifier(GetMode mode) {
        return obtainDirect(FIELD_Identifier, String.class, mode);
    }

    /**
     * Getter for identifier
     * 
     * @see Fields#identifier
     */
    public String getIdentifier() {
        return getIdentifier(GetMode.STRICT);
    }

    /**
     * Setter for identifier
     * 
     * @see Fields#identifier
     */
    public AssociationSchema setIdentifier(String value, SetMode mode) {
        putDirect(FIELD_Identifier, String.class, String.class, value, mode);
        return this;
    }

    /**
     * Setter for identifier
     * 
     * @see Fields#identifier
     */
    public AssociationSchema setIdentifier(String value) {
        putDirect(FIELD_Identifier, String.class, String.class, value, SetMode.DISALLOW_NULL);
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
    public AssocKeySchemaArray getAssocKeys(GetMode mode) {
        return obtainWrapped(FIELD_AssocKeys, AssocKeySchemaArray.class, mode);
    }

    /**
     * Getter for assocKeys
     * 
     * @see Fields#assocKeys
     */
    public AssocKeySchemaArray getAssocKeys() {
        return getAssocKeys(GetMode.STRICT);
    }

    /**
     * Setter for assocKeys
     * 
     * @see Fields#assocKeys
     */
    public AssociationSchema setAssocKeys(AssocKeySchemaArray value, SetMode mode) {
        putWrapped(FIELD_AssocKeys, AssocKeySchemaArray.class, value, mode);
        return this;
    }

    /**
     * Setter for assocKeys
     * 
     * @see Fields#assocKeys
     */
    public AssociationSchema setAssocKeys(AssocKeySchemaArray value) {
        putWrapped(FIELD_AssocKeys, AssocKeySchemaArray.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    /**
     * Existence checker for supports
     * 
     * @see Fields#supports
     */
    public boolean hasSupports() {
        return contains(FIELD_Supports);
    }

    /**
     * Remover for supports
     * 
     * @see Fields#supports
     */
    public void removeSupports() {
        remove(FIELD_Supports);
    }

    /**
     * Getter for supports
     * 
     * @see Fields#supports
     */
    public StringArray getSupports(GetMode mode) {
        return obtainWrapped(FIELD_Supports, StringArray.class, mode);
    }

    /**
     * Getter for supports
     * 
     * @see Fields#supports
     */
    public StringArray getSupports() {
        return getSupports(GetMode.STRICT);
    }

    /**
     * Setter for supports
     * 
     * @see Fields#supports
     */
    public AssociationSchema setSupports(StringArray value, SetMode mode) {
        putWrapped(FIELD_Supports, StringArray.class, value, mode);
        return this;
    }

    /**
     * Setter for supports
     * 
     * @see Fields#supports
     */
    public AssociationSchema setSupports(StringArray value) {
        putWrapped(FIELD_Supports, StringArray.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    /**
     * Existence checker for methods
     * 
     * @see Fields#methods
     */
    public boolean hasMethods() {
        return contains(FIELD_Methods);
    }

    /**
     * Remover for methods
     * 
     * @see Fields#methods
     */
    public void removeMethods() {
        remove(FIELD_Methods);
    }

    /**
     * Getter for methods
     * 
     * @see Fields#methods
     */
    public RestMethodSchemaArray getMethods(GetMode mode) {
        return obtainWrapped(FIELD_Methods, RestMethodSchemaArray.class, mode);
    }

    /**
     * Getter for methods
     * 
     * @see Fields#methods
     */
    public RestMethodSchemaArray getMethods() {
        return getMethods(GetMode.STRICT);
    }

    /**
     * Setter for methods
     * 
     * @see Fields#methods
     */
    public AssociationSchema setMethods(RestMethodSchemaArray value, SetMode mode) {
        putWrapped(FIELD_Methods, RestMethodSchemaArray.class, value, mode);
        return this;
    }

    /**
     * Setter for methods
     * 
     * @see Fields#methods
     */
    public AssociationSchema setMethods(RestMethodSchemaArray value) {
        putWrapped(FIELD_Methods, RestMethodSchemaArray.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    /**
     * Existence checker for finders
     * 
     * @see Fields#finders
     */
    public boolean hasFinders() {
        return contains(FIELD_Finders);
    }

    /**
     * Remover for finders
     * 
     * @see Fields#finders
     */
    public void removeFinders() {
        remove(FIELD_Finders);
    }

    /**
     * Getter for finders
     * 
     * @see Fields#finders
     */
    public FinderSchemaArray getFinders(GetMode mode) {
        return obtainWrapped(FIELD_Finders, FinderSchemaArray.class, mode);
    }

    /**
     * Getter for finders
     * 
     * @see Fields#finders
     */
    public FinderSchemaArray getFinders() {
        return getFinders(GetMode.STRICT);
    }

    /**
     * Setter for finders
     * 
     * @see Fields#finders
     */
    public AssociationSchema setFinders(FinderSchemaArray value, SetMode mode) {
        putWrapped(FIELD_Finders, FinderSchemaArray.class, value, mode);
        return this;
    }

    /**
     * Setter for finders
     * 
     * @see Fields#finders
     */
    public AssociationSchema setFinders(FinderSchemaArray value) {
        putWrapped(FIELD_Finders, FinderSchemaArray.class, value, SetMode.DISALLOW_NULL);
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
    public AssociationSchema setActions(ActionSchemaArray value, SetMode mode) {
        putWrapped(FIELD_Actions, ActionSchemaArray.class, value, mode);
        return this;
    }

    /**
     * Setter for actions
     * 
     * @see Fields#actions
     */
    public AssociationSchema setActions(ActionSchemaArray value) {
        putWrapped(FIELD_Actions, ActionSchemaArray.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    /**
     * Existence checker for entity
     * 
     * @see Fields#entity
     */
    public boolean hasEntity() {
        return contains(FIELD_Entity);
    }

    /**
     * Remover for entity
     * 
     * @see Fields#entity
     */
    public void removeEntity() {
        remove(FIELD_Entity);
    }

    /**
     * Getter for entity
     * 
     * @see Fields#entity
     */
    public EntitySchema getEntity(GetMode mode) {
        return obtainWrapped(FIELD_Entity, EntitySchema.class, mode);
    }

    /**
     * Getter for entity
     * 
     * @see Fields#entity
     */
    public EntitySchema getEntity() {
        return getEntity(GetMode.STRICT);
    }

    /**
     * Setter for entity
     * 
     * @see Fields#entity
     */
    public AssociationSchema setEntity(EntitySchema value, SetMode mode) {
        putWrapped(FIELD_Entity, EntitySchema.class, value, mode);
        return this;
    }

    /**
     * Setter for entity
     * 
     * @see Fields#entity
     */
    public AssociationSchema setEntity(EntitySchema value) {
        putWrapped(FIELD_Entity, EntitySchema.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    @Override
    public AssociationSchema clone()
        throws CloneNotSupportedException
    {
        return ((AssociationSchema) super.clone());
    }

    @Override
    public AssociationSchema copy()
        throws CloneNotSupportedException
    {
        return ((AssociationSchema) super.copy());
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
         * name of the identifier (key) for this collection
         * 
         */
        public PathSpec identifier() {
            return new PathSpec(getPathComponents(), "identifier");
        }

        /**
         * list of association keys for this association
         * 
         */
        public com.linkedin.restli.restspec.AssocKeySchemaArray.Fields assocKeys() {
            return new com.linkedin.restli.restspec.AssocKeySchemaArray.Fields(getPathComponents(), "assocKeys");
        }

        /**
         * list of rest.li methods supported by this association, e.g., get, update, delete, batch_get
         * 
         */
        public PathSpec supports() {
            return new PathSpec(getPathComponents(), "supports");
        }

        /**
         * details on rest methods supported by this association
         * 
         */
        public com.linkedin.restli.restspec.RestMethodSchemaArray.Fields methods() {
            return new com.linkedin.restli.restspec.RestMethodSchemaArray.Fields(getPathComponents(), "methods");
        }

        /**
         * list of finders supported by this association
         * 
         */
        public com.linkedin.restli.restspec.FinderSchemaArray.Fields finders() {
            return new com.linkedin.restli.restspec.FinderSchemaArray.Fields(getPathComponents(), "finders");
        }

        /**
         * list of actions supported by this association
         * 
         */
        public com.linkedin.restli.restspec.ActionSchemaArray.Fields actions() {
            return new com.linkedin.restli.restspec.ActionSchemaArray.Fields(getPathComponents(), "actions");
        }

        /**
         * details on the entities contained in this association
         * 
         */
        public com.linkedin.restli.restspec.EntitySchema.Fields entity() {
            return new com.linkedin.restli.restspec.EntitySchema.Fields(getPathComponents(), "entity");
        }

    }

}

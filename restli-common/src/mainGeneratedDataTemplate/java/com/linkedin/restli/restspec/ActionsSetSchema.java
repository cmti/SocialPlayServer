
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
@Generated(value = "com.linkedin.pegasus.generator.PegasusDataTemplateGenerator", comments = "LinkedIn Data Template. Generated from /Users/jianli/git/SocialPlayServer/restli-common/src/main/pegasus/com/linkedin/restli/restspec/ActionsSetSchema.pdsc.", date = "Fri Apr 17 15:52:47 PDT 2015")
public class ActionsSetSchema
    extends RecordTemplate
{

    private final static ActionsSetSchema.Fields _fields = new ActionsSetSchema.Fields();
    private final static RecordDataSchema SCHEMA = ((RecordDataSchema) DataTemplateUtil.parseSchema("{\"type\":\"record\",\"name\":\"ActionsSetSchema\",\"namespace\":\"com.linkedin.restli.restspec\",\"fields\":[{\"name\":\"actions\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"ActionSchema\",\"include\":[{\"type\":\"record\",\"name\":\"CustomAnnotationSchema\",\"doc\":\"Custom annotation for idl\",\"fields\":[{\"name\":\"annotations\",\"type\":{\"type\":\"map\",\"values\":{\"type\":\"record\",\"name\":\"CustomAnnotationContentSchema\",\"doc\":\"Unstructured record that represents arbitrary custom annotations for idl. Actual content is always a map with annotation's overridable member name as key and member value as value\",\"fields\":[]}},\"doc\":\"custom annotation data\",\"optional\":true}]}],\"fields\":[{\"name\":\"name\",\"type\":\"string\",\"doc\":\"name of this action\"},{\"name\":\"doc\",\"type\":\"string\",\"doc\":\"Documentation for this action\",\"optional\":true},{\"name\":\"parameters\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"ParameterSchema\",\"include\":[\"CustomAnnotationSchema\"],\"fields\":[{\"name\":\"name\",\"type\":\"string\",\"doc\":\"name of this parameter\"},{\"name\":\"type\",\"type\":\"string\",\"doc\":\"avro type of this parameter\"},{\"name\":\"items\",\"type\":\"string\",\"doc\":\"type of individual items, if this is an array parameter (used for finder parameters)\",\"optional\":true},{\"name\":\"optional\",\"type\":\"boolean\",\"doc\":\"indicates whether this parameter is optional.  omitted for required parameters\",\"optional\":true},{\"name\":\"default\",\"type\":\"string\",\"doc\":\"indicates the default value for this parameter\",\"optional\":true},{\"name\":\"doc\",\"type\":\"string\",\"doc\":\"Documentation for this parameter\",\"optional\":true}]}},\"doc\":\"parameters for this action\",\"optional\":true},{\"name\":\"returns\",\"type\":\"string\",\"doc\":\"avro type of this action's return value\",\"optional\":true},{\"name\":\"throws\",\"type\":{\"type\":\"array\",\"items\":\"string\"},\"doc\":\"list of exception types thrown by this action\",\"optional\":true}]}},\"doc\":\"list of actions supported by this action set\"}]}"));
    private final static RecordDataSchema.Field FIELD_Actions = SCHEMA.getField("actions");

    public ActionsSetSchema() {
        super(new DataMap(), SCHEMA);
    }

    public ActionsSetSchema(DataMap data) {
        super(data, SCHEMA);
    }

    public static ActionsSetSchema.Fields fields() {
        return _fields;
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
    public ActionsSetSchema setActions(ActionSchemaArray value, SetMode mode) {
        putWrapped(FIELD_Actions, ActionSchemaArray.class, value, mode);
        return this;
    }

    /**
     * Setter for actions
     * 
     * @see Fields#actions
     */
    public ActionsSetSchema setActions(ActionSchemaArray value) {
        putWrapped(FIELD_Actions, ActionSchemaArray.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    @Override
    public ActionsSetSchema clone()
        throws CloneNotSupportedException
    {
        return ((ActionsSetSchema) super.clone());
    }

    @Override
    public ActionsSetSchema copy()
        throws CloneNotSupportedException
    {
        return ((ActionsSetSchema) super.copy());
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
         * list of actions supported by this action set
         * 
         */
        public com.linkedin.restli.restspec.ActionSchemaArray.Fields actions() {
            return new com.linkedin.restli.restspec.ActionSchemaArray.Fields(getPathComponents(), "actions");
        }

    }

}

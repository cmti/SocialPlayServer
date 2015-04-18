
package com.linkedin.restli.restspec;

import java.util.Collection;
import java.util.List;
import javax.annotation.Generated;
import com.linkedin.data.DataList;
import com.linkedin.data.schema.ArrayDataSchema;
import com.linkedin.data.schema.PathSpec;
import com.linkedin.data.template.DataTemplateUtil;
import com.linkedin.data.template.WrappingArrayTemplate;

@Generated(value = "com.linkedin.pegasus.generator.PegasusDataTemplateGenerator", comments = "LinkedIn Data Template. Generated from /Users/jianli/git/SocialPlayServer/restli-common/src/main/pegasus/com/linkedin/restli/restspec/ActionsSetSchema.pdsc.", date = "Fri Apr 17 15:52:47 PDT 2015")
public class ActionSchemaArray
    extends WrappingArrayTemplate<ActionSchema>
{

    private final static ArrayDataSchema SCHEMA = ((ArrayDataSchema) DataTemplateUtil.parseSchema("{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"ActionSchema\",\"namespace\":\"com.linkedin.restli.restspec\",\"include\":[{\"type\":\"record\",\"name\":\"CustomAnnotationSchema\",\"doc\":\"Custom annotation for idl\",\"fields\":[{\"name\":\"annotations\",\"type\":{\"type\":\"map\",\"values\":{\"type\":\"record\",\"name\":\"CustomAnnotationContentSchema\",\"doc\":\"Unstructured record that represents arbitrary custom annotations for idl. Actual content is always a map with annotation's overridable member name as key and member value as value\",\"fields\":[]}},\"doc\":\"custom annotation data\",\"optional\":true}]}],\"fields\":[{\"name\":\"name\",\"type\":\"string\",\"doc\":\"name of this action\"},{\"name\":\"doc\",\"type\":\"string\",\"doc\":\"Documentation for this action\",\"optional\":true},{\"name\":\"parameters\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"ParameterSchema\",\"include\":[\"CustomAnnotationSchema\"],\"fields\":[{\"name\":\"name\",\"type\":\"string\",\"doc\":\"name of this parameter\"},{\"name\":\"type\",\"type\":\"string\",\"doc\":\"avro type of this parameter\"},{\"name\":\"items\",\"type\":\"string\",\"doc\":\"type of individual items, if this is an array parameter (used for finder parameters)\",\"optional\":true},{\"name\":\"optional\",\"type\":\"boolean\",\"doc\":\"indicates whether this parameter is optional.  omitted for required parameters\",\"optional\":true},{\"name\":\"default\",\"type\":\"string\",\"doc\":\"indicates the default value for this parameter\",\"optional\":true},{\"name\":\"doc\",\"type\":\"string\",\"doc\":\"Documentation for this parameter\",\"optional\":true}]}},\"doc\":\"parameters for this action\",\"optional\":true},{\"name\":\"returns\",\"type\":\"string\",\"doc\":\"avro type of this action's return value\",\"optional\":true},{\"name\":\"throws\",\"type\":{\"type\":\"array\",\"items\":\"string\"},\"doc\":\"list of exception types thrown by this action\",\"optional\":true}]}}"));

    public ActionSchemaArray() {
        this(new DataList());
    }

    public ActionSchemaArray(int initialCapacity) {
        this(new DataList(initialCapacity));
    }

    public ActionSchemaArray(Collection<ActionSchema> c) {
        this(new DataList(c.size()));
        addAll(c);
    }

    public ActionSchemaArray(DataList data) {
        super(data, SCHEMA, ActionSchema.class);
    }

    @Override
    public ActionSchemaArray clone()
        throws CloneNotSupportedException
    {
        return ((ActionSchemaArray) super.clone());
    }

    @Override
    public ActionSchemaArray copy()
        throws CloneNotSupportedException
    {
        return ((ActionSchemaArray) super.copy());
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

        public com.linkedin.restli.restspec.ActionSchema.Fields items() {
            return new com.linkedin.restli.restspec.ActionSchema.Fields(getPathComponents(), PathSpec.WILDCARD);
        }

    }

}

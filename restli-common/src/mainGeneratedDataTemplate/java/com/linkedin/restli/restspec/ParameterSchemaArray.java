
package com.linkedin.restli.restspec;

import java.util.Collection;
import java.util.List;
import javax.annotation.Generated;
import com.linkedin.data.DataList;
import com.linkedin.data.schema.ArrayDataSchema;
import com.linkedin.data.schema.PathSpec;
import com.linkedin.data.template.DataTemplateUtil;
import com.linkedin.data.template.WrappingArrayTemplate;

@Generated(value = "com.linkedin.pegasus.generator.PegasusDataTemplateGenerator", comments = "LinkedIn Data Template. Generated from /Users/jianli/workspaces/SocialPlayServer/restli-common/src/main/pegasus/com/linkedin/restli/restspec/ActionSchema.pdsc.", date = "Wed Jan 14 22:36:03 PST 2015")
public class ParameterSchemaArray
    extends WrappingArrayTemplate<ParameterSchema>
{

    private final static ArrayDataSchema SCHEMA = ((ArrayDataSchema) DataTemplateUtil.parseSchema("{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"ParameterSchema\",\"namespace\":\"com.linkedin.restli.restspec\",\"include\":[{\"type\":\"record\",\"name\":\"CustomAnnotationSchema\",\"doc\":\"Custom annotation for idl\",\"fields\":[{\"name\":\"annotations\",\"type\":{\"type\":\"map\",\"values\":{\"type\":\"record\",\"name\":\"CustomAnnotationContentSchema\",\"doc\":\"Unstructured record that represents arbitrary custom annotations for idl. Actual content is always a map with annotation's overridable member name as key and member value as value\",\"fields\":[]}},\"doc\":\"custom annotation data\",\"optional\":true}]}],\"fields\":[{\"name\":\"name\",\"type\":\"string\",\"doc\":\"name of this parameter\"},{\"name\":\"type\",\"type\":\"string\",\"doc\":\"avro type of this parameter\"},{\"name\":\"items\",\"type\":\"string\",\"doc\":\"type of individual items, if this is an array parameter (used for finder parameters)\",\"optional\":true},{\"name\":\"optional\",\"type\":\"boolean\",\"doc\":\"indicates whether this parameter is optional.  omitted for required parameters\",\"optional\":true},{\"name\":\"default\",\"type\":\"string\",\"doc\":\"indicates the default value for this parameter\",\"optional\":true},{\"name\":\"doc\",\"type\":\"string\",\"doc\":\"Documentation for this parameter\",\"optional\":true}]}}"));

    public ParameterSchemaArray() {
        this(new DataList());
    }

    public ParameterSchemaArray(int initialCapacity) {
        this(new DataList(initialCapacity));
    }

    public ParameterSchemaArray(Collection<ParameterSchema> c) {
        this(new DataList(c.size()));
        addAll(c);
    }

    public ParameterSchemaArray(DataList data) {
        super(data, SCHEMA, ParameterSchema.class);
    }

    @Override
    public ParameterSchemaArray clone()
        throws CloneNotSupportedException
    {
        return ((ParameterSchemaArray) super.clone());
    }

    @Override
    public ParameterSchemaArray copy()
        throws CloneNotSupportedException
    {
        return ((ParameterSchemaArray) super.copy());
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

        public com.linkedin.restli.restspec.ParameterSchema.Fields items() {
            return new com.linkedin.restli.restspec.ParameterSchema.Fields(getPathComponents(), PathSpec.WILDCARD);
        }

    }

}

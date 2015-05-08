
package com.linkedin.restli.restspec;

import java.util.Collection;
import java.util.List;
import javax.annotation.Generated;
import com.linkedin.data.DataList;
import com.linkedin.data.schema.ArrayDataSchema;
import com.linkedin.data.schema.PathSpec;
import com.linkedin.data.template.DataTemplateUtil;
import com.linkedin.data.template.WrappingArrayTemplate;

@Generated(value = "com.linkedin.pegasus.generator.PegasusDataTemplateGenerator", comments = "LinkedIn Data Template. Generated from /Users/jianli/git/SocialPlayServer/restli-common/src/main/pegasus/com/linkedin/restli/restspec/AssociationSchema.pdsc.", date = "Thu May 07 23:46:42 PDT 2015")
public class AssocKeySchemaArray
    extends WrappingArrayTemplate<AssocKeySchema>
{

    private final static ArrayDataSchema SCHEMA = ((ArrayDataSchema) DataTemplateUtil.parseSchema("{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"AssocKeySchema\",\"namespace\":\"com.linkedin.restli.restspec\",\"fields\":[{\"name\":\"name\",\"type\":\"string\",\"doc\":\"name of association key\"},{\"name\":\"type\",\"type\":\"string\",\"doc\":\"avro type of association key\"}]}}"));

    public AssocKeySchemaArray() {
        this(new DataList());
    }

    public AssocKeySchemaArray(int initialCapacity) {
        this(new DataList(initialCapacity));
    }

    public AssocKeySchemaArray(Collection<AssocKeySchema> c) {
        this(new DataList(c.size()));
        addAll(c);
    }

    public AssocKeySchemaArray(DataList data) {
        super(data, SCHEMA, AssocKeySchema.class);
    }

    @Override
    public AssocKeySchemaArray clone()
        throws CloneNotSupportedException
    {
        return ((AssocKeySchemaArray) super.clone());
    }

    @Override
    public AssocKeySchemaArray copy()
        throws CloneNotSupportedException
    {
        return ((AssocKeySchemaArray) super.copy());
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

        public com.linkedin.restli.restspec.AssocKeySchema.Fields items() {
            return new com.linkedin.restli.restspec.AssocKeySchema.Fields(getPathComponents(), PathSpec.WILDCARD);
        }

    }

}

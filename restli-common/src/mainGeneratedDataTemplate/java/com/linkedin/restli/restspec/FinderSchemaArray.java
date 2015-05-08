
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
public class FinderSchemaArray
    extends WrappingArrayTemplate<FinderSchema>
{

    private final static ArrayDataSchema SCHEMA = ((ArrayDataSchema) DataTemplateUtil.parseSchema("{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"FinderSchema\",\"namespace\":\"com.linkedin.restli.restspec\",\"include\":[{\"type\":\"record\",\"name\":\"CustomAnnotationSchema\",\"doc\":\"Custom annotation for idl\",\"fields\":[{\"name\":\"annotations\",\"type\":{\"type\":\"map\",\"values\":{\"type\":\"record\",\"name\":\"CustomAnnotationContentSchema\",\"doc\":\"Unstructured record that represents arbitrary custom annotations for idl. Actual content is always a map with annotation's overridable member name as key and member value as value\",\"fields\":[]}},\"doc\":\"custom annotation data\",\"optional\":true}]}],\"fields\":[{\"name\":\"name\",\"type\":\"string\",\"doc\":\"name of this finder - not required if this is the default finder\",\"optional\":true},{\"name\":\"doc\",\"type\":\"string\",\"doc\":\"Documentation for this finder\",\"optional\":true},{\"name\":\"parameters\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"ParameterSchema\",\"include\":[\"CustomAnnotationSchema\"],\"fields\":[{\"name\":\"name\",\"type\":\"string\",\"doc\":\"name of this parameter\"},{\"name\":\"type\",\"type\":\"string\",\"doc\":\"avro type of this parameter\"},{\"name\":\"items\",\"type\":\"string\",\"doc\":\"type of individual items, if this is an array parameter (used for finder parameters)\",\"optional\":true},{\"name\":\"optional\",\"type\":\"boolean\",\"doc\":\"indicates whether this parameter is optional.  omitted for required parameters\",\"optional\":true},{\"name\":\"default\",\"type\":\"string\",\"doc\":\"indicates the default value for this parameter\",\"optional\":true},{\"name\":\"doc\",\"type\":\"string\",\"doc\":\"Documentation for this parameter\",\"optional\":true}]}},\"doc\":\"list of query parameters for this finder\",\"optional\":true},{\"name\":\"metadata\",\"type\":{\"type\":\"record\",\"name\":\"MetadataSchema\",\"fields\":[{\"name\":\"type\",\"type\":\"string\",\"doc\":\"pegasus type of the metadata\"}]},\"doc\":\"describes the collection-level metadata returned by this finder\",\"optional\":true},{\"name\":\"assocKey\",\"type\":\"string\",\"doc\":\"association key for this finder - only present if this finder takes a single association key\",\"optional\":true},{\"name\":\"assocKeys\",\"type\":{\"type\":\"array\",\"items\":\"string\"},\"doc\":\"list of association keys for this finder - only present if this finder takes multiple association keys\",\"optional\":true}]}}"));

    public FinderSchemaArray() {
        this(new DataList());
    }

    public FinderSchemaArray(int initialCapacity) {
        this(new DataList(initialCapacity));
    }

    public FinderSchemaArray(Collection<FinderSchema> c) {
        this(new DataList(c.size()));
        addAll(c);
    }

    public FinderSchemaArray(DataList data) {
        super(data, SCHEMA, FinderSchema.class);
    }

    @Override
    public FinderSchemaArray clone()
        throws CloneNotSupportedException
    {
        return ((FinderSchemaArray) super.clone());
    }

    @Override
    public FinderSchemaArray copy()
        throws CloneNotSupportedException
    {
        return ((FinderSchemaArray) super.copy());
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

        public com.linkedin.restli.restspec.FinderSchema.Fields items() {
            return new com.linkedin.restli.restspec.FinderSchema.Fields(getPathComponents(), PathSpec.WILDCARD);
        }

    }

}

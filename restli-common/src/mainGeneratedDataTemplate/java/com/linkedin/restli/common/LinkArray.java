
package com.linkedin.restli.common;

import java.util.Collection;
import java.util.List;
import javax.annotation.Generated;
import com.linkedin.data.DataList;
import com.linkedin.data.schema.ArrayDataSchema;
import com.linkedin.data.schema.PathSpec;
import com.linkedin.data.template.DataTemplateUtil;
import com.linkedin.data.template.WrappingArrayTemplate;

@Generated(value = "com.linkedin.pegasus.generator.PegasusDataTemplateGenerator", comments = "LinkedIn Data Template. Generated from /Users/jianli/git/SocialPlayServer/restli-common/src/main/pegasus/com/linkedin/restli/common/CollectionMetadata.pdsc.", date = "Thu May 07 23:46:42 PDT 2015")
public class LinkArray
    extends WrappingArrayTemplate<Link>
{

    private final static ArrayDataSchema SCHEMA = ((ArrayDataSchema) DataTemplateUtil.parseSchema("{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"Link\",\"namespace\":\"com.linkedin.restli.common\",\"doc\":\"A atom:link-inspired link\",\"fields\":[{\"name\":\"rel\",\"type\":\"string\",\"doc\":\"The link relation e.g. 'self' or 'next'\"},{\"name\":\"href\",\"type\":\"string\",\"doc\":\"The link URI\"},{\"name\":\"type\",\"type\":\"string\",\"doc\":\"The type (media type) of the resource\"}]}}"));

    public LinkArray() {
        this(new DataList());
    }

    public LinkArray(int initialCapacity) {
        this(new DataList(initialCapacity));
    }

    public LinkArray(Collection<Link> c) {
        this(new DataList(c.size()));
        addAll(c);
    }

    public LinkArray(DataList data) {
        super(data, SCHEMA, Link.class);
    }

    @Override
    public LinkArray clone()
        throws CloneNotSupportedException
    {
        return ((LinkArray) super.clone());
    }

    @Override
    public LinkArray copy()
        throws CloneNotSupportedException
    {
        return ((LinkArray) super.copy());
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

        public com.linkedin.restli.common.Link.Fields items() {
            return new com.linkedin.restli.common.Link.Fields(getPathComponents(), PathSpec.WILDCARD);
        }

    }

}

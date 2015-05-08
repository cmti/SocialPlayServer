
package com.linkedin.restli.common;

import java.util.List;
import javax.annotation.Generated;
import com.linkedin.data.DataMap;
import com.linkedin.data.schema.PathSpec;
import com.linkedin.data.schema.RecordDataSchema;
import com.linkedin.data.template.DataTemplateUtil;
import com.linkedin.data.template.RecordTemplate;


/**
 * A "marker" data schema for data that is itself a data schema (a "PDSC for PDSCs"). Because PDSC is not expressive enough to describe it's own format, this is only a marker, and has no fields. Despite having no fields, it is required that data marked with this schema be non-empty. Specifically, is required that data marked as using this schema fully conform to the PDSC format (https://github.com/linkedin/rest.li/wiki/DATA-Data-Schema-and-Templates#schema-definition).
 * 
 */
@Generated(value = "com.linkedin.pegasus.generator.PegasusDataTemplateGenerator", comments = "LinkedIn Data Template. Generated from /Users/jianli/git/SocialPlayServer/restli-common/src/main/pegasus/com/linkedin/restli/common/PegasusSchema.pdsc.", date = "Thu May 07 23:46:42 PDT 2015")
public class PegasusSchema
    extends RecordTemplate
{

    private final static PegasusSchema.Fields _fields = new PegasusSchema.Fields();
    private final static RecordDataSchema SCHEMA = ((RecordDataSchema) DataTemplateUtil.parseSchema("{\"type\":\"record\",\"name\":\"PegasusSchema\",\"namespace\":\"com.linkedin.restli.common\",\"doc\":\"A \\\"marker\\\" data schema for data that is itself a data schema (a \\\"PDSC for PDSCs\\\"). Because PDSC is not expressive enough to describe it's own format, this is only a marker, and has no fields. Despite having no fields, it is required that data marked with this schema be non-empty. Specifically, is required that data marked as using this schema fully conform to the PDSC format (https://github.com/linkedin/rest.li/wiki/DATA-Data-Schema-and-Templates#schema-definition).\",\"fields\":[]}"));

    public PegasusSchema() {
        super(new DataMap(), SCHEMA);
    }

    public PegasusSchema(DataMap data) {
        super(data, SCHEMA);
    }

    public static PegasusSchema.Fields fields() {
        return _fields;
    }

    @Override
    public PegasusSchema clone()
        throws CloneNotSupportedException
    {
        return ((PegasusSchema) super.clone());
    }

    @Override
    public PegasusSchema copy()
        throws CloneNotSupportedException
    {
        return ((PegasusSchema) super.copy());
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

    }

}

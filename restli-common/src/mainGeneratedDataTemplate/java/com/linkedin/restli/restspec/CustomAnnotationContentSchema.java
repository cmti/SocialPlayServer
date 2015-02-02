
package com.linkedin.restli.restspec;

import java.util.List;
import javax.annotation.Generated;
import com.linkedin.data.DataMap;
import com.linkedin.data.schema.PathSpec;
import com.linkedin.data.schema.RecordDataSchema;
import com.linkedin.data.template.DataTemplateUtil;
import com.linkedin.data.template.RecordTemplate;


/**
 * Unstructured record that represents arbitrary custom annotations for idl. Actual content is always a map with annotation's overridable member name as key and member value as value
 * 
 */
@Generated(value = "com.linkedin.pegasus.generator.PegasusDataTemplateGenerator", comments = "LinkedIn Data Template. Generated from /Users/jianli/workspaces/SocialPlayServer/restli-common/src/main/pegasus/com/linkedin/restli/restspec/CustomAnnotationContentSchema.pdsc.", date = "Wed Jan 14 22:36:03 PST 2015")
public class CustomAnnotationContentSchema
    extends RecordTemplate
{

    private final static CustomAnnotationContentSchema.Fields _fields = new CustomAnnotationContentSchema.Fields();
    private final static RecordDataSchema SCHEMA = ((RecordDataSchema) DataTemplateUtil.parseSchema("{\"type\":\"record\",\"name\":\"CustomAnnotationContentSchema\",\"namespace\":\"com.linkedin.restli.restspec\",\"doc\":\"Unstructured record that represents arbitrary custom annotations for idl. Actual content is always a map with annotation's overridable member name as key and member value as value\",\"fields\":[]}"));

    public CustomAnnotationContentSchema() {
        super(new DataMap(), SCHEMA);
    }

    public CustomAnnotationContentSchema(DataMap data) {
        super(data, SCHEMA);
    }

    public static CustomAnnotationContentSchema.Fields fields() {
        return _fields;
    }

    @Override
    public CustomAnnotationContentSchema clone()
        throws CloneNotSupportedException
    {
        return ((CustomAnnotationContentSchema) super.clone());
    }

    @Override
    public CustomAnnotationContentSchema copy()
        throws CloneNotSupportedException
    {
        return ((CustomAnnotationContentSchema) super.copy());
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

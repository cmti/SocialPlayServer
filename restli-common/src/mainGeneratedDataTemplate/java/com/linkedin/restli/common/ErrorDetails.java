
package com.linkedin.restli.common;

import java.util.List;
import javax.annotation.Generated;
import com.linkedin.data.DataMap;
import com.linkedin.data.schema.PathSpec;
import com.linkedin.data.schema.RecordDataSchema;
import com.linkedin.data.template.DataTemplateUtil;
import com.linkedin.data.template.RecordTemplate;


/**
 * 
 * 
 */
@Generated(value = "com.linkedin.pegasus.generator.PegasusDataTemplateGenerator", comments = "LinkedIn Data Template. Generated from /Users/jianli/workspaces/SocialPlayServer/restli-common/src/main/pegasus/com/linkedin/restli/common/ErrorResponse.pdsc.", date = "Wed Jan 14 22:36:03 PST 2015")
public class ErrorDetails
    extends RecordTemplate
{

    private final static ErrorDetails.Fields _fields = new ErrorDetails.Fields();
    private final static RecordDataSchema SCHEMA = ((RecordDataSchema) DataTemplateUtil.parseSchema("{\"type\":\"record\",\"name\":\"ErrorDetails\",\"namespace\":\"com.linkedin.restli.common\",\"fields\":[]}"));

    public ErrorDetails() {
        super(new DataMap(), SCHEMA);
    }

    public ErrorDetails(DataMap data) {
        super(data, SCHEMA);
    }

    public static ErrorDetails.Fields fields() {
        return _fields;
    }

    @Override
    public ErrorDetails clone()
        throws CloneNotSupportedException
    {
        return ((ErrorDetails) super.clone());
    }

    @Override
    public ErrorDetails copy()
        throws CloneNotSupportedException
    {
        return ((ErrorDetails) super.copy());
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

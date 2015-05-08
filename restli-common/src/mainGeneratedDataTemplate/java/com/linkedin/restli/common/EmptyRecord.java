
package com.linkedin.restli.common;

import java.util.List;
import javax.annotation.Generated;
import com.linkedin.data.DataMap;
import com.linkedin.data.schema.PathSpec;
import com.linkedin.data.schema.RecordDataSchema;
import com.linkedin.data.template.DataTemplateUtil;
import com.linkedin.data.template.RecordTemplate;


/**
 * An literally empty record.  Intended as a marker to indicate the absence of content where a record type is required.  If used the underlying DataMap *must* be empty, EmptyRecordValidator is provided to help enforce this.  For example,  CreateRequest extends Request<EmptyRecord> to indicate it has no response body.   Also, a ComplexKeyResource implementation that has no ParamKey should have a signature like XyzResource implements ComplexKeyResource<XyzKey, EmptyRecord, Xyz>.
 * 
 */
@Generated(value = "com.linkedin.pegasus.generator.PegasusDataTemplateGenerator", comments = "LinkedIn Data Template. Generated from /Users/jianli/git/SocialPlayServer/restli-common/src/main/pegasus/com/linkedin/restli/common/EmptyRecord.pdsc.", date = "Thu May 07 23:46:42 PDT 2015")
public class EmptyRecord
    extends RecordTemplate
{

    private final static EmptyRecord.Fields _fields = new EmptyRecord.Fields();
    private final static RecordDataSchema SCHEMA = ((RecordDataSchema) DataTemplateUtil.parseSchema("{\"type\":\"record\",\"name\":\"EmptyRecord\",\"namespace\":\"com.linkedin.restli.common\",\"doc\":\"An literally empty record.  Intended as a marker to indicate the absence of content where a record type is required.  If used the underlying DataMap *must* be empty, EmptyRecordValidator is provided to help enforce this.  For example,  CreateRequest extends Request<EmptyRecord> to indicate it has no response body.   Also, a ComplexKeyResource implementation that has no ParamKey should have a signature like XyzResource implements ComplexKeyResource<XyzKey, EmptyRecord, Xyz>.\",\"fields\":[],\"validate\":{\"com.linkedin.restli.common.EmptyRecordValidator\":{}}}"));

    public EmptyRecord() {
        super(new DataMap(), SCHEMA);
    }

    public EmptyRecord(DataMap data) {
        super(data, SCHEMA);
    }

    public static EmptyRecord.Fields fields() {
        return _fields;
    }

    @Override
    public EmptyRecord clone()
        throws CloneNotSupportedException
    {
        return ((EmptyRecord) super.clone());
    }

    @Override
    public EmptyRecord copy()
        throws CloneNotSupportedException
    {
        return ((EmptyRecord) super.copy());
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


package com.linkedin.restli.restspec;

import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.linkedin.data.DataMap;
import com.linkedin.data.schema.MapDataSchema;
import com.linkedin.data.schema.PathSpec;
import com.linkedin.data.template.DataTemplateUtil;
import com.linkedin.data.template.WrappingMapTemplate;

@Generated(value = "com.linkedin.pegasus.generator.PegasusDataTemplateGenerator", comments = "LinkedIn Data Template. Generated from /Users/jianli/git/SocialPlayServer/restli-common/src/main/pegasus/com/linkedin/restli/restspec/CustomAnnotationSchema.pdsc.", date = "Fri Apr 17 15:52:47 PDT 2015")
public class CustomAnnotationContentSchemaMap
    extends WrappingMapTemplate<CustomAnnotationContentSchema>
{

    private final static MapDataSchema SCHEMA = ((MapDataSchema) DataTemplateUtil.parseSchema("{\"type\":\"map\",\"values\":{\"type\":\"record\",\"name\":\"CustomAnnotationContentSchema\",\"namespace\":\"com.linkedin.restli.restspec\",\"doc\":\"Unstructured record that represents arbitrary custom annotations for idl. Actual content is always a map with annotation's overridable member name as key and member value as value\",\"fields\":[]}}"));

    public CustomAnnotationContentSchemaMap() {
        this(new DataMap());
    }

    public CustomAnnotationContentSchemaMap(int initialCapacity) {
        this(new DataMap(initialCapacity));
    }

    public CustomAnnotationContentSchemaMap(int initialCapacity, float loadFactor) {
        this(new DataMap(initialCapacity, loadFactor));
    }

    public CustomAnnotationContentSchemaMap(Map<String, CustomAnnotationContentSchema> m) {
        this(newDataMapOfSize(m.size()));
        putAll(m);
    }

    public CustomAnnotationContentSchemaMap(DataMap data) {
        super(data, SCHEMA, CustomAnnotationContentSchema.class);
    }

    @Override
    public CustomAnnotationContentSchemaMap clone()
        throws CloneNotSupportedException
    {
        return ((CustomAnnotationContentSchemaMap) super.clone());
    }

    @Override
    public CustomAnnotationContentSchemaMap copy()
        throws CloneNotSupportedException
    {
        return ((CustomAnnotationContentSchemaMap) super.copy());
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

        public com.linkedin.restli.restspec.CustomAnnotationContentSchema.Fields values() {
            return new com.linkedin.restli.restspec.CustomAnnotationContentSchema.Fields(getPathComponents(), PathSpec.WILDCARD);
        }

    }

}

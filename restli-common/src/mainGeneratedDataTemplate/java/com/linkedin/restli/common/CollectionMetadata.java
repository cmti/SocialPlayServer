
package com.linkedin.restli.common;

import java.util.List;
import javax.annotation.Generated;
import com.linkedin.data.DataMap;
import com.linkedin.data.schema.PathSpec;
import com.linkedin.data.schema.RecordDataSchema;
import com.linkedin.data.template.DataTemplateUtil;
import com.linkedin.data.template.GetMode;
import com.linkedin.data.template.RecordTemplate;
import com.linkedin.data.template.SetMode;


/**
 * Metadata and pagination links for this collection
 * 
 */
@Generated(value = "com.linkedin.pegasus.generator.PegasusDataTemplateGenerator", comments = "LinkedIn Data Template. Generated from /Users/jianli/git/SocialPlayServer/restli-common/src/main/pegasus/com/linkedin/restli/common/CollectionMetadata.pdsc.", date = "Fri Apr 17 15:52:47 PDT 2015")
public class CollectionMetadata
    extends RecordTemplate
{

    private final static CollectionMetadata.Fields _fields = new CollectionMetadata.Fields();
    private final static RecordDataSchema SCHEMA = ((RecordDataSchema) DataTemplateUtil.parseSchema("{\"type\":\"record\",\"name\":\"CollectionMetadata\",\"namespace\":\"com.linkedin.restli.common\",\"doc\":\"Metadata and pagination links for this collection\",\"fields\":[{\"name\":\"start\",\"type\":\"int\",\"doc\":\"The start index of this collection\"},{\"name\":\"count\",\"type\":\"int\",\"doc\":\"The number of elements in this collection segment\"},{\"name\":\"total\",\"type\":\"int\",\"doc\":\"The total number of elements in the entire collection (not just this segment)\",\"default\":0},{\"name\":\"links\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"Link\",\"doc\":\"A atom:link-inspired link\",\"fields\":[{\"name\":\"rel\",\"type\":\"string\",\"doc\":\"The link relation e.g. 'self' or 'next'\"},{\"name\":\"href\",\"type\":\"string\",\"doc\":\"The link URI\"},{\"name\":\"type\",\"type\":\"string\",\"doc\":\"The type (media type) of the resource\"},{\"name\":\"title\",\"type\":\"string\",\"doc\":\"The title of the link\"}]}}}]}"));
    private final static RecordDataSchema.Field FIELD_Start = SCHEMA.getField("start");
    private final static RecordDataSchema.Field FIELD_Count = SCHEMA.getField("count");
    private final static RecordDataSchema.Field FIELD_Total = SCHEMA.getField("total");
    private final static RecordDataSchema.Field FIELD_Links = SCHEMA.getField("links");

    public CollectionMetadata() {
        super(new DataMap(), SCHEMA);
    }

    public CollectionMetadata(DataMap data) {
        super(data, SCHEMA);
    }

    public static CollectionMetadata.Fields fields() {
        return _fields;
    }

    /**
     * Existence checker for start
     * 
     * @see Fields#start
     */
    public boolean hasStart() {
        return contains(FIELD_Start);
    }

    /**
     * Remover for start
     * 
     * @see Fields#start
     */
    public void removeStart() {
        remove(FIELD_Start);
    }

    /**
     * Getter for start
     * 
     * @see Fields#start
     */
    public Integer getStart(GetMode mode) {
        return obtainDirect(FIELD_Start, Integer.class, mode);
    }

    /**
     * Getter for start
     * 
     * @see Fields#start
     */
    public Integer getStart() {
        return getStart(GetMode.STRICT);
    }

    /**
     * Setter for start
     * 
     * @see Fields#start
     */
    public CollectionMetadata setStart(Integer value, SetMode mode) {
        putDirect(FIELD_Start, Integer.class, Integer.class, value, mode);
        return this;
    }

    /**
     * Setter for start
     * 
     * @see Fields#start
     */
    public CollectionMetadata setStart(Integer value) {
        putDirect(FIELD_Start, Integer.class, Integer.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    /**
     * Setter for start
     * 
     * @see Fields#start
     */
    public CollectionMetadata setStart(int value) {
        putDirect(FIELD_Start, Integer.class, Integer.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    /**
     * Existence checker for count
     * 
     * @see Fields#count
     */
    public boolean hasCount() {
        return contains(FIELD_Count);
    }

    /**
     * Remover for count
     * 
     * @see Fields#count
     */
    public void removeCount() {
        remove(FIELD_Count);
    }

    /**
     * Getter for count
     * 
     * @see Fields#count
     */
    public Integer getCount(GetMode mode) {
        return obtainDirect(FIELD_Count, Integer.class, mode);
    }

    /**
     * Getter for count
     * 
     * @see Fields#count
     */
    public Integer getCount() {
        return getCount(GetMode.STRICT);
    }

    /**
     * Setter for count
     * 
     * @see Fields#count
     */
    public CollectionMetadata setCount(Integer value, SetMode mode) {
        putDirect(FIELD_Count, Integer.class, Integer.class, value, mode);
        return this;
    }

    /**
     * Setter for count
     * 
     * @see Fields#count
     */
    public CollectionMetadata setCount(Integer value) {
        putDirect(FIELD_Count, Integer.class, Integer.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    /**
     * Setter for count
     * 
     * @see Fields#count
     */
    public CollectionMetadata setCount(int value) {
        putDirect(FIELD_Count, Integer.class, Integer.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    /**
     * Existence checker for total
     * 
     * @see Fields#total
     */
    public boolean hasTotal() {
        return contains(FIELD_Total);
    }

    /**
     * Remover for total
     * 
     * @see Fields#total
     */
    public void removeTotal() {
        remove(FIELD_Total);
    }

    /**
     * Getter for total
     * 
     * @see Fields#total
     */
    public Integer getTotal(GetMode mode) {
        return obtainDirect(FIELD_Total, Integer.class, mode);
    }

    /**
     * Getter for total
     * 
     * @see Fields#total
     */
    public Integer getTotal() {
        return getTotal(GetMode.STRICT);
    }

    /**
     * Setter for total
     * 
     * @see Fields#total
     */
    public CollectionMetadata setTotal(Integer value, SetMode mode) {
        putDirect(FIELD_Total, Integer.class, Integer.class, value, mode);
        return this;
    }

    /**
     * Setter for total
     * 
     * @see Fields#total
     */
    public CollectionMetadata setTotal(Integer value) {
        putDirect(FIELD_Total, Integer.class, Integer.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    /**
     * Setter for total
     * 
     * @see Fields#total
     */
    public CollectionMetadata setTotal(int value) {
        putDirect(FIELD_Total, Integer.class, Integer.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    /**
     * Existence checker for links
     * 
     * @see Fields#links
     */
    public boolean hasLinks() {
        return contains(FIELD_Links);
    }

    /**
     * Remover for links
     * 
     * @see Fields#links
     */
    public void removeLinks() {
        remove(FIELD_Links);
    }

    /**
     * Getter for links
     * 
     * @see Fields#links
     */
    public LinkArray getLinks(GetMode mode) {
        return obtainWrapped(FIELD_Links, LinkArray.class, mode);
    }

    /**
     * Getter for links
     * 
     * @see Fields#links
     */
    public LinkArray getLinks() {
        return getLinks(GetMode.STRICT);
    }

    /**
     * Setter for links
     * 
     * @see Fields#links
     */
    public CollectionMetadata setLinks(LinkArray value, SetMode mode) {
        putWrapped(FIELD_Links, LinkArray.class, value, mode);
        return this;
    }

    /**
     * Setter for links
     * 
     * @see Fields#links
     */
    public CollectionMetadata setLinks(LinkArray value) {
        putWrapped(FIELD_Links, LinkArray.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    @Override
    public CollectionMetadata clone()
        throws CloneNotSupportedException
    {
        return ((CollectionMetadata) super.clone());
    }

    @Override
    public CollectionMetadata copy()
        throws CloneNotSupportedException
    {
        return ((CollectionMetadata) super.copy());
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

        /**
         * The start index of this collection
         * 
         */
        public PathSpec start() {
            return new PathSpec(getPathComponents(), "start");
        }

        /**
         * The number of elements in this collection segment
         * 
         */
        public PathSpec count() {
            return new PathSpec(getPathComponents(), "count");
        }

        /**
         * The total number of elements in the entire collection (not just this segment)
         * 
         */
        public PathSpec total() {
            return new PathSpec(getPathComponents(), "total");
        }

        public com.linkedin.restli.common.LinkArray.Fields links() {
            return new com.linkedin.restli.common.LinkArray.Fields(getPathComponents(), "links");
        }

    }

}

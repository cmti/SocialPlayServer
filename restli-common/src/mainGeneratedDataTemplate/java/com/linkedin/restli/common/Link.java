
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
 * A atom:link-inspired link
 * 
 */
@Generated(value = "com.linkedin.pegasus.generator.PegasusDataTemplateGenerator", comments = "LinkedIn Data Template. Generated from /Users/jianli/git/SocialPlayServer/restli-common/src/main/pegasus/com/linkedin/restli/common/Link.pdsc.", date = "Fri Apr 17 15:52:47 PDT 2015")
public class Link
    extends RecordTemplate
{

    private final static Link.Fields _fields = new Link.Fields();
    private final static RecordDataSchema SCHEMA = ((RecordDataSchema) DataTemplateUtil.parseSchema("{\"type\":\"record\",\"name\":\"Link\",\"namespace\":\"com.linkedin.restli.common\",\"doc\":\"A atom:link-inspired link\",\"fields\":[{\"name\":\"rel\",\"type\":\"string\",\"doc\":\"The link relation e.g. 'self' or 'next'\"},{\"name\":\"href\",\"type\":\"string\",\"doc\":\"The link URI\"},{\"name\":\"type\",\"type\":\"string\",\"doc\":\"The type (media type) of the resource\"},{\"name\":\"title\",\"type\":\"string\",\"doc\":\"The title of the link\"}]}"));
    private final static RecordDataSchema.Field FIELD_Rel = SCHEMA.getField("rel");
    private final static RecordDataSchema.Field FIELD_Href = SCHEMA.getField("href");
    private final static RecordDataSchema.Field FIELD_Type = SCHEMA.getField("type");
    private final static RecordDataSchema.Field FIELD_Title = SCHEMA.getField("title");

    public Link() {
        super(new DataMap(), SCHEMA);
    }

    public Link(DataMap data) {
        super(data, SCHEMA);
    }

    public static Link.Fields fields() {
        return _fields;
    }

    /**
     * Existence checker for rel
     * 
     * @see Fields#rel
     */
    public boolean hasRel() {
        return contains(FIELD_Rel);
    }

    /**
     * Remover for rel
     * 
     * @see Fields#rel
     */
    public void removeRel() {
        remove(FIELD_Rel);
    }

    /**
     * Getter for rel
     * 
     * @see Fields#rel
     */
    public String getRel(GetMode mode) {
        return obtainDirect(FIELD_Rel, String.class, mode);
    }

    /**
     * Getter for rel
     * 
     * @see Fields#rel
     */
    public String getRel() {
        return getRel(GetMode.STRICT);
    }

    /**
     * Setter for rel
     * 
     * @see Fields#rel
     */
    public Link setRel(String value, SetMode mode) {
        putDirect(FIELD_Rel, String.class, String.class, value, mode);
        return this;
    }

    /**
     * Setter for rel
     * 
     * @see Fields#rel
     */
    public Link setRel(String value) {
        putDirect(FIELD_Rel, String.class, String.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    /**
     * Existence checker for href
     * 
     * @see Fields#href
     */
    public boolean hasHref() {
        return contains(FIELD_Href);
    }

    /**
     * Remover for href
     * 
     * @see Fields#href
     */
    public void removeHref() {
        remove(FIELD_Href);
    }

    /**
     * Getter for href
     * 
     * @see Fields#href
     */
    public String getHref(GetMode mode) {
        return obtainDirect(FIELD_Href, String.class, mode);
    }

    /**
     * Getter for href
     * 
     * @see Fields#href
     */
    public String getHref() {
        return getHref(GetMode.STRICT);
    }

    /**
     * Setter for href
     * 
     * @see Fields#href
     */
    public Link setHref(String value, SetMode mode) {
        putDirect(FIELD_Href, String.class, String.class, value, mode);
        return this;
    }

    /**
     * Setter for href
     * 
     * @see Fields#href
     */
    public Link setHref(String value) {
        putDirect(FIELD_Href, String.class, String.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    /**
     * Existence checker for type
     * 
     * @see Fields#type
     */
    public boolean hasType() {
        return contains(FIELD_Type);
    }

    /**
     * Remover for type
     * 
     * @see Fields#type
     */
    public void removeType() {
        remove(FIELD_Type);
    }

    /**
     * Getter for type
     * 
     * @see Fields#type
     */
    public String getType(GetMode mode) {
        return obtainDirect(FIELD_Type, String.class, mode);
    }

    /**
     * Getter for type
     * 
     * @see Fields#type
     */
    public String getType() {
        return getType(GetMode.STRICT);
    }

    /**
     * Setter for type
     * 
     * @see Fields#type
     */
    public Link setType(String value, SetMode mode) {
        putDirect(FIELD_Type, String.class, String.class, value, mode);
        return this;
    }

    /**
     * Setter for type
     * 
     * @see Fields#type
     */
    public Link setType(String value) {
        putDirect(FIELD_Type, String.class, String.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    /**
     * Existence checker for title
     * 
     * @see Fields#title
     */
    public boolean hasTitle() {
        return contains(FIELD_Title);
    }

    /**
     * Remover for title
     * 
     * @see Fields#title
     */
    public void removeTitle() {
        remove(FIELD_Title);
    }

    /**
     * Getter for title
     * 
     * @see Fields#title
     */
    public String getTitle(GetMode mode) {
        return obtainDirect(FIELD_Title, String.class, mode);
    }

    /**
     * Getter for title
     * 
     * @see Fields#title
     */
    public String getTitle() {
        return getTitle(GetMode.STRICT);
    }

    /**
     * Setter for title
     * 
     * @see Fields#title
     */
    public Link setTitle(String value, SetMode mode) {
        putDirect(FIELD_Title, String.class, String.class, value, mode);
        return this;
    }

    /**
     * Setter for title
     * 
     * @see Fields#title
     */
    public Link setTitle(String value) {
        putDirect(FIELD_Title, String.class, String.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    @Override
    public Link clone()
        throws CloneNotSupportedException
    {
        return ((Link) super.clone());
    }

    @Override
    public Link copy()
        throws CloneNotSupportedException
    {
        return ((Link) super.copy());
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
         * The link relation e.g. 'self' or 'next'
         * 
         */
        public PathSpec rel() {
            return new PathSpec(getPathComponents(), "rel");
        }

        /**
         * The link URI
         * 
         */
        public PathSpec href() {
            return new PathSpec(getPathComponents(), "href");
        }

        /**
         * The type (media type) of the resource
         * 
         */
        public PathSpec type() {
            return new PathSpec(getPathComponents(), "type");
        }

        /**
         * The title of the link
         * 
         */
        public PathSpec title() {
            return new PathSpec(getPathComponents(), "title");
        }

    }

}

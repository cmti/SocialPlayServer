/*
   Copyright (c) 2012 LinkedIn Corp.

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/

package com.linkedin.data.avro;

import com.linkedin.data.schema.JsonBuilder;

/**
 * Options that affect the translation of {@link com.linkedin.data.schema.DataSchema} to Avro schema.
 */
public class DataToAvroSchemaTranslationOptions
{
  public static final OptionalDefaultMode DEFAULT_OPTIONAL_DEFAULT_MODE = OptionalDefaultMode.TRANSLATE_DEFAULT;
  public static final JsonBuilder.Pretty DEFAULT_PRETTY = JsonBuilder.Pretty.COMPACT;
  public static final EmbedSchemaMode DEFAULT_EMBED_SCHEMA_MODE = EmbedSchemaMode.NONE;

  /**
   * Default constructor.
   *
   * Sets optional default mode to {@link #DEFAULT_OPTIONAL_DEFAULT_MODE}.
   * Sets pretty mode to {@link #DEFAULT_PRETTY}.
   * Sets embed schema mode to {@link #DEFAULT_EMBED_SCHEMA_MODE}.
   */
  public DataToAvroSchemaTranslationOptions()
  {
    this(DEFAULT_OPTIONAL_DEFAULT_MODE, DEFAULT_PRETTY, DEFAULT_EMBED_SCHEMA_MODE);
  }

  /**
   * Constructor.
   *
   * Sets optional default mode to the specified value.
   *
   * @param optionalDefaultMode specifies the {@link OptionalDefaultMode}.
   */
  public DataToAvroSchemaTranslationOptions(OptionalDefaultMode optionalDefaultMode)
  {
    this(optionalDefaultMode, DEFAULT_PRETTY, DEFAULT_EMBED_SCHEMA_MODE);
  }

  /**
   * Constructor.
   *
   * Sets pretty mode to the specified value.
   *
   * @param pretty specifies the pretty mode.
   */
  public DataToAvroSchemaTranslationOptions(JsonBuilder.Pretty pretty)
  {
    this(DEFAULT_OPTIONAL_DEFAULT_MODE, pretty, DEFAULT_EMBED_SCHEMA_MODE);
  }

  /**
   * Constructor.
   *
   * Sets embedded schema to the specified value.
   *
   * @param embedSchemaMode specifies to the specified {@link EmbedSchemaMode}.
   */
  public DataToAvroSchemaTranslationOptions(EmbedSchemaMode embedSchemaMode )
  {
    this(DEFAULT_OPTIONAL_DEFAULT_MODE, DEFAULT_PRETTY, embedSchemaMode);
  }

  /**
   * Constructor.
   *
   * @param optionalDefaultMode specifies the optional default mode.
   * @param pretty specifies the pretty mode.
   */
  public DataToAvroSchemaTranslationOptions(OptionalDefaultMode optionalDefaultMode, JsonBuilder.Pretty pretty)
  {
    this(optionalDefaultMode, pretty, DEFAULT_EMBED_SCHEMA_MODE);
  }

  /**
   * Constructor.
   *
   * @param pretty specifies the pretty mode.
   * @param embedSchemaMode specifies the embed schema mode.
   */
  public DataToAvroSchemaTranslationOptions(JsonBuilder.Pretty pretty, EmbedSchemaMode embedSchemaMode)
  {
    this(DEFAULT_OPTIONAL_DEFAULT_MODE, pretty, embedSchemaMode);
  }

  /**
   * Constructor.
   *
   * @param optionalDefaultMode specifies the optional default mode.
   * @param pretty specifies the pretty mode.
   * @param embedSchemaMode specifies the embed schema mode.
   */
  public DataToAvroSchemaTranslationOptions(OptionalDefaultMode optionalDefaultMode, JsonBuilder.Pretty pretty, EmbedSchemaMode embedSchemaMode)
  {
    _optionalDefaultMode = optionalDefaultMode;
    _pretty = pretty;
    _embedSchemaMode = embedSchemaMode;
  }

  /**
   * Set the {@link OptionalDefaultMode}.
   *
   * @param mode provides the new {@link OptionalDefaultMode}.
   * @return {@code this}.
   */
  public DataToAvroSchemaTranslationOptions setOptionalDefaultMode(OptionalDefaultMode mode)
  {
    _optionalDefaultMode = mode;
    return this;
  }

  /**
   * Return how an optional field and associated default value should be translated.
   *
   * @return how an optional field and associated default value should be translated.
   */
  public OptionalDefaultMode getOptionalDefaultMode()
  {
    return _optionalDefaultMode;
  }

  /**
   * Set the pretty mode.
   *
   * @param pretty provides the new pretty mode.
   * @return {@code this}.
   */
  public DataToAvroSchemaTranslationOptions setPretty(JsonBuilder.Pretty pretty)
  {
    _pretty = pretty;
    return this;
  }

  /**
   * Return the pretty mode.
   *
   * @return the pretty mode.
   */
  public JsonBuilder.Pretty getPretty()
  {
    return _pretty;
  }

  /**
   * Set the embed schema mode.
   */
  public DataToAvroSchemaTranslationOptions setEmbedSchemaMode(EmbedSchemaMode embedSchemaMode)
  {
    _embedSchemaMode = embedSchemaMode;
    return this;
  }

  /**
   * Returns the embed schema mode.
   */
  public EmbedSchemaMode getEmbeddedSchema()
  {
    return _embedSchemaMode;
  }

  private OptionalDefaultMode _optionalDefaultMode;
  private JsonBuilder.Pretty  _pretty;
  private EmbedSchemaMode _embedSchemaMode;
}

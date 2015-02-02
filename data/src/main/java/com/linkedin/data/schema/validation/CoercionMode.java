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

package com.linkedin.data.schema.validation;

/**
 * Specifies whether and how primitive types will be coerced from
 * one value type to a value type that conforms to the Java type
 * expected for the schema type.
 */
public enum CoercionMode
{
  /**
   * No type coercion will be performed.
   */
  OFF,

  /**
   * Coerces numeric values to the schema's numeric type and
   * coerces Avro string encoded binary to {@link com.linkedin.data.ByteString}.
   *
   * This coercion mode performs the following type coercions:
   * 
   */
  NORMAL,

  /**
   * Coerces numeric values and strings containing numeric values to the schema's numeric type and
   * coerces Avro string encoded binary to {@link com.linkedin.data.ByteString}.
   *
   * The coercion mode performs the following coercion in addition to coercions performed by {@link CoercionMode#NORMAL}:
   *
   */
  STRING_TO_PRIMITIVE
}

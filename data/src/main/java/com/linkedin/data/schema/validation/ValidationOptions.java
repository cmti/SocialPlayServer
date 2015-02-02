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

import com.linkedin.util.ArgumentUtil;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


/**
 * Options that control how a Data object is validated against a
 * {@link com.linkedin.data.schema.DataSchema}.
 *
 * <p>
 * The <i>required mode</i> indicates how required fields should be handled during validation,
 * see {@link RequiredMode} for a description of the various required modes.
 *
 * <p>
 * The <i>coercion mode</i> indicates whether and how primitive values should be coerced
 * from a value that does not conform to the schema to a value that conforms
 * to the schema's type, see {@link CoercionMode} for a description of the various
 * coercion modes.
 *
 * <p>
 * If fix-up occurs, the fixed-up value is returned by
 * {@link com.linkedin.data.schema.validation.ValidationResult#getFixed()}.
 * Fix-up can occur if the coercion mode is not set to {@link CoercionMode#OFF}
 * or the required mode is set to {@link RequiredMode#FIXUP_ABSENT_WITH_DEFAULT}.
 *
 * Unlike Avro, union to record schema resolution is not implemented.
 *
 * @author slim
 */
public final class ValidationOptions
{
  /**
   * Constructor.
   *
   * Sets coercion mode to {@link CoercionMode#NORMAL} and
   * required mode to {@link RequiredMode#CAN_BE_ABSENT_IF_HAS_DEFAULT}.
   */
  public ValidationOptions()
  {
    _coercionMode = CoercionMode.NORMAL;
    _requiredMode = RequiredMode.CAN_BE_ABSENT_IF_HAS_DEFAULT;
  }

  /**
   * Constructor.
   *
   * Sets coercion mode to {@link CoercionMode#NORMAL}
   *
   * @param requiredMode specifies the required mode.
   */
  public ValidationOptions(RequiredMode requiredMode)
  {
    _coercionMode = CoercionMode.NORMAL;
    _requiredMode = requiredMode;
  }

  /**
   * Constructor.
   *
   * This method is deprecated, use {@link #ValidationOptions(RequiredMode, CoercionMode)} instead.
   *
   * @param requiredMode specifies the required mode.
   * @param fixup if true, sets coercion mode to {@link CoercionMode#NORMAL} else, set coercion mode to
   *              {@link CoercionMode#OFF}
   */
  @Deprecated
  public ValidationOptions(RequiredMode requiredMode, boolean fixup)
  {
    _coercionMode = fixup ? CoercionMode.NORMAL : CoercionMode.OFF;
    _requiredMode = requiredMode;
  }

  /**
   * Constructor.
   *
   * @param requiredMode specifies the required mode.
   * @param coercionMode specifies the coercion mode.
   */
  public ValidationOptions(RequiredMode requiredMode, CoercionMode coercionMode)
  {
    _coercionMode = coercionMode;
    _requiredMode = requiredMode;
  }

  /**
   * Return whether to fix-up is enabled.
   *
   * This method is deprecated, use {@link #getCoercionMode()} instead.
   *
   * @return true if fix-up is possible,
   *         i.e. coercion mod is not set to {@link CoercionMode#OFF} or
   *         required mode is set to {@link RequiredMode#FIXUP_ABSENT_WITH_DEFAULT}.
   */
  @Deprecated
  public boolean isFixup()
  {
    return (_coercionMode != CoercionMode.OFF) || (_requiredMode == RequiredMode.FIXUP_ABSENT_WITH_DEFAULT);
  }

  /**
   * Set whether to fix-up is enabled.
   *
   * This method is deprecated, use {@link #setCoercionMode(CoercionMode)} instead.
   *
   * @param fixup if true, then set coercion mode to {@link CoercionMode#NORMAL} else
   *              set coercion mode to {@link CoercionMode#OFF}.
   */
  @Deprecated
  public void setFixup(boolean fixup)
  {
    _coercionMode =  (fixup ? CoercionMode.NORMAL : CoercionMode.OFF);
  }

  /**
   * Set the coercion mode.
   *
   * @param coercionMode specifies the coercion mode.
   */
  public void setCoercionMode(CoercionMode coercionMode)
  {
    ArgumentUtil.notNull(coercionMode, "coercionMode");
    _coercionMode = coercionMode;
  }

  /**
   * Return the coercion mode.
   *
   * @return the coercion mode.
   */
  public CoercionMode getCoercionMode()
  {
    return _coercionMode;
  }

  /**
   * Return required mode that indicates how required fields should be handled during validation.
   *
   * @return the required mode.
   */
  public RequiredMode getRequiredMode()
  {
    return _requiredMode;
  }

  /**
   * Set the required mode that indicates how required fields should be handled during validation.
   * 
   * @param requiredMode specifies the required mode.
   */
  public void setRequiredMode(RequiredMode requiredMode)
  {
    ArgumentUtil.notNull(requiredMode, "RequiredMode");
    _requiredMode = requiredMode;
  }

  /**
   * Set Avro union mode.
   * 
   * If Avro union mode is enabled, a union uses the name (instead of full name) of the
   * member type as the key to specify the type of the value in the union.
   * 
   * @param value set to true to enable Avro union mode.
   */
  public void setAvroUnionMode(boolean value)
  {
    _avroUnionMode = value;
  }

  /**
   * Set a parameter intended to be passed to a {@link com.linkedin.data.schema.validator.Validator}.
   *
   * @param key to identify option.
   * @param parameter to pass.
   */
  public void setValidatorParameter(String key, Object parameter)
  {
    if (_validatorParameters == NO_VALIDATOR_PARAMETERS)
    {
      _validatorParameters = new HashMap<String, Object>();
    }
    _validatorParameters.put(key, parameter);
  }

  /**
   * Get a parameter intended to be passed to a {@link com.linkedin.data.schema.validator.Validator}.
   *
   * @param key to identify the option.
   * @return the value of the parameter previously associated with the key through
   *         {@link #setValidatorParameter(String, Object)} or null if key does not exists.
   */
  public Object getValidatorParameter(String key)
  {
    return _validatorParameters.get(key);
  }

  /**
   * Return whether Avro union mode is enabled.
   * 
   * If Avro union mode is enabled, a union uses the name (instead of full name) of the
   * member type as the key to specify the type of the value in the union.
   * 
   * @return true if Avro union mode is enabled.
   */
  public boolean isAvroUnionMode()
  {
    return _avroUnionMode;
  }

  @Override
  public boolean equals(Object other)
  {
    if (other == null || other.getClass() != getClass())
    {
      return false;
    }
    ValidationOptions otherOptions = (ValidationOptions) other;
    return (otherOptions._coercionMode == _coercionMode
        && otherOptions._requiredMode == _requiredMode
        && otherOptions._avroUnionMode == _avroUnionMode
        && otherOptions._validatorParameters.equals(_validatorParameters));
  }

  @Override
  public int hashCode()
  {
    int code = 17;
    code = code * 31 + (_requiredMode == null ? 0 : _requiredMode.hashCode());
    code = code * 31 + (_coercionMode == null ? 0 : _coercionMode.hashCode());
    code = code * 31 + (_avroUnionMode ? 0 : 53);
    code = code * 31 + (_validatorParameters.hashCode());
    return code;
  }

  @Override
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("RequiredMode=")
      .append(_requiredMode)
      .append(", FixupMode=")
      .append(_coercionMode)
      .append(", AvroUnionMode=")
      .append(_avroUnionMode);
    if (_validatorParameters != NO_VALIDATOR_PARAMETERS)
    {
      sb.append(", ValidatorOptions=")
        .append(_validatorParameters);
    }
    return sb.toString();
  }

  private CoercionMode _coercionMode;
  private RequiredMode _requiredMode;
  private boolean      _avroUnionMode = false;
  private Map<String,Object> _validatorParameters = NO_VALIDATOR_PARAMETERS;

  private static final Map<String,Object> NO_VALIDATOR_PARAMETERS = Collections.emptyMap();
}

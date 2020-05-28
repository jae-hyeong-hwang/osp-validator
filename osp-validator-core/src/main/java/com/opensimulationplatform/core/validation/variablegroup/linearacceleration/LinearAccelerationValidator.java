package com.opensimulationplatform.core.validation.variablegroup.linearacceleration;

import com.opensimulationplatform.core.model.modeldescription.variablegroup.linearacceleration.LinearAcceleration;
import com.opensimulationplatform.core.validation.ValidationError;
import com.opensimulationplatform.core.validation.Validator;

import java.util.Arrays;
import java.util.List;

public class LinearAccelerationValidator extends Validator<LinearAcceleration> {
  private final VE_LinearAcceleration_1 ve_linearAcceleration_1 = new VE_LinearAcceleration_1();
  private final VE_LinearAcceleration_2 ve_linearAcceleration_2 = new VE_LinearAcceleration_2();
  private final VE_LinearAcceleration_3 ve_linearAcceleration_3 = new VE_LinearAcceleration_3();

  @Override
  protected List<Validator<?>> getValidators() {
    return null;
  }

  @Override
  protected List<ValidationError<?>> getValidationErrors() {
    return Arrays.asList(ve_linearAcceleration_1, ve_linearAcceleration_2, ve_linearAcceleration_3);
  }
}

package com.opensimulationplatform.core.validation.variablegroup.pressure;

import com.opensimulationplatform.core.model.modeldescription.variablegroup.pressure.Pressure;
import com.opensimulationplatform.core.validation.ValidationError;
import com.opensimulationplatform.core.validation.Validator;

import java.util.Arrays;
import java.util.List;

public class PressureValidator extends Validator<Pressure> {
  private final VE_Pressure_1 ve_pressure_1 = new VE_Pressure_1();
  private final VE_Pressure_2 ve_pressure_2 = new VE_Pressure_2();
  private final VE_Pressure_3 ve_pressure_3 = new VE_Pressure_3();

  @Override
  protected List<Validator<?>> getValidators() {
    return null;
  }

  @Override
  protected List<ValidationError<?>> getValidationErrors() {
    return Arrays.asList(ve_pressure_1, ve_pressure_2, ve_pressure_3);
  }
}

package com.opensimulationplatform.core.validation.name;

import com.opensimulationplatform.core.model.modeldescription.Name;
import com.opensimulationplatform.core.validation.ValidationError;
import com.opensimulationplatform.core.validation.Validator;

import java.util.Arrays;
import java.util.List;

public class NamesValidator extends Validator<Name> {
  private final VE_Name_1 ve_name_1 = new VE_Name_1();
  private final VE_Name_2 ve_name_2 = new VE_Name_2();
  private final VE_Name_3 ve_name_3 = new VE_Name_3();

  @Override
  protected List<Validator<?>> getValidators() {
    return null;
  }

  @Override
  protected List<ValidationError<?>> getValidationErrors() {
    return Arrays.asList(ve_name_1, ve_name_2, ve_name_3);
  }
}

package com.opensimulationplatform.core.model.modeldescription.variablegroup.angularacceleration;

import com.opensimulationplatform.core.model.modeldescription.variablegroup.VariableGroup;
import com.opensimulationplatform.core.model.modeldescription.variablegroup.ndimensionsalvariablegroup.NDimensionalVariableGroup;

import java.util.Collections;
import java.util.List;

public class AngularAcceleration extends NDimensionalVariableGroup {
  @Override
  protected int numberOfDimensions() {
    return 3;
  }

  @Override
  public List<VariableGroup> getVariableGroups() {
    return Collections.emptyList();
  }
}
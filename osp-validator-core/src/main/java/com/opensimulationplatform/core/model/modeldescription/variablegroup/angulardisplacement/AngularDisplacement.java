package com.opensimulationplatform.core.model.modeldescription.variablegroup.angulardisplacement;

import com.opensimulationplatform.core.model.modeldescription.variablegroup.VariableGroup;
import com.opensimulationplatform.core.model.modeldescription.variablegroup.ndimensionsalvariablegroup.NDimensionalVariableGroup;

import java.util.Collections;
import java.util.List;

public class AngularDisplacement extends NDimensionalVariableGroup {
  @Override
  protected int numberOfDimensions() {
    return 3;
  }

  @Override
  public List<VariableGroup> getVariableGroups() {
    return Collections.emptyList();
  }
}

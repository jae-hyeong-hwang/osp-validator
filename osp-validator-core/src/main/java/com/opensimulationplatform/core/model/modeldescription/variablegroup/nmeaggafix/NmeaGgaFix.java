package com.opensimulationplatform.core.model.modeldescription.variablegroup.nmeaggafix;

import com.opensimulationplatform.core.model.modeldescription.variablegroup.VariableGroup;
import com.opensimulationplatform.core.model.modeldescription.variablegroup.fixedsizevariablegroup.FixedSizeVariableGroup;

import java.util.Collections;
import java.util.List;

public class NmeaGgaFix extends FixedSizeVariableGroup {

  @Override
  protected int size() {
    return 7;
  }

  @Override
  public List<VariableGroup> getVariableGroups() {
    return Collections.emptyList();
  }
}
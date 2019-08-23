package com.opensimulationplatform.core.validator.model.ospmodeldescription;

import java.util.ArrayList;
import java.util.List;

public class VariableFactory {
  public static List<Variable> create(List<String> variableList) {
    List<Variable> variables = new ArrayList<>();
    for (String variableName : variableList) {
      Variable v = new Variable(variableName);
      variables.add(v);
    }
    return variables;
  }
}

package com.opensimulationplatform.core.validation.variable;

import com.opensimulationplatform.core.model.modeldescription.ModelDescription;
import com.opensimulationplatform.core.model.modeldescription.Variable;
import com.opensimulationplatform.core.validation.ValidationContext;
import com.opensimulationplatform.core.validation.ValidationDiagnostic;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class VariablesValidatorTest {
  @Test
  public void invalid() {
    ModelDescription modelDescription = new ModelDescription();
    Variable v1 = new Variable();
    v1.setName("v1");
    v1.setCausality(Variable.Causality.UNDEFINED);
    v1.setType(Variable.Type.UNDEFINED);
    modelDescription.getVariables().add(v1);

    VariablesValidator variablesValidator = new VariablesValidator();
    variablesValidator.setContext(new ValidationContext(modelDescription));
    List<ValidationDiagnostic<Variable>> diagnostics = variablesValidator.validate();

    assertEquals(1, diagnostics.size());
    Variable invalidVariable = diagnostics.get(0).getValidatedObject();
    assertEquals(v1, invalidVariable);
  }

  @Test
  public void valid() {
    ModelDescription modelDescription = new ModelDescription();
    Variable v1 = new Variable();
    v1.setName("v1");
    v1.setCausality(Variable.Causality.INPUT);
    v1.setType(Variable.Type.REAL);
    modelDescription.getVariables().add(v1);

    VariablesValidator variablesValidator = new VariablesValidator();
    variablesValidator.setContext(new ValidationContext(modelDescription));
    List<ValidationDiagnostic<Variable>> diagnostics = variablesValidator.validate();

    assertEquals(0, diagnostics.size());
  }
}
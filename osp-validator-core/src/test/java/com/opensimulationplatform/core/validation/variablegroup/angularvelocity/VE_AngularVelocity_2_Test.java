package com.opensimulationplatform.core.validation.variablegroup.angularvelocity;

import com.opensimulationplatform.core.model.modeldescription.ModelDescription;
import com.opensimulationplatform.core.model.modeldescription.Unit;
import com.opensimulationplatform.core.model.modeldescription.Variable;
import com.opensimulationplatform.core.model.modeldescription.variablegroup.angularvelocity.AngularVelocity;
import com.opensimulationplatform.core.validation.ValidationContext;
import com.opensimulationplatform.core.validation.ValidationDiagnostic;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class VE_AngularVelocity_2_Test {
  @Test
  public void valid() {
    ModelDescription modelDescription = new ModelDescription();

    AngularVelocity angularVelocity = new AngularVelocity();
    Variable v1 = new Variable();
    v1.setCausality(Variable.Causality.INPUT);
    v1.setType(Variable.Type.REAL);
    v1.setUnit(new Unit());

    Variable v2 = new Variable();
    v2.setCausality(v1.getCausality());
    v2.setType(v1.getType());
    v2.setUnit(v1.getUnit());

    angularVelocity.setVariables(Arrays.asList(v1, v2));

    modelDescription.getAngularVelocities().add(angularVelocity);

    VE_AngularVelocity_2 v = new VE_AngularVelocity_2();
    v.setContext(new ValidationContext(modelDescription));
    List<ValidationDiagnostic<AngularVelocity>> diagnostics = v.validate();

    assertTrue(diagnostics.isEmpty());
  }

  @Test
  public void invalid() {
    ModelDescription modelDescription = new ModelDescription();

    AngularVelocity angularVelocity = new AngularVelocity();
    Variable v1 = new Variable();
    v1.setCausality(Variable.Causality.INPUT);
    v1.setType(Variable.Type.REAL);
    v1.setUnit(new Unit());

    Variable v2 = new Variable();
    v2.setCausality(v1.getCausality());
    v2.setType(Variable.Type.INTEGER);
    v2.setUnit(v1.getUnit());

    angularVelocity.setVariables(Arrays.asList(v1, v2));

    modelDescription.getAngularVelocities().add(angularVelocity);

    VE_AngularVelocity_2 v = new VE_AngularVelocity_2();
    v.setContext(new ValidationContext(modelDescription));
    List<ValidationDiagnostic<AngularVelocity>> diagnostics = v.validate();

    assertEquals(1, diagnostics.size());
    AngularVelocity invalidObject = diagnostics.get(0).getValidatedObject();
    List<Variable> variables = invalidObject.getVariables();
    assertTrue(variables.contains(v1));
    assertTrue(variables.contains(v2));
  }
}

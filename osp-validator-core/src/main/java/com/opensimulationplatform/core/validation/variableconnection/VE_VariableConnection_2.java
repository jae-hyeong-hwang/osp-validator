package com.opensimulationplatform.core.validation.variableconnection;

import com.opensimulationplatform.core.model.modeldescription.Variable;
import com.opensimulationplatform.core.model.systemstructure.VariableConnection;
import com.opensimulationplatform.core.validation.ValidationError;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLNamedIndividual;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import static com.opensimulationplatform.gen.owl.model.OntologyClasses.VE_VariableConnection_2;

public class VE_VariableConnection_2 extends ValidationError<VariableConnection> {
  @Override
  protected List<VariableConnection> getInvalidObjects() {
    OWLClass validationErrorClass = context.owl.dataFactory.getOWLClass(VE_VariableConnection_2, context.owl.prefixManager);
    Set<OWLNamedIndividual> invalidIndividuals = context.invalidIndividuals.get(validationErrorClass);
    return invalidIndividuals.stream().map(context.variableConnections::get).filter(Objects::nonNull).collect(Collectors.toList());
  }

  @Override
  protected String getErrorMessage(VariableConnection variableConnection) {
    String variableA = variableConnection.getVariableA().getName().get();
    Variable.Causality causalityA = variableConnection.getVariableA().getCausality();
    String variableB = variableConnection.getVariableB().getName().get();
    Variable.Causality causalityB = variableConnection.getVariableA().getCausality();
    return "Variable connection [" + variableA + ", " + variableB + "] is invalid because they have the same " +
        "causality [" + causalityA + ", " + causalityB + "]";
  }
}

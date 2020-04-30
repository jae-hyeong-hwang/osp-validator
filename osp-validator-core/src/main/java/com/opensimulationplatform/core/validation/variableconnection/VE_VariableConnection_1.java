package com.opensimulationplatform.core.validation.variableconnection;

import com.opensimulationplatform.core.model.modeldescription.Variable;
import com.opensimulationplatform.core.model.systemstructure.VariableConnection;
import com.opensimulationplatform.core.validation.ValidationError;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLNamedIndividual;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.opensimulationplatform.gen.owl.model.OntologyClasses.VE_VariableConnection_1;

public class VE_VariableConnection_1 extends ValidationError<VariableConnection> {
  @Override
  protected List<VariableConnection> getInvalidObjects() {
    OWLClass validationErrorClass = context.owl.dataFactory.getOWLClass(VE_VariableConnection_1, context.owl.prefixManager);
    Stream<OWLNamedIndividual> invalidIndividuals = context.owl.reasoner.getInstances(validationErrorClass, false).getFlattened().stream();
    return invalidIndividuals.map(context.variableConnections::get).collect(Collectors.toList());
  }

  @Override
  protected String getErrorMessage(VariableConnection variableConnection) {
    String variableA = variableConnection.getVariableA().getName().get();
    Variable.Type typeA = variableConnection.getVariableA().getType();
    String variableB = variableConnection.getVariableB().getName().get();
    Variable.Type typeB = variableConnection.getVariableA().getType();
    return "Variable connection [" + variableA + ", " + variableB + "] is invalid because they have different types " +
        "[" + typeA + ", " + typeB + "]";
  }
}

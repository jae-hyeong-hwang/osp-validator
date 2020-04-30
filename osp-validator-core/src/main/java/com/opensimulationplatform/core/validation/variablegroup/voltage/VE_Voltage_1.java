package com.opensimulationplatform.core.validation.variablegroup.voltage;

import com.opensimulationplatform.core.model.modeldescription.variablegroup.voltage.Voltage;
import com.opensimulationplatform.core.validation.ValidationError;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLNamedIndividual;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.opensimulationplatform.gen.owl.model.OntologyClasses.VE_Voltage_1;

public class VE_Voltage_1 extends ValidationError<Voltage> {
  @Override
  protected List<Voltage> getInvalidObjects() {
    OWLClass validationErrorClass = context.owl.dataFactory.getOWLClass(VE_Voltage_1, context.owl.prefixManager);
    Stream<OWLNamedIndividual> invalidIndividuals = context.owl.reasoner.getInstances(validationErrorClass, false).getFlattened().stream();
    return invalidIndividuals.map(individual -> (Voltage) context.variableGroups.get(individual)).collect(Collectors.toList());
  }

  @Override
  protected String getErrorMessage(Voltage voltage) {
    return "Voltage variable group '" + voltage.getName().get() + "' contains variables with mixed causalities";
  }
}

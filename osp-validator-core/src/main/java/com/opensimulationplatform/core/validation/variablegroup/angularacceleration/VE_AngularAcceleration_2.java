package com.opensimulationplatform.core.validation.variablegroup.angularacceleration;

import com.opensimulationplatform.core.model.modeldescription.variablegroup.angularacceleration.AngularAcceleration;
import com.opensimulationplatform.core.validation.ValidationError;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLNamedIndividual;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.opensimulationplatform.gen.owl.model.OntologyClasses.VE_AngularAcceleration_2;

public class VE_AngularAcceleration_2 extends ValidationError<AngularAcceleration> {
  @Override
  protected List<AngularAcceleration> getInvalidObjects() {
    OWLClass validationErrorClass = context.owl.dataFactory.getOWLClass(VE_AngularAcceleration_2, context.owl.prefixManager);
    Set<OWLNamedIndividual> invalidIndividuals = context.invalidIndividuals.get(validationErrorClass);
    return invalidIndividuals.stream().map(individual -> (AngularAcceleration) context.variableGroups.get(individual)).collect(Collectors.toList());
  }

  @Override
  protected String getErrorMessage(AngularAcceleration angularAcceleration) {
    return "AngularAcceleration variable group '" + angularAcceleration.getName().getId().get() + "' contains variables with mixed data types";
  }
}

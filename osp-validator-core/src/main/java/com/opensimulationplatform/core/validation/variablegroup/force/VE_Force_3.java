package com.opensimulationplatform.core.validation.variablegroup.force;

import com.opensimulationplatform.core.model.modeldescription.variablegroup.force.Force;
import com.opensimulationplatform.core.owlconfig.OWLConfig;
import com.opensimulationplatform.core.validation.ValidationError;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLNamedIndividual;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.opensimulationplatform.gen.owl.model.OntologyClasses.VE_Force_3;

public class VE_Force_3 extends ValidationError<Force> {
  @Override
  protected List<Force> getInvalidObjects() {
    OWLConfig config = this.context.getOwlConfig();
    OWLClass validationErrorClass = config.dataFactory.getOWLClass(VE_Force_3, config.prefixManager);
    Stream<OWLNamedIndividual> invalidIndividuals = config.reasoner.getInstances(validationErrorClass, false).getFlattened().stream();
    return invalidIndividuals.map(individual -> (Force) config.getVariableGroup(individual)).collect(Collectors.toList());
  }

  @Override
  protected String getErrorMessage(Force force) {
    return "Force variable group '" + force.getName().get() + "' contains variables with incompatible units";
  }
}

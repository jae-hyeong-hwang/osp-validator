package com.opensimulationplatform.core.validation;

import com.opensimulationplatform.core.model.modeldescription.Name;
import com.opensimulationplatform.core.model.modeldescription.Unit;
import com.opensimulationplatform.core.model.modeldescription.Variable;
import com.opensimulationplatform.core.model.modeldescription.variablegroup.VariableGroup;
import com.opensimulationplatform.core.model.systemstructure.Simulator;
import com.opensimulationplatform.core.model.systemstructure.VariableConnection;
import com.opensimulationplatform.core.model.systemstructure.VariableGroupConnection;
import com.opensimulationplatform.core.owlconfig.OWLConfig;
import org.semanticweb.owlapi.model.OWLIndividual;

import java.util.HashMap;
import java.util.Map;

public class ValidationErrorContext {
  public OWLConfig owl;
  public Map<OWLIndividual, Name> names = new HashMap<>();
  public Map<OWLIndividual, Unit> units = new HashMap<>();
  public Map<OWLIndividual, Variable> variables = new HashMap<>();
  public Map<OWLIndividual, VariableGroup> variableGroups = new HashMap<>();
  public Map<OWLIndividual, Simulator> simulators = new HashMap<>();
  public Map<OWLIndividual, VariableConnection> variableConnections = new HashMap<>();
  public Map<OWLIndividual, VariableGroupConnection> variableGroupConnections = new HashMap<>();
}

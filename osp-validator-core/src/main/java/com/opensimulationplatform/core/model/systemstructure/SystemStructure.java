package com.opensimulationplatform.core.model.systemstructure;

import com.opensimulationplatform.core.model.ID;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SystemStructure {
  private final String id = UUID.randomUUID().toString();
  private final List<Simulator> simulators = new ArrayList<>();
  private final List<Function> functions = new ArrayList<>();
  private final List<VariableConnection> variableConnections = new ArrayList<>();
  private final List<VariableGroupConnection> variableGroupConnections = new ArrayList<>();
  private final List<SignalConnection> signalConnections = new ArrayList<>();
  private final List<SignalGroupConnection> signalGroupConnections = new ArrayList<>();

  public ID getId() {
    return () -> id;
  }

  public List<Simulator> getSimulators() {
    return simulators;
  }

  public List<Function> getFunctions() {
    return functions;
  }

  public List<VariableConnection> getVariableConnections() {
    return variableConnections;
  }

  public List<VariableGroupConnection> getVariableGroupConnections() {
    return variableGroupConnections;
  }

  public List<SignalConnection> getSignalConnections() {
    return signalConnections;
  }

  public List<SignalGroupConnection> getSignalGroupConnections() {
    return signalGroupConnections;
  }
}

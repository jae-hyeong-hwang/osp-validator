package com.opensimulationplatform.validator.model.configuration;

import com.opensimulationplatform.validator.model.ospmodeldescription.Bond;
import com.opensimulationplatform.validator.model.ospmodeldescription.Simulator;

public class BondConnection {
  private final Simulator simulatorA;
  private final Bond bondA;
  private final Simulator simulatorB;
  private final Bond bondB;
  
  public BondConnection(Simulator simulatorA, Bond bondA, Simulator simulatorB, Bond bondB) {
    this.simulatorA = simulatorA;
    this.bondA = bondA;
    this.simulatorB = simulatorB;
    this.bondB = bondB;
  }
  
  public Simulator getSimulatorA() {
    return simulatorA;
  }
  
  public Bond getBondA() {
    return bondA;
  }
  
  public Simulator getSimulatorB() {
    return simulatorB;
  }
  
  public Bond getBondB() {
    return bondB;
  }
}

package com.opensimulationplatform.core.owl.factory;

import com.opensimulationplatform.core.validator.model.modeldescription.*;
import org.junit.Test;

import static com.opensimulationplatform.core.owl.converter.IndividualNameGenerator.getIndividualName;
import static org.junit.Assert.assertEquals;

public class IndividualNameGeneratorTest {
  @Test
  public void canCreateIndividualNameForVariableI() {
    OspVariable v = new OspVariable("variableName");
    OspSimulator sim = new OspSimulator("simulatorName", "source", "modelDefinition");
    sim.addVariable(v);
    
    assertEquals("simulator_simulatorName_variable_variableName", getIndividualName(v));
  }
  
  @Test
  public void canCreateIndividualNameForSocket() {
    OspSocket s = new OspSocket("socketType", "socketName");
    OspSimulator sim = new OspSimulator("simulatorName", "source", "modelDefinition");
    sim.addSocket(s);
    
    assertEquals("simulator_simulatorName_socketType_socket_socketName", getIndividualName(s));
  }
  
  @Test
  public void canCreateIndividualNameForPlug() {
    OspPlug p = new OspPlug("plugType", "plugName");
    OspSimulator sim = new OspSimulator("simulatorName", "source", "modelDefinition");
    sim.addPlug(p);
    
    assertEquals("simulator_simulatorName_plugType_plug_plugName", getIndividualName(p));
  }
  
  @Test
  public void canCreateIndividualNameForBond() {
    OspBond b = new OspBond("bondName");
    OspSimulator sim = new OspSimulator("simulatorName", "source", "modelDefinition");
    sim.addBond(b);
    
    assertEquals("simulator_simulatorName_bond_bondName", getIndividualName(b));
  }
  
  @Test
  public void canCreateIndividualNameForSimulator() {
    OspSimulator sim = new OspSimulator("simulatorName", "source", "modelDefinition");
    
    assertEquals("simulator_simulatorName", getIndividualName(sim));
  }
}
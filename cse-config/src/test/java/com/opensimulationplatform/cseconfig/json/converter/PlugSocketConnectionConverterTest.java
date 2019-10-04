package com.opensimulationplatform.cseconfig.json.converter;

import com.opensimulationplatform.core.model.modeldescription.ModelDescription;
import com.opensimulationplatform.core.model.systemstructure.OspPlugSocketConnection;
import com.opensimulationplatform.core.model.systemstructure.OspSimulator;
import com.opensimulationplatform.cseconfig.json.model.OspSystemStructure;
import com.opensimulationplatform.cseconfig.json.model.PlugSocketConnection;
import com.opensimulationplatform.modeldescription.json.converter.OspModelDescriptionConverter;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PlugSocketConnectionConverterTest {
  @Test
  public void canConvert() {
    TestSetup testSetup = new TestSetup();
    
    PlugSocketConnection plugSocketConnection = testSetup.plugSocketConnectionA;
    OspSystemStructure ospSystemStructure = testSetup.ospSystemStructure;
    ModelDescription modelDescriptionA = OspModelDescriptionConverter.convert(testSetup.ospModelDescription);
    ModelDescription modelDescriptionB = OspModelDescriptionConverter.convert(testSetup.ospModelDescription);
    OspSimulator ospSimulatorA = SimulatorConverter.convert(testSetup.simulatorA, ospSystemStructure, modelDescriptionA);
    OspSimulator ospSimulatorB = SimulatorConverter.convert(testSetup.simulatorB, ospSystemStructure, modelDescriptionB);
    
    List<OspSimulator> simulators = new ArrayList<>();
    simulators.add(ospSimulatorA);
    simulators.add(ospSimulatorB);
  
    OspPlugSocketConnection ospPlugSocketConnection = PlugSocketConnectionConverter.convert(plugSocketConnection, simulators);
  
    assertEquals(plugSocketConnection.getSourceSimulator(), ospPlugSocketConnection.getSourceOspSimulator().getName());
    assertEquals(plugSocketConnection.getPlug(), ospPlugSocketConnection.getOspPlug().getName());
    assertEquals(plugSocketConnection.getTargetSimulator(), ospPlugSocketConnection.getTargetOspSimulator().getName());
    assertEquals(plugSocketConnection.getSocket(), ospPlugSocketConnection.getOspSocket().getName());
  }
}
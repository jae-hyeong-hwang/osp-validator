package com.opensimulationplatform.datamodel.modeldefinition;

import org.junit.Test;

import static org.junit.Assert.*;

public class SocketTest {
  @Test
  public void canCreateSocket() {
    Socket s = new Socket("type", "name");
    
    assertEquals("type", s.getType());
    assertEquals("name", s.getName());
  }
  
  @Test
  public void canSetSimulator() {
    Socket s = new Socket("type", "name");
    Simulator sim = new Simulator("name", "source", "modelDefinition");
  
    s.setSimulator(sim);
    
    assertEquals(sim, s.getSimulator());
    assertTrue(sim.getSockets().containsValue(s));
  }
  
  @Test(expected = Exception.class)
  public void canNotChangeSimulator() {
    Socket s = new Socket("type", "name");
    Simulator sim = new Simulator("name", "source", "modelDefinition");
    Simulator simNew = new Simulator("name", "source", "modelDefinition");
    
    s.setSimulator(sim);
    
    s.setSimulator(simNew);
  }
  
  @Test
  public void canAddVariable() {
    Socket s = new Socket("type", "name");
    Simulator sim = new Simulator("name", "source", "modelDefinition");
    s.setSimulator(sim);
    Variable v = new Variable("name");
    
    s.addVariable(v);
    
    assertTrue(s.getVariables().containsValue(v));
    assertEquals(s, v.getSocket());
  }
  
  @Test
  public void addingVariableAddsSimulatorToVariable() {
    Socket s = new Socket("type", "name");
    Simulator sim = new Simulator("name", "source", "modelDefinition");
    s.setSimulator(sim);
    Variable v = new Variable("name");
    
    s.addVariable(v);
   
    assertEquals(sim, v.getSimulator());
  }
  
  @Test
  public void addingVariableAddsSimulatorToSocket() {
    Socket s = new Socket("type", "name");
    Variable v = new Variable("name");
    Simulator sim = new Simulator("name", "source", "modelDefinition");
    v.setSimulator(sim);
    
    s.addVariable(v);
   
    assertEquals(sim, s.getSimulator());
  }
  
  @Test(expected = Exception.class)
  public void canNotAddVariableWithDifferentSimulator() {
    Socket s = new Socket("type", "name");
    Simulator sim1 = new Simulator("name", "source", "modelDefinition");
    s.setSimulator(sim1);
    Variable v = new Variable("name");
    Simulator sim2 = new Simulator("name", "source", "modelDefinition");
    v.setSimulator(sim2);
  
    s.addVariable(v);
  }
  
  @Test
  public void canAddBond() {
    Socket s = new Socket("type", "name");
    Bond b = new Bond("name");
    
    s.addBond(b);
    
    assertTrue(s.getBonds().containsValue(b));
    assertTrue(b.getSockets().contains(s));
  }
  
  @Test
  public void addingBondAddsSimulatorToSocket() {
    Socket s = new Socket("type", "name");
    Bond b = new Bond("name");
    Simulator sim = new Simulator("name", "source", "modelDefinition");
    b.setSimulator(sim);
    
    s.addBond(b);
    
    assertEquals(sim, s.getSimulator());
  }
  
  @Test
  public void addingBondAddsSimulatorToBond() {
    Socket s = new Socket("type", "name");
    Bond b = new Bond("name");
    Simulator sim = new Simulator("name", "source", "modelDefinition");
    s.setSimulator(sim);
    
    s.addBond(b);
    
    assertEquals(sim, b.getSimulator());
  }
  
  @Test(expected = Exception.class)
  public void canNotAddBondWithDifferentSimulator() {
    Socket s = new Socket("type", "name");
    Simulator sim1 = new Simulator("name", "source", "modelDefinition");
    s.setSimulator(sim1);
    Bond b = new Bond("name");
    Simulator sim2 = new Simulator("name", "source", "modelDefinition");
    b.setSimulator(sim2);
    
    s.addBond(b);
  }
  
  @Test
  public void oneSocketCanNotBelongToSeveralBonds() {
    fail();
  }
}
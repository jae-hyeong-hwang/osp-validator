package com.opensimulationplatform.datamodel.modeldefinition;

import org.junit.Test;

import static org.junit.Assert.*;

public class BondTest {
  @Test
  public void canCreateBond() {
    Bond b = new Bond("name");
    
    assertEquals("name", b.getName());
  }
  
  @Test
  public void canSetSimulator() {
    Bond b = new Bond("name");
    Simulator sim = new Simulator("name", "source", "modelDefinition");
    
    b.setSimulator(sim);
    
    assertEquals(sim, b.getSimulator());
    assertTrue(sim.getBonds().containsValue(b));
  }
  
  @Test(expected = Exception.class)
  public void canNotChangeSimulator() {
    Bond b = new Bond("name");
    Simulator sim = new Simulator("name", "source", "modelDefinition");
    Simulator simNew = new Simulator("name", "source", "modelDefinition");
    
    b.setSimulator(sim);
    
    b.setSimulator(simNew);
  }
  
  @Test
  public void canAddPlug() {
    Bond b = new Bond("name");
    Plug p = new Plug("type", "name");
    
    b.addPlug(p);
    
    assertTrue(b.getPlugs().contains(p));
    assertTrue(p.getBonds().containsValue(b));
  }
  
  @Test
  public void canAddSocket() {
    Bond b = new Bond("name");
    Socket s = new Socket("type", "name");
    
    b.addSocket(s);
    
    assertTrue(b.getSockets().contains(s));
    assertTrue(s.getBonds().containsValue(b));
  }
  
  @Test
  public void onlyKeepsOneCopyOfPlugAndSocket() {
    Bond b = new Bond("name");
    Plug p = new Plug("type", "name");
    Socket s = new Socket("type", "name");
    
    b.addPlug(p);
    b.addPlug(p);
    b.addSocket(s);
    b.addSocket(s);
    
    assertEquals(1, b.getPlugs().size());
    assertEquals(1, b.getSockets().size());
  }
  
  @Test
  public void addingPlugAddsSimulatorToPlug() {
    Bond b = new Bond("name");
    Simulator sim = new Simulator("name", "source", "modelDefinition");
    b.setSimulator(sim);
    Plug p = new Plug("type", "name");
  
    b.addPlug(p);
    
    assertEquals(sim, p.getSimulator());
  }
  
  @Test
  public void addingPlugAddsSimulatorToBond() {
    Plug p = new Plug("type", "name");
    Simulator sim = new Simulator("name", "source", "modelDefinition");
    p.setSimulator(sim);
    Bond b = new Bond("name");
    
    b.addPlug(p);
    
    assertEquals(sim, b.getSimulator());
  }
  
  @Test(expected = Exception.class)
  public void canNotAddPlugWithDifferentSimulator() {
    Bond b = new Bond("name");
    Simulator sim1 = new Simulator("name", "source", "modelDefinition");
    b.setSimulator(sim1);
    Plug p = new Plug("type", "name");
    Simulator sim2 = new Simulator("name", "source", "modelDefinition");
    p.setSimulator(sim2);
  
    b.addPlug(p);
  }
  
  
  @Test
  public void addingSocketAddsSimulatorToSocket() {
    Socket s = new Socket("type", "name");
    Simulator sim = new Simulator("name", "source", "modelDefinition");
    Bond b = new Bond("name");
    b.setSimulator(sim);
    
    b.addSocket(s);
    
    assertEquals(sim, s.getSimulator());
  }
  
  @Test
  public void addingSocketAddsSimulatorToBond() {
    Socket s = new Socket("type", "name");
    Simulator sim = new Simulator("name", "source", "modelDefinition");
    s.setSimulator(sim);
    Bond b = new Bond("name");
    
    b.addSocket(s);
    
    assertEquals(sim, b.getSimulator());
  }
  
  @Test(expected = Exception.class)
  public void canNotAddSocketWithDifferentSimulator() {
    Bond b = new Bond("name");
    Simulator sim1 = new Simulator("name", "source", "modelDefinition");
    b.setSimulator(sim1);
    Socket s = new Socket("type", "name");
    Simulator sim2 = new Simulator("name", "source", "modelDefinition");
    s.setSimulator(sim2);
    
    b.addSocket(s);
  }
  
  @Test
  public void twoBondsCanHaveSamePlug() {
    fail();
  }
  
  @Test
  public void twoBondsCanNotHaveSameSocket() {
    fail();
  }
}
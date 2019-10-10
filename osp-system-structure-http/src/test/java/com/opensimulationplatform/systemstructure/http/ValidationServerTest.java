package com.opensimulationplatform.systemstructure.http;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.client.api.Request;
import org.eclipse.jetty.client.util.MultiPartContentProvider;
import org.eclipse.jetty.client.util.StringContentProvider;
import org.eclipse.jetty.http.HttpStatus;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.net.URI;

import static org.junit.Assert.*;

public class ValidationServerTest {
  
  private final URI validConfiguration = TestResources.SYSTEM_STRUCTURE_VALID_XML.toFile().toURI();
  private final URI invalidConfiguration = TestResources.SYSTEM_STRUCTURE_INVALID_XML.toFile().toURI();
  private final URI ontology = TestResources.OSP_OWL.toFile().toURI();
  private final int port = 8001;
  private final Gson gson = new GsonBuilder().create();
  private ValidationServer validationServer;
  
  @Before
  public void setUp() throws Exception {
    validationServer = new ValidationServer(port);
    validationServer.start();
    assertTrue(validationServer.isRunning());
  }
  
  @After
  public void tearDown() throws Exception {
    validationServer.stop();
    assertFalse(validationServer.isRunning());
  }
  
  @Test
  public void canHandleGetRequestWithValidConfiguration() throws Exception {
    HttpClient client = new HttpClient();
    client.start();
    
    ContentResponse httpResponse = client.GET("http://localhost:" + port + "/validate?configuration=" + validConfiguration + "&ontology=" + ontology);
    ValidationServletResponse response = gson.fromJson(httpResponse.getContentAsString(), ValidationServletResponse.class);
    
    assertEquals(HttpStatus.OK_200, httpResponse.getStatus());
    assertEquals("application/json", httpResponse.getMediaType());
    assertEquals("true", response.getValid());
    assertTrue(response.getMessage().isEmpty());
  }
  
  @Test
  public void canHandleGetRequestWithInvalidConfiguration() throws Exception {
    HttpClient client = new HttpClient();
    client.start();
    
    ContentResponse httpResponse = client.GET("http://localhost:" + port + "/validate?configuration=" + invalidConfiguration + "&ontology=" + ontology);
    ValidationServletResponse response = gson.fromJson(httpResponse.getContentAsString(), ValidationServletResponse.class);
    
    assertEquals(HttpStatus.BAD_REQUEST_400, httpResponse.getStatus());
    assertEquals("application/json", httpResponse.getMediaType());
    assertEquals("false", response.getValid());
    assertFalse(response.getMessage().isEmpty());
    assertEquals(
        "generic DisjointWith velocity\n" +
        "socket SubClassOf has_plug_mate max 1 plug\n" +
        "simulator_KnuckleBoomCrane_generic_plug_actuatorLimits Type plug\n" +
        "simulator_KnuckleBoomCrane_generic_plug_actuatorLimits Type generic\n" +
        "simulator_KnuckleBoomCrane_velocity_plug_velocity Type plug\n" +
        "simulator_CraneController_velocity_socket_velocity has_plug_mate simulator_KnuckleBoomCrane_velocity_plug_velocity\n" +
        "simulator_CraneController_velocity_socket_velocity has_plug_mate simulator_KnuckleBoomCrane_generic_plug_actuatorLimits\n" +
        "simulator_CraneController_velocity_socket_velocity Type socket\n" +
        "simulator_KnuckleBoomCrane_velocity_plug_velocity Type velocity\n", response.getMessage());
  }
  
  @Test
  public void canHandleMultiPartPostRequestWithValidConfiguration() throws Exception {
    HttpClient client = new HttpClient();
    client.start();
  
    MultiPartContentProvider multiPart = new MultiPartContentProvider();
    multiPart.addFieldPart("configuration", new StringContentProvider(validConfiguration.toString()), null);
    multiPart.addFieldPart("ontology", new StringContentProvider(ontology.toString()), null);
    multiPart.close();
  
    Request request = client.POST("http://localhost:" + port + "/validate");
    ContentResponse httpResponse = request.content(multiPart).send();
    ValidationServletResponse response = gson.fromJson(httpResponse.getContentAsString(), ValidationServletResponse.class);
    
    assertEquals(HttpStatus.OK_200, httpResponse.getStatus());
    assertEquals("application/json", httpResponse.getMediaType());
    assertEquals("true", response.getValid());
    assertTrue(response.getMessage().isEmpty());
  }
  
  @Test
  public void canHandleMultiPartPostRequestWithInvalidConfiguration() throws Exception {
    HttpClient client = new HttpClient();
    client.start();
    
    MultiPartContentProvider multiPart = new MultiPartContentProvider();
    multiPart.addFieldPart("configuration", new StringContentProvider(invalidConfiguration.toString()), null);
    multiPart.addFieldPart("ontology", new StringContentProvider(ontology.toString()), null);
    multiPart.close();
    
    Request request = client.POST("http://localhost:" + port + "/validate");
    ContentResponse httpResponse = request.content(multiPart).send();
    ValidationServletResponse response = gson.fromJson(httpResponse.getContentAsString(), ValidationServletResponse.class);
  
    assertEquals(HttpStatus.BAD_REQUEST_400, httpResponse.getStatus());
    assertEquals("application/json", httpResponse.getMediaType());
    assertEquals("false", response.getValid());
    assertFalse(response.getMessage().isEmpty());
    assertEquals(
        "generic DisjointWith velocity\n" +
        "socket SubClassOf has_plug_mate max 1 plug\n" +
        "simulator_KnuckleBoomCrane_generic_plug_actuatorLimits Type plug\n" +
        "simulator_KnuckleBoomCrane_generic_plug_actuatorLimits Type generic\n" +
        "simulator_KnuckleBoomCrane_velocity_plug_velocity Type plug\n" +
        "simulator_CraneController_velocity_socket_velocity has_plug_mate simulator_KnuckleBoomCrane_velocity_plug_velocity\n" +
        "simulator_CraneController_velocity_socket_velocity has_plug_mate simulator_KnuckleBoomCrane_generic_plug_actuatorLimits\n" +
        "simulator_CraneController_velocity_socket_velocity Type socket\n" +
        "simulator_KnuckleBoomCrane_velocity_plug_velocity Type velocity\n", response.getMessage());
  }
  
  @Test
  public void canHandleMultiPartPostRequestWithDefaultOntology() throws Exception {
    HttpClient client = new HttpClient();
    client.start();
  
    MultiPartContentProvider multiPart = new MultiPartContentProvider();
    multiPart.addFieldPart("configuration", new StringContentProvider(validConfiguration.toString()), null);
    multiPart.close();
  
    Request request = client.POST("http://localhost:" + port + "/validate");
    ContentResponse httpResponse = request.content(multiPart).send();
    ValidationServletResponse response = gson.fromJson(httpResponse.getContentAsString(), ValidationServletResponse.class);
  
    assertEquals(HttpStatus.OK_200, httpResponse.getStatus());
    assertEquals("application/json", httpResponse.getMediaType());
    assertEquals("true", response.getValid());
    assertTrue(response.getMessage().isEmpty());
  }
  
  @Test
  public void canHandleGetRequestWithDefaultOntology() throws Exception {
    HttpClient client = new HttpClient();
    client.start();
  
    ContentResponse httpResponse = client.GET("http://localhost:" + port + "/validate?configuration=" + validConfiguration);
    ValidationServletResponse response = gson.fromJson(httpResponse.getContentAsString(), ValidationServletResponse.class);
  
    assertEquals(HttpStatus.OK_200, httpResponse.getStatus());
    assertEquals("application/json", httpResponse.getMediaType());
    assertEquals("true", response.getValid());
    assertTrue(response.getMessage().isEmpty());
  }
}
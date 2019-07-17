package com.opensimulationplatform.servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensimulationplatform.validator.MsmiValidator;
import org.eclipse.jetty.http.HttpStatus;
import org.semanticweb.owlapi.io.OWLObjectRenderer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.ac.manchester.cs.owl.owlapi.mansyntaxrenderer.ManchesterOWLSyntaxOWLObjectRendererImpl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidationServlet extends HttpServlet {
  
  private static final Logger LOG = LoggerFactory.getLogger(ValidationServlet.class);
  private final Gson gson = new GsonBuilder().create();
  
  @Override
  protected void doGet(HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
    try {
      Map<String, URI> queries = getQueries(httpRequest);
      File ontology = new File(queries.get("ontology"));
      File configuration = new File(queries.get("configuration"));
      
      MsmiValidator.Result result = MsmiValidator.validate(ontology, configuration);
      
      createHttpResponse(httpResponse, result);
    } catch (Exception e) {
      String message = "Error during doGet";
      LOG.error(message, e);
      writeResponse(httpResponse, gson.toJson(e.getMessage()));
    }
  }
  
  @Override
  protected void doPost(HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
    try {
      File ontology = new File(getURI(httpRequest.getParameter("ontology")));
      File configuration = new File(getURI(httpRequest.getParameter("configuration")));
      
      MsmiValidator.Result result = MsmiValidator.validate(ontology, configuration);
      
      createHttpResponse(httpResponse, result);
    } catch (Exception e) {
      String message = "Error during doPost";
      LOG.error(message, e);
      writeResponse(httpResponse, gson.toJson(e.getMessage()));
    }
  }
  
  private void createHttpResponse(HttpServletResponse httpResponse, MsmiValidator.Result result) {
    httpResponse.setContentType("application/json");
    httpResponse.setCharacterEncoding("UTF-8");
    httpResponse.addHeader("Access-Control-Allow-Origin", "*");
    
    if (result.isSuccess()) {
      httpResponse.setStatus(HttpStatus.OK_200);
    } else {
      httpResponse.setStatus(HttpStatus.BAD_REQUEST_400);
    }
    
    writeResponse(httpResponse, gson.toJson(getServletResponse(result)));
  }
  
  private void writeResponse(HttpServletResponse httpResponse, String response) {
    try (PrintWriter writer = httpResponse.getWriter()) {
      writer.println(response);
      writer.flush();
    } catch (Exception e) {
      String message = "Error writing http response";
      LOG.error(message, e);
    }
  }
  
  private ValidationServletResponse getServletResponse(MsmiValidator.Result result) {
    ValidationServletResponse response = new ValidationServletResponse();
    
    if (result.isSuccess()) {
      response.setValid("true");
    } else {
      response.setValid("false");
      
      List<String> explanations = new ArrayList<>();
      OWLObjectRenderer renderer = new ManchesterOWLSyntaxOWLObjectRendererImpl();
      result.getExplanations().forEach(axioms -> {
        axioms.forEach(axiom -> explanations.add(renderer.render(axiom.getAxiomWithoutAnnotations())));
      });
      
      response.setExplanations(explanations);
    }
    
    return response;
  }
  
  private Map<String, URI> getQueries(HttpServletRequest request) {
    Map<String, URI> queries = new HashMap<>();
    for (String queryString : request.getQueryString().split("&")) {
      String[] keyValue = queryString.split("=");
      String key = keyValue[0];
      String value = keyValue[1];
      queries.put(key, getURI(value));
    }
    return queries;
  }
  
  private URI getURI(String value) {
    try {
      LOG.debug("Attempting to parse: '" + value + "' as a URI...");
      URI uri = new URL(value).toURI();
      LOG.debug("done!");
      return uri;
    } catch (Exception e) {
      LOG.debug("'" + value + "' is not on proper URI format. Attempting conversion...");
      try {
        URI uri = new File(value).toURI();
        LOG.debug("done!");
        return uri;
      } catch (Exception ex) {
        String message = "Error parsing: '" + value + "' as a URI";
        LOG.error(message, e);
        throw new RuntimeException(message, e);
      }
    }
  }
}

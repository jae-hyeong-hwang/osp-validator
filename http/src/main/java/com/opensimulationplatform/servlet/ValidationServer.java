package com.opensimulationplatform.servlet;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ValidationServer {
  
  private static final Logger LOG = LoggerFactory.getLogger(ValidationServer.class);
  
  private final Server server;
  private final int port;
  
  ValidationServer(int port) {
    this.port = port;
    server = new Server(port);
  }
  
  void start() throws Exception {
    ServletContextHandler handler = new ServletContextHandler(server, "/");
    handler.addServlet(ValidationServlet.class, "/validate");
    
    LOG.info("Starting msmi-validator-http server on port: " + port);
    LOG.info("Run validation checks using: http://<ip-address>:" + port + "/validate?configuration=/path/to/cse-config.json&ontology=/path/to/osp.owl");
    server.start();
  }
  
  void stop() throws Exception {
    LOG.info("Stopping msmi-validator-http server on port: " + port);
    server.stop();
  }
  
  boolean isRunning() {
    return server.isRunning();
  }
}

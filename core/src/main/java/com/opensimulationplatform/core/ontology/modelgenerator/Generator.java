package com.opensimulationplatform.core.ontology.modelgenerator;

import com.opensimulationplatform.core.owl.util.ontologycontent.OntologyContent;
import com.opensimulationplatform.core.owl.util.ontologyparser.OntologyParser;
import com.opensimulationplatform.core.util.resource.Resources;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

class Generator {
  
  private static final File templateFile = new File("./core/src/main/java/com/opensimulationplatform/core/ontology/modelgenerator/Template");
  private static final String destinationPackage = "com.opensimulationplatform.core.ontology.model";
  
  public static void main(String[] args) throws Exception {
    File ontologyFile = Resources.OSP_OWL.toFile();
    
    OntologyContent content = OntologyParser.parse(ontologyFile);
  
    String classes = getContentForClassesDataModel(content);
    String objectProperties = getContentForObjectPropertiesDataModel(content);
    String dataProperties = getContentForDataPropertiesDataModel(content);
    String individuals = getContentForIndividualsDataModel(content);
  
    writeDataModelClassFile(destinationPackage, classes, "OntologyClasses");
    writeDataModelClassFile(destinationPackage, objectProperties, "OntologyObjectProperties");
    writeDataModelClassFile(destinationPackage, dataProperties, "OntologyDataProperties");
    writeDataModelClassFile(destinationPackage, individuals, "OntologyIndividuals");
  }
  
  private static String getContentForClassesDataModel(OntologyContent content) {
    StringBuilder classes = new StringBuilder();
    content.getClasses().forEach((name, owlClass) -> addField(classes, name));
    
    return classes.toString();
  }
  
  private static String getContentForObjectPropertiesDataModel(OntologyContent content) {
    StringBuilder objectProperties = new StringBuilder();
    content.getObjectProperties().forEach((name, owlObjectProperty) -> addField(objectProperties, name));
    
    return objectProperties.toString();
  }
  
  private static void addField(StringBuilder objectProperties, String name) {
    objectProperties.append("public static final String ").append(name.toUpperCase()).append(" = ").append("\"").append(name.toLowerCase()).append("\"").append(";\n  ");
  }
  
  private static String getContentForDataPropertiesDataModel(OntologyContent content) {
    StringBuilder dataProperties = new StringBuilder();
    content.getDataProperties().forEach((name, owlDataProperty) -> addField(dataProperties, name));
    
    return dataProperties.toString();
  }
  
  private static String getContentForIndividualsDataModel(OntologyContent content) {
    StringBuilder individuals = new StringBuilder();
    content.getIndividuals().forEach((name, owlIndividual) -> addField(individuals, name));
    
    return individuals.toString();
  }
  
  private static void writeDataModelClassFile(String pkg, String fields, String classFileName) throws IOException {
    String templateContent = new String(Files.readAllBytes(templateFile.toPath()));
    String dataModelClassContent = templateContent.replace("$FIELDS$", fields).replace("$CLASS_NAME$", classFileName).replace("$PACKAGE$", pkg);
    File destination = new File("./core/src/main/java/" + pkg.replace(".", "/") + "/");
    File dataModelClassFile = new File(destination, classFileName + ".java");
    if (!dataModelClassFile.getParentFile().exists() && !dataModelClassFile.getParentFile().mkdirs()) {
      throw new RuntimeException("Unable to create directory: " + destination.getAbsolutePath());
    } else {
      FileWriter writer = new FileWriter(dataModelClassFile);
      writer.write(dataModelClassContent);
      writer.flush();
      writer.close();
    }
  }
}

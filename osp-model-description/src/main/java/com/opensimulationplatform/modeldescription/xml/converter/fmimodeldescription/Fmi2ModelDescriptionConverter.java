package com.opensimulationplatform.modeldescription.xml.converter.fmimodeldescription;


import com.opensimulationplatform.core.model.modeldescription.Unit;
import com.opensimulationplatform.core.model.modeldescription.Variable;
import com.opensimulationplatform.modeldescription.util.FmiModelDescription;
import com.opensimulationplatform.modeldescription.xml.converter.Converter;
import com.opensimulationplatform.modeldescription.xml.converter.ConverterContext;
import no.ntnu.ihb.fmi4j.modeldescription.fmi2.Fmi2ScalarVariable;
import no.ntnu.ihb.fmi4j.modeldescription.fmi2.Fmi2Unit;

import java.util.List;
import java.util.stream.Collectors;

public class Fmi2ModelDescriptionConverter extends Converter<no.ntnu.ihb.fmi4j.modeldescription.fmi2.FmiModelDescription, FmiModelDescription> {

  public Fmi2ModelDescriptionConverter(ConverterContext converterContext) {
    super(converterContext);
  }

  @Override
  public FmiModelDescription convert(no.ntnu.ihb.fmi4j.modeldescription.fmi2.FmiModelDescription fmiModelDescription) {
    FmiModelDescription fmd = new FmiModelDescription();

    List<Fmi2ScalarVariable> scalarVariables = fmiModelDescription.getModelVariables().getScalarVariable();
    List<Variable> variables = converterContext.fmi2ScalarVariableConverter.convert(scalarVariables);
    fmd.setVariables(variables);

    no.ntnu.ihb.fmi4j.modeldescription.fmi2.FmiModelDescription.UnitDefinitions unitDefinitions = fmiModelDescription.getUnitDefinitions();
    if (unitDefinitions != null) {
      List<Fmi2Unit> fmi2Units = unitDefinitions.getUnit();
      List<Unit> units = converterContext.fmi2UnitConverter.convert(fmi2Units);
      fmd.setUnits(units);
    }

    return fmd;
  }

  @Override
  public List<FmiModelDescription> convert(List<no.ntnu.ihb.fmi4j.modeldescription.fmi2.FmiModelDescription> fmiModelDescriptions) {
    return fmiModelDescriptions.stream().map(this::convert).collect(Collectors.toList());
  }
}
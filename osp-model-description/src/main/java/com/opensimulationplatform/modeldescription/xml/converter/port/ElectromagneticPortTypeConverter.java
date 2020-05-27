package com.opensimulationplatform.modeldescription.xml.converter.port;

import com.opensimulationplatform.core.model.modeldescription.variablegroup.current.Current;
import com.opensimulationplatform.core.model.modeldescription.variablegroup.electromagneticport.ElectromagneticPort;
import com.opensimulationplatform.core.model.modeldescription.variablegroup.voltage.Voltage;
import com.opensimulationplatform.modeldescription.xml.converter.Converter;
import com.opensimulationplatform.modeldescription.xml.converter.ConverterContext;
import com.opensimulationplatform.modeldescription.xml.model.ElectromagneticPortType;

public class ElectromagneticPortTypeConverter extends Converter<ElectromagneticPortType, ElectromagneticPort> {

  public ElectromagneticPortTypeConverter(ConverterContext converterContext) {
    super(converterContext);
  }

  @Override
  public ElectromagneticPort convert(ElectromagneticPortType electromagneticPortType) {
    ElectromagneticPort electromagneticPort = new ElectromagneticPort();

    Voltage voltage = context.voltageTypeConverter.convert(electromagneticPortType.getVoltage());
    Current current = context.currentTypeConverter.convert(electromagneticPortType.getCurrent());

    context.modelDescription.getVoltages().add(voltage);
    context.modelDescription.getCurrents().add(current);

    electromagneticPort.setName(electromagneticPortType.getName());
    electromagneticPort.setVoltage(voltage);
    electromagneticPort.setCurrent(current);

    return electromagneticPort;
  }
}

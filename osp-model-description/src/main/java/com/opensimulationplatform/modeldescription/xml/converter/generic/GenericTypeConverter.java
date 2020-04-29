package com.opensimulationplatform.modeldescription.xml.converter.generic;

import com.opensimulationplatform.core.model.modeldescription.Variable;
import com.opensimulationplatform.core.model.modeldescription.variablegroup.angulardisplacement.AngularDisplacement;
import com.opensimulationplatform.core.model.modeldescription.variablegroup.angularmechanicalport.AngularMechanicalPort;
import com.opensimulationplatform.core.model.modeldescription.variablegroup.angularmechanicalquasiport.AngularMechanicalQuasiPort;
import com.opensimulationplatform.core.model.modeldescription.variablegroup.angularvelocity.AngularVelocity;
import com.opensimulationplatform.core.model.modeldescription.variablegroup.charge.Charge;
import com.opensimulationplatform.core.model.modeldescription.variablegroup.current.Current;
import com.opensimulationplatform.core.model.modeldescription.variablegroup.electromagneticport.ElectromagneticPort;
import com.opensimulationplatform.core.model.modeldescription.variablegroup.electromagneticquasiport.ElectromagneticQuasiPort;
import com.opensimulationplatform.core.model.modeldescription.variablegroup.force.Force;
import com.opensimulationplatform.core.model.modeldescription.variablegroup.generic.Generic;
import com.opensimulationplatform.core.model.modeldescription.variablegroup.hydraulicport.HydraulicPort;
import com.opensimulationplatform.core.model.modeldescription.variablegroup.hydraulicquasiport.HydraulicQuasiPort;
import com.opensimulationplatform.core.model.modeldescription.variablegroup.lineardisplacement.LinearDisplacement;
import com.opensimulationplatform.core.model.modeldescription.variablegroup.linearmechanicalport.LinearMechanicalPort;
import com.opensimulationplatform.core.model.modeldescription.variablegroup.linearmechanicalquasiport.LinearMechanicalQuasiPort;
import com.opensimulationplatform.core.model.modeldescription.variablegroup.linearvelocity.LinearVelocity;
import com.opensimulationplatform.core.model.modeldescription.variablegroup.pressure.Pressure;
import com.opensimulationplatform.core.model.modeldescription.variablegroup.torque.Torque;
import com.opensimulationplatform.core.model.modeldescription.variablegroup.voltage.Voltage;
import com.opensimulationplatform.core.model.modeldescription.variablegroup.volume.Volume;
import com.opensimulationplatform.core.model.modeldescription.variablegroup.volumeflowrate.VolumeFlowRate;
import com.opensimulationplatform.modeldescription.xml.converter.Converter;
import com.opensimulationplatform.modeldescription.xml.converter.ConverterContext;
import com.opensimulationplatform.modeldescription.xml.model.*;

import java.util.List;
import java.util.stream.Collectors;

public class GenericTypeConverter extends Converter<GenericType, Generic> {

  public GenericTypeConverter(ConverterContext converterContext) {
    super(converterContext);
  }

  @Override
  public Generic convert(GenericType genericType) {
    Generic generic = new Generic();

    generic.setName(genericType.getName());

    List<GenericType> genericTypes = genericType.getGeneric();
    List<Generic> generics = converterContext.genericTypeConverter.convert(genericTypes);
    generic.getGenerics().addAll(generics);

    List<VariableType> variable = genericType.getVariable();
    List<Variable> variables = converterContext.variableTypeConverter.convert(variable);
    generic.setVariables(variables);

    List<AngularDisplacementType> angularDisplacement = genericType.getAngularDisplacement();
    List<AngularDisplacement> angularDisplacements = converterContext.angularDisplacementTypeConverter.convert(angularDisplacement);
    generic.getAngularDisplacements().addAll(angularDisplacements);

    List<ChargeType> charge = genericType.getCharge();
    List<Charge> charges = converterContext.chargeTypeConverter.convert(charge);
    generic.getCharges().addAll(charges);

    List<LinearDisplacementType> linearDisplacement = genericType.getLinearDisplacement();
    List<LinearDisplacement> linearDisplacements = converterContext.linearDisplacementTypeConverter.convert(linearDisplacement);
    generic.getLinearDisplacements().addAll(linearDisplacements);

    List<VolumeType> volume = genericType.getVolume();
    List<Volume> volumes = converterContext.volumeTypeConverter.convert(volume);
    generic.getVolumes().addAll(volumes);

    List<ForceType> force = genericType.getForce();
    List<Force> forces = converterContext.forceTypeConverter.convert(force);
    generic.getForces().addAll(forces);

    List<PressureType> pressure = genericType.getPressure();
    List<Pressure> pressures = converterContext.pressureTypeConverter.convert(pressure);
    generic.getPressures().addAll(pressures);

    List<TorqueType> torque = genericType.getTorque();
    List<Torque> torques = converterContext.torqueTypeConverter.convert(torque);
    generic.getTorques().addAll(torques);

    List<VoltageType> voltage = genericType.getVoltage();
    List<Voltage> voltages = converterContext.voltageTypeConverter.convert(voltage);
    generic.getVoltages().addAll(voltages);

    List<AngularVelocityType> angularVelocity = genericType.getAngularVelocity();
    List<AngularVelocity> angularVelocities = converterContext.angularVelocityTypeConverter.convert(angularVelocity);
    generic.getAngularVelocities().addAll(angularVelocities);

    List<CurrentType> current = genericType.getCurrent();
    List<Current> currents = converterContext.currentTypeConverter.convert(current);
    generic.getCurrents().addAll(currents);

    List<LinearVelocityType> linearVelocity = genericType.getLinearVelocity();
    List<LinearVelocity> linearVelocities = converterContext.linearVelocityTypeConverter.convert(linearVelocity);
    generic.getLinearVelocities().addAll(linearVelocities);

    List<VolumeFlowRateType> volumeFlowRate = genericType.getVolumeFlowRate();
    List<VolumeFlowRate> volumeFlowRates = converterContext.volumeFlowRateTypeConverter.convert(volumeFlowRate);
    generic.getVolumeFlowRates().addAll(volumeFlowRates);

    List<AngularMechanicalPortType> angularMechanicalPort = genericType.getAngularMechanicalPort();
    List<AngularMechanicalPort> angularMechanicalPorts = converterContext.angularMechanicalPortTypeConverter.convert(angularMechanicalPort);
    generic.getAngularMechanicalPorts().addAll(angularMechanicalPorts);

    List<ElectromagneticPortType> electromagneticPort = genericType.getElectromagneticPort();
    List<ElectromagneticPort> electromagneticPorts = converterContext.electromagneticPortTypeConverter.convert(electromagneticPort);
    generic.getElectromagneticPorts().addAll(electromagneticPorts);

    List<HydraulicPortType> hydraulicPort = genericType.getHydraulicPort();
    List<HydraulicPort> hydraulicPorts = converterContext.hydraulicPortTypeConverter.convert(hydraulicPort);
    generic.getHydraulicPorts().addAll(hydraulicPorts);

    List<LinearMechanicalPortType> linearMechanicalPort = genericType.getLinearMechanicalPort();
    List<LinearMechanicalPort> linearMechanicalPorts = converterContext.linearMechanicalPortTypeConverter.convert(linearMechanicalPort);
    generic.getLinearMechanicalPorts().addAll(linearMechanicalPorts);

    List<AngularMechanicalQuasiPortType> angularMechanicalQuasiPort = genericType.getAngularMechanicalQuasiPort();
    List<AngularMechanicalQuasiPort> angularMechanicalQuasiPorts = converterContext.angularMechanicalQuasiPortTypeConverter.convert(angularMechanicalQuasiPort);
    generic.getAngularMechanicalQuasiPorts().addAll(angularMechanicalQuasiPorts);

    List<ElectromagneticQuasiPortType> electromagneticQuasiPort = genericType.getElectromagneticQuasiPort();
    List<ElectromagneticQuasiPort> electromagneticQuasiPorts = converterContext.electromagneticQuasiPortTypeConverter.convert(electromagneticQuasiPort);
    generic.getElectromagneticQuasiPorts().addAll(electromagneticQuasiPorts);

    List<HydraulicQuasiPortType> hydraulicQuasiPort = genericType.getHydraulicQuasiPort();
    List<HydraulicQuasiPort> hydraulicQuasiPorts = converterContext.hydraulicQuasiPortTypeConverter.convert(hydraulicQuasiPort);
    generic.getHydraulicQuasiPorts().addAll(hydraulicQuasiPorts);

    List<LinearMechanicalQuasiPortType> linearMechanicalQuasiPort = genericType.getLinearMechanicalQuasiPort();
    List<LinearMechanicalQuasiPort> linearMechanicalQuasiPorts = converterContext.linearMechanicalQuasiPortTypeConverter.convert(linearMechanicalQuasiPort);
    generic.getLinearMechanicalQuasiPorts().addAll(linearMechanicalQuasiPorts);

    return generic;
  }

  @Override
  public List<Generic> convert(List<GenericType> genericTypes) {
    return genericTypes.stream().map(this::convert).collect(Collectors.toList());
  }
}

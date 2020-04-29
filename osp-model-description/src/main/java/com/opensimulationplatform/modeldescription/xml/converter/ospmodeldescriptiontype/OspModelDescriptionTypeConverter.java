package com.opensimulationplatform.modeldescription.xml.converter.ospmodeldescriptiontype;

import com.opensimulationplatform.core.model.modeldescription.ModelDescription;
import com.opensimulationplatform.core.model.modeldescription.Unit;
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
import com.opensimulationplatform.modeldescription.util.FmuHelper_Fmi1;
import com.opensimulationplatform.modeldescription.util.FmuHelper_Fmi2;
import com.opensimulationplatform.modeldescription.xml.converter.Converter;
import com.opensimulationplatform.modeldescription.xml.converter.ConverterContext;
import com.opensimulationplatform.modeldescription.xml.model.*;
import no.ntnu.ihb.fmi4j.modeldescription.ModelDescriptionParser;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

public class OspModelDescriptionTypeConverter extends Converter<OspModelDescriptionType, ModelDescription> {

  public OspModelDescriptionTypeConverter(ConverterContext converterContext) {
    super(converterContext);
  }

  public OspModelDescriptionTypeConverter(URI fmu) {
    super();
    try {
      String fmiVersion = ModelDescriptionParser.extractVersion(fmu.toURL());
      if ("1.0".equals(fmiVersion)) {
        converterContext.fmiModelDescription = converterContext.fmi1ModelDescriptionConverter.convert(FmuHelper_Fmi1.getFmiModelDescription(fmu));
      } else if ("2.0".equals(fmiVersion)) {
        converterContext.fmiModelDescription = converterContext.fmi2ModelDescriptionConverter.convert(FmuHelper_Fmi2.getFmiModelDescription(fmu));
      } else {
        throw new RuntimeException("fmiVersion " + fmiVersion + " not supported");
      }
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public ModelDescription convert(OspModelDescriptionType ospModelDescriptionType) {
    ModelDescription modelDescription = converterContext.modelDescription;

    modelDescription.getVariables().addAll(converterContext.fmiModelDescription.getVariables());
    modelDescription.getUnits().addAll(converterContext.fmiModelDescription.getUnits());

    UnitDefinitionsType unitDefinitions = ospModelDescriptionType.getUnitDefinitions();
    if (unitDefinitions != null) {
      List<UnitType> unitTypes = unitDefinitions.getUnit();
      List<Unit> units = converterContext.unitTypeConverter.convert(unitTypes);
      modelDescription.getUnits().addAll(units);
    }

    VariableGroupsType variableGroups = ospModelDescriptionType.getVariableGroups();

    List<GenericType> genericTypes = variableGroups.getGeneric();
    List<Generic> generics = converterContext.genericTypeConverter.convert(genericTypes);
    modelDescription.getGenerics().addAll(generics);

    List<AngularDisplacementType> angularDisplacementTypes = variableGroups.getAngularDisplacement();
    List<AngularDisplacement> angularDisplacements = converterContext.angularDisplacementTypeConverter.convert(angularDisplacementTypes);
    modelDescription.getAngularDisplacements().addAll(angularDisplacements);

    List<ChargeType> chargeTypes = variableGroups.getCharge();
    List<Charge> charges = converterContext.chargeTypeConverter.convert(chargeTypes);
    modelDescription.getCharges().addAll(charges);

    List<LinearDisplacementType> linearDisplacementTypes = variableGroups.getLinearDisplacement();
    List<LinearDisplacement> linearDisplacements = converterContext.linearDisplacementTypeConverter.convert(linearDisplacementTypes);
    modelDescription.getLinearDisplacements().addAll(linearDisplacements);

    List<VolumeType> volumeTypes = variableGroups.getVolume();
    List<Volume> volumes = converterContext.volumeTypeConverter.convert(volumeTypes);
    modelDescription.getVolumes().addAll(volumes);

    List<ForceType> forceTypes = variableGroups.getForce();
    List<Force> forces = converterContext.forceTypeConverter.convert(forceTypes);
    modelDescription.getForces().addAll(forces);

    List<PressureType> pressureTypes = variableGroups.getPressure();
    List<Pressure> pressures = converterContext.pressureTypeConverter.convert(pressureTypes);
    modelDescription.getPressures().addAll(pressures);

    List<TorqueType> torqueTypes = variableGroups.getTorque();
    List<Torque> torques = converterContext.torqueTypeConverter.convert(torqueTypes);
    modelDescription.getTorques().addAll(torques);

    List<VoltageType> voltageTypes = variableGroups.getVoltage();
    List<Voltage> voltages = converterContext.voltageTypeConverter.convert(voltageTypes);
    modelDescription.getVoltages().addAll(voltages);

    List<AngularVelocityType> angularVelocityTypes = variableGroups.getAngularVelocity();
    List<AngularVelocity> angularVelocities = converterContext.angularVelocityTypeConverter.convert(angularVelocityTypes);
    modelDescription.getAngularVelocities().addAll(angularVelocities);

    List<CurrentType> currentTypes = variableGroups.getCurrent();
    List<Current> currents = converterContext.currentTypeConverter.convert(currentTypes);
    modelDescription.getCurrents().addAll(currents);

    List<LinearVelocityType> linearVelocityTypes = variableGroups.getLinearVelocity();
    List<LinearVelocity> linearVelocities = converterContext.linearVelocityTypeConverter.convert(linearVelocityTypes);
    modelDescription.getLinearVelocities().addAll(linearVelocities);

    List<VolumeFlowRateType> volumeFlowRateTypes = variableGroups.getVolumeFlowRate();
    List<VolumeFlowRate> volumeFlowRates = converterContext.volumeFlowRateTypeConverter.convert(volumeFlowRateTypes);
    modelDescription.getVolumeFlowRates().addAll(volumeFlowRates);

    List<AngularMechanicalPortType> angularMechanicalPortTypes = variableGroups.getAngularMechanicalPort();
    List<AngularMechanicalPort> angularMechanicalPorts = converterContext.angularMechanicalPortTypeConverter.convert(angularMechanicalPortTypes);
    modelDescription.getAngularMechanicalPorts().addAll(angularMechanicalPorts);

    List<ElectromagneticPortType> electromagneticPortTypes = variableGroups.getElectromagneticPort();
    List<ElectromagneticPort> electromagneticPorts = converterContext.electromagneticPortTypeConverter.convert(electromagneticPortTypes);
    modelDescription.getElectromagneticPorts().addAll(electromagneticPorts);

    List<HydraulicPortType> hydraulicPortTypes = variableGroups.getHydraulicPort();
    List<HydraulicPort> hydraulicPorts = converterContext.hydraulicPortTypeConverter.convert(hydraulicPortTypes);
    modelDescription.getHydraulicPorts().addAll(hydraulicPorts);

    List<LinearMechanicalPortType> linearMechanicalPortTypes = variableGroups.getLinearMechanicalPort();
    List<LinearMechanicalPort> linearMechanicalPorts = converterContext.linearMechanicalPortTypeConverter.convert(linearMechanicalPortTypes);
    modelDescription.getLinearMechanicalPorts().addAll(linearMechanicalPorts);

    List<AngularMechanicalQuasiPortType> angularMechanicalQuasiPortTypes = variableGroups.getAngularMechanicalQuasiPort();
    List<AngularMechanicalQuasiPort> angularMechanicalQuasiPorts = converterContext.angularMechanicalQuasiPortTypeConverter.convert(angularMechanicalQuasiPortTypes);
    modelDescription.getAngularMechanicalQuasiPorts().addAll(angularMechanicalQuasiPorts);

    List<ElectromagneticQuasiPortType> electromagneticQuasiPortTypes = variableGroups.getElectromagneticQuasiPort();
    List<ElectromagneticQuasiPort> electromagneticQuasiPorts = converterContext.electromagneticQuasiPortTypeConverter.convert(electromagneticQuasiPortTypes);
    modelDescription.getElectromagneticQuasiPorts().addAll(electromagneticQuasiPorts);

    List<HydraulicQuasiPortType> hydraulicQuasiPortTypes = variableGroups.getHydraulicQuasiPort();
    List<HydraulicQuasiPort> hydraulicQuasiPorts = converterContext.hydraulicQuasiPortTypeConverter.convert(hydraulicQuasiPortTypes);
    modelDescription.getHydraulicQuasiPorts().addAll(hydraulicQuasiPorts);

    List<LinearMechanicalQuasiPortType> linearMechanicalQuasiPortTypes = variableGroups.getLinearMechanicalQuasiPort();
    List<LinearMechanicalQuasiPort> linearMechanicalQuasiPorts = converterContext.linearMechanicalQuasiPortTypeConverter.convert(linearMechanicalQuasiPortTypes);
    modelDescription.getLinearMechanicalQuasiPorts().addAll(linearMechanicalQuasiPorts);

    return modelDescription;
  }

  @Override
  public List<ModelDescription> convert(List<OspModelDescriptionType> ospModelDescriptionTypes) {
    return ospModelDescriptionTypes.stream().map(this::convert).collect(Collectors.toList());
  }
}

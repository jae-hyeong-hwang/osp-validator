/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.opensimulationplatform.modeldescription.xml.converter;

import com.opensimulationplatform.core.model.modeldescription.ModelDescription;
import com.opensimulationplatform.modeldescription.util.FmiModelDescription;
import com.opensimulationplatform.modeldescription.xml.converter.displacement.AngularDisplacementTypeConverter;
import com.opensimulationplatform.modeldescription.xml.converter.displacement.ChargeTypeConverter;
import com.opensimulationplatform.modeldescription.xml.converter.displacement.LinearDisplacementTypeConverter;
import com.opensimulationplatform.modeldescription.xml.converter.displacement.VolumeTypeConverter;
import com.opensimulationplatform.modeldescription.xml.converter.effort.ForceTypeConverter;
import com.opensimulationplatform.modeldescription.xml.converter.effort.PressureTypeConverter;
import com.opensimulationplatform.modeldescription.xml.converter.effort.TorqueTypeConverter;
import com.opensimulationplatform.modeldescription.xml.converter.effort.VoltageTypeConverter;
import com.opensimulationplatform.modeldescription.xml.converter.flow.AngularVelocityTypeConverter;
import com.opensimulationplatform.modeldescription.xml.converter.flow.CurrentTypeConverter;
import com.opensimulationplatform.modeldescription.xml.converter.flow.LinearVelocityTypeConverter;
import com.opensimulationplatform.modeldescription.xml.converter.flow.VolumeFlowRateTypeConverter;
import com.opensimulationplatform.modeldescription.xml.converter.fmimodeldescription.Fmi1ModelDescriptionConverter;
import com.opensimulationplatform.modeldescription.xml.converter.fmimodeldescription.Fmi2ModelDescriptionConverter;
import com.opensimulationplatform.modeldescription.xml.converter.generic.GenericTypeConverter;
import com.opensimulationplatform.modeldescription.xml.converter.ospmodeldescriptiontype.OspModelDescriptionTypeConverter;
import com.opensimulationplatform.modeldescription.xml.converter.port.AngularMechanicalPortTypeConverter;
import com.opensimulationplatform.modeldescription.xml.converter.port.ElectromagneticPortTypeConverter;
import com.opensimulationplatform.modeldescription.xml.converter.port.HydraulicPortTypeConverter;
import com.opensimulationplatform.modeldescription.xml.converter.port.LinearMechanicalPortTypeConverter;
import com.opensimulationplatform.modeldescription.xml.converter.quasiport.AngularMechanicalQuasiPortTypeConverter;
import com.opensimulationplatform.modeldescription.xml.converter.quasiport.ElectromagneticQuasiPortTypeConverter;
import com.opensimulationplatform.modeldescription.xml.converter.quasiport.HydraulicQuasiPortTypeConverter;
import com.opensimulationplatform.modeldescription.xml.converter.quasiport.LinearMechanicalQuasiPortTypeConverter;
import com.opensimulationplatform.modeldescription.xml.converter.tentative.*;
import com.opensimulationplatform.modeldescription.xml.converter.tentative.nmea.*;
import com.opensimulationplatform.modeldescription.xml.converter.unit.Fmi2UnitConverter;
import com.opensimulationplatform.modeldescription.xml.converter.unit.UnitTypeConverter;
import com.opensimulationplatform.modeldescription.xml.converter.variable.Fmi1ScalarVariableConverter;
import com.opensimulationplatform.modeldescription.xml.converter.variable.Fmi2ScalarVariableConverter;
import com.opensimulationplatform.modeldescription.xml.converter.variable.VariableTypeConverter;

public class ConverterContext {

  public ModelDescription modelDescription;

  public FmiModelDescription fmiModelDescription;

  public OspModelDescriptionTypeConverter ospModelDescriptionTypeConverter;

  public Fmi1ModelDescriptionConverter fmi1ModelDescriptionConverter;
  public Fmi2ModelDescriptionConverter fmi2ModelDescriptionConverter;

  public Fmi1ScalarVariableConverter fmi1ScalarVariableConverter;
  public Fmi2ScalarVariableConverter fmi2ScalarVariableConverter;
  public VariableTypeConverter variableTypeConverter;

  public Fmi2UnitConverter fmi2UnitConverter;
  public UnitTypeConverter unitTypeConverter;

  public GenericTypeConverter genericTypeConverter;

  public AngularDisplacementTypeConverter angularDisplacementTypeConverter;
  public ChargeTypeConverter chargeTypeConverter;
  public LinearDisplacementTypeConverter linearDisplacementTypeConverter;
  public VolumeTypeConverter volumeTypeConverter;

  public ForceTypeConverter forceTypeConverter;
  public PressureTypeConverter pressureTypeConverter;
  public TorqueTypeConverter torqueTypeConverter;
  public VoltageTypeConverter voltageTypeConverter;

  public AngularVelocityTypeConverter angularVelocityTypeConverter;
  public CurrentTypeConverter currentTypeConverter;
  public LinearVelocityTypeConverter linearVelocityTypeConverter;
  public VolumeFlowRateTypeConverter volumeFlowRateTypeConverter;

  public AngularMechanicalPortTypeConverter angularMechanicalPortTypeConverter;
  public ElectromagneticPortTypeConverter electromagneticPortTypeConverter;
  public HydraulicPortTypeConverter hydraulicPortTypeConverter;
  public LinearMechanicalPortTypeConverter linearMechanicalPortTypeConverter;

  public AngularMechanicalQuasiPortTypeConverter angularMechanicalQuasiPortTypeConverter;
  public ElectromagneticQuasiPortTypeConverter electromagneticQuasiPortTypeConverter;
  public HydraulicQuasiPortTypeConverter hydraulicQuasiPortTypeConverter;
  public LinearMechanicalQuasiPortTypeConverter linearMechanicalQuasiPortTypeConverter;

  public NmeaGgaFixTypeConverter nmeaGgaFixTypeConverter;
  public NmeaTimeTypeConverter nmeaTimeTypeConverter;
  public NmeaGgaLatitudeLongitudeTypeConverter nmeaGgaLatitudeLongitudeTypeConverter;
  public NmeaGstEllipseTypeConverter nmeaGstEllipseTypeConverter;
  public NmeaGstPositionErrorTypeConverter nmeaGstPositionErrorTypeConverter;
  public NmeaGstRmsTypeConverter nmeaGstRmsTypeConverter;
  public NmeaStatusTypeConverter nmeaStatusTypeConverter;
  public NmeaWindDirectionTypeConverter nmeaWindDirectionTypeConverter;
  public NmeaWindSpeedTypeConverter nmeaWindSpeedTypeConverter;
  public NmeaTrueHeadingTypeConverter nmeaTrueHeadingTypeConverter;
  public AzimuthAngleTypeConverter azimuthAngleTypeConverter;
  public BladePitchTypeConverter bladePitchTypeConverter;
  public ShaftSpeedTypeConverter shaftSpeedTypeConverter;
  public ElectricPowerTypeConverter electricPowerTypeConverter;
  public FrequencyTypeConverter frequencyTypeConverter;
  public NmeaGgaTypeConverter nmeaGgaTypeConverter;
  public NmeaGstTypeConverter nmeaGstTypeConverter;
  public NmeaMwvTypeConverter nmeaMwvTypeConverter;
  public NmeaSxnTypeConverter nmeaSxnTypeConverter;
  public NmeaThsTypeConverter nmeaThsTypeConverter;
  public AngularAccelerationTypeConverter angularAccelerationTypeConverter;
  public AzimuthThrusterFeedbackTypeConverter azimuthThrusterFeedbackTypeConverter;
  public AzimuthThrusterSetpointTypeConverter azimuthThrusterSetpointTypeConverter;
  public BatteryFeedbackTypeConverter batteryFeedbackTypeConverter;
  public BusFeedbackTypeConverter busFeedbackTypeConverter;
  public FixedThrusterFeedbackTypeConverter fixedThrusterFeedbackTypeConverter;
  public FixedThrusterSetpointTypeConverter fixedThrusterSetpointTypeConverter;
  public GeneratorFeedbackTypeConverter generatorFeedbackTypeConverter;
  public LinearAccelerationTypeConverter linearAccelerationTypeConverter;


  public ConverterContext() {
    this.modelDescription = new ModelDescription();

    this.ospModelDescriptionTypeConverter = new OspModelDescriptionTypeConverter(this);

    this.fmi1ModelDescriptionConverter = new Fmi1ModelDescriptionConverter(this);
    this.fmi2ModelDescriptionConverter = new Fmi2ModelDescriptionConverter(this);

    this.fmi1ScalarVariableConverter = new Fmi1ScalarVariableConverter(this);
    this.fmi2ScalarVariableConverter = new Fmi2ScalarVariableConverter(this);
    this.variableTypeConverter = new VariableTypeConverter(this);

    this.fmi2UnitConverter = new Fmi2UnitConverter(this);
    this.unitTypeConverter = new UnitTypeConverter(this);

    this.genericTypeConverter = new GenericTypeConverter(this);

    this.angularDisplacementTypeConverter = new AngularDisplacementTypeConverter(this);
    this.chargeTypeConverter = new ChargeTypeConverter(this);
    this.linearDisplacementTypeConverter = new LinearDisplacementTypeConverter(this);
    this.volumeTypeConverter = new VolumeTypeConverter(this);

    this.forceTypeConverter = new ForceTypeConverter(this);
    this.pressureTypeConverter = new PressureTypeConverter(this);
    this.torqueTypeConverter = new TorqueTypeConverter(this);
    this.voltageTypeConverter = new VoltageTypeConverter(this);

    this.angularVelocityTypeConverter = new AngularVelocityTypeConverter(this);
    this.currentTypeConverter = new CurrentTypeConverter(this);
    this.linearVelocityTypeConverter = new LinearVelocityTypeConverter(this);
    this.volumeFlowRateTypeConverter = new VolumeFlowRateTypeConverter(this);

    this.angularMechanicalPortTypeConverter = new AngularMechanicalPortTypeConverter(this);
    this.electromagneticPortTypeConverter = new ElectromagneticPortTypeConverter(this);
    this.hydraulicPortTypeConverter = new HydraulicPortTypeConverter(this);
    this.linearMechanicalPortTypeConverter = new LinearMechanicalPortTypeConverter(this);

    this.angularMechanicalQuasiPortTypeConverter = new AngularMechanicalQuasiPortTypeConverter(this);
    this.electromagneticQuasiPortTypeConverter = new ElectromagneticQuasiPortTypeConverter(this);
    this.hydraulicQuasiPortTypeConverter = new HydraulicQuasiPortTypeConverter(this);
    this.linearMechanicalQuasiPortTypeConverter = new LinearMechanicalQuasiPortTypeConverter(this);

    this.nmeaGgaFixTypeConverter = new NmeaGgaFixTypeConverter(this);
    this.nmeaTimeTypeConverter = new NmeaTimeTypeConverter(this);
    this.nmeaGgaLatitudeLongitudeTypeConverter = new NmeaGgaLatitudeLongitudeTypeConverter(this);
    this.nmeaGstEllipseTypeConverter = new NmeaGstEllipseTypeConverter(this);
    this.nmeaGstPositionErrorTypeConverter = new NmeaGstPositionErrorTypeConverter(this);
    this.nmeaGstRmsTypeConverter = new NmeaGstRmsTypeConverter(this);
    this.nmeaStatusTypeConverter = new NmeaStatusTypeConverter(this);
    this.nmeaWindDirectionTypeConverter = new NmeaWindDirectionTypeConverter(this);
    this.nmeaWindSpeedTypeConverter = new NmeaWindSpeedTypeConverter(this);
    this.nmeaTrueHeadingTypeConverter = new NmeaTrueHeadingTypeConverter(this);
    this.azimuthAngleTypeConverter = new AzimuthAngleTypeConverter(this);
    this.bladePitchTypeConverter = new BladePitchTypeConverter(this);
    this.shaftSpeedTypeConverter = new ShaftSpeedTypeConverter(this);
    this.electricPowerTypeConverter = new ElectricPowerTypeConverter(this);
    this.frequencyTypeConverter = new FrequencyTypeConverter(this);
    this.nmeaGgaTypeConverter = new NmeaGgaTypeConverter(this);
    this.nmeaGstTypeConverter = new NmeaGstTypeConverter(this);
    this.nmeaMwvTypeConverter = new NmeaMwvTypeConverter(this);
    this.nmeaSxnTypeConverter = new NmeaSxnTypeConverter(this);
    this.nmeaThsTypeConverter = new NmeaThsTypeConverter(this);
    this.angularAccelerationTypeConverter = new AngularAccelerationTypeConverter(this);
    this.azimuthThrusterFeedbackTypeConverter = new AzimuthThrusterFeedbackTypeConverter(this);
    this.azimuthThrusterSetpointTypeConverter = new AzimuthThrusterSetpointTypeConverter(this);
    this.batteryFeedbackTypeConverter = new BatteryFeedbackTypeConverter(this);
    this.busFeedbackTypeConverter = new BusFeedbackTypeConverter(this);
    this.fixedThrusterFeedbackTypeConverter = new FixedThrusterFeedbackTypeConverter(this);
    this.fixedThrusterSetpointTypeConverter = new FixedThrusterSetpointTypeConverter(this);
    this.generatorFeedbackTypeConverter = new GeneratorFeedbackTypeConverter(this);
    this.linearAccelerationTypeConverter = new LinearAccelerationTypeConverter(this);
  }
}

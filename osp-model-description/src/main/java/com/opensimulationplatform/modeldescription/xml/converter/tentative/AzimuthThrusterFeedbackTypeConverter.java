package com.opensimulationplatform.modeldescription.xml.converter.tentative;

import com.opensimulationplatform.core.model.modeldescription.variablegroup.azimuthangle.AzimuthAngle;
import com.opensimulationplatform.core.model.modeldescription.variablegroup.azimuththrusterfeedback.AzimuthThrusterFeedback;
import com.opensimulationplatform.core.model.modeldescription.variablegroup.bladepitch.BladePitch;
import com.opensimulationplatform.core.model.modeldescription.variablegroup.force.Force;
import com.opensimulationplatform.core.model.modeldescription.variablegroup.shaftspeed.ShaftSpeed;
import com.opensimulationplatform.modeldescription.xml.converter.Converter;
import com.opensimulationplatform.modeldescription.xml.model.AzimuthThrusterFeedbackType;

public class AzimuthThrusterFeedbackTypeConverter extends Converter<AzimuthThrusterFeedbackType, AzimuthThrusterFeedback> {
  @Override
  public AzimuthThrusterFeedback convert(AzimuthThrusterFeedbackType azimuthThrusterFeedbackType) {
    AzimuthThrusterFeedback azimuthThrusterFeedback = new AzimuthThrusterFeedback();

    AzimuthAngle azimuthAngle = context.azimuthAngleTypeConverter.convert(azimuthThrusterFeedbackType.getAzimuthAngle());
    BladePitch bladePitch = context.bladePitchTypeConverter.convert(azimuthThrusterFeedbackType.getBladePitch());
    Force force = context.forceTypeConverter.convert(azimuthThrusterFeedbackType.getForce());
    ShaftSpeed shaftSpeed = context.shaftSpeedTypeConverter.convert(azimuthThrusterFeedbackType.getShaftSpeed());

    context.modelDescription.getAzimuthAngles().add(azimuthAngle);
    context.modelDescription.getBladePitches().add(bladePitch);
    context.modelDescription.getForces().add(force);
    context.modelDescription.getShaftSpeeds().add(shaftSpeed);

    azimuthThrusterFeedback.setAzimuthAngle(azimuthAngle);
    azimuthThrusterFeedback.setBladePitch(bladePitch);
    azimuthThrusterFeedback.setForce(force);
    azimuthThrusterFeedback.setShaftSpeed(shaftSpeed);

    return azimuthThrusterFeedback;
  }
}

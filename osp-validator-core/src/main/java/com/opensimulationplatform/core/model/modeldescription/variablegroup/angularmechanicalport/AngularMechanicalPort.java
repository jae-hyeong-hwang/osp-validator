/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.opensimulationplatform.core.model.modeldescription.variablegroup.angularmechanicalport;

import com.opensimulationplatform.core.model.modeldescription.variablegroup.VariableGroup;
import com.opensimulationplatform.core.model.modeldescription.variablegroup.angularvelocity.AngularVelocity;
import com.opensimulationplatform.core.model.modeldescription.variablegroup.ndimensionsalvariablegroup.NDimensionalVariableGroup;
import com.opensimulationplatform.core.model.modeldescription.variablegroup.torque.Torque;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AngularMechanicalPort extends NDimensionalVariableGroup {
  private Torque torque;
  private AngularVelocity angularVelocity;

  public Torque getTorque() {
    return torque;
  }

  public void setTorque(Torque torque) {
    this.torque = torque;
  }

  public AngularVelocity getAngularVelocity() {
    return angularVelocity;
  }

  public void setAngularVelocity(AngularVelocity angularVelocity) {
    this.angularVelocity = angularVelocity;
  }

  @Override
  public List<VariableGroup> getVariableGroups() {
    return Collections.unmodifiableList(Arrays.asList(torque, angularVelocity));
  }

  @Override
  protected int numberOfDimensions() {
    return 0;
  }
}

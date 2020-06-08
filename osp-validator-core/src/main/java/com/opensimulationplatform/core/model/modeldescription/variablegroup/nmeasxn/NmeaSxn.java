/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.opensimulationplatform.core.model.modeldescription.variablegroup.nmeasxn;

import com.opensimulationplatform.core.model.modeldescription.variablegroup.VariableGroup;
import com.opensimulationplatform.core.model.modeldescription.variablegroup.angulardisplacement.AngularDisplacement;
import com.opensimulationplatform.core.model.modeldescription.variablegroup.fixedsizevariablegroup.FixedSizeVariableGroup;
import com.opensimulationplatform.core.model.modeldescription.variablegroup.nmeastatus.NmeaStatus;

import java.util.Arrays;
import java.util.List;

public class NmeaSxn extends FixedSizeVariableGroup {

  private AngularDisplacement angularDisplacement;
  private NmeaStatus nmeaStatus;

  @Override
  protected int size() {
    return 0;
  }

  @Override
  public List<VariableGroup> getVariableGroups() {
    return Arrays.asList(angularDisplacement, nmeaStatus);
  }

  public AngularDisplacement getAngularDisplacement() {
    return angularDisplacement;
  }

  public void setAngularDisplacement(AngularDisplacement angularDisplacement) {
    this.angularDisplacement = angularDisplacement;
  }

  public NmeaStatus getNmeaStatus() {
    return nmeaStatus;
  }

  public void setNmeaStatus(NmeaStatus nmeaStatus) {
    this.nmeaStatus = nmeaStatus;
  }
}

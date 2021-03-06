
/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.opensimulationplatform.modeldescription.xml.model;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for HydraulicQuasiPortType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HydraulicQuasiPortType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Pressure" type="{https://open-simulation-platform.com/OspModelDescription/1.0.0}PressureType"/>
 *         &lt;element name="Volume" type="{https://open-simulation-platform.com/OspModelDescription/1.0.0}VolumeType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HydraulicQuasiPortType", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0", propOrder = {
    "pressure",
    "volume"
})
public class HydraulicQuasiPortType {

    @XmlElement(name = "Pressure", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0", required = true)
    protected PressureType pressure;
    @XmlElement(name = "Volume", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0", required = true)
    protected VolumeType volume;
    @XmlAttribute(name = "name", required = true)
    protected String name;

    /**
     * Gets the value of the pressure property.
     * 
     * @return
     *     possible object is
     *     {@link PressureType }
     *     
     */
    public PressureType getPressure() {
        return pressure;
    }

    /**
     * Sets the value of the pressure property.
     * 
     * @param value
     *     allowed object is
     *     {@link PressureType }
     *     
     */
    public void setPressure(PressureType value) {
        this.pressure = value;
    }

    /**
     * Gets the value of the volume property.
     * 
     * @return
     *     possible object is
     *     {@link VolumeType }
     *     
     */
    public VolumeType getVolume() {
        return volume;
    }

    /**
     * Sets the value of the volume property.
     * 
     * @param value
     *     allowed object is
     *     {@link VolumeType }
     *     
     */
    public void setVolume(VolumeType value) {
        this.volume = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

}

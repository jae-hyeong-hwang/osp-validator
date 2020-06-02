
/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.opensimulationplatform.modeldescription.xml.model;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for LinearMechanicalPortType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LinearMechanicalPortType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Force" type="{http://opensimulationplatform.com/osp-is/OSPModelDescription}ForceType"/>
 *         &lt;element name="LinearVelocity" type="{http://opensimulationplatform.com/osp-is/OSPModelDescription}LinearVelocityType"/>
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
@XmlType(name = "LinearMechanicalPortType", namespace = "http://opensimulationplatform.com/osp-is/OSPModelDescription", propOrder = {
    "force",
    "linearVelocity"
})
public class LinearMechanicalPortType {

    @XmlElement(name = "Force", namespace = "http://opensimulationplatform.com/osp-is/OSPModelDescription", required = true)
    protected ForceType force;
    @XmlElement(name = "LinearVelocity", namespace = "http://opensimulationplatform.com/osp-is/OSPModelDescription", required = true)
    protected LinearVelocityType linearVelocity;
    @XmlAttribute(name = "name", required = true)
    protected String name;

    /**
     * Gets the value of the force property.
     * 
     * @return
     *     possible object is
     *     {@link ForceType }
     *     
     */
    public ForceType getForce() {
        return force;
    }

    /**
     * Sets the value of the force property.
     * 
     * @param value
     *     allowed object is
     *     {@link ForceType }
     *     
     */
    public void setForce(ForceType value) {
        this.force = value;
    }

    /**
     * Gets the value of the linearVelocity property.
     * 
     * @return
     *     possible object is
     *     {@link LinearVelocityType }
     *     
     */
    public LinearVelocityType getLinearVelocity() {
        return linearVelocity;
    }

    /**
     * Sets the value of the linearVelocity property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinearVelocityType }
     *     
     */
    public void setLinearVelocity(LinearVelocityType value) {
        this.linearVelocity = value;
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

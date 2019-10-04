//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.09.27 at 09:29:41 AM CEST 
//


package com.opensimulationplatform.cseconfig.xml.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for bondConnections complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="bondConnections">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BondConnection" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Bond" type="{http://opensimulationplatform.com/MSMI/OSPSystemStructure}connectionEndpoint" maxOccurs="2" minOccurs="2"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bondConnections", propOrder = {
    "bondConnection"
})
public class BondConnections {

    @XmlElement(name = "BondConnection")
    protected List<BondConnections.BondConnection> bondConnection;

    /**
     * Gets the value of the bondConnection property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bondConnection property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBondConnection().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BondConnections.BondConnection }
     * 
     * 
     */
    public List<BondConnections.BondConnection> getBondConnection() {
        if (bondConnection == null) {
            bondConnection = new ArrayList<BondConnections.BondConnection>();
        }
        return this.bondConnection;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="Bond" type="{http://opensimulationplatform.com/MSMI/OSPSystemStructure}connectionEndpoint" maxOccurs="2" minOccurs="2"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "bond"
    })
    public static class BondConnection {

        @XmlElement(name = "Bond", required = true)
        protected List<ConnectionEndpoint> bond;

        /**
         * Gets the value of the bond property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the bond property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getBond().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ConnectionEndpoint }
         * 
         * 
         */
        public List<ConnectionEndpoint> getBond() {
            if (bond == null) {
                bond = new ArrayList<ConnectionEndpoint>();
            }
            return this.bond;
        }

    }

}

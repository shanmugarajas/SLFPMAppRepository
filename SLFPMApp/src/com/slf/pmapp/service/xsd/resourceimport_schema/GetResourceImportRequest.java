
package com.slf.pmapp.service.xsd.resourceimport_schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="empid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="empstatus" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dojslf" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="mobile" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="phone" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {

})
@XmlRootElement(name = "GetResourceImportRequest")
public class GetResourceImportRequest {

    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected String empid;
    @XmlElement(required = true)
    protected String empstatus;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dojslf;
    @XmlElement(required = true)
    protected String email;
    protected int mobile;
    protected int phone;

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

    /**
     * Gets the value of the empid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmpid() {
        return empid;
    }

    /**
     * Sets the value of the empid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmpid(String value) {
        this.empid = value;
    }

    /**
     * Gets the value of the empstatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmpstatus() {
        return empstatus;
    }

    /**
     * Sets the value of the empstatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmpstatus(String value) {
        this.empstatus = value;
    }

    /**
     * Gets the value of the dojslf property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDojslf() {
        return dojslf;
    }

    /**
     * Sets the value of the dojslf property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDojslf(XMLGregorianCalendar value) {
        this.dojslf = value;
    }

    /**
     * Gets the value of the email property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Gets the value of the mobile property.
     * 
     */
    public int getMobile() {
        return mobile;
    }

    /**
     * Sets the value of the mobile property.
     * 
     */
    public void setMobile(int value) {
        this.mobile = value;
    }

    /**
     * Gets the value of the phone property.
     * 
     */
    public int getPhone() {
        return phone;
    }

    /**
     * Sets the value of the phone property.
     * 
     */
    public void setPhone(int value) {
        this.phone = value;
    }

}

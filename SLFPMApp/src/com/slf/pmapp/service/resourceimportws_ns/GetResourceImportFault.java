
package com.slf.pmapp.service.resourceimportws_ns;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.1 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebFault(name = "GetResourceImportFault", targetNamespace = "http://slf.com/pmapp/service/xsd/resourceimport-schema")
public class GetResourceImportFault
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private com.slf.pmapp.service.xsd.resourceimport_schema.GetResourceImportFault faultInfo;

    /**
     * 
     * @param message
     * @param faultInfo
     */
    public GetResourceImportFault(String message, com.slf.pmapp.service.xsd.resourceimport_schema.GetResourceImportFault faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param message
     * @param faultInfo
     * @param cause
     */
    public GetResourceImportFault(String message, com.slf.pmapp.service.xsd.resourceimport_schema.GetResourceImportFault faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: com.slf.pmapp.service.xsd.resourceimport_schema.GetResourceImportFault
     */
    public com.slf.pmapp.service.xsd.resourceimport_schema.GetResourceImportFault getFaultInfo() {
        return faultInfo;
    }

}
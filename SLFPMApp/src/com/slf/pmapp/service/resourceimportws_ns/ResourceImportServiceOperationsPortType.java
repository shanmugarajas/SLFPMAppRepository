
package com.slf.pmapp.service.resourceimportws_ns;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import com.slf.pmapp.service.xsd.resourceimport_schema.GetResourceImportRequest;
import com.slf.pmapp.service.xsd.resourceimport_schema.GetResourceImportResponse;
import com.slf.pmapp.service.xsd.resourceimport_schema.ObjectFactory;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.1 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebService(name = "ResourceImportServiceOperationsPortType", targetNamespace = "http://slf.com/pmapp/service/resourceimportws-ns")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ResourceImportServiceOperationsPortType {


    /**
     * Imports Resource Information into iPM
     *             
     * 
     * @param getResourceImportRequest
     * @return
     *     returns com.slf.pmapp.service.xsd.resourceimport_schema.GetResourceImportResponse
     * @throws GetResourceImportFault
     */
    @WebMethod(action = "/Service/resourceimport")
    @WebResult(name = "GetResourceImportResponse", targetNamespace = "http://slf.com/pmapp/service/xsd/resourceimport-schema", partName = "GetResourceImportResponse")
    public GetResourceImportResponse resourceimport(
        @WebParam(name = "GetResourceImportRequest", targetNamespace = "http://slf.com/pmapp/service/xsd/resourceimport-schema", partName = "GetResourceImportRequest")
        GetResourceImportRequest getResourceImportRequest)
        throws GetResourceImportFault
    ;

}

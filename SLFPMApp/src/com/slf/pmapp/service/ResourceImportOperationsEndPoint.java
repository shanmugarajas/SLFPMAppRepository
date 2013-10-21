package com.slf.pmapp.service;

import java.util.Date;
import java.util.Locale;

import java.util.GregorianCalendar;

import javax.annotation.Resource;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.log4j.Category;
import org.apache.log4j.Logger;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.slf.pmapp.service.xsd.resourceimport_schema.GetResourceImportRequest;
import com.slf.pmapp.service.xsd.resourceimport_schema.GetResourceImportResponse;



@Endpoint
public class ResourceImportOperationsEndPoint{

    private static final Logger logger = Logger.getLogger(ResourceImportOperationsEndPoint.class);
    private static final String NAMESPACE_URI = "http://slf.com/pmapp/service/xsd/resourceimport-schema";
 
    @Resource(name="riService")
    private RIService riService;
    
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetResourceImportRequest")
    @ResponsePayload
   public GetResourceImportResponse handleRequest(
         @RequestPayload final GetResourceImportRequest activateServiceRequest)
         throws Exception {
    	String time = new DateFormatter().print(new Date(),Locale.ENGLISH);
        GetResourceImportResponse getResourceImportResponse = new GetResourceImportResponse();
        String name = activateServiceRequest.getName();
        String empid = activateServiceRequest.getEmpid();
        String empstatus = activateServiceRequest.getEmpstatus();
        Date dojslf =  activateServiceRequest.getDojslf().toGregorianCalendar().getTime();
        String email = activateServiceRequest.getEmail();
        int mobile = activateServiceRequest.getMobile();
        int phone = activateServiceRequest.getPhone();
        
        //riService.ImportResource(activateServiceRequest);
        
        System.out.println("Imported resource name: " + name );
        System.out.println("Imported resource empid: " + empid );
        System.out.println("Imported resource empstatus: " + empstatus );
        System.out.println("Imported resource dojlsf: " + dojslf.toString() );
        System.out.println("Imported resource email: " + email );
        System.out.println("Imported resource mobile: " + mobile );
        System.out.println("Imported resource phone: " + phone );

        getResourceImportResponse.setValue(1);
        getResourceImportResponse.setResponse("Successfully imported the resource");

        return getResourceImportResponse;
    }
  
}
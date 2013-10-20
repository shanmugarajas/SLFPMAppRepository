package com.slf.pmapp.service;

import java.util.Date;
import java.util.Locale;

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
 
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetResourceImportRequest")
    @ResponsePayload
   public GetResourceImportResponse handleRequest(
         @RequestPayload final GetResourceImportRequest activateServiceRequest)
         throws Exception {
        GetResourceImportResponse getResourceImportResponse = new GetResourceImportResponse();
        getResourceImportResponse.setValue(100);
        return getResourceImportResponse;
    }
  
}
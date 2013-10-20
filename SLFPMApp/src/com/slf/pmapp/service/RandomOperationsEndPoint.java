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

import com.ws.service.xsd.random_schema.GetRandomRequest;
import com.ws.service.xsd.random_schema.GetRandomResponse;

@Endpoint
public class RandomOperationsEndPoint{

    private static final Logger logger = Logger.getLogger(RandomOperationsEndPoint.class);
    private static final String NAMESPACE_URI = "http://ws.com/Service/xsd/random-schema";
 
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetRandomRequest")
    @ResponsePayload
   public GetRandomResponse handleRequest(
         @RequestPayload final GetRandomRequest activateServiceRequest)
         throws Exception {
        GetRandomResponse getRandomResponse = new GetRandomResponse();
        getRandomResponse.setValue(5);
        return getRandomResponse;
    }
  
}
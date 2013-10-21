package com.slf.pmapp.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
 
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.slf.pmapp.service.xsd.resourceimport_schema.GetResourceImportRequest;
 
/**
 * Handles resource import services.
 * <p>
 * This is a Spring MVC @Service. Spring WS can communicate with this service.
 */
@Service("riService")
@Transactional

public class RIService {
	
	public void ImportService(GetResourceImportRequest activateServiceRequest)
	{
		
	}

}

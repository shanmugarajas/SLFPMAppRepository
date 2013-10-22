package com.slf.pmapp.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
 
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.slf.pmapp.models.Resource;
import com.slf.pmapp.persistance.ResourcesDAO;
import com.slf.pmapp.service.xsd.resourceimport_schema.GetResourceImportRequest;
 
/**
 * Handles resource import services.
 * <p>
 * This is a Spring MVC @Service. Spring WS can communicate with this service.
 */
@Service("riservice")
@Transactional

public class RIService {
	
	private Resource impresource;
	
	@Autowired
	private ResourcesDAO resourcesDAO;
	
	private GetResourceImportRequest resourceImport = new GetResourceImportRequest();
	
	@Transactional
	public void ImportService(GetResourceImportRequest activateServiceRequest)
	{
		this.resourceImport = activateServiceRequest;
		
		impresource = new Resource();
		
		impresource.setName(resourceImport.getName());
		impresource.setEmpid(resourceImport.getEmpid());
		//impResource.setDojslf(riService.getResourceImport().getDojslf().toGregorianCalendar().getTime());
		impresource.setEmpstatus(resourceImport.getEmpstatus());
		impresource.setEmail(resourceImport.getEmail());
		//impResource.setPhone(resourceImport.getPhone());
		//impResource.setMobile(resourceImport.getMobile());
		
		resourcesDAO.save(impresource);
	}
	
	public void setImpresource(Resource resource){
		this.impresource = resource;
	}
	
	public Resource getImpresource() {
		  
		  return this.impresource;
		 }

}

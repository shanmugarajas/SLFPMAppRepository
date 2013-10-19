package com.slf.pmapp.email;

import java.util.Map;

import org.apache.velocity.Template;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.ui.velocity.VelocityEngineUtils;

public class TemplateEmailer {

	    private VelocityEngine velocityEngine;

	    public VelocityEngine getVelocityEngine() {
	        return velocityEngine;
	    }

	    public void setVelocityEngine(VelocityEngine velocityEngine) {
	        this.velocityEngine = velocityEngine;
	    }

	    public String getMessage(final String vmSrc,
	            final Map<String, Object> paramMap) {
	         final String text = VelocityEngineUtils.mergeTemplateIntoString(
	                this.velocityEngine, vmSrc, paramMap);
	        return text;
	    }
	    
	    public Template getTemplate(final String vmSrc,
	            final Map<String, Object> paramMap) {
	    	velocityEngine.setProperty("user", paramMap);
	        return  this.velocityEngine.getTemplate(vmSrc);	        
	    }
	}


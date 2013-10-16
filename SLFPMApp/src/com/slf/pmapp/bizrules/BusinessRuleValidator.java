package com.slf.pmapp.bizrules;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.slf.pmapp.models.Resource;
import com.slf.pmapp.models.Track;
import com.slf.pmapp.models.Allocation;
import com.slf.pmapp.models.Request;
import com.slf.pmapp.bizrules.RulesInvoker;


/**
 * @author Venky
 *
 */
@Component("BusinessRuleValidator")
public class BusinessRuleValidator implements Validator
{
	RulesInvoker rulesHandle = new RulesInvoker();
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean supports(Class clazz)
	{
		return Resource.class.isAssignableFrom(clazz);
	}
@Override
	public void validate(Object model, Errors errors)
	{	
		 if (model.toString() == "Resource")
			rulesHandle.validate((Resource) model, errors);
		else if (model.toString() == "Track")
			rulesHandle.validate((Track) model, errors);
		else if (model.toString() == "Allocation")
			rulesHandle.validate((Allocation) model, errors);
		else if (model.toString() == "Request")
			rulesHandle.validate((Request) model, errors);
			
	}
	
}

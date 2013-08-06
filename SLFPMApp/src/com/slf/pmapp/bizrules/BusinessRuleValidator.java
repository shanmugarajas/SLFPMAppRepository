package com.slf.pmapp.bizrules;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.slf.pmapp.models.Resource;
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
	
	}
	
	public void checkBusinessRules(Object model, Errors errors) throws Exception{
	
			rulesHandle.validate((Resource) model, errors);
		}
}

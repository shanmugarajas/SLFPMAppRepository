package com.slf.pmapp.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.apache.commons.collections.Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.slf.pmapp.bizrules.BusinessRuleValidator;
import com.slf.pmapp.models.Resource;
import com.slf.pmapp.persistance.ResourcesDAO;
import com.slf.pmapp.jms.MessageReceiver;
import com.slf.pmapp.jms.MessageSender;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.eclipse.birt.report.engine.api.EngineException;
import com.slf.pmapp.reports.ExecuteReport;

/**
 * @author Venky
 *
 */

@Controller
public class SLFPMAppControllers
{
	
	@Autowired
	private ResourcesDAO resourcesDAO;
		
	@Autowired
	private BusinessRuleValidator validator;
	
	@RequestMapping("/home")
	public String home()
	{
		return "home";
	}
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder) 
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
		
	@RequestMapping("/searchResources")
	public ModelAndView searchResources(@RequestParam(required= false, defaultValue="") String name)
	{
		ModelAndView mav = new ModelAndView("showResources");
		List<Resource> resources = resourcesDAO.searchResources(name.trim());
		mav.addObject("SEARCH_RESOURCES_RESULTS_KEY", resources);
		return mav;
	}
	
	@RequestMapping("/viewTheHome")
	public ModelAndView goToHome()
	{
		ModelAndView mav = new ModelAndView("home");
		return mav;
	}
	
	@RequestMapping("/viewAllResources")
	public ModelAndView getAllResources()
	{
		ModelAndView mav = new ModelAndView("showResources");
		List<Resource> resources = resourcesDAO.getAllResources();
		mav.addObject("SEARCH_RESOURCES_RESULTS_KEY", resources);
		return mav;
	}
	
	@RequestMapping(value="/saveResource", method=RequestMethod.GET)
	public ModelAndView newuserForm()
	{
		ModelAndView mav = new ModelAndView("newResource");
		Resource resource = new Resource();
		mav.getModelMap().put("newResource", resource);
		return mav;
	}
	
	@RequestMapping(value="/saveResource", method=RequestMethod.POST)
	public String create(@ModelAttribute("newResource")Resource resource, BindingResult result, SessionStatus status)
	{
		
		validator.validate(resource, result);
		
		if (result.hasErrors()){
			return "newResource";
		}
		resourcesDAO.save(resource);
		status.setComplete();
		return "redirect:viewAllResources.do";
	}
	
	@RequestMapping(value="/updateResource", method=RequestMethod.GET)
	public ModelAndView edit(@RequestParam("id")Integer id)
	{
		ModelAndView mav = new ModelAndView("editResource");
		Resource resource = resourcesDAO.getById(id);
		mav.addObject("editResource", resource);
		return mav;
	}
	
	@RequestMapping(value="/updateResource", method=RequestMethod.POST)
	public String update(@ModelAttribute("editResource") Resource resource, BindingResult result, SessionStatus status)
	{
		validator.validate(resource, result);
		if (result.hasErrors()){
			return "editResource";
		}
		resourcesDAO.update(resource);
		status.setComplete();
		return "redirect:viewAllResources.do";
	}
	
	
	@RequestMapping("deleteResource")
	public ModelAndView delete(@RequestParam("id")Integer id)
	{
		ModelAndView mav = new ModelAndView("redirect:viewAllResources.do");
		resourcesDAO.delete(id);
		return mav;
	}
	
	@RequestMapping("createReport")
	public ModelAndView createReport()
	{
		
		System.out.println("Controller delegating the report");
		ApplicationContext context=new ClassPathXmlApplicationContext("classpath*:/applicationContext.xml"); 
		
		
		MessageSender sender = (MessageSender) context.getBean("messageSender");
		Map map = new HashMap();
		map.put("Report", "TracksReport");
		sender.send(map);
		ModelAndView mav = new ModelAndView("redirect:viewAllResources.do");
		return mav;
	}
}

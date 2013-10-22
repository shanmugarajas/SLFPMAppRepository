package com.slf.pmapp.controllers;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

//import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.mail.MailException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
import com.slf.pmapp.models.Allocation;
import com.slf.pmapp.models.Track;
import com.slf.pmapp.models.Request;
import com.slf.pmapp.persistance.RequestsDAO;
import com.slf.pmapp.persistance.ResourcesDAO;
import com.slf.pmapp.persistance.AllocationsDAO;
import com.slf.pmapp.persistance.TracksDAO;
import com.slf.pmapp.service.RIService;
import com.slf.pmapp.service.xsd.resourceimport_schema.GetResourceImportRequest;
import com.slf.pmapp.jms.JmsMessageSender;
import com.slf.pmapp.email.AlertMail;
import com.slf.pmapp.email.TemplateEmailer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
	private AllocationsDAO allocationsDAO;
	@Autowired
	private TracksDAO tracksDAO;
	@Autowired
	private RequestsDAO requestsDAO;
	@Autowired
	private BusinessRuleValidator validator;
	@Autowired
	private RIService riservice;
	
	@RequestMapping("/login")
	public String login()
	{
		return "login";
	}
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder) 
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
		
	@RequestMapping("/searchResources")
	public ModelAndView searchResources(@RequestParam(required= false, defaultValue="") String name, @RequestParam(required= true, defaultValue="1")int page, @RequestParam(required= false, defaultValue="3")int pageSize)
	{
		ModelAndView mav = new ModelAndView("showResources");
		List<Resource> resourcerecords = resourcesDAO.searchResources(name.trim());
		mav.addObject("LIST_SIZE", resourcerecords.size());
		mav.addObject("NUM_PAGES", resourcerecords.size()/pageSize);
		List<Resource> resources = resourcesDAO.searchResources(name.trim(), page);
		mav.addObject("SEARCH_RESOURCES_RESULTS_KEY", resources);
		return mav;
	}
	
	@RequestMapping("/searchAllocations")
	public ModelAndView searchAllocations(@RequestParam(required= false, defaultValue="") String ProjectModule, @RequestParam(required= true, defaultValue="1")int page, @RequestParam(required= false, defaultValue="3")int pageSize)
	{
		ModelAndView mav = new ModelAndView("showAllocations");
		List<Allocation> allocationrecords = allocationsDAO.searchAllocations(ProjectModule.trim());
		mav.addObject("LIST_SIZE", allocationrecords.size());
		mav.addObject("NUM_PAGES", allocationrecords.size()/pageSize);
		List<Allocation> allocations = allocationsDAO.searchAllocations(ProjectModule.trim(), page);
		mav.addObject("SEARCH_ALLOCATIONS_RESULTS_KEY", allocations);
		return mav;
	}
	
	@RequestMapping("/viewTheHome")
	public ModelAndView goToHome()
	{
		ModelAndView mav = new ModelAndView("home");
		return mav;
	}
	
	@RequestMapping(value="/viewAllAllocations")
	public ModelAndView getAllAllocations(@RequestParam(required= true, defaultValue="1")int page, @RequestParam(required= false, defaultValue="3")int pageSize)
	{
		ModelAndView mav = new ModelAndView("showAllocations");
		List<Allocation> allocationRecords = allocationsDAO.getAllAllocations();
		mav.addObject("LIST_SIZE", allocationRecords.size());
		mav.addObject("NUM_PAGES", allocationRecords.size()/pageSize);
		List<Allocation> allocations = allocationsDAO.getAllAllocations(page);
		mav.addObject("SEARCH_ALLOCATIONS_RESULTS_KEY", allocations);
		return mav;
	}
	
	@RequestMapping("/viewMyAllocations")
	public ModelAndView getMyAllocations(HttpServletRequest request)
	{
		ModelAndView mav = new ModelAndView("showMyAllocations");
		String userName = "not logged in"; 
	    Principal principal = request.getUserPrincipal();
	    if (principal != null) {
	        userName = principal.getName();
	    } 
		List<Allocation> allocations = allocationsDAO.getMyAllocations(userName.trim());
		mav.addObject("SEARCH_ALLOCATIONS_RESULTS_KEY", allocations);
		return mav;
	}
	
	@RequestMapping(value="/updateAllocation", method=RequestMethod.GET)
	public ModelAndView editAllocation(@RequestParam("id")Integer id)
	{
		ModelAndView mav = new ModelAndView("editAllocation");
		Allocation allocation = allocationsDAO.getById(id);
		mav.addObject("editAllocation", allocation);
		return mav;
	}
	
	@RequestMapping(value="/updateAllocation", method=RequestMethod.POST)
	public String updateAllocation(@ModelAttribute("editAllocation") Allocation allocation, BindingResult result, SessionStatus status)
	{
		validator.validate(allocation, result);
		if (result.hasErrors()){
			return "editAllocation";
		}
		
		allocationsDAO.update(allocation);
		status.setComplete();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) auth.getPrincipal();
		String userRole = userDetails.getAuthorities().toString().trim();
		System.out.println("User Role: " + userRole);
		
		if (userRole.contains("ROLE_ADMIN"))
			return "redirect:viewAllAllocations.do";
		else
			return "redirect:viewMyAllocations.do";
	}
	
	
	@RequestMapping("/viewAllResources")
	public ModelAndView getAllResources(@RequestParam(required= true, defaultValue="1")int page, @RequestParam(required= false, defaultValue="10")int pageSize)
	{	
		ModelAndView mav = new ModelAndView("showResources");
		List<Resource> resourceRecords = resourcesDAO.getAllResources();
		mav.addObject("LIST_SIZE", resourceRecords.size());
		mav.addObject("NUM_PAGES", resourceRecords.size()/pageSize);
		List<Resource> resources = resourcesDAO.getAllResources(page);
		mav.addObject("SEARCH_RESOURCES_RESULTS_KEY", resources);
		return mav;
	}
	
	@RequestMapping("/viewMyResources")
	public ModelAndView getMyResources(HttpServletRequest request)
	{
		ModelAndView mav = new ModelAndView("showMyResources");
		String userName = "not logged in"; 
	    Principal principal = request.getUserPrincipal();
	    if (principal != null) {
	        userName = principal.getName();
	    } 
		List<Resource> resources = resourcesDAO.getMyResources(userName.trim());
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
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) auth.getPrincipal();
		String userRole = userDetails.getAuthorities().toString().trim();
		System.out.println("User Role: " + userRole);
		
		if (userRole.contains("ROLE_ADMIN"))
			return "redirect:viewAllResources.do";
		else
			return "redirect:viewMyResources.do";
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
		JmsMessageSender sender = (JmsMessageSender) context.getBean("jmsMessageSender");
		Map map = new HashMap();
		map.put("Report", "TracksReport");
		sender.send(map);
		ModelAndView mav = new ModelAndView("redirect:viewAllResources.do");
		return mav;
	}
	
	
	@RequestMapping("/viewAllTracks")
	public ModelAndView getAllTracks()
	{
		ModelAndView mav = new ModelAndView("showTracks");
		List<Track> tracks = tracksDAO.getAllTracks();
		mav.addObject("SEARCH_TRACKS_RESULTS_KEY", tracks);
		return mav;
	}
	
	@RequestMapping(value="/saveTrack", method=RequestMethod.GET)
	public ModelAndView newtrackForm()
	{
		ModelAndView mav = new ModelAndView("newTrack");
		Track track = new Track();
		mav.getModelMap().put("newTrack", track);
		return mav;
	}
	
	@RequestMapping(value="/saveTrack", method=RequestMethod.POST)
	public String createTrack(@ModelAttribute("newTrack")Track track, BindingResult result, SessionStatus status)
	{
		
		validator.validate(track, result);
		
		if (result.hasErrors()){
			return "newTrack";
		}
		tracksDAO.save(track);
		status.setComplete();
		return "redirect:viewAllTracks.do";
	}
	
	@RequestMapping(value="/updateTrack", method=RequestMethod.GET)
	public ModelAndView editTrack(@RequestParam("id")Integer id)
	{
		ModelAndView mav = new ModelAndView("editTrack");
		Track track = tracksDAO.getById(id);
		mav.addObject("editTrack", track);
		return mav;
	}
	
	@RequestMapping(value="/updateTrack", method=RequestMethod.POST)
	public String updateTrack(@ModelAttribute("editTrack") Track track, BindingResult result, SessionStatus status)
	{
		validator.validate(track, result);
		if (result.hasErrors()){
			return "editTrack";
		}
		tracksDAO.update(track);
		status.setComplete();
		return "redirect:viewAllTracks.do";
	}
	
	
	@RequestMapping("deleteTrack")
	public ModelAndView deleteTrack(@RequestParam("id")Integer id)
	{
		ModelAndView mav = new ModelAndView("redirect:viewAllTracks.do");
		tracksDAO.delete(id);
		return mav;
	}
	
	@RequestMapping("/searchTracks")
	public ModelAndView searchTracks(@RequestParam(required= false, defaultValue="") String name)
	{
		ModelAndView mav = new ModelAndView("showTracks");
		List<Track> tracks = tracksDAO.searchTracks(name.trim());
		mav.addObject("SEARCH_TRACKS_RESULTS_KEY", tracks);
		return mav;
	}
	
	
	@RequestMapping(value="/saveAllocation", method=RequestMethod.GET)
	public ModelAndView newallocationForm()
	{
		ModelAndView mav = new ModelAndView("newAllocation");
		Allocation allocation = new Allocation();
		List<Track> tracks = tracksDAO.getAllTracks();
		mav.addObject("DROPDOWN_TRACKS_RESULTS_KEY", tracks);
		List<Resource> resources = resourcesDAO.getAllResources();
		mav.addObject("DROPDOWN_RESOURCES_RESULTS_KEY", resources);
		mav.getModelMap().put("newAllocation", allocation);
		return mav;
	}
	
	@RequestMapping(value="/saveAllocation", method=RequestMethod.POST)
	public String createAllocation(@ModelAttribute("newAllocation")Allocation allocation, BindingResult result, SessionStatus status)
	{
		
		validator.validate(allocation, result);
		
		if (result.hasErrors()){
			return "newAllocation";
		}
		allocationsDAO.save(allocation);
		status.setComplete();
		return "redirect:viewAllAllocations.do";
	}
	
	@RequestMapping("deleteAllocation")
	public ModelAndView deleteAllocation(@RequestParam("id")Integer id)
	{
		ModelAndView mav = new ModelAndView("redirect:viewAllAllocations.do");
		allocationsDAO.delete(id);
		return mav;
	}
	
//Requests controlling
	
	@RequestMapping("/viewAllRequests")
	public ModelAndView getAllRequests()
	{
		ModelAndView mav = new ModelAndView("showRequests");
		List<Request> requests = requestsDAO.getAllRequests();
		mav.addObject("SEARCH_REQUESTS_RESULTS_KEY", requests);
		return mav;
	}
	
	@RequestMapping(value="/saveRequest", method=RequestMethod.GET)
	public ModelAndView newrquestForm()
	{
		ModelAndView mav = new ModelAndView("newRequest");
		Request request = new Request();
		mav.getModelMap().put("newRequest", request);
		return mav;
	}
	
	@RequestMapping(value="/saveRequest", method=RequestMethod.POST)
	public String createRequest(@ModelAttribute("newRequest")Request request, BindingResult result, SessionStatus status)
	{
		
		validator.validate(request, result);
		
		if (result.hasErrors()){
			return "newRequest";
		}
		requestsDAO.save(request);
		status.setComplete();
		
		ApplicationContext xmlBeanFactory = new ClassPathXmlApplicationContext("classpath*:/applicationContext.xml");
		    
	    AlertMail mailsender = (AlertMail) xmlBeanFactory.getBean("AlertMail");
	    try {
			mailsender.sendMail(request.getRequestid(), request.getRequestdate());
		} catch (MailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:viewAllRequests.do";
	}
	
	@RequestMapping(value="/updateRequest", method=RequestMethod.GET)
	public ModelAndView editRequest(@RequestParam("id")Integer id)
	{
		ModelAndView mav = new ModelAndView("editRequest");
		Request request = requestsDAO.getById(id);
		mav.addObject("editRequest", request);
		return mav;
	}
	
	@RequestMapping(value="/updateRequest", method=RequestMethod.POST)
	public String updateRequest(@ModelAttribute("editRequest") Request request, BindingResult result, SessionStatus status)
	{
		validator.validate(request, result);
		if (result.hasErrors()){
			return "editRequest";
		}
		requestsDAO.update(request);
		
		status.setComplete();
		ApplicationContext xmlBeanFactory = new ClassPathXmlApplicationContext("classpath*:/applicationContext.xml");
	    AlertMail mailsender = (AlertMail) xmlBeanFactory.getBean("AlertMail");
	    try {
			mailsender.sendMail(request.getRequestid(), request.getRequestdate());
		} catch (MailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    return "redirect:viewAllRequests.do";
	}
		
	@RequestMapping("/searchRequests")
	public ModelAndView searchRequests(@RequestParam(required= false, defaultValue="") String name)
	{
		ModelAndView mav = new ModelAndView("showRequests");
		List<Request> requests = requestsDAO.searchRequests(name.trim());
		mav.addObject("SEARCH_REQUESTS_RESULTS_KEY", requests);
		return mav;
	}
}

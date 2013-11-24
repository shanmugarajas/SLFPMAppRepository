package com.slf.pmapp.controllers;

import java.security.Principal;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.social.connect.ConnectionData;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.NotConnectedException;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.slf.pmapp.models.IpmFacebookProfile;
import com.slf.pmapp.persistance.IpmFacebookProfileDAO;
import com.slf.pmapp.persistance.ResourcesDAO;
import com.slf.pmapp.social.FriendsList;
import com.slf.pmapp.social.FbConnectionHelper;
import com.slf.pmapp.social.FbOperationsHelper;


@Controller
@SessionAttributes({"profileLink", "profileInfo"})
@Scope("request")
@RequestMapping("connect/fb")
public class FacebookController {
	
	
	private String providerUserId = "None";
	
	private static final Logger logger = LoggerFactory.getLogger(FacebookController.class);
	@Autowired
	private ConnectionRepository userConnectionRepository;
	
	@Autowired
	private FbConnectionHelper fbConnectionHelper;
	
	@Autowired
	private FbOperationsHelper fbOperationsHelper;
	
	@Autowired
	private IpmFacebookProfileDAO ipmfacebookprofileDAO;
	
	private IpmFacebookProfile ipmfacebookprofile = new IpmFacebookProfile();
	
	private static final String SCOPE = "email,offline_access,user_about_me,user_birthday,read_friendlists";
	private static final String REDIRECT_URI = "http://localhost:8080/SLFPMApp";
	private static final String CLIENT_ID = "631539616903082";
	private static final String APP_SECRET = "206b036faddd13e0e0c328fcb2ce12ed";
	private static final String DIALOG_OAUTH = "https://www.facebook.com/dialog/oauth";
	private static final String ACCESS_TOKEN = "https://graph.facebook.com/oauth/access_token";

	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public void signin(HttpServletRequest request, HttpServletResponse response)
               throws Exception {
		try {
			//TODO: if already have a valid access token, no need to redirect, just login
			response.sendRedirect(DIALOG_OAUTH+"?client_id="+CLIENT_ID+
                              "&redirect_uri="+REDIRECT_URI+
                              "&scope="+SCOPE);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value="/profile/{providerUserId}/{facebookAccessToken}" , method = RequestMethod.GET)
	public String getProfile(@PathVariable("facebookAccessToken") String facebookAccessToken, 
                             @PathVariable("providerUserId") String providerUserId,
                             Model model) {
		try {
			
			
		    
			boolean userExistsInRepo = fbConnectionHelper.checkForUserInRepository(providerUserId,userConnectionRepository);
			if(userExistsInRepo) {	
				  fbConnectionHelper.updateExistingConnectionInRepository(providerUserId,facebookAccessToken, userConnectionRepository);
				//fbConnectionHelper.deleteExistingConnection(providerUserId, userConnectionRepository);
				//fbConnectionHelper.addNewConnectionToRepository(providerUserId, facebookAccessToken, userConnectionRepository);
			  } else {
				  fbConnectionHelper.addNewConnectionToRepository(providerUserId, facebookAccessToken, userConnectionRepository);
			  }
			
		    Facebook facebook =userConnectionRepository.getConnection(Facebook.class, providerUserId).getApi();  
			
			model.addAttribute("profileInfoName", facebook.userOperations().getUserProfile().getName());
			model.addAttribute("providerUserId", facebook.userOperations().getUserProfile().getId());
			
			//ipmfacebookprofile.setId(facebook.userOperations().getUserProfile().getId());
			//ipmfacebookprofile.setName(facebook.userOperations().getUserProfile().getName());
			//ipmfacebookprofile.setLink(facebook.userOperations().getUserProfile().getLink());
			//ipmfacebookprofile.setImgurl("http://graph.facebook.com/" + facebook.userOperations().getUserProfile().getId() + "/picture");
			
			//ipmfacebookprofileDAO.save(ipmfacebookprofile);
			
			return "facebook/profile";
		}  catch (NotConnectedException e) {
			return "connect/facebookConnect";
		}
	}
	
	@RequestMapping(value="/getProfileIdintoSession")
	public String getProfileIdintoSession(Model model, HttpServletRequest request){
		String userName = "None"; 
		String accessToken = "";
		
		//if (providerUserId != "None")
		//	return "connect/facebookConnected";
			
		//Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		//User userDet =  (User) auth.getPrincipal();
		userName = "facebook.do"; //userDet.getUsername();
		
		System.out.println("Username retrived is: " + userName);
		
		providerUserId = ipmfacebookprofileDAO.getProfileID(userName).getId();
	    String profileInfoName = fbConnectionHelper.getProfileInfoName(userName, providerUserId);;
	    
	    request.getSession().setAttribute("providerUserId", providerUserId);
	    request.getSession().setAttribute("profileInfoName", profileInfoName);
	    	    
	    System.out.println("Controller time providerUserId set: " + providerUserId);
	    System.out.println("Controller time profileInfoName set: " + profileInfoName);
	    
	    accessToken = fbConnectionHelper.getAccessToken(userName, providerUserId);
		request.getSession().setAttribute("accessToken", accessToken);
		request.setAttribute("accessToken", accessToken);
		System.out.println("Controller time accessToken set: " + accessToken);
		
		
	    return "facebook/providerIDRetrieved";
	}
	
	@RequestMapping(value="/friends/{providerUserId}/{facebookAccessToken}", method = RequestMethod.GET)
	public String getFriends(@PathVariable("facebookAccessToken") String facebookAccessToken, 
			                          @PathVariable("providerUserId") String providerUserId,
			                          Model model, HttpServletRequest request){
		    
		  logger.info("providerUserId = "+providerUserId);
		  logger.info("facebookAccessToken = "+facebookAccessToken); 
		  boolean userExistsInRepo = fbConnectionHelper.checkForUserInRepository(providerUserId,userConnectionRepository);
			if(userExistsInRepo) {	
				 fbConnectionHelper.updateExistingConnectionInRepository(providerUserId,facebookAccessToken, userConnectionRepository);
				
			  } else {
				  fbConnectionHelper.addNewConnectionToRepository(providerUserId, facebookAccessToken, userConnectionRepository);
			  }
		  Facebook facebook =userConnectionRepository.getConnection(Facebook.class, providerUserId).getApi();
		 
		  model.addAttribute("profileInfoName", facebook.userOperations().getUserProfile().getName());
		  model.addAttribute("providerUserId", facebook.userOperations().getUserProfile().getId());
		 
		  request.setAttribute("providerUserId", facebook.userOperations().getUserProfile().getId());
		  request.setAttribute("profileInfoName", facebook.userOperations().getUserProfile().getName());
			
		  FriendsList friendsListDto = fbOperationsHelper.getFriendNames(facebook);
		  model.addAttribute("friendsListDto",friendsListDto);//// for xml
		  model.addAttribute("friendsList",friendsListDto.getFriendsList()); //// for jsp
		  
		  return "facebook/profile";
	}
	
}

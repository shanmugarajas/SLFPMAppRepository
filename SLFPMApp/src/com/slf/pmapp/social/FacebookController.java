package com.slf.pmapp.social;

import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
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


@Controller
@Scope("request")
@RequestMapping("/facebook")
public class FacebookController {
	
	private static final Logger logger = LoggerFactory.getLogger(FacebookController.class);
	@Autowired
	private ConnectionRepository userConnectionRepository;
	
	@Autowired
	private FbConnectionHelper fbConnectionHelper;
	
	@Autowired
	private FbOperationsHelper fbOperationsHelper;
	
	
	@RequestMapping(value="/profile")
	public String getProfile(ModelMap model) {
		try {
			Facebook facebook = userConnectionRepository.getPrimaryConnection(Facebook.class).getApi();		
			model.addAttribute("profileLink", facebook.userOperations().getUserProfile().getLink());
			model.addAttribute("profileInfo", facebook.userOperations().getUserProfile());
			return "facebook/profile";
		}  catch (NotConnectedException e) {
			return "facebook/connect";
		}
	}

	/*
	@RequestMapping(value="/profile/{providerUserId}/{facebookAccessToken}" , method = RequestMethod.GET)
	public String getProfile(@PathVariable("facebookAccessToken") String facebookAccessToken, 
                             @PathVariable("providerUserId") String providerUserId,
                             Model model) {
		try {
			
			
			boolean userExistsInRepo = fbConnectionHelper.checkForUserInRepository(providerUserId,userConnectionRepository);
			if(userExistsInRepo) {	
				  fbConnectionHelper.updateExistingConnectionInRepository(providerUserId,facebookAccessToken, userConnectionRepository);
			  } else {
				  fbConnectionHelper.addNewConnectionToRepository(providerUserId, facebookAccessToken, userConnectionRepository);
			  }
		    Facebook facebook =userConnectionRepository.getConnection(Facebook.class, providerUserId).getApi();  
			model.addAttribute("profileLink", facebook.userOperations().getUserProfile().getLink());
			model.addAttribute("profileInfo", facebook.userOperations().getUserProfile());
			System.out.println("Facebook connection succeeded");
			return "profile";
		}  catch (NotConnectedException e) {
			System.out.println("Facebook connection failed");
			return "facebookConnect";
		}
	}
	
	*/
	
	@RequestMapping(value="/friends/{providerUserId}/{facebookAccessToken}", method = RequestMethod.GET)
	public String getFriends(@PathVariable("facebookAccessToken") String facebookAccessToken, 
			                          @PathVariable("providerUserId") String providerUserId,
			                          Model model){
		
		System.out.println("providerUserId = "+providerUserId);
		System.out.println("facebookAccessToken = "+facebookAccessToken); 
		  boolean userExistsInRepo = fbConnectionHelper.checkForUserInRepository(providerUserId,userConnectionRepository);
			if(userExistsInRepo) {	
				  fbConnectionHelper.updateExistingConnectionInRepository(providerUserId,facebookAccessToken, userConnectionRepository);
			  } else {
				  fbConnectionHelper.addNewConnectionToRepository(providerUserId, facebookAccessToken, userConnectionRepository);
			  }
		  Facebook facebook =userConnectionRepository.getConnection(Facebook.class, providerUserId).getApi();
		 
		  FriendsList friendsListDto = fbOperationsHelper.getFriendNames(facebook);
		  model.addAttribute("friendsListDto",friendsListDto);//// for xml
		  model.addAttribute("friendsList",friendsListDto.getFriendsList()); //// for jsp
		  
		  return "friends";
	}
	
}
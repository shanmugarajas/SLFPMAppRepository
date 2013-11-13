package com.slf.pmapp.controllers;

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

import com.slf.pmapp.social.FriendsList;
import com.slf.pmapp.social.FbConnectionHelper;
import com.slf.pmapp.social.FbOperationsHelper;


@Controller
@Scope("request")
@RequestMapping("/fb")
public class FacebookController {
	
	private static final Logger logger = LoggerFactory.getLogger(FacebookController.class);
	@Autowired
	private ConnectionRepository userConnectionRepository;
	
	@Autowired
	private FbConnectionHelper fbConnectionHelper;
	
	@Autowired
	private FbOperationsHelper fbOperationsHelper;
	
	

	@RequestMapping(value="/profile/{providerUserId}/{facebookAccessToken}" , method = RequestMethod.GET)
	public String getProfile(@PathVariable("facebookAccessToken") String facebookAccessToken, 
                             @PathVariable("providerUserId") String providerUserId,
                             Model model) {
		try {
			
			providerUserId = "100007063864816";
			facebookAccessToken = "CAAIZBYcaG76oBAJWvv9EAxHkmG6NHqEXE0jCVZClPICdBpoZANX0ZB4kFrYft4MbzgJjebLs8PgLqOOgkmUwWGb2Ngise6LIj0rPV7wJMADY10v7yaksoK60FuZACAVEqfNjlJ20kkNLzc1Mgp4iTZCcWvSoWjEqe8Ngh1yD0JZCHGnEGwD1SYF9K7vKuo32GQZD";
			
			boolean userExistsInRepo = fbConnectionHelper.checkForUserInRepository(providerUserId,userConnectionRepository);
			if(userExistsInRepo) {	
				  fbConnectionHelper.updateExistingConnectionInRepository(providerUserId,facebookAccessToken, userConnectionRepository);
			  } else {
				  fbConnectionHelper.addNewConnectionToRepository(providerUserId, facebookAccessToken, userConnectionRepository);
			  }
		    Facebook facebook =userConnectionRepository.getConnection(Facebook.class, providerUserId).getApi();  
			model.addAttribute("profileLink", facebook.userOperations().getUserProfile().getLink());
			model.addAttribute("profileInfo", facebook.userOperations().getUserProfile());
			return "facebook/profile";
		}  catch (NotConnectedException e) {
			return "connect/facebookConnect";
		}
	}
	
	
	
	@RequestMapping(value="/friends/{providerUserId}/{facebookAccessToken}", method = RequestMethod.GET)
	public String getFriends(@PathVariable("facebookAccessToken") String facebookAccessToken, 
			                          @PathVariable("providerUserId") String providerUserId,
			                          Model model){
		
		  logger.info("providerUserId = "+providerUserId);
		  logger.info("facebookAccessToken = "+facebookAccessToken); 
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
		  
		  return "facebook/friends";
	}
	
}

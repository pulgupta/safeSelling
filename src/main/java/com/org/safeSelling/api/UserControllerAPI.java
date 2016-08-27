package com.org.safeSelling.api;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.org.safeSelling.User;

@RestController
@RequestMapping("/loggedInUser")
public class UserControllerAPI {

	/*
	 * This method will be called from a generic js script page
	 * This page will serve as the master page for the header of the website
	 * If the user is not found or is null we will assume that the user is not logged in 
	 * */
	@RequestMapping(method=RequestMethod.GET)
	public static User getLoggedinUser(){
		User user = new  User();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication(); 
		String userName = auth.getName();
		user.setUserName(userName);
		return user;
	}
	
}

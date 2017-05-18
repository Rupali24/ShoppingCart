package com.niit.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.UsesSunHttpServer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.domain.Category;
import com.niit.shoppingcart.domain.User;


@Controller
public class UserController {
	
	
	private static Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired UserDAO userDAO;
	@Autowired User  user;
	
	
	@Autowired CategoryDAO categoryDAO;
	
	@Autowired  Category  category;
	
	@Autowired  HttpSession session;
	
	
	
	
	//Get the user id and password from login page
	//send these values to userDAO.validate
	//based on response, you can navigate to either login.jps or Home.jsp
	
	//Palvisha - Jayanagar - show home.
	
	//Whenever we configure spring security - we can remove this method
	
	@PostMapping("validate")
	public ModelAndView login(@RequestParam("userName") String id, 
			@RequestParam("password") String password)
	
	{
		
		log.debug("Starting of the method login");
		
		log.info("You are login with the id "+id);
		ModelAndView mv = new ModelAndView("/Home");
		 if(userDAO.validate(id, password)==true)
		 {
			 log.debug("Valid credentials");
			 
			 user = userDAO.get(id);
			 
			 //${message}  - to display in the Home.jsp
			 mv.addObject("message", " Welcom " + user.getName());
			 
			 mv.addObject("categoryList", categoryDAO.list());
			 mv.addObject("category", category);
			 
			 
			 //store the user id in the session
			 session.setAttribute("logedInUserID", id);
			 
			 
			 //check whether user is customer or admin
			 
			 if(user.getRole().equals("ROLE_ADMIN"))
			 {
				 log.debug("You are admin");
				 mv.addObject("isAdmin", "true");
				 session.setAttribute("role", "ROLE_ADMIN");
			 }
			 else
			 {
				 log.debug("You are customer");
				 mv.addObject("isAdmin", "false");
				 session.setAttribute("role", "ROLE_USER");
			 }
			 
			 
		 }
		 else
		 {
			 log.debug("Invalid user");
			 mv.addObject("message", "Invalid credentials..please try again.");
		 }
		 
		 log.debug("Ending of the method login");
		 return mv;
		
	}
	
	
	
	//We need to implement
	//create user
	//update user
	//getAllUsers
	//
	
	
	
	

}


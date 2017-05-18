package com.niit.controller;

import java.util.List;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.domain.Category;
import com.niit.shoppingcart.domain.Product;

@Controller

public class HomeController {
	
	@Autowired(required=true) HttpSession session;
	@Autowired(required=true) Category category;
	@Autowired(required=true) CategoryDAO categoryDAO;
	@Autowired(required=true) Product product;
	@Autowired(required=true) ProductDAO productDAO;
	
	@RequestMapping("/")	
	public ModelAndView goToHome(){
		ModelAndView mv = new ModelAndView("Home");
		mv.addObject("welcome", "thank you");
		
		//get all category
		List <Category> categoryList=categoryDAO.list();
		
		//attAch to session
		session.setAttribute("categoryList",categoryDAO.list());
		session.setAttribute("category", category);

		
		//get all product
				List <Product> productList=productDAO.list();
				
				//attAch to session
				session.setAttribute("productList",productDAO.list());
				session.setAttribute("product", product);
		
		return mv;
	}
	
	@RequestMapping("/Login")
	public String login(Model model){
		model.addAttribute("isValidLogin","true");
		return "Home";
	}
	
	@RequestMapping("/Registration")
	public String register(Model model){
		model.addAttribute("isValidRegister","true");
		return "Home";
	}
}


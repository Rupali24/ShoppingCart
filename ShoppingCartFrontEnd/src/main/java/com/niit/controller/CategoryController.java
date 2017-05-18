package com.niit.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.domain.Category;
import com.niit.shoppingcart.domain.Product;

@Controller
public class CategoryController {
	
	
	private static  Logger log = LoggerFactory.getLogger(CategoryController.class);
	
	
	
	//create category
	//fetch all categories
	//delete category
	//update category
	
	@Autowired  CategoryDAO categorydAO;
	
	@Autowired  Category category;
	
	@Autowired  ProductDAO productDAO;
	
	@Autowired  Product product;
	
	
	@Autowired  HttpSession session;
	
	
	
	//@RequestMapping("/manage_category_add")
	//@GetMapping("/manage_category_add")
	public ModelAndView  createCategory(@RequestParam("id") String id, 
			@RequestParam("name") String name,  @RequestParam("description") String desc)
	{
		
		log.debug("Starting of the method manageCategories");
		category.setId(id);
		category.setName(name);
		category.setDescription(desc);
		
		ModelAndView mv = new ModelAndView("redirect:/manageCategories");
		
		mv.addObject("isAdminClickedCategories", "true");
		mv.addObject("isAdmin", "true");
		
		//Before calling save method, check whether the category id already exist in db or not
		
		//if it is does not exist, then only call save method
		
		if (categorydAO.getCategoryByID(id) !=null)
		{
			//category already exist
			mv.addObject("message", "Category already exist with teh id " +id);
			return mv;
			
		}
		else  // actualy else is not required if return statement is there in if condition
		{
			categorydAO.save(category);
			mv.addObject("message", "Category created successfuly ");
		}
		
		
		/*session.setAttribute("categoryList", categorydAO.list());
		session.setAttribute("category", category);*/
		
	
		
		log.debug("End of the method manageCategories");
		
		return mv;
		
		
		
	}
	
	
	
	
	
	
	
	//@GetMapping("/manage_category_delete/{id}")
	public ModelAndView deleteCategory(@PathVariable("id") String id, int Id, String size)
	{
		
		log.debug("Starting of the method deleteCategory");
		log.debug("You are going to delete " + id);
		ModelAndView mv = new ModelAndView("redirect:/manageCategories");
		
	
		//size = ((Object) productDAO)getAllProductsByCategoryID(id).size();
		if(Id!=0)
		{
			log.debug("Few products are there under this category. you can not delete");
			 mv.addObject("message", size+ " products are there under category" + id +". you can not delete");
			 session.setAttribute("message", size+ " products are there under category" + id +". you can not delete");
			 return mv;
		}
		
		
		
		 if( categorydAO.delete(id))
		 {
			 mv.addObject("message", "successfully deleted the category");
		 }
		 else
		 {
			 mv.addObject("message", "Not able to delte the category");
		 }
		 
			/*session.setAttribute("categoryList", categorydAO.list());
			session.setAttribute("category", category);*/
			
		
			log.debug("Ending of the method deleteCategory");
		 
		 return mv;
		
	}
	//http://localhost:8080/ShoppingCartFrontEnd/manage_category_edit/cat001
	@RequestMapping("/manage_category_edit/{id}")
	public ModelAndView editCategory(@PathVariable("id") String id )
	{
		
		log.debug("Starting of the method editCategory");
		
		log.debug("Going to edit the category : " + id);
		 category=  categorydAO.getCategoryByID(id);
		 //selected category details we have to store in another instance
		 // in ModelAndView instance
		 
		 ModelAndView mv = new ModelAndView("redirect:/manageCategories");
		 session.setAttribute("selectedCategory", category);
		 mv.addObject("selectedCategory", category);
		 log.debug("Ending of the method editCategory");
		 return mv;
		
		
	}
	
	//@GetMapping("/maage_category_edit/manage_category_update")
	//@PostMapping("/manage_category_update")
	public ModelAndView  updateCategory(@RequestParam("id") String id, 
			@RequestParam("name") String name,  @RequestParam("description") String desc)
	{
		
		log.debug("Starting of the method updateCategory");
		category.setId(id);
		category.setName(name);
		category.setDescription(desc);
		
		ModelAndView mv = new ModelAndView("redirect:/manageCategories");
		
		/*mv.addObject("isAdminClickedCategories", "true");
		mv.addObject("isAdmin", "true");*/
		
		//Before calling save method, check whether the category id already exist in db or not
		
		//if it is does not exist, then only call save method
		
		if (categorydAO.getCategoryByID(id) ==null)
		{
			//category does not exist
			mv.addObject("message", "Category does now exist with the id " +id);
			return mv;
			
		}
		else  // actualy else is not required if return statement is there in if condition
		{
			categorydAO.update(category);
			mv.addObject("message", "Category update successfuly ");
		}
		
		
	/*	session.setAttribute("categoryList", categorydAO.list());
		session.setAttribute("category", category);
		*/
	
		
		log.debug("End of the method updateCategory");
		
		return mv;
		
		
		
	}
	
	
}
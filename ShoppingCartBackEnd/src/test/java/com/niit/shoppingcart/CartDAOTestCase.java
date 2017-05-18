package com.niit.shoppingcart;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.CartDAO;
import com.niit.shoppingcart.domain.Cart;

public class CartDAOTestCase {

	@Autowired static AnnotationConfigApplicationContext context;		//ACAC is used to configure Db using Annotations
	
	@Autowired static CartDAO CartDAO;
	
	@Autowired static Cart Cart;
	
	//initialize the above methods
	
	@BeforeClass
	
	public static void initialize(){
		context= new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		//get cartdao from context
		CartDAO=(CartDAO) context.getBean("CartDAO");
		
		//get cart from context
		Cart=(Cart) context.getBean("Cart");
		}
	
	//TestCAses
	
	@Test
	public void createMy_CartTestCase(){
		Cart.setId("10911");
		Cart.setUser_id("aaa");
		Cart.setUser_name("ssdj");
		Cart.setProduct_name("9924569");
		Cart.setPrice(9924);
		Cart.setQuantity(5);
		boolean flag=CartDAO.save(Cart);
		assertEquals("createMy_CartTestCase",true,flag);
		
	}

}

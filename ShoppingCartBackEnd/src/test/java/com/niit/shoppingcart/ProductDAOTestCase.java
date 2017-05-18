package com.niit.shoppingcart;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.domain.Product;

public class ProductDAOTestCase {

	@Autowired static AnnotationConfigApplicationContext context;
	
	@Autowired static ProductDAO productDAO;
	
	@Autowired static Product product;
	
	//initialize above objects
	
	@BeforeClass
	public static void initialize(){
		context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		//get productdao from context
		
		productDAO=(ProductDAO) context.getBean("productDAO");
		
		//get product from context
		
		product=(Product) context.getBean("product");
	}
	
	//TestCases
	@Test
	public void createProductTestCase(){
		product.setId("S222");
		product.setName("mobile");
		product.setDescription("mobile of brand xxx");
		product.setPrice(20000);
		product.setSupplier("s1122");
		product.setCategory("1001");
		boolean flag=productDAO.save(product);
		assertEquals("ceate producttestcase",true,flag);
	}
	
	 @Test
     public void updateProductTestCase(){
		product.setId("S2211");
		product.setName("NOKIA");
		product.setDescription("FOREIGN BASED MOBILE COMPANY");
		product.setPrice(20000);
		product.setSupplier("s1122");
		boolean flag=productDAO.update(product);
		assertEquals("updateProductTestCase",true,flag);
		}
	

	
	@Test
	public void getAllProductTestCase(){
		int actualSize=productDAO.list().size();
		assertEquals(1,actualSize);
	}


}

package com.niit.shoppingcart;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.domain.Supplier;

public class SupplierDAOTestCase {

@Autowired static AnnotationConfigApplicationContext context;
	
	@Autowired static SupplierDAO supplierDAO;
	
	@Autowired static Supplier supplier;
	
	//initialize above objects
	
	@BeforeClass
	public static void initialize(){
		context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		//get supplierdao from context
		
		supplierDAO=(SupplierDAO) context.getBean("supplierDAO");
		
		//get supplierfrom context
		
		supplier=(Supplier) context.getBean("supplier");
	}
	
	//TestCases
	@Test
	public void createSupplierTestCase(){
		supplier.setSupplier_id("S22111");
		supplier.setSupplier_name("mobile");
		supplier.setSupplier_desc("mobile of brand xxx");
		boolean flag=supplierDAO.save(supplier);
		assertEquals("create Suppliertestcase",true,flag);
	}
	
	@Test
	public void updateSupplierTestCase(){
		supplier.setSupplier_id("S2211");
		supplier.setSupplier_name("laptops");
		supplier.setSupplier_desc("mobile of brand xxx");
		boolean flag=supplierDAO.update(supplier);
		assertEquals("create Suppliertestcase",true,flag);
	}
	
}

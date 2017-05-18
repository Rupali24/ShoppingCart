package com.niit.shoppingcart;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.domain.User;

public class UserDAOTestCase {

	
	@Autowired static AnnotationConfigApplicationContext context;
	
	@Autowired  static UserDAO  userDAO;
	
	@Autowired  static User user;
	
	
	@BeforeClass
	public static void initialize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		//get the userDAO from context
		userDAO =  (UserDAO) context.getBean("userDAO");
		
		//get the user from context
		
		user = (User)context.getBean("user");
		
	}
	
	@Test
	public void createUserTestCase()
	{
		user.setId("S100");
		user.setName("SEJAL");
		user.setPassword("sejal");
		user.setRole("ROLE_USER");
		user.setContact("8778787979");
		boolean flag =  userDAO.save(user);
	

				assertEquals("createUser TestCase  abcd",true,flag);
		
	}
	
	
	@Test
	public void updateUserTestCase()
	{
		user.setId("100");
		user.setName("RUPESH");
		user.setPassword("rupesh");
		user.setRole("ROLE_ADMIN");
		user.setContact("8888888");
		boolean flag =  userDAO.update(user);
	

		
		assertEquals(" update user test case",true,flag);
		
	}
	
	@Test
	public void validateUSerTestCase()
	{
		
		boolean flag =  userDAO.validate("RUPESH", "RUPESH");
		
		
		assertEquals(true, flag);
		
	}
	
	@Test
	public void getAllUserTestCase()
	{
		int actualSize=   userDAO.list().size();
		
		
		assertEquals(12, actualSize);
	}
	
	
}




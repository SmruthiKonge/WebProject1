package com.niit.shoppingcart.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.UserLoginDAO;
import com.niit.shoppingcart.model.UserDetails;

public class TestUserLoginDAO {

	/*@Test
	public void test() {
		fail("Not yet implemented");
	}
*/
	//beans:- UserDetails & UserDetailsDAO from context
	
	@Autowired
	UserLoginDAO userLoginDAO;
	
	@Autowired
	UserDetails userDetails;
	
	AnnotationConfigApplicationContext context;

	
	
	@Before
	public void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		userLoginDAO = (UserLoginDAO) context.getBean("userLoginDAO");
		userDetails = (UserDetails) context.getBean("userDetails");
		
	}
	
	@Test
	public void UsersTestCase()
	{
		int size = userLoginDAO.list().size();
		
		assertEquals("User list test case",4,size);
		
	}
}

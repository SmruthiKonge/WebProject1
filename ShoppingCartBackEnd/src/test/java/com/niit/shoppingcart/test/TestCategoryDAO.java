package com.niit.shoppingcart.test;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.model.Product;


public class TestCategoryDAO {

	/*@Test
	public void test() {
		fail("Not yet implemented");
	}*/

	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	Product product;
	
	AnnotationConfigApplicationContext context;
	
	@Before
	public void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
		product = (Product) context.getBean("product");
		
	}
	
	@Test
	public void UsersTestCase()
	{
		int size = categoryDAO.listCategory().size();
		
		assertEquals("category list test case",3,size);
		
	}
}

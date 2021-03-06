package com.niit.shoppingcart.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.model.Product;

public class ProductTest {
	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();

		Product product =(Product) context.getBean("product");
		ProductDAO productDAO = (ProductDAO)context.getBean("productDAO");
		
		product.setProductId("PROD104");
		product.setProductName("Laptop");
		product.setDescription("This is  laptop product");
		product.setPrice(78.95);
		
		productDAO.saveOrUpdate(product);
		System.out.println(productDAO.listProduct());
		
		if(productDAO.get("PROD104")!=null)
		{
			System.out.println("Product Exist");
		}
		else
		{
			System.out.println("Product not Exists");
		}
		
		
		//productDAO.delete("PROD102");
		
		
		
	}
}
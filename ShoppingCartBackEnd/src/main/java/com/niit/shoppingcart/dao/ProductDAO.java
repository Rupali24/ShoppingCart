package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.domain.Product;

public interface ProductDAO {

	public List<Product> list();
	
	public List<Product> getAll(); 
	
	public Product get(String id);

	public boolean save(Product product);

	public boolean update(Product product);
	
	public boolean delete(String id);
	
	public List<String> productnames();

	public List<Product> getSimilarProducts(String search_string);

	public void delete1(String id);

}
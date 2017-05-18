package com.niit.shoppingcart.dao;

import java.util.List;

public interface CartDAO<Cart> {
	public boolean save(Cart c);
	public boolean update(Cart c);
	public List<Cart> list();
	public Cart get(String id);
	public Object getTotalAmount(String loggedInUserid);

}
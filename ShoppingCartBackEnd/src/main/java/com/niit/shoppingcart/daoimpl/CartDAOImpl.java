package com.niit.shoppingcart.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.dao.CartDAO;
import com.niit.shoppingcart.domain.Cart;



@Component
@Repository("CartDAO")
@Transactional
public class CartDAOImpl implements CartDAO{
	@Autowired
	private SessionFactory sessionFactory;
	
	//user defined constructor with one argument

	public CartDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	
	
	public boolean save(Cart cart) {
	try{
		sessionFactory.getCurrentSession().save(cart);		//getCurrentSession will establish connection to existing DB 
	}
	catch(Exception e){
		e.printStackTrace();								//printStackTrace will print all the exceptions.
		return false;
	}
	return true;
	}


	public boolean update(Cart cart) {
		try{
			sessionFactory.getCurrentSession().update(cart);
		}
		catch(Exception e){
			e.printStackTrace();
			return true;
		}
		return false;
		}
	
	
	@SuppressWarnings("unchecked")
	
	public List<Cart> list() {
		return sessionFactory.getCurrentSession().createQuery("from cart").list();
	}
	
	
	public Cart get(String id)
	{													
		return (Cart) sessionFactory.getCurrentSession().get(Cart.class,id);			
		
	}

	
}



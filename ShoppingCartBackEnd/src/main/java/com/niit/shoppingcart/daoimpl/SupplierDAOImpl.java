package com.niit.shoppingcart.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.domain.Supplier;
@Component
@Repository("supplierDAO")
@Transactional
public class SupplierDAOImpl implements SupplierDAO{
	@Autowired
	private SessionFactory sessionFactory;
	
	//user defined constructor with one argument

	public SupplierDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	
	
	
	
	public boolean save(Supplier supplier) {
	try{
		sessionFactory.getCurrentSession().save(supplier);		//getCurrentSession will establish connection to existing DB 
	}
	catch(Exception e){
		e.printStackTrace();								//printStackTrace will print all the exceptions.
		return false;
	}
	return true;
	}


	public boolean update(Supplier supplier) {
		try{
			sessionFactory.getCurrentSession().update(supplier);
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
		}
	
	
	@SuppressWarnings("unchecked")
	
	public List<Supplier> list() {
		return sessionFactory.getCurrentSession().createQuery("from Supplier").list();
	}
	
	
	public Supplier get(String id){															//get method will return object
		return (Supplier) sessionFactory.getCurrentSession().get(Supplier.class, id);			//return(User)-->typecast the User into object
		
	}

	


}

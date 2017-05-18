package com.niit.shoppingcart.daoimpl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.domain.Product;
import com.niit.shoppingcart.domain.Product;


@Repository("productDAO")
public class ProductDAOImpl implements ProductDAO,Serializable {
	

	
	
	@Autowired
	private SessionFactory sessionFactory;

	public ProductDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<Product> list() {

		String hql = "from Product";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	@Transactional
	public boolean save11(Product product) {

		try {
			if (get1(product.getId()) != null) {
				return false;
			}

			product = (Product) sessionFactory.getCurrentSession().merge(product);
			sessionFactory.getCurrentSession().save(product);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}

	}

	@Transactional
	public boolean update1(Product Product) {
		try {
			if (get1(Product.getId()) == null) {
				return false;
			}
			Product = (Product) sessionFactory.getCurrentSession().merge(Product);
			sessionFactory.getCurrentSession().update(Product);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();

			return false;
		}
	}

	@Transactional
	public boolean delete(Product Product) {
		try {
			if (get1(Product.getId()) != null) {
				Product = (Product) sessionFactory.getCurrentSession().merge(Product);
				sessionFactory.getCurrentSession().delete(Product);
				return true;
			} else {
				return false;
			}
		} catch (HibernateException e) {

			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	  public Product get1(String id) {
		return (Product) sessionFactory.getCurrentSession() .get(Product.class,id);
		}

	public boolean save1(com.niit.shoppingcart.domain.Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean update11(com.niit.shoppingcart.domain.Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	public com.niit.shoppingcart.domain.Product getProductByID(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public com.niit.shoppingcart.domain.Product getProductByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Product> listByProductAndSubProduct(String productId, String subProductId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Product> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Product get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean save(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean update(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete1(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<String> productnames() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Product> listByProductAndSubProduct1(String ProductId, String subProductId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Product> listByCategoryAndSubCategory(String categoryId, String subCategoryId) {
		// TODO Auto-generated method stub
		return null;
	}
}

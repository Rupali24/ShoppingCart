package com.niit.shoppingcart.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="Supplier")
@Component
public class Supplier {
	@Id
	@Column(name="supplier_id")
	private String supplier_id;
	@Column(name="supplier_name")
	private String supplier_name;
	@Column(name="supplier_desc")
	private String supplier_desc;
	
	@OneToMany(mappedBy="supplier",fetch = FetchType.EAGER)
	private Set<Product> products;
	
		public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	
	public String getSupplier_id() {
		return supplier_id;
	}
	public void setSupplier_id(String supplier_id) {
		this.supplier_id = supplier_id;
	}
	public String getSupplier_name() {
		return supplier_name;
	}
	public void setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
	}
	public String getSupplier_desc() {
		return supplier_desc;
	}
	public void setSupplier_desc(String supplier_desc) {
		this.supplier_desc = supplier_desc;
	}
	
}

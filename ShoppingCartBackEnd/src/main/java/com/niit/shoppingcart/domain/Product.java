package com.niit.shoppingcart.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="Product")
@Component
public class Product {
	@Id
	@Column(name="id")
	private String id;
	@Column(name="name")
	private String name;
	@Column(name="description")
	private String description;
	@Column(name="price")
	private int price;
	@Column(name="category_id")
	private String category_id;
	@Column(name="supplier_id")
	private String supplier_id;
	
	

	@ManyToOne
	@JoinColumn(name="category_id", updatable = false, insertable = false, nullable = false)
	private Category category;
	
	@ManyToOne
	@JoinColumn(name="supplier_id", updatable = false, insertable = false, nullable = false)
	private Supplier supplier;
	
	/*
			//@Manytoone (fetch = FetchType.EAGER,cascade=CAscadeType.ALL)   cascadetype.ALL is used instead of updatable insertable n nullable
	
	//@Transient				to access image directly from local machine n not from DB then @Transient is used
	
	//private MultipartFile image;
	//generate gettr n setter
	//private MultipartFile getImage(){
	//	return image;
	//}
	//public void setImage(MultipartFile image){
		//this.image = image;
	//}
	
	*/
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getCategory() {
		return category_id;
	}
	public void setCategory(String category) {
		this.category_id = category;
	}
	public String getSupplier() {
		return supplier_id;
	}
	public void setSupplier(String supplier_id) {
		this.supplier_id = supplier_id;
	}
	
	
	
}
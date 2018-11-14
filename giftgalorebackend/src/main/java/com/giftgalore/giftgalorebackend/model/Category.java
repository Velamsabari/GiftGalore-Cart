package com.giftgalore.giftgalorebackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Category {

	
	@Column(nullable=false,unique=true)
	@NotBlank(message="Category Name is mandatory")

	private String category_Name;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int category_id;
	
	
	
	@Column(nullable=false,columnDefinition="text")
	@NotBlank(message="Category Description is mandatory")
	private String categoryDesc;



	public String getCategory_Name() {
		return category_Name;
	}



	public void setCategory_Name(String category_Name) {
		this.category_Name = category_Name;
	}



	public int getCategory_id() {
		return category_id;
	}



	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}



	public String getCategoryDesc() {
		return categoryDesc;
	}



	public void setCategoryDesc(String categoryDesc) {
		this.categoryDesc = categoryDesc;
	}

}


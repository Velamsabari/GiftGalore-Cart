package com.giftgalore.giftgalorebackend.model;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;


@Entity
public class MyProduct {
		    
		@Column(nullable=false)
		@NotBlank(message="Product Name is mandatory")
		private String product_Name;
		
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private int product_id;
  	
		@Column(nullable=false,columnDefinition="text")
		@NotBlank(message="Product Description is mandatory")

		private String productDesc;
		
		@ManyToOne
		@OnDelete(action=OnDeleteAction.CASCADE)
		private Category category;
		
		@Column(nullable=false)
		@NotNull(message="Quantity is mandatory")
		private int quantity;
		
		@Column(nullable=false)
		@NotNull(message="Price is mandatory")
		@Min(value=100,message="Minimum Rs.100/pices")
		private int price;
		
		
		@Transient
		MultipartFile pimage;


		public String getProduct_Name() {
			return product_Name;
		}


		public void setProduct_Name(String product_Name) {
			this.product_Name = product_Name;
		}


		public int getProduct_id() {
			return product_id;
		}


		public void setProduct_id(int product_id) {
			this.product_id = product_id;
		}


		public String getProductDesc() {
			return productDesc;
		}


		public void setProductDesc(String productDesc) {
			this.productDesc = productDesc;
		}


		public Category getCategory() {
			return category;
		}


		public void setCategory(Category category) {
			this.category = category;
		}


		public int getQuantity() {
			return quantity;
		}


		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}


		public int getPrice() {
			return price;
		}


		public void setPrice(int price) {
			this.price = price;
		}


		public MultipartFile getPimage() {
			return pimage;
		}


		public void setPimage(MultipartFile pimage) {
			this.pimage = pimage;
		}

		
		


}

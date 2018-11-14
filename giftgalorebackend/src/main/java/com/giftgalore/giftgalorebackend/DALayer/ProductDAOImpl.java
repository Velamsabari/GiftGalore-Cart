package com.giftgalore.giftgalorebackend.DALayer;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.giftgalore.giftgalorebackend.model.Category;
import com.giftgalore.giftgalorebackend.model.Product;


@Repository
@Transactional
public class ProductDAOImpl implements ProductDAO {

		@Autowired
		SessionFactory sessionfactory;

		public boolean CreateProduct(Product product) {
			try
			{
				sessionfactory.getCurrentSession().save(product);
				return true;
			}
			catch (Exception e) {
				return false;
			}
			
			
		}

		public boolean UpdateProduct(Product product) {
			try
			{
				sessionfactory.getCurrentSession().update(product);
				return true;
			}
			catch (Exception e) {
				return false;
			}
			
			
		}

		public boolean DeleteProduct(Product product) {
			try
			{
				sessionfactory.getCurrentSession().delete(product);
				return true;
			}
			catch (Exception e) {
				return false;
			}
		}

		public Product SelectProduct(int Product_id) {
			try {
				System.out.println("df");
				return (Product) sessionfactory.getCurrentSession()
						.createQuery("from Product where product_id='"+Product_id+"'").uniqueResult();
			}

			catch (Exception e) {
				System.out.println("ef");
				return null;
			}
			
		}

		public List<Product> SelectAllProduct() {
			try {
				
				return sessionfactory.getCurrentSession()
						.createQuery("from Product").list();
			}

			catch (Exception e) {
				
				return null;
			}
			
		}

		public List<Product> SelectCatProduct(String Category_Name) 
		{
			try {
				Category C=	(Category)sessionfactory.getCurrentSession().createQuery("from Category where Category_Name='"+Category_Name+"'").uniqueResult();
				return sessionfactory.getCurrentSession()
						.createQuery("from Product where Category_category_id="+C.getCategory_id()).list();
			}

			catch (Exception e) {
				
				return null;
			}
		}
	}
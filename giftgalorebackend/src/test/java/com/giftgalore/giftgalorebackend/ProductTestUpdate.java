//package com.giftgalore.giftgalorebackend;
//
//import static org.junit.Assert.*;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.giftgalore.giftgalorebackend.DALayer.CategoryDAO;
//import com.giftgalore.giftgalorebackend.DALayer.ProductDAO;
//import com.giftgalore.giftgalorebackend.model.Category;
//import com.giftgalore.giftgalorebackend.model.Product;
//
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringJUnitConfig(value=DBConfig.class)
//public class ProductTestUpdate {
//	@Autowired
//	ProductDAO productDAOImpl;
//	
//	@Autowired
//	CategoryDAO categoryDAOImpl;
//	Product p;
//
//	@Before
//	public void setUp() throws Exception {
////		p=new Product();
////		p.setProduct_Name("Fenshui Toys");
////		p.setProductDesc("white");
////		p.setCategory(categoryDAOImpl.ViewOneCategory("Toys"));
////		p.setPrice("700");
////		p.setQuantity("3");
//	}
//	
//
//	@After
//	public void tearDown() throws Exception {
//	}
//
//	@Test
//	public void test() {
//		//productDAOImpl.CreateProduct(p);
//		Product p1=productDAOImpl.SelectProduct("Fenshui Toys");
//		p1.setProductDesc("ghtfyt");
//		assertEquals("Success", true, productDAOImpl.UpdateProduct(p1));
//	}
//}

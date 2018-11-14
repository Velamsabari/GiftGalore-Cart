//package com.giftgalore.giftgalorebackend;
//import static org.junit.Assert.*;
//
//import java.util.List;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import com.giftgalore.giftgalorebackend.DALayer.CategoryDAO;
//import com.giftgalore.giftgalorebackend.DALayer.ProductDAO;
//import com.giftgalore.giftgalorebackend.model.Category;
//import com.giftgalore.giftgalorebackend.model.Product;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringJUnitConfig(value=DBConfig.class)
//
//public class ProductTest {
//	@Autowired
//	ProductDAO productDAOImpl;
//	
//	@Autowired
//	CategoryDAO categoryDAOImpl;
//	
//	Category c;
//	
//	Product p;
//	
//
//	@Before
//	public void setUp() throws Exception
//	{
//		c=new Category();
//		c.setCategory_Name("hgyf");
//		c.setCategoryDesc("new");
//		categoryDAOImpl.CreateCategory(c);
//		p=new Product();
//		p.setProduct_Name("Fenshui Toys");
//		p.setProductDesc("white");
//		p.setCategory(categoryDAOImpl.ViewOneCategory("hgyf"));
//		p.setPrice("700");
//		p.setQuantity("3");
//		productDAOImpl.CreateProduct(p);
//	}
//	
//
//	@After
//	public void tearDown() throws Exception
//	{
//		categoryDAOImpl.DeleteCategory("hgyf");
//	}
//
//	@Test
//	public void test() 
//	{
//	List<Product> p=productDAOImpl.SelectCatProduct("hgyf");
//	System.out.println(p.size());
//	}
//
//}

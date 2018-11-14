//package com.giftgalore.giftgalorebackend;
//import static org.junit.Assert.assertEquals;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import com.giftgalore.giftgalorebackend.DALayer.CategoryDAO;
//import com.giftgalore.giftgalorebackend.model.Category;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringJUnitConfig(value=DBConfig.class)
//public class CategoryTest {
//	@Autowired
//	CategoryDAO categoryDAOImpl;
//	Category c;
//	
//	@Before
//	public void setUp() throws Exception {
//		c=new Category();
//		c.setCategory_Name("hgyf");
//		c.setCategoryDesc("new");
//
//	}
//
//	@After
//	public void tearDown() throws Exception {
//		 categoryDAOImpl.DeleteCategory("hgyf");
//	}
//
//	@Test
//	public void test() {
//		assertEquals("Success", true, categoryDAOImpl.CreateCategory(c));
////		assertEquals("Success", true, categoryDAOImpl.CreateCategory(c));
//	}
//
//}

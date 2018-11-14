//package com.giftgalore.giftgalorebackend;
//import static org.junit.Assert.*;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import com.giftgalore.giftgalorebackend.DALayer.UserDAO;
//import com.giftgalore.giftgalorebackend.model.UserDetails;
//
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringJUnitConfig(value=DBConfig.class)
//public class UserTest {
//	@Autowired
//	UserDAO UserDAOImpl;
//	
//	UserDetails u;
//
//	@Before
//	public void setUp() throws Exception {
//		u=new UserDetails();
//		u.setEmailid("anns@gmail");
//		u.setMobileno("9876543210");
//		u.setUser_name("velam");
//		u.setUser_password("df4#GFdg");
//	}
//
//	@After
//	public void tearDown() throws Exception {
//		UserDAOImpl.DeleteUserDetails(u);
//	}
//
//	@Test
//	public void test() 
//	{
//		assertEquals("Success", true, UserDAOImpl.CreateUserDetails(u));
//		
//	}
//
//}

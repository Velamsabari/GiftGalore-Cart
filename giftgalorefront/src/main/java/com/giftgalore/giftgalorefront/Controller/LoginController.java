package com.giftgalore.giftgalorefront.Controller;

import java.util.Collection;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.giftgalore.giftgalorebackend.DALayer.CartDAO;
import com.giftgalore.giftgalorebackend.DALayer.ProductDAO;
import com.giftgalore.giftgalorebackend.DALayer.UserDAO;
import com.giftgalore.giftgalorebackend.model.UserDetails;

@Controller
public class LoginController
{
	@Autowired
	UserDAO userdao;
	
	@Autowired
	CartDAO cartdao;
	
	@Autowired
	ProductDAO productdao;

	@RequestMapping(value = { "/Login" })
	public String loginpage(Model m) {
		m.addAttribute("error", false);
		m.addAttribute("loginpage", true);
		m.addAttribute("title", "GiftGalore-Login");
		return "index";

	}

	@RequestMapping(value = { "/flogin" })
	public String errorloginpage(Model m) {
		m.addAttribute("error", true);
		m.addAttribute("loginpage", true);
		m.addAttribute("title", "GiftGalore-Login");
		return "index";
	}
	
	
	@RequestMapping("/loginsuccess")
	public String isLoggedin(HttpSession session) 
	{
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		@SuppressWarnings("unchecked")
		Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) SecurityContextHolder.getContext()
				.getAuthentication().getAuthorities();
		for (GrantedAuthority authority : authorities) 
		{
			if (authority.getAuthority().equals("ROLE_USER")) 
			{
				UserDetails customer = userdao.SelectUser(email);
				session.setAttribute("useremail", customer.getEmailid());
				session.setAttribute("usercartid", customer.getCart_id());
				session.setAttribute("username",customer.getUser_name());
				session.setAttribute("userlogin", true);
				if(session.getAttribute("proid")!=null)
				{
					return "redirect:/addToCart?pid="+Integer.parseInt(session.getAttribute("proid").toString());
				}
				else
				{
					return "redirect:/";
				}
			} 
			else 
			{
				session.setAttribute("username","Administrator");
				session.setAttribute("userlogin", false);
				return "redirect:/";
			}
		}
		return "redirect:/";
		
	}

}

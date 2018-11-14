package com.giftgalore.giftgalorefront.Controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.giftgalore.giftgalorebackend.DALayer.UserDAO;
import com.giftgalore.giftgalorebackend.model.UserDetails;


@Controller
public class UserController {
	
	@Autowired
	UserDAO userdao;

	@RequestMapping(value= {"/Register"})
	public String registerpage(Model m) {
			m.addAttribute("registerpage",true);
		m.addAttribute("title","GiftGalore-Register");
		m.addAttribute("UserDetail",new UserDetails());
		return "index";
			
		}
	
	@RequestMapping("/adduser")
	public String adduser(@Valid @ModelAttribute("UserDetail")UserDetails userdetails,BindingResult BR,Model m)
	{
		if(BR.hasErrors())
		{
			System.out.println("re");
			m.addAttribute("registerpage",true);
			m.addAttribute("title","GiftGalore-Register");
			m.addAttribute("UserDetail",userdetails);
		}
	  
		else
		{
			System.out.println("rere");
			if(userdao.CreateUserDetails(userdetails))
			{
			m.addAttribute("loginpage",true);
			m.addAttribute("title","GiftGalore-Login");
			m.addAttribute("UserDetail",userdetails);
			}
			else
			{
				m.addAttribute("registerpage",true);
				m.addAttribute("title","GiftGalore-Register");
				m.addAttribute("UserDetail", userdetails);
			}
		}
		return "index";
	}
}



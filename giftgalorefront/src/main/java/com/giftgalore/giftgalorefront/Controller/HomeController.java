package com.giftgalore.giftgalorefront.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping(value= {"/","/home"})
	public String homepage(Model m) {
		m.addAttribute("sliderpage",true);
		m.addAttribute("title","GiftGalore-Home");
		return "index";
				}


@RequestMapping(value= {"/Aboutus"})
public String aboutuspage(Model m) {
	m.addAttribute("aboutuspage",true);
	m.addAttribute("title","GiftGalore-Aboutus");
	return "index";
		
	}



@RequestMapping(value= {"/Contactus"})
public String contactuspage(Model m) {
	m.addAttribute("contactuspage",true);
	m.addAttribute("title","GiftGalore-Contactus");
	return "index";
		
	}

}

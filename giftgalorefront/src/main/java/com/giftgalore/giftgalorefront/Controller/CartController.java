package com.giftgalore.giftgalorefront.Controller;

import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.giftgalore.giftgalorebackend.DALayer.CartDAO;
import com.giftgalore.giftgalorebackend.DALayer.ProductDAO;
import com.giftgalore.giftgalorebackend.model.Cart;
import com.giftgalore.giftgalorebackend.model.Product;

@Controller
public class CartController {
	@Autowired
	CartDAO cartdao;

	@Autowired
	ProductDAO productdao;

	@RequestMapping("addToCart")
	String addToCart(@RequestParam("pid") int pid, HttpSession session) {
		if (session.getAttribute("usercartid") != null) {
			Product p = productdao.SelectProduct(pid);
			ArrayList<Cart> cartlist = (ArrayList<Cart>) cartdao
					.ViewCart(Integer.parseInt(session.getAttribute("usercartid").toString()));
			Iterator<Cart> cartiterator = cartlist.listIterator();
			while (cartiterator.hasNext()) {
				Cart cart2 = (Cart) cartiterator.next();
				if (cart2.getPid() == pid) {
					cart2.setQuantity(cart2.getQuantity() + 1);
					cart2.setTotal(cart2.getQuantity() * p.getPrice());
					cartdao.UpdateCart(cart2);
					return "redirect:/AllProduct";
				}
			}
			Cart c = new Cart();
			c.setCartid(Integer.parseInt(session.getAttribute("usercartid").toString()));
			c.setPid(pid);
			c.setQuantity(1);
			c.setProduct_Name(p.getProduct_Name());
			c.setPrice(p.getPrice());
			c.setTotal(p.getPrice());
			cartdao.CreateCart(c);
			return "redirect:/AllProduct";
		} else {
			session.setAttribute("proid", pid);
			return "redirect:/Login";
		}

	}

	
	@RequestMapping("/user/viewCart")
	String viewCart(Model m,HttpSession session) 
	{
		int cartid=Integer.parseInt(session.getAttribute("usercartid").toString());
		m.addAttribute("cartpage", true);
		m.addAttribute("title", "GiftGalore-MyCart");
		m.addAttribute("cartlist", cartdao.ViewCart(cartid));
		return "index";		
	}
}

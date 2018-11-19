package com.giftgalore.giftgalorefront.Controller;

import java.io.File;
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
import com.giftgalore.giftgalorebackend.model.MyProduct;

@Controller
public class CartController {
	@Autowired
	CartDAO cartdao;

	@Autowired
	ProductDAO productdao;

	@RequestMapping("addToCart")
	String addToCart(@RequestParam("pid") int pid, HttpSession session, Model m) {
		if (session.getAttribute("usercartid") != null) {
			MyProduct p = productdao.SelectProduct(pid);
			ArrayList<Cart> cartlist = (ArrayList<Cart>) cartdao
					.ViewCart(Integer.parseInt(session.getAttribute("usercartid").toString()));
			Iterator<Cart> cartiterator = cartlist.listIterator();
			while (cartiterator.hasNext()) {
				Cart cart2 = (Cart) cartiterator.next();
				if (cart2.getPid() == pid) {
					int qty = cart2.getQuantity() + 1;
					if (qty > p.getQuantity()) {
						m.addAttribute("cartpage", true);
						m.addAttribute("title", "GiftGalore-MyCart");
						m.addAttribute("cartlist", cartdao.ViewCart(cart2.getCartid()));
						m.addAttribute("error1", true);
						m.addAttribute("error", false);
						m.addAttribute("stock", p.getQuantity());
						m.addAttribute("pid", cart2.getPid());
						return "index";

					} else {
						if (qty > 3) {
							m.addAttribute("cartpage", true);
							m.addAttribute("title", "GiftGalore-MyCart");
							m.addAttribute("cartlist", cartdao.ViewCart(cart2.getCartid()));
							m.addAttribute("error", true);
							m.addAttribute("error1", false);
							m.addAttribute("pid", cart2.getPid());
							return "index";
						}
						cart2.setQuantity(qty);
						cart2.setTotal(qty * p.getPrice());
						cartdao.UpdateCart(cart2);
						m.addAttribute("cartpage", true);
						m.addAttribute("title", "GiftGalore-MyCart");
						m.addAttribute("cartlist", cartdao.ViewCart(cart2.getCartid()));
						m.addAttribute("error", false);
						m.addAttribute("error1", false);
						return "index";
					}

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
			m.addAttribute("cartpage", true);
			m.addAttribute("title", "GiftGalore-MyCart");
			m.addAttribute("cartlist", cartdao.ViewCart(c.getCartid()));
			m.addAttribute("error", false);
			m.addAttribute("error1", false);
			return "index";

		} else {
			session.setAttribute("proid", pid);
			return "redirect:/Login";
		}

	}

	@RequestMapping("/user/viewCart")
	String viewCart(Model m, HttpSession session) {
		int cartid = Integer.parseInt(session.getAttribute("usercartid").toString());
		m.addAttribute("cartpage", true);
		m.addAttribute("title", "GiftGalore-MyCart");
		m.addAttribute("cartlist", cartdao.ViewCart(cartid));
		m.addAttribute("error", false);
		m.addAttribute("error1", false);
		return "index";
	}

	@RequestMapping("/user/deleteitem")
	public String deleteCart(@RequestParam("itemid") int id) {
		cartdao.DeleteCart(id);
		return "redirect:/user/viewCart";
	}

	@RequestMapping("/user/incqty")
	public String incqty(@RequestParam("itemid") int id, Model m) {
		Cart c = cartdao.Showitem(id);
		int qty = c.getQuantity() + 1;
		int pqty = productdao.SelectProduct(c.getPid()).getQuantity();
		if (qty > pqty) {
			m.addAttribute("cartpage", true);
			m.addAttribute("title", "GiftGalore-MyCart");
			m.addAttribute("cartlist", cartdao.ViewCart(c.getCartid()));
			m.addAttribute("error1", true);
			m.addAttribute("error", false);
			m.addAttribute("stock", pqty);
			m.addAttribute("pid", c.getPid());

			return "index";

		} else {
			if (qty > 3) {
				m.addAttribute("cartpage", true);
				m.addAttribute("title", "GiftGalore-MyCart");
				m.addAttribute("cartlist", cartdao.ViewCart(c.getCartid()));
				m.addAttribute("error", true);
				m.addAttribute("error1", false);
				m.addAttribute("pid", c.getPid());
				return "index";
			} else {
				c.setQuantity(qty);
				c.setTotal(c.getPrice() * qty);
				cartdao.UpdateCart(c);
				return "redirect:/user/viewCart";
			}
		}

	}

	@RequestMapping("/user/decqty")
	public String decqty(@RequestParam("itemid") int id, Model m) {
		Cart c = cartdao.Showitem(id);
		int qty = c.getQuantity() - 1;
		if (qty == 0) {
			m.addAttribute("cartpage", true);
			m.addAttribute("title", "GiftGalore-MyCart");
			m.addAttribute("cartlist", cartdao.ViewCart(c.getCartid()));
			m.addAttribute("error", true);
			m.addAttribute("pid", c.getPid());
			m.addAttribute("error1", false);
			return "index";
		} else {
			c.setQuantity(qty);
			c.setTotal(c.getPrice() * qty);
			cartdao.UpdateCart(c);
			return "redirect:/user/viewCart";
		}
	}

}

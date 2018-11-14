package com.giftgalore.giftgalorefront.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.giftgalore.giftgalorebackend.DALayer.CategoryDAO;
import com.giftgalore.giftgalorebackend.model.Category;


@Controller

public class CategoryController {

	@Autowired
	CategoryDAO categorydao;

	@RequestMapping(value = { "/admin/Category" })
	public String registerpage(Model m) {
		m.addAttribute("categorypage", true);
		m.addAttribute("title", "GiftGalore-Category");
		m.addAttribute("Category", new Category());
		m.addAttribute("catlist", categorydao.ViewAllCategory());
		m.addAttribute("edit", false);
		return "index";

	}

	@RequestMapping("/admin/addcategory")
	public String addcategory(@Valid @ModelAttribute("Category") Category category, BindingResult BR, Model m) {
		if (BR.hasErrors()) {
			System.out.println("1");
			m.addAttribute("categorypage", true);
			m.addAttribute("title", "GiftGalore-Category");
			m.addAttribute("Category", category);
			m.addAttribute("catlist", categorydao.ViewAllCategory());

		}

		else {

			if (categorydao.CreateCategory(category)) {
				System.out.println("2");
				m.addAttribute("categorypage", true);
				m.addAttribute("title", "GiftGalore-Category");
				m.addAttribute("Category", new Category());
				m.addAttribute("catlist", categorydao.ViewAllCategory());
			} else {
				System.out.println("3");
				m.addAttribute("categorypage", true);
				m.addAttribute("title", "GiftGalore-Category");
				m.addAttribute("Category", category);
				m.addAttribute("catlist", categorydao.ViewAllCategory());
			}

		}
		return "index";

	}

	@RequestMapping("/admin/updatecategory")
	public String editcategory(@Valid @ModelAttribute("Category") Category category, BindingResult BR, Model m) {
		if (BR.hasErrors()) {
			System.out.println("1");
			m.addAttribute("categorypage", true);
			m.addAttribute("title", "GiftGalore-Category");
			m.addAttribute("Category", category);
			m.addAttribute("catlist", categorydao.ViewAllCategory());
			m.addAttribute("edit", true);

		}

		else {

			if (categorydao.UpdateCategory(category)) {
				System.out.println("2");
				m.addAttribute("categorypage", true);
				m.addAttribute("title", "GiftGalore-Category");
				m.addAttribute("Category", new Category());
				m.addAttribute("catlist", categorydao.ViewAllCategory());
				m.addAttribute("edit", false);
			} else {
				System.out.println("3");
				m.addAttribute("categorypage", true);
				m.addAttribute("title", "GiftGalore-Category");
				m.addAttribute("Category", category);
				m.addAttribute("catlist", categorydao.ViewAllCategory());
				m.addAttribute("edit", true);
			}

		}
		return "index";

	}

	@RequestMapping("/admin/deletecategory")
	public String deletecategoryt(@RequestParam("cid") String cid) {
		categorydao.DeleteCategory(categorydao.ViewOneCategory(cid));
		return "redirect:/admin/Category";
	}

	@RequestMapping("/admin/editcategory")
	public String editcategoryt(@RequestParam("cid") String cid, Model m) {
		m.addAttribute("categorypage", true);
		m.addAttribute("title", "GiftGalore-Category");
		m.addAttribute("Category", categorydao.ViewOneCategory(cid));
		m.addAttribute("catlist", categorydao.ViewAllCategory());
		m.addAttribute("edit", true);
		return "index";
	}

}
package com.giftgalore.giftgalorefront.Controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.giftgalore.giftgalorebackend.DALayer.CategoryDAO;
import com.giftgalore.giftgalorebackend.DALayer.ProductDAO;
import com.giftgalore.giftgalorebackend.model.MyProduct;



@Controller
public class ProductController {
	@Autowired
	ProductDAO productdao;

	@Autowired
	CategoryDAO catagorydao;

	void addimage(MultipartFile f, int id) {
		try {
			System.out.println("adding img");
			String path = "D:\\StudentProject\\giftgalorefront\\src\\main\\webapp\\resources\\pimages\\";
			path = path + String.valueOf(id) + ".jpg";
			System.out.println(path);
			if (!f.isEmpty()) {
				byte[] imagebytes = f.getBytes();
				File x = new File(path);
				if (x.exists()) {
					x.delete();
					BufferedOutputStream bs = new BufferedOutputStream(new FileOutputStream(x));
					bs.write(imagebytes);
					bs.close();
				} else {
					BufferedOutputStream bs = new BufferedOutputStream(new FileOutputStream(x));
					bs.write(imagebytes);
					bs.close();
				}
			}
			Thread.sleep(5000);
		} catch (Exception e) {

		}

	}

	@RequestMapping(value = { "/admin/Product" })
	public String registerpage(Model m) {
		m.addAttribute("productpage", true);
		m.addAttribute("title", "GiftGalore-Product");
		m.addAttribute("catlist", catagorydao.ViewAllCategory());
		m.addAttribute("prodlist", productdao.SelectAllProduct());
		m.addAttribute("Product", new MyProduct());
		m.addAttribute("edit", false);
		return "index";

	}

	@RequestMapping(value = "/AllProduct")
	public String allproducts(Model m) {
		m.addAttribute("allproductpage", true);
		m.addAttribute("title", "GiftGalore-Products");
		m.addAttribute("prodlist", productdao.SelectAllProduct());
		m.addAttribute("catlist", catagorydao.ViewAllCategory());
		return "index";

	}

	@RequestMapping("/admin/addproduct")
	public String addproduct(@Valid @ModelAttribute("Product") MyProduct product, BindingResult BR, Model m) {
		if (BR.hasErrors()) {
			System.out.println("re");
			m.addAttribute("productpage", true);
			m.addAttribute("title", "GiftGalore-Product");
			m.addAttribute("catlist", catagorydao.ViewAllCategory());
			m.addAttribute("prodlist", productdao.SelectAllProduct());
			m.addAttribute("Product", product);
			m.addAttribute("edit", false);

		}
		else {

			if (productdao.CreateProduct(product)) {
				addimage(product.getPimage(), product.getProduct_id());
				m.addAttribute("productpage", true);
				m.addAttribute("title", "GiftGalore-Product");
				m.addAttribute("catlist", catagorydao.ViewAllCategory());
				m.addAttribute("prodlist", productdao.SelectAllProduct());
				m.addAttribute("Product", new MyProduct());
				m.addAttribute("edit", false);
			} else {
				m.addAttribute("productpage", true);
				m.addAttribute("title", "GiftGalore-Product");
				m.addAttribute("catlist", catagorydao.ViewAllCategory());
				m.addAttribute("prodlist", productdao.SelectAllProduct());
				m.addAttribute("Product", product);
				m.addAttribute("edit", false);
			}

		}
		return "index";

	}

	@RequestMapping("/admin/deleteproduct")
	public String deleteProduct(@RequestParam("pid") int pid) {
		if (productdao.DeleteProduct(productdao.SelectProduct(pid))) {
			String path = "D:\\StudentProject\\giftgalorefront\\src\\main\\webapp\\resources\\pimages\\";
			path = path + String.valueOf(pid) + ".jpg";
			File x = new File(path);
			if (x.exists()) {
				x.delete();
			}
		}
		return "redirect:/admin/Product";
	}

	@RequestMapping("/admin/editproduct")
	public String editproduct(@RequestParam("pid") int pid, Model m) {
		m.addAttribute("productpage", true);
		m.addAttribute("title", "GiftGalore-Product");
		m.addAttribute("Product", productdao.SelectProduct(pid));
		m.addAttribute("catlist", catagorydao.ViewAllCategory());
		m.addAttribute("prodlist", productdao.SelectAllProduct());
		m.addAttribute("edit", true);
		return "index";
	}

	@RequestMapping("/admin/updateproduct")
	public String editproduct(@Valid @ModelAttribute("Product") MyProduct product, BindingResult BR, Model m) {
		if (BR.hasErrors()) {
			System.out.println("1");
			m.addAttribute("productpage", true);
			m.addAttribute("title", "GiftGalore-Product");
			m.addAttribute("Product", product);
			m.addAttribute("prodlist", productdao.SelectAllProduct());
			m.addAttribute("edit", true);

		}

		else {

			if (productdao.UpdateProduct(product)) {
				System.out.println("2");
				addimage(product.getPimage(), product.getProduct_id());
				m.addAttribute("productpage", true);
				m.addAttribute("title", "GiftGalore-Product");
				m.addAttribute("Product", new MyProduct());
				m.addAttribute("catlist", catagorydao.ViewAllCategory());
				m.addAttribute("prodlist", productdao.SelectAllProduct());
				m.addAttribute("edit", false);
			} else {
				System.out.println("3");
				m.addAttribute("productpage", true);
				m.addAttribute("title", "GiftGalore-Product");
				m.addAttribute("Product", product);
				m.addAttribute("catlist", catagorydao.ViewAllCategory());
				m.addAttribute("prodlist", productdao.SelectAllProduct());
				m.addAttribute("edit", true);
			}

		}
		return "index";

	}

	@RequestMapping(value = "/products")
	public String catproducts(Model m, @RequestParam("catname") String name) {
		m.addAttribute("allproductpage", true);
		m.addAttribute("title", "GiftGalore-Products");
		m.addAttribute("prodlist", productdao.SelectCatProduct(name));
		m.addAttribute("catlist", catagorydao.ViewAllCategory());
		return "index";

	}

	@RequestMapping(value = "/OneProduct")
	public String oneproductpage(Model m, @RequestParam("pid") int pid) {
		m.addAttribute("oneproductpage", true);
		m.addAttribute("title", "GiftGalore-Products");
		m.addAttribute("prod", productdao.SelectProduct(pid));
		return "index";

	}

}

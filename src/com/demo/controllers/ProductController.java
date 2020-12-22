package com.demo.controllers;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.demo.entity.Product;
import com.demo.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping(value = { "/", "/index" })
	public String home(HttpSession session) {
		session.removeAttribute("username");
		session.removeAttribute("password");
		return "index";
	}

	@RequestMapping("/listproduct")
	public String product(Model model, HttpSession session, RedirectAttributes redirect) {
		try {
			if (session.getAttribute("name") != null) {
				List<Product> listProducts = productService.listAll();
				model.addAttribute("listProducts", listProducts);
				return "listProduct";
			} else {
				redirect.addFlashAttribute("message", "Bạn chưa đăng nhập, hãy đăng nhập.");
				return "redirect:/login";
			}
		} catch (Exception e) {
			redirect.addFlashAttribute("message", "Bạn chưa đăng nhập, hãy đăng nhập.");
			return "redirect:/login";
		}
	}

	@RequestMapping("/new")
	public String newProductForm(Map<String, Object> model) {
		Product product = new Product();
		model.put("product", product);
		return "newProduct";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveProduct(@Valid @ModelAttribute("product") Product product, BindingResult result,
			RedirectAttributes redirect) {
		if (result.hasErrors()) {
			return "new_product";
		}
		productService.save(product);
		redirect.addFlashAttribute("message", "Thêm thành công sản phẩm id: " + product.getId_product());
		return "redirect:/listproduct";
	}

	@RequestMapping("/edit")
	public ModelAndView editProductForm(@RequestParam long id) {
		ModelAndView mav = new ModelAndView("editProduct");
		Product product = productService.get(id);
		mav.addObject("product", product);

		return mav;
	}

	@RequestMapping("/delete")
	public String deleteProductForm(@RequestParam long id, RedirectAttributes redirect) {
		productService.delete(id);
		redirect.addFlashAttribute("message", "Xóa thành công sản phẩm id: " + id);
		return "redirect:/listproduct";
	}

	@RequestMapping("/search")
	public ModelAndView search(@RequestParam String keyword, ModelMap modelMap) {
		List<Product> result = productService.search(keyword);
		ModelAndView mav = new ModelAndView("search");
		mav.addObject("result", result);
		modelMap.addAttribute("message", keyword);
		return mav;
	}
}

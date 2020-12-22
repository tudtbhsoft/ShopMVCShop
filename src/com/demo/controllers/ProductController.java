package com.demo.controllers;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	public ModelAndView home() {
		List<Product> listProducts = productService.listAll();
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("listProducts", listProducts);
		return mav;
	}

	@RequestMapping("/new")
	public String newProductForm(Map<String, Object> model) {
		Product product = new Product();
		model.put("product", product);
		return "new_product";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveProduct(@Valid @ModelAttribute("product") Product product, BindingResult result,
			RedirectAttributes redirect) {
		if (result.hasErrors()) {
			return "new_product";
		}
		productService.save(product);
		redirect.addFlashAttribute("message", "Thêm thành công sản phẩm id: " + product.getId_product());
		return "redirect:/";
	}

	@RequestMapping("/edit")
	public ModelAndView editProductForm(@RequestParam long id) {
		ModelAndView mav = new ModelAndView("edit_product");
		Product product = productService.get(id);
		mav.addObject("product", product);

		return mav;
	}

	@RequestMapping("/delete")
	public String deleteProductForm(@RequestParam long id, RedirectAttributes redirect) {
		productService.delete(id);
		redirect.addFlashAttribute("message", "Xóa thành công sản phẩm id: " + id);
		return "redirect:/";
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

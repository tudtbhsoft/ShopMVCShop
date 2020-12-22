package com.demo.controllers;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.demo.entity.Product;
import com.demo.entity.User;
import com.demo.service.UserService;
import com.sun.xml.bind.v2.runtime.Name;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@RequestMapping("/registr")
	public String registr(Map<String, Object> model) {
		User customer = new User();
		model.put("registr", customer);
		return "registr";
	}

	@RequestMapping(value = "/saveRegistr", method = RequestMethod.POST)
	public String saveRegistr(@Valid @ModelAttribute("registr") User user, BindingResult result,
			RedirectAttributes redirect) {
		if (result.hasErrors()) {
			return "registr";
		}
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		redirect.addFlashAttribute("message", "Đăng kí tài khoản thành công");
		userService.save(user);
		return "redirect:/login";
	}

	@RequestMapping("/login")
	public String login(Map<String, Object> model) {
		User user = new User();
		model.put("login", user);
		return "login";
	}

	@RequestMapping(value = "/checklogin", method = RequestMethod.POST)
	public String checklogin(User user, ModelMap modelMap, HttpServletRequest request, HttpSession session,
			RedirectAttributes redirect) {
		List<User> list = userService.listAll();
		for (User x : list) {
			if (user.getUsername().equals(x.getUsername())) {
				if (bCryptPasswordEncoder.matches(user.getPassword(), x.getPassword())) {
					session.setAttribute("name", user.getUsername());
					return "/index";
				} else {
					redirect.addFlashAttribute("message", "Bạn nhập sai mật khẩu");
					return "redirect:/login";
				}
			} else {
				continue;
			}
		}
		redirect.addFlashAttribute("message", "Tài khoản không tồn tại");
		return "redirect:/login";
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("name");
		return "redirect:/login";
	}
}

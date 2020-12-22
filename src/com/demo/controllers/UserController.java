package com.demo.controllers;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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
	public String registr(Map<String, Object> model, HttpSession session) {
		session.removeAttribute("username");
		session.removeAttribute("password");
		User customer = new User();
		model.put("registr", customer);
		return "registr";
	}

	@RequestMapping(value = "/saveRegistr", method = RequestMethod.POST)
	public String saveRegistr(@Valid @ModelAttribute("registr") User user, BindingResult result,
			RedirectAttributes redirect) {
		if (result.hasErrors()) {
			return "registr";
		} else {
			List<User> list = userService.listAll();
			for (User x : list) {
				if (user.getUsername().equals(x.getUsername())) {
					redirect.addFlashAttribute("message", "Tài khoản này đã tồn tại");
					userService.save(user);
					return "redirect:/registr";
				} else {
					continue;
				}
			}
			user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
			redirect.addFlashAttribute("message", "Đăng kí tài khoản thành công");
			userService.save(user);
			return "redirect:/login";
		}
	}

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/checklogin", method = RequestMethod.POST)
	public String checklogin(ModelMap modelMap, @RequestParam("username") String username,
			@RequestParam("password") String password, HttpSession session) {
		List<User> list = userService.listAll();
		for (User x : list) {
			if (username.equals(x.getUsername())) {
				if (bCryptPasswordEncoder.matches(password, x.getPassword())) {
					session.setAttribute("name", username);
					session.removeAttribute("username");
					session.removeAttribute("password");
					return "redirect:/listproduct";
				} else {
					session.setAttribute("username", username);
					session.setAttribute("password", username);
					modelMap.addAttribute("message", "Bạn nhập sai mật khẩu");
					return "login";
				}
			} else {
				continue;
			}
		}
		session.setAttribute("username", username);
		session.setAttribute("password", username);
		modelMap.addAttribute("message", "Tài khoản " + username + " không tồn tại");
		return "login";
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("name");
		return "redirect:/login";
	}
}

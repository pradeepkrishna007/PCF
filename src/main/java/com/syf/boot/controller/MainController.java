package com.syf.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.syf.boot.model.User;
import com.syf.boot.model.UserLogin;
import com.syf.boot.service.MvcDemoService;

@Controller
public class MainController {

	@Autowired
	MvcDemoService mvcDemo;

	@RequestMapping("/greeting")
	public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			Model model) {
		model.addAttribute("name", name);
		System.out.println("In Greeting==================== >>");
		return "greeting";
	}

	@RequestMapping("/")
	public String firstPage() {
		System.out.println("In Index==================== >>");
		return "index";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute User user) {
		System.out.println("In Save==================== >>");
		User userResp = mvcDemo.save(user);
		return new ModelAndView("index", "user", userResp);
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute UserLogin userLogin, Model map) {
		System.out.println("In Login==================== >>");
		User userResp = mvcDemo.getDetails(userLogin.getUsername(), userLogin.getPassword());
		System.out.println(userResp);
		map.addAttribute("user", userResp);
		return "data_user";
	}
}

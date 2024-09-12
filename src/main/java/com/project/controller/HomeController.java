package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.Responsitory.ProductResponsitory;
import com.project.service.ProductService;

@Controller
public class HomeController {
	@Autowired
	ProductResponsitory productResponsitory;
	@Autowired
	ProductService productService;
	
	@RequestMapping("/")
	public String home(Model model) {
		
		return "index";
	}
}

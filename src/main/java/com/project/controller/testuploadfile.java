package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.project.service.StorageService;

@Controller
@RequestMapping("/uploadtest")
public class testuploadfile {
	@Autowired
	private StorageService service;

	@GetMapping
	public String test() {
		return "test";
	}

	@PostMapping
	public String save(@RequestParam("file") MultipartFile file) {
		this.service.store(file);
		return "test";
	}
}

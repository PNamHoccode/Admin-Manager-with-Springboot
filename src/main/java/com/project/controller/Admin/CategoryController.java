package com.project.controller.Admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.models.Category;
import com.project.service.CategoryService;

@Controller
@RequestMapping("/admin")
public class CategoryController {
	@Autowired
	CategoryService categoryService;

	@GetMapping("/category")
	public String index(Model model,@Param("keyword") String keyword, @RequestParam(name="page",defaultValue ="1")Integer page) {
		
	//	Page<Category> list = this.categoryService.getAll(page);
		Page<Category> list = this.categoryService.getAll(page);
		if(keyword != null) {
			list= this.categoryService.search(keyword,page);
			model.addAttribute("keyword",keyword);
		}
		model.addAttribute("totalpage",list.getTotalPages());
		model.addAttribute("currentPage",page);
		model.addAttribute("list", list);
		return "admin/category/index";
	}

	@GetMapping("/add-category")
	public String addcategory(Model model) {
		Category category = new Category();
		category.setCategoryStatus(true);
		model.addAttribute("category", category);
		return "admin/category/add";
	}

	@PostMapping("/add-category")
	public String save(@ModelAttribute("category") Category category) {
		if (this.categoryService.create(category)) {
			return "redirect:/admin/category";
		} else {
			return "admin/category/add";
		}

	}

	@GetMapping("/edit-category/{id}")
	public String edit(Model model, @PathVariable("id") Integer id) {
		Category category = this.categoryService.finByID(id);
		model.addAttribute("category", category);
		return "admin/category/edit";
	}

	@PostMapping("/edit-category")
	public String update(@ModelAttribute("category") Category category) {
		if (this.categoryService.create(category)) {
			return "redirect:/admin/category";
		} else {
			return "admin/category/add";
		}
	}
	@GetMapping("/delete-category/{id}")
	public String delete(@PathVariable("id") Integer id) {
		if (this.categoryService.delete(id)) {
			return "redirect:/admin/category";
		} else {
			return "redirect:/admin/category";
		}
		
	}
	@PostMapping("/delete-categories")
	public String deleteCategories(@RequestParam("ids") List<Integer> ids) {
	    if (ids != null && !ids.isEmpty()) {
	        for (Integer id : ids) {
	            this.categoryService.delete(id);
	        }
	    }
	    return "redirect:/admin/category";
	}

	
}

package com.project.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.project.models.Category;

public interface CategoryService {
	List<Category> getAll();
	Boolean create(Category category);
	Category finByID(Integer id);
	Boolean update(Category category);
	Boolean delete(Integer id);
	List<Category> search(String keyword);
	
	Page<Category> getAll(Integer pageNo);
	Page<Category> search(String keyword, Integer pageNo);
}

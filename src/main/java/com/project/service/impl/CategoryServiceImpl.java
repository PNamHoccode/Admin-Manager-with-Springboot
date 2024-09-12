package com.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.project.Responsitory.CategoryRepository;
import com.project.models.Category;
import com.project.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;
	@Override
	public List<Category> getAll() {
		return this.categoryRepository.findAll();
	}

	@Override
	public Boolean create(Category category) {
	    try {
	        this.categoryRepository.save(category);
	        return true;
	    } catch (Exception e) {
	        e.printStackTrace();
	        
	    }
	    return false;
	}


	@Override
	public Category finByID(Integer id) {
		
		return this.categoryRepository.findById(id).get();
	}

	@Override
	public Boolean update(Category category) {
		 try {
		        this.categoryRepository.save(category);
		        return true;
		    } catch (Exception e) {
		        e.printStackTrace();
		        
		    }
		    return false;
	}

	@Override
	public Boolean delete(Integer id) {
		try {
			this.categoryRepository.delete(finByID(id));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false ;
	}

	@Override
	public List<Category> search(String keyword) {
		
		return this.categoryRepository.searchcategory(keyword);
	}

	@Override
	public Page<Category> getAll(Integer pageNo) {
		Pageable page = PageRequest.of(pageNo-1, 3);
		return this.categoryRepository.findAll(page);
	}

	@Override
	public Page<Category> search(String keyword, Integer pageNo) {
		List list = this.search(keyword);
		Pageable pageable = PageRequest.of(pageNo-1, 3);
		Integer start = (int) pageable.getOffset();
		Integer end = (int) ((pageable.getOffset() + pageable.getPageSize()) > list.size()? list.size() : pageable.getOffset()+pageable.getPageSize());
		List subList = list.subList(start, end);
		return new PageImpl(list, pageable,this.search(keyword).size() ) ;
	}


}

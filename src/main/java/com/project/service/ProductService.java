package com.project.service;

import java.util.List;


import com.project.models.product;

public interface ProductService {
	List<product> getAll();
	Boolean create(product product);
	product finByID(Integer id);
	Boolean update(product product);
	Boolean delete(Integer id);
}

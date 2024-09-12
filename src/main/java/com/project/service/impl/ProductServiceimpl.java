package com.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Responsitory.ProductResponsitory;
import com.project.models.product;
import com.project.service.ProductService;

@Service
public class ProductServiceimpl implements ProductService {
	@Autowired
	ProductResponsitory productResponsitory;

	@Override
	public List<product> getAll() {
		// TODO Auto-generated method stub
		return this.productResponsitory.findAll();
	}

	@Override
	public Boolean create(product product) {
		try {
	        this.productResponsitory.save(product);
	        return true;
	    } catch (Exception e) {
	        e.printStackTrace();
	        
	    }
	    return false;
	}

	@Override
	public product finByID(Integer id) {
		return this.productResponsitory.findById(id).get();

	}

	@Override
	public Boolean update(product product) {
		 try {
		        this.productResponsitory.save(product);
		        return true;
		    } catch (Exception e) {
		        e.printStackTrace();
		        
		    }
		    return false;
	}

	@Override
	public Boolean delete(Integer id) {
		try {
			this.productResponsitory.delete(finByID(id));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false ;
	}

}

package com.project.Responsitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.models.product;

public interface ProductResponsitory extends JpaRepository<product, Integer> {

}

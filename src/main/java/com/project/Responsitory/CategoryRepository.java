package com.project.Responsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
	@Query("SELECT c FROM Category c WHERE c.categoryName LIKE %?1%")
	List<Category> searchcategory(String keyword);

}

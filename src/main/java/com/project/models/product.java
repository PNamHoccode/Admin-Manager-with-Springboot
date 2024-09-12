package com.project.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="products")
public class product {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "productName")
	private String productName;
	@Column(name = "price")
	private Double price;
	@Column(name = "image")
	private String image;
	@Column(name = "description",columnDefinition = "NVARCHAR(MAX)")
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "categoryId",referencedColumnName = "id")
	private Category category;
}

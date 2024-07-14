package com.ecfcode.springstore.infrastructure.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Table(name="categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {

	@Id
	@Column(name="category_id")
	private Long categoryId;
	
	@Column(name="category_name")
	private String categoryName;

	@Column(name="description",
			columnDefinition = "TEXT")
	private String description;

	@OneToMany(mappedBy="category")
	private List<Product> products;
}

package com.ecfcode.springstore.domain.requests.categories;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCategoryRequest {

	@Positive
	private int categoryId;
	
	@NotBlank
	@Size(min=1,max=15)
	private String categoryName;
	
}

package com.ecfcode.springstore.domain.responses.categories;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryGetResponse {

	private int categoryId;
	private String categoryName;
}

package com.ecfcode.springstore.domain.requests.products;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProductRequest {

	private int productId;
	
	@NotBlank
	@Size(min=1,max=15)
	private String productName;
	
	
	@Min(1)
	@Max(100)
	private double unitPrice;
	
	@Positive
	private int unitsInStock;
	
	@Positive
	private int categoryId;
	
	@Positive
	private int supplierId;
	
	@PositiveOrZero
	private int discontinued; 
	
}

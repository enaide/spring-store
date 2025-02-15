package com.ecfcode.springstore.domain.responses.products;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductListResponse {

	private int productId;

	private String productName;

	private double unitPrice;

	private int unitsInStock;

	private int categoryCategoryId;

	private String categoryCategoryName;
	
	private int supplierSupplierId;
	
	private String supplierCompanyName;
}

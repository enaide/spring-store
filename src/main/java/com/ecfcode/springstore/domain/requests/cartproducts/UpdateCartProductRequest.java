package com.ecfcode.springstore.domain.requests.cartproducts;

import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCartProductRequest {

	@Positive
    private int cartProductId;
	
	@Positive
	private int cartId;
	
	@Positive
	private int productId;
	
	@Positive
	private int quantity;
}

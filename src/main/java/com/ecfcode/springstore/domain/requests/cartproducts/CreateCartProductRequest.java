package com.ecfcode.springstore.domain.requests.cartproducts;

import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCartProductRequest {

	@Positive
    private int cartId;
	
	@Positive
    private Long productId;
	
	@Positive
    private int quantity;


}

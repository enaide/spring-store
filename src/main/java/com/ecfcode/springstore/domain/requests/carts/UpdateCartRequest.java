package com.ecfcode.springstore.domain.requests.carts;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCartRequest {

	@Positive
	private int cartId;
	
	@Size(min=1,max=5)
    private String customerNumber;
}

package com.ecfcode.springstore.domain.requests.carts;

import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeleteCartRequest {
	@Positive
	private int cartId;


}

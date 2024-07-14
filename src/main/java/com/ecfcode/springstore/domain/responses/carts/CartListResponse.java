package com.ecfcode.springstore.domain.responses.carts;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CartListResponse {
	private int cartId;
	private String customerNumber;

}

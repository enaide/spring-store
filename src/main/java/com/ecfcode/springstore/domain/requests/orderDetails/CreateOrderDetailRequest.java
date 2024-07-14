package com.ecfcode.springstore.domain.requests.orderDetails;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderDetailRequest {

	@Positive
	private Long orderId;
	
	@Positive
	private int  productId;
	
	@Positive
	private double unitPrice;
	
	@Positive
	private int quantity;
	
	@PositiveOrZero
	private double discount;
}

package com.ecfcode.springstore.domain.requests.orderDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateOrderDetailRequest {

	private Long orderId;
	private int productId;
	private double unitPrice;
	private int quantity;
	private double discount;
}

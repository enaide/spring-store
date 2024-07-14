package com.ecfcode.springstore.domain.requests.orderDetails;

import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeleteOrderDetailRequest {

	@Positive
	private Long orderId;
	
	@Positive
	private Long productId;
}

package com.ecfcode.springstore.domain.requests.orders;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateOrderRequest {
	
	@NotEmpty
	@Positive
	private Long orderId;
	
	@FutureOrPresent
	private LocalDate orderDate;
	
	@Future
	private LocalDate requiredDate;
	
	@Future
	private LocalDate shippedDate;
	
	@NotEmpty
	@Positive
	private int employeeId;
	
	@NotEmpty
	@Positive
	private String customerNumber;
}


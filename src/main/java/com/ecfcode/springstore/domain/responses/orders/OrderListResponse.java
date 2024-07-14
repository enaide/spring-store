package com.ecfcode.springstore.domain.responses.orders;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderListResponse {
	
	private Long orderId;
	private LocalDate orderDate;
	private LocalDate requiredDate;
	private LocalDate shippedDate;
	private String customerId;
	private String customerCompanyName;
	private int employeeId;
//	private String employeeFirstName;
//	private String employeeLastName;
	private String employeeFullName;
}

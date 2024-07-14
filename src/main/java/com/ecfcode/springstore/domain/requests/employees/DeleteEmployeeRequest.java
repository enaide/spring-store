package com.ecfcode.springstore.domain.requests.employees;

import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeleteEmployeeRequest {
	
	@Positive
	private Long employeeId;
	
}

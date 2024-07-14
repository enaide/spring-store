package com.ecfcode.springstore.domain.requests.employees;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateEmployeeRequest {

	@Positive
	private int employeeId;
	
	@Size(min=1,max=15)
	private String firstName;
	
	@Size(min=1,max=15)
	private String lastName;
	
	@Size(min=1,max=15)
	private String title;
	
	@DateTimeFormat
	private LocalDate birthDate;
	
	@NotNull
	private String address;
	
	@Positive
	private Integer reportsTo;
	
	@Positive
	private int cityId;
	
	@Positive
	private int countryId;
}

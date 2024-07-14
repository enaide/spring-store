package com.ecfcode.springstore.domain.requests.customers;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCustomerRequest {

	@Size(min=1,max=5)
	private String customerNumber;
	
	@Size(min=1,max=15)
	private String companyName;
	
	@Size(min=1,max=15)
	private String contactName;
	
	@Size(min=1,max=15)
	private String contactTitle;
	
	@NotNull
	private String address;
	
	@Positive
	private int cityId;
	
	@Positive
	private int countryId;
	
}

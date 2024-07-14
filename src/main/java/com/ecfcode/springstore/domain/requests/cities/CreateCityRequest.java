package com.ecfcode.springstore.domain.requests.cities;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCityRequest {

	@Size(min=1,max=20)
	private String cityName;
	
	@Positive
	private int countryId;
	
}

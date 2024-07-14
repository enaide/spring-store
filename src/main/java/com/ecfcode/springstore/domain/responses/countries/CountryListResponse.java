package com.ecfcode.springstore.domain.responses.countries;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountryListResponse {

	
	private int countryId;
	private String countyName;
}
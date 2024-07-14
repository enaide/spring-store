package com.ecfcode.springstore.domain.responses.cities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CityListResponse {

	private int cityId;
	private String cityName;
	private int countryId;
	private String countryCountyName;
}

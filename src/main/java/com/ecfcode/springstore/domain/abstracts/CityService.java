package com.ecfcode.springstore.domain.abstracts;

import com.ecfcode.springstore.core.utilities.results.DataResult;
import com.ecfcode.springstore.core.utilities.results.Result;
import com.ecfcode.springstore.domain.requests.cities.CreateCityRequest;
import com.ecfcode.springstore.domain.responses.cities.CityListResponse;

import java.util.List;

public interface CityService {

	Result add(CreateCityRequest createCityRequest);
	DataResult<List<CityListResponse>> getAll();
	
}

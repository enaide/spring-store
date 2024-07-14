package com.ecfcode.springstore.domain.abstracts;

import com.ecfcode.springstore.core.utilities.results.DataResult;
import com.ecfcode.springstore.core.utilities.results.Result;
import com.ecfcode.springstore.domain.requests.countries.CreateCountryRequest;
import com.ecfcode.springstore.domain.responses.countries.CountryListResponse;

import java.util.List;

public interface CountryService {


	Result add(CreateCountryRequest createCountryRequest);
	DataResult<List<CountryListResponse>> getAll();
}

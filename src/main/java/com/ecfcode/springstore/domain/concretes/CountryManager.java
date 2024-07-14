package com.ecfcode.springstore.domain.concretes;

import com.ecfcode.springstore.core.utilities.mapping.ModelMapperService;
import com.ecfcode.springstore.core.utilities.results.DataResult;
import com.ecfcode.springstore.core.utilities.results.Result;
import com.ecfcode.springstore.core.utilities.results.SuccessDataResult;
import com.ecfcode.springstore.core.utilities.results.SuccessResult;
import com.ecfcode.springstore.domain.abstracts.CountryService;
import com.ecfcode.springstore.domain.requests.countries.CreateCountryRequest;
import com.ecfcode.springstore.domain.responses.countries.CountryListResponse;
import com.ecfcode.springstore.infrastructure.abstracts.CountryRepository;
import com.ecfcode.springstore.infrastructure.entities.concretes.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryManager implements CountryService {

	private CountryRepository countryRepository;
	private ModelMapperService modelMapperService;

	@Autowired
	public CountryManager(CountryRepository countryRepository, ModelMapperService modelMapperService) {
		this.countryRepository = countryRepository;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public Result add(CreateCountryRequest createCountryRequest) {
		Country country = this.modelMapperService.forRequest().map(createCountryRequest, Country.class);
		this.countryRepository.save(country);
		return new SuccessResult("COUNTRY.ADDED");
	}

	@Override
	public DataResult<List<CountryListResponse>> getAll() {
		List<Country> result = this.countryRepository.findAll();
		List<CountryListResponse> response = result.stream()
				.map(country -> this.modelMapperService.forResponse().map(country, CountryListResponse.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<CountryListResponse>>(response);
	}

}

package com.ecfcode.springstore.domain.concretes;

import com.ecfcode.springstore.core.utilities.mapping.ModelMapperService;
import com.ecfcode.springstore.core.utilities.results.DataResult;
import com.ecfcode.springstore.core.utilities.results.Result;
import com.ecfcode.springstore.core.utilities.results.SuccessDataResult;
import com.ecfcode.springstore.core.utilities.results.SuccessResult;
import com.ecfcode.springstore.domain.abstracts.CityService;
import com.ecfcode.springstore.domain.requests.cities.CreateCityRequest;
import com.ecfcode.springstore.domain.responses.cities.CityListResponse;
import com.ecfcode.springstore.infrastructure.abstracts.CityRepository;
import com.ecfcode.springstore.infrastructure.entities.concretes.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityManager implements CityService {

	private final CityRepository cityRepository;
	private final ModelMapperService modelMapperService;

	@Autowired
	public CityManager(CityRepository cityRepository, ModelMapperService modelMapperService) {
		this.cityRepository = cityRepository;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public Result add(CreateCityRequest createCityRequest) {
		City city = this.modelMapperService.forRequest().map(createCityRequest, City.class);
		this.cityRepository.save(city);
		return new SuccessResult("CITY.ADDED");
	}

	@Override
	public DataResult<List<CityListResponse>> getAll() {
		List<City> result = this.cityRepository.findAll();
		List<CityListResponse> response = result.stream()
				.map(city -> this.modelMapperService.forResponse().map(city, CityListResponse.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<CityListResponse>>(response);
	}

}

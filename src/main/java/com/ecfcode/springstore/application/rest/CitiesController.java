package com.ecfcode.springstore.application.rest;

import com.ecfcode.springstore.core.utilities.results.DataResult;
import com.ecfcode.springstore.core.utilities.results.Result;
import com.ecfcode.springstore.domain.abstracts.CityService;
import com.ecfcode.springstore.domain.requests.cities.CreateCityRequest;
import com.ecfcode.springstore.domain.responses.cities.CityListResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/cities")
public class CitiesController {
	
	private CityService cityService;

	@Autowired
	public CitiesController(CityService cityService) {
		this.cityService = cityService;
	}
	
	@PostMapping("/add")
	public Result add(@Valid @RequestBody CreateCityRequest createCityRequest) {
		return this.cityService.add(createCityRequest);
	}
	
	@GetMapping("/getall")
	public DataResult<List<CityListResponse>> getAll(){
		return this.cityService.getAll();
	}

}

package com.ecfcode.springstore.application.rest;

import com.ecfcode.springstore.core.utilities.results.DataResult;
import com.ecfcode.springstore.core.utilities.results.Result;
import com.ecfcode.springstore.domain.abstracts.CountryService;
import com.ecfcode.springstore.domain.requests.countries.CreateCountryRequest;
import com.ecfcode.springstore.domain.responses.countries.CountryListResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/countries")
public class CountriesController {
	
	private CountryService countryService;

	@Autowired
	public CountriesController(CountryService countryService) {
		this.countryService = countryService;
	}
	
	@PostMapping("/add")
	public Result add(@Valid @RequestBody CreateCountryRequest createCountryRequest) {
		return this.countryService.add(createCountryRequest);
	}
	
	@GetMapping("/getall")
	public DataResult<List<CountryListResponse>>getAll(){
		return this.countryService.getAll();
	}

}

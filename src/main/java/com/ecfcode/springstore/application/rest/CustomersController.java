package com.ecfcode.springstore.application.rest;

import com.ecfcode.springstore.core.utilities.results.DataResult;
import com.ecfcode.springstore.core.utilities.results.Result;
import com.ecfcode.springstore.domain.abstracts.CustomerService;
import com.ecfcode.springstore.domain.requests.customers.CreateCustomerRequest;
import com.ecfcode.springstore.domain.requests.customers.DeleteCustomerRequest;
import com.ecfcode.springstore.domain.requests.customers.UpdateCustomerRequest;
import com.ecfcode.springstore.domain.responses.customers.CustomerGetResponse;
import com.ecfcode.springstore.domain.responses.customers.CustomerListResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomersController {

	private CustomerService customerService;

	@Autowired
	public CustomersController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@PostMapping("/add")
    public Result add(@Valid @RequestBody CreateCustomerRequest createCustomerRequest) {
		return this.customerService.add(createCustomerRequest);
    }

    @PostMapping("/delete")
    public Result delete(@Valid @RequestBody DeleteCustomerRequest deleteCustomerRequest) {
    	return this.customerService.delete(deleteCustomerRequest);
    }

    @PostMapping("/update")
    public Result update(@Valid @RequestBody UpdateCustomerRequest updateCustomerRequest) {
    	return this.customerService.update(updateCustomerRequest);
    }

    @GetMapping("/getbyid")
    public DataResult<CustomerGetResponse> getById(@RequestParam String customerNumber) {
        return this.customerService.getById(customerNumber);
    }
	
	@GetMapping("/getall")
	public DataResult<List<CustomerListResponse>> getAll(){
		return this.customerService.getAll();
	}
}

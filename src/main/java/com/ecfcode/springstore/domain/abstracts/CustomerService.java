package com.ecfcode.springstore.domain.abstracts;

import com.ecfcode.springstore.core.utilities.results.DataResult;
import com.ecfcode.springstore.core.utilities.results.Result;
import com.ecfcode.springstore.domain.requests.customers.CreateCustomerRequest;
import com.ecfcode.springstore.domain.requests.customers.DeleteCustomerRequest;
import com.ecfcode.springstore.domain.requests.customers.UpdateCustomerRequest;
import com.ecfcode.springstore.domain.responses.customers.CustomerGetResponse;
import com.ecfcode.springstore.domain.responses.customers.CustomerListResponse;

import java.util.List;

public interface CustomerService {

	Result add(CreateCustomerRequest createCustomerRequest);
	Result delete(DeleteCustomerRequest deleteCustomerRequest);
	Result update(UpdateCustomerRequest updateCustomerRequest);
	
	DataResult<CustomerGetResponse> getById(String id);
	DataResult<List<CustomerListResponse>> getAll();
}

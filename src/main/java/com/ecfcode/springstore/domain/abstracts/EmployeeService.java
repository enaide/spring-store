package com.ecfcode.springstore.domain.abstracts;

import com.ecfcode.springstore.core.utilities.results.DataResult;
import com.ecfcode.springstore.core.utilities.results.Result;
import com.ecfcode.springstore.domain.requests.employees.CreateEmployeeRequest;
import com.ecfcode.springstore.domain.requests.employees.DeleteEmployeeRequest;
import com.ecfcode.springstore.domain.requests.employees.UpdateEmployeeRequest;
import com.ecfcode.springstore.domain.responses.employees.EmployeeGetResponse;
import com.ecfcode.springstore.domain.responses.employees.EmployeeListResponse;

import java.util.List;

public interface EmployeeService {

	Result add(CreateEmployeeRequest createEmployeeRequest);
	Result delete(DeleteEmployeeRequest deleteEmployeeRequest);
	Result update(UpdateEmployeeRequest updateEmployeeRequest);
	
	DataResult<EmployeeGetResponse> getById(Long id);
	DataResult<List<EmployeeListResponse>> getAll();
}

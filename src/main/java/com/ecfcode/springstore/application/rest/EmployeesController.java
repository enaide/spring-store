package com.ecfcode.springstore.application.rest;

import com.ecfcode.springstore.core.utilities.results.DataResult;
import com.ecfcode.springstore.core.utilities.results.Result;
import com.ecfcode.springstore.domain.abstracts.EmployeeService;
import com.ecfcode.springstore.domain.requests.employees.CreateEmployeeRequest;
import com.ecfcode.springstore.domain.requests.employees.DeleteEmployeeRequest;
import com.ecfcode.springstore.domain.requests.employees.UpdateEmployeeRequest;
import com.ecfcode.springstore.domain.responses.employees.EmployeeGetResponse;
import com.ecfcode.springstore.domain.responses.employees.EmployeeListResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeesController {

	private EmployeeService employeeService;

	@Autowired
	public EmployeesController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	@PostMapping("/add")
    public Result add(@Valid @RequestBody CreateEmployeeRequest createEmployeeRequest) {
		return this.employeeService.add(createEmployeeRequest);
    }

    @PostMapping("/delete")
    public Result delete(@Valid @RequestBody DeleteEmployeeRequest deleteEmployeeRequest) {
    	return this.employeeService.delete(deleteEmployeeRequest);
    }

    @PostMapping("/update")
    public Result update(@Valid @RequestBody UpdateEmployeeRequest updateEmployeeRequest) {
    	return this.employeeService.update(updateEmployeeRequest);
    }

    @GetMapping("/getbyid")
    public DataResult<EmployeeGetResponse> getById(@RequestParam Long id) {
        return this.employeeService.getById(id);
    }
    
	@GetMapping("/getall")
	public DataResult<List<EmployeeListResponse>> getAll() {
		return this.employeeService.getAll();
	}

}

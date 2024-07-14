package com.ecfcode.springstore.domain.concretes;

import com.ecfcode.springstore.core.exceptions.BusinessException;
import com.ecfcode.springstore.core.utilities.mapping.ModelMapperService;
import com.ecfcode.springstore.core.utilities.results.DataResult;
import com.ecfcode.springstore.core.utilities.results.Result;
import com.ecfcode.springstore.core.utilities.results.SuccessDataResult;
import com.ecfcode.springstore.core.utilities.results.SuccessResult;
import com.ecfcode.springstore.domain.abstracts.EmployeeService;
import com.ecfcode.springstore.domain.requests.employees.CreateEmployeeRequest;
import com.ecfcode.springstore.domain.requests.employees.DeleteEmployeeRequest;
import com.ecfcode.springstore.domain.requests.employees.UpdateEmployeeRequest;
import com.ecfcode.springstore.domain.responses.employees.EmployeeGetResponse;
import com.ecfcode.springstore.domain.responses.employees.EmployeeListResponse;
import com.ecfcode.springstore.infrastructure.abstracts.EmployeeRepository;
import com.ecfcode.springstore.infrastructure.entities.concretes.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeManager implements EmployeeService {

	private EmployeeRepository employeeRepository;
	private ModelMapperService modelMapperService;

	@Autowired
	public EmployeeManager(EmployeeRepository employeeRepository, ModelMapperService modelMapperService) {
		this.employeeRepository = employeeRepository;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public Result add(CreateEmployeeRequest createEmployeeRequest) {
		checkIEmployeeReportLimitExceeds(createEmployeeRequest.getReportsTo());
		
		Employee employee = this.modelMapperService.forRequest().map(createEmployeeRequest, Employee.class);
		this.employeeRepository.save(employee);
		
		return new SuccessResult("EMPLOYEE.ADDED");
	}

	@Override
	public Result delete(DeleteEmployeeRequest deleteEmployeeRequest) {
		this.employeeRepository.deleteById(deleteEmployeeRequest.getEmployeeId());

		return new SuccessResult("EMPLOYEE.DELETED");
	}

	@Override
	public Result update(UpdateEmployeeRequest updateEmployeeRequest) {
		Employee employee = this.modelMapperService.forRequest().map(updateEmployeeRequest, Employee.class);
		this.employeeRepository.save(employee);
		
		return new SuccessResult("EMPLOYEE.UPDATED");
	}

	@Override
	public DataResult<EmployeeGetResponse> getById(Long id) {
		Employee employee = this.employeeRepository.findById(id).get();
		EmployeeGetResponse response = this.modelMapperService.forRequest().map(employee, EmployeeGetResponse.class);
		
		return new SuccessDataResult<EmployeeGetResponse>(response);
	}

	@Override
	public DataResult<List<EmployeeListResponse>> getAll() {
		List<Employee> result = this.employeeRepository.findAll();
		List<EmployeeListResponse> response = result.stream()
				.map(employee -> this.modelMapperService.forResponse().map(employee, EmployeeListResponse.class))
				.collect(Collectors.toList());
		
		return new SuccessDataResult<List<EmployeeListResponse>>(response);
	}
	
	private void checkIEmployeeReportLimitExceeds(int reportsTo) {
		List<Employee> result = this.employeeRepository.findByReportsTo(reportsTo);
		if (result.size() >= 10) {
			throw new BusinessException("NO.MORE.EMPLOYEE.CAN.BE.ADDED");
		}
	}
	
	
	

	
}

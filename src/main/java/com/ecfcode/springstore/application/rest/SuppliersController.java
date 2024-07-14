package com.ecfcode.springstore.application.rest;

import com.ecfcode.springstore.core.utilities.results.DataResult;
import com.ecfcode.springstore.core.utilities.results.Result;
import com.ecfcode.springstore.domain.abstracts.SupplierService;
import com.ecfcode.springstore.domain.requests.suppliers.CreateSupplierRequest;
import com.ecfcode.springstore.domain.requests.suppliers.DeleteSupplierRequest;
import com.ecfcode.springstore.domain.requests.suppliers.UpdateSupplierRequest;
import com.ecfcode.springstore.domain.responses.suppliers.SupplierGetResponse;
import com.ecfcode.springstore.domain.responses.suppliers.SupplierListResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/suppliers")
public class SuppliersController {

	private SupplierService supplierService;

	@Autowired
	public SuppliersController(SupplierService supplierService) {
		this.supplierService = supplierService;
	}
	
	@PostMapping("/add")
    public Result add(@Valid @RequestBody CreateSupplierRequest createSupplierRequest) {
		return this.supplierService.add(createSupplierRequest);
    }

    @PostMapping("/delete")
    public Result delete(@Valid @RequestBody DeleteSupplierRequest deleteSupplierRequest) {
    	return this.supplierService.delete(deleteSupplierRequest);
    }

    @PostMapping("/update")
    public Result update(@Valid @RequestBody UpdateSupplierRequest updateSupplierRequest) {
        return this.supplierService.update(updateSupplierRequest);
    }

    @GetMapping("/getbyid")
    public DataResult<SupplierGetResponse> getById(@RequestParam int id) {
        return this.supplierService.getById(id);
    }
	@GetMapping("/getall")
	public DataResult<List<SupplierListResponse>> getAll(){
		return this.supplierService.getAll();
	}
}

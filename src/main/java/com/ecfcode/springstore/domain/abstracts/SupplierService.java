package com.ecfcode.springstore.domain.abstracts;

import com.ecfcode.springstore.core.utilities.results.DataResult;
import com.ecfcode.springstore.core.utilities.results.Result;
import com.ecfcode.springstore.domain.requests.suppliers.CreateSupplierRequest;
import com.ecfcode.springstore.domain.requests.suppliers.DeleteSupplierRequest;
import com.ecfcode.springstore.domain.requests.suppliers.UpdateSupplierRequest;
import com.ecfcode.springstore.domain.responses.suppliers.SupplierGetResponse;
import com.ecfcode.springstore.domain.responses.suppliers.SupplierListResponse;

import java.util.List;

public interface SupplierService {
	Result add(CreateSupplierRequest createSupplierRequest);
	Result delete(DeleteSupplierRequest deleteSupplierRequest);
	Result update(UpdateSupplierRequest updateSupplierRequest);
	
	DataResult<SupplierGetResponse> getById(int id);
	DataResult<List<SupplierListResponse>> getAll();
}

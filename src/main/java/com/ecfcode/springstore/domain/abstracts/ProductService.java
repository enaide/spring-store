package com.ecfcode.springstore.domain.abstracts;

import com.ecfcode.springstore.core.utilities.results.DataResult;
import com.ecfcode.springstore.core.utilities.results.Result;
import com.ecfcode.springstore.domain.requests.products.CreateProductRequest;
import com.ecfcode.springstore.domain.requests.products.DeleteProductRequest;
import com.ecfcode.springstore.domain.requests.products.UpdateProductRequest;
import com.ecfcode.springstore.domain.responses.dtos.PageableResponse;
import com.ecfcode.springstore.domain.responses.products.ProductGetResponse;
import com.ecfcode.springstore.domain.responses.products.ProductListResponse;

import java.util.List;

public interface ProductService {
	
	Result add(CreateProductRequest createProductRequest);
	Result delete(DeleteProductRequest deleteProductRequest);
	Result update(UpdateProductRequest updateProductRequest);
	
	DataResult<ProductGetResponse> getById(Long id);
	DataResult<List<ProductListResponse>> getAll();
	
	DataResult<List<ProductListResponse>> getAll(int pageNo,int pageSize);
	PageableResponse<List<ProductListResponse>> getAllByPage(int pageNo, int pageSize);
	DataResult<List<ProductListResponse>> getAllSortedByAsc(String field);
	DataResult<List<ProductListResponse>> getAllSortedByDesc(String field);
	
}

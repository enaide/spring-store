package com.ecfcode.springstore.domain.abstracts;

import com.ecfcode.springstore.core.utilities.results.DataResult;
import com.ecfcode.springstore.core.utilities.results.Result;
import com.ecfcode.springstore.domain.requests.categories.CreateCategoryRequest;
import com.ecfcode.springstore.domain.requests.categories.DeleteCategoryRequest;
import com.ecfcode.springstore.domain.requests.categories.UpdateCategoryRequest;
import com.ecfcode.springstore.domain.responses.categories.CategoryGetResponse;
import com.ecfcode.springstore.domain.responses.categories.CategoryListResponse;
import com.ecfcode.springstore.domain.responses.dtos.PageableResponse;

import java.util.List;

public interface CategoryService {

	Result add(CreateCategoryRequest createCategoryRequest);
	Result delete(DeleteCategoryRequest deleteCategoryRequest);
	Result update(UpdateCategoryRequest updateCategoryRequest);
	
	DataResult<CategoryGetResponse> getById(int id);
	DataResult<List<CategoryListResponse>> getAll();
	
	PageableResponse<List<CategoryListResponse>> getAllByPage(int pageNo, int pageSize);
	
	 
}

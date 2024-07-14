package com.ecfcode.springstore.domain.concretes;

import com.ecfcode.springstore.core.exceptions.BusinessException;
import com.ecfcode.springstore.core.utilities.mapping.ModelMapperService;
import com.ecfcode.springstore.core.utilities.results.DataResult;
import com.ecfcode.springstore.core.utilities.results.Result;
import com.ecfcode.springstore.core.utilities.results.SuccessDataResult;
import com.ecfcode.springstore.core.utilities.results.SuccessResult;
import com.ecfcode.springstore.domain.abstracts.CategoryService;
import com.ecfcode.springstore.domain.requests.categories.CreateCategoryRequest;
import com.ecfcode.springstore.domain.requests.categories.DeleteCategoryRequest;
import com.ecfcode.springstore.domain.requests.categories.UpdateCategoryRequest;
import com.ecfcode.springstore.domain.responses.categories.CategoryGetResponse;
import com.ecfcode.springstore.domain.responses.categories.CategoryListResponse;
import com.ecfcode.springstore.domain.responses.dtos.PageItem;
import com.ecfcode.springstore.domain.responses.dtos.PageableResponse;
import com.ecfcode.springstore.infrastructure.abstracts.CategoryRepository;
import com.ecfcode.springstore.infrastructure.entities.concretes.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryManager implements CategoryService {

	private final CategoryRepository categoryRepository;
	private final ModelMapperService modelMapperService;

	@Autowired
	public CategoryManager(CategoryRepository categoryRepository, ModelMapperService modelMapperService) {
		this.categoryRepository = categoryRepository;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public Result add(CreateCategoryRequest createCategoryRequest) {
		checkIfCategoryNameExists(createCategoryRequest.getCategoryName());

		Category category = this.modelMapperService.forRequest().map(createCategoryRequest, Category.class);
		this.categoryRepository.save(category);

		return new SuccessResult("CATEGORY.ADDED");

	}

	@Override
	public Result delete(DeleteCategoryRequest deleteCategoryRequest) {
		this.categoryRepository.deleteById(deleteCategoryRequest.getCategoryId());

		return new SuccessResult("CATEGORY.DELETED");
	}

	@Override
	public Result update(UpdateCategoryRequest updateCategoryRequest) {
		Category category = this.modelMapperService.forRequest().map(updateCategoryRequest, Category.class);
		this.categoryRepository.save(category);

		return new SuccessResult("CATEGORY.UPDATED");
	}

	@Override
	public DataResult<CategoryGetResponse> getById(int id) {
		Category category = this.categoryRepository.findById(id);
		CategoryGetResponse response = this.modelMapperService.forResponse().map(category, CategoryGetResponse.class);
		return new SuccessDataResult<CategoryGetResponse>(response);
	}

	@Override
	public DataResult<List<CategoryListResponse>> getAll() {
		List<Category> result = this.categoryRepository.findAll();
		List<CategoryListResponse> response = result.stream()
				.map(category -> this.modelMapperService.forResponse().map(category, CategoryListResponse.class))
				.collect(Collectors.toList());

		return new SuccessDataResult<List<CategoryListResponse>>(response);
	}

	@Override
	public PageableResponse<List<CategoryListResponse>> getAllByPage(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
		List<Category> result = this.categoryRepository.findAll(pageable).getContent();
		Page<Category> resultPage = this.categoryRepository.findAll(pageable);
		List<CategoryListResponse> response = result.stream()
				.map(category -> this.modelMapperService.forResponse().map(category, CategoryListResponse.class))
				.collect(Collectors.toList());
		PageItem item = new PageItem();
		item.setPageNo(pageNo);
		item.setPageSize(pageSize);
		item.setTotalPages(resultPage.getTotalPages());
		item.setTotalData(resultPage.getTotalElements());
	
		return new PageableResponse<List<CategoryListResponse>>(item,response);
	}

	private void checkIfCategoryNameExists(String name) {
		Category category = this.categoryRepository.findByCategoryName(name);
		if (category != null) {
			throw new BusinessException("CATEGORY.NAME.EXISTS");
		}
	}

}

package com.ecfcode.springstore.application.rest;

import com.ecfcode.springstore.core.utilities.results.DataResult;
import com.ecfcode.springstore.core.utilities.results.Result;
import com.ecfcode.springstore.domain.abstracts.ProductService;
import com.ecfcode.springstore.domain.requests.products.CreateProductRequest;
import com.ecfcode.springstore.domain.requests.products.DeleteProductRequest;
import com.ecfcode.springstore.domain.requests.products.UpdateProductRequest;
import com.ecfcode.springstore.domain.responses.dtos.PageableResponse;
import com.ecfcode.springstore.domain.responses.products.ProductGetResponse;
import com.ecfcode.springstore.domain.responses.products.ProductListResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductsController {

	private final ProductService productService;

	@Autowired
	public ProductsController(ProductService productService) {
		this.productService = productService;
	}
	
	
	@PostMapping("/add")
    public Result add(@Valid @RequestBody CreateProductRequest createProductRequest) {
        return this.productService.add(createProductRequest);
    }
	
	
    @PostMapping("/delete")
    public Result delete(@Valid @RequestBody DeleteProductRequest deleteProductRequest) {
    	return this.productService.delete(deleteProductRequest);
    }

    @PostMapping("/update")
    public Result update(@Valid @RequestBody UpdateProductRequest updateProductRequest) {
        return this.productService.update(updateProductRequest);
    }
    
    @GetMapping("/getbyid")
    public DataResult<ProductGetResponse> getById(@RequestParam Long id) {
        return this.productService.getById(id);
    }
	
	@GetMapping("/getall")
	public DataResult<List<ProductListResponse>> getAll(){
		return this.productService.getAll();
	}
	
	@GetMapping("/getallpage")
	public DataResult<List<ProductListResponse>>getAll(@RequestParam int pageNo,int pageSize){
		return this.productService.getAll(pageNo,pageSize);
	}
	
	@GetMapping("/getallbypage")
	public PageableResponse<List<ProductListResponse>> getAllByPage(@RequestParam int pageNo, int pageSize){
		return this.productService.getAllByPage(pageNo,pageSize);
	}
	
	@GetMapping("/getallsortedbyasc")
	public  DataResult<List<ProductListResponse>> getAllSortedByAsc(@RequestParam String field){
		return this.productService.getAllSortedByAsc(field);
	}
	
	@GetMapping("/getallsortedbydesc")
	public  DataResult<List<ProductListResponse>> getAllSortedByDesc(@RequestParam String field){
		return this.productService.getAllSortedByDesc(field);
	}
}

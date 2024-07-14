package com.ecfcode.springstore.application.rest;

import com.ecfcode.springstore.core.utilities.results.DataResult;
import com.ecfcode.springstore.core.utilities.results.Result;
import com.ecfcode.springstore.domain.abstracts.CartProductService;
import com.ecfcode.springstore.domain.requests.cartproducts.CreateCartProductRequest;
import com.ecfcode.springstore.domain.requests.cartproducts.DeleteCartProductRequest;
import com.ecfcode.springstore.domain.requests.cartproducts.UpdateCartProductRequest;
import com.ecfcode.springstore.domain.responses.cartProducts.CartProductListResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cartproducts")
public class CartProductsController {

	private CartProductService cartProductService;

	@Autowired
	public CartProductsController(CartProductService cartProductService) {
		this.cartProductService = cartProductService;
	}

	@PostMapping("/add")
	public Result add(@Valid @RequestBody CreateCartProductRequest createCartProductRequest) {
		return this.cartProductService.add(createCartProductRequest);
	}

	@PostMapping("/delete")
	public Result delete(@Valid @RequestBody DeleteCartProductRequest deleteCartProductRequest) {
		return this.cartProductService.delete(deleteCartProductRequest);
	}

	@PostMapping("/update")
	public Result update(@Valid @RequestBody UpdateCartProductRequest updateCartProductRequest) {
		return this.cartProductService.update(updateCartProductRequest);
	}

	@GetMapping("/getbyid")
	public DataResult<CartProductListResponse> getById(int cartProductId) {
		return this.cartProductService.getById(cartProductId);
	}

	@GetMapping("/getall")
	public DataResult<List<CartProductListResponse>> getAll() {
		return this.cartProductService.getAll();
	}
}

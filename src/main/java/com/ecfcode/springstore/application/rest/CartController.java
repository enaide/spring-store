package com.ecfcode.springstore.application.rest;

import com.ecfcode.springstore.core.utilities.results.DataResult;
import com.ecfcode.springstore.core.utilities.results.Result;
import com.ecfcode.springstore.domain.abstracts.CartService;
import com.ecfcode.springstore.domain.requests.carts.CreateCartRequest;
import com.ecfcode.springstore.domain.requests.carts.DeleteCartRequest;
import com.ecfcode.springstore.domain.requests.carts.UpdateCartRequest;
import com.ecfcode.springstore.domain.responses.carts.CartListResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carts")
public class CartController {

	private CartService cartService;

	@Autowired
	public CartController(CartService cartService) {
		this.cartService = cartService;
	}
	
	@PostMapping("/add")
	public Result add(@Valid @RequestBody CreateCartRequest createCartRequest){
		return this.cartService.add(createCartRequest);
	}
	@PostMapping("/delete")
	public Result delete(@Valid  @RequestBody DeleteCartRequest deleteCartRequest){
		return this.cartService.delete(deleteCartRequest);
	}
	
	@PostMapping("/update")
	public Result update (@Valid @RequestBody UpdateCartRequest updateCartRequest){
		return this.cartService.update(updateCartRequest);
	}
	
	@GetMapping("/getbyid")
	public DataResult<CartListResponse> getById(int cartId){
		return this.cartService.getById(cartId);
	}
	
	@GetMapping("/getall")
	public DataResult<List<CartListResponse>> getAll(){
		return this.cartService.getAll();
	}
	


}

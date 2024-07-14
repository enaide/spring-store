package com.ecfcode.springstore.domain.concretes;

import com.ecfcode.springstore.core.utilities.mapping.ModelMapperService;
import com.ecfcode.springstore.core.utilities.results.DataResult;
import com.ecfcode.springstore.core.utilities.results.Result;
import com.ecfcode.springstore.core.utilities.results.SuccessDataResult;
import com.ecfcode.springstore.core.utilities.results.SuccessResult;
import com.ecfcode.springstore.domain.abstracts.CartService;
import com.ecfcode.springstore.domain.requests.carts.CreateCartRequest;
import com.ecfcode.springstore.domain.requests.carts.DeleteCartRequest;
import com.ecfcode.springstore.domain.requests.carts.UpdateCartRequest;
import com.ecfcode.springstore.domain.responses.carts.CartListResponse;
import com.ecfcode.springstore.infrastructure.abstracts.CartProductRepository;
import com.ecfcode.springstore.infrastructure.abstracts.CartRepository;
import com.ecfcode.springstore.infrastructure.entities.concretes.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartManager implements CartService {

	private CartRepository cartRepository;
	private ModelMapperService modelMapperService;
	private CartProductRepository cartProductRepository;

	@Autowired
	public CartManager(CartRepository cartRepository, ModelMapperService modelMapperService,
			CartProductRepository cartProductRepository) {
		this.cartRepository = cartRepository;
		this.modelMapperService = modelMapperService;
		this.cartProductRepository = cartProductRepository;
	}

	@Override
	public Result add(CreateCartRequest createCartRequest) {
		Cart cart = this.modelMapperService.forRequest().map(createCartRequest, Cart.class);
		this.cartRepository.save(cart);
		return new SuccessResult();
	}

	@Override
	public Result update(UpdateCartRequest updateCartRequest) {
		Cart cart = this.modelMapperService.forRequest().map(updateCartRequest, Cart.class);
		this.cartRepository.save(cart);
		return new SuccessResult();
	}

	@Override
	public Result delete(DeleteCartRequest deleteCartRequest) {
		this.cartRepository.deleteById(deleteCartRequest.getCartId());
		return new SuccessResult();
	}

	@Override
	public DataResult<CartListResponse> getById(int cartId) {
		Cart cart = this.cartRepository.findById(cartId).get();
		CartListResponse response = this.modelMapperService.forRequest().map(cart, CartListResponse.class);
		
		return new SuccessDataResult<>(response);
	}

	@Override
	public DataResult<List<CartListResponse>> getAll() {
		List<Cart> result = this.cartRepository.findAll();
		List<CartListResponse> response = result.stream()
				.map(cart -> this.modelMapperService.forResponse().map(cart, CartListResponse.class))
				.collect(Collectors.toList());

		return new SuccessDataResult<List<CartListResponse>>(response);
	}

}

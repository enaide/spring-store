package com.ecfcode.springstore.domain.abstracts;

import com.ecfcode.springstore.core.utilities.results.DataResult;
import com.ecfcode.springstore.core.utilities.results.Result;
import com.ecfcode.springstore.domain.requests.cartproducts.CreateCartProductRequest;
import com.ecfcode.springstore.domain.requests.cartproducts.DeleteCartProductRequest;
import com.ecfcode.springstore.domain.requests.cartproducts.UpdateCartProductRequest;
import com.ecfcode.springstore.domain.responses.cartProducts.CartProductListResponse;

import java.util.List;

public interface CartProductService {

	Result add(CreateCartProductRequest createCartProductRequest);
	Result update(UpdateCartProductRequest updateCartProductRequest);
	Result delete(DeleteCartProductRequest deleteCartProductRequest);
	DataResult<List<CartProductListResponse>> getAll();
	DataResult<CartProductListResponse> getById(int cartProductId);
}

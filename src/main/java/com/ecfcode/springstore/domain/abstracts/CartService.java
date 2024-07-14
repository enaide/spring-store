package com.ecfcode.springstore.domain.abstracts;

import com.ecfcode.springstore.core.utilities.results.DataResult;
import com.ecfcode.springstore.core.utilities.results.Result;
import com.ecfcode.springstore.domain.requests.carts.CreateCartRequest;
import com.ecfcode.springstore.domain.requests.carts.DeleteCartRequest;
import com.ecfcode.springstore.domain.requests.carts.UpdateCartRequest;
import com.ecfcode.springstore.domain.responses.carts.CartListResponse;

import java.util.List;

public interface CartService {

	Result add (CreateCartRequest createCartRequest);
    Result update(UpdateCartRequest updateCartRequest);
    Result delete(DeleteCartRequest deleteCartRequest);
    DataResult<CartListResponse> getById(int cartId);
	DataResult<List<CartListResponse>> getAll();
	
	
}

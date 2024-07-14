package com.ecfcode.springstore.domain.abstracts;


import com.ecfcode.springstore.core.utilities.results.DataResult;
import com.ecfcode.springstore.core.utilities.results.Result;
import com.ecfcode.springstore.domain.requests.orders.CreateOrderRequest;
import com.ecfcode.springstore.domain.requests.orders.DeleteOrderRequest;
import com.ecfcode.springstore.domain.requests.orders.UpdateOrderRequest;
import com.ecfcode.springstore.domain.responses.orders.OrderGetResponse;
import com.ecfcode.springstore.domain.responses.orders.OrderListResponse;

import java.util.List;

public interface OrderService {

	Result add(CreateOrderRequest createOrderRequest);
	Result delete(DeleteOrderRequest deleteOrderRequest);
	Result update(UpdateOrderRequest updateOrderRequest);
	
	DataResult<OrderGetResponse> getById(Long id);
	DataResult<List<OrderListResponse>> getAll();
 }

package com.ecfcode.springstore.domain.abstracts;

import com.ecfcode.springstore.core.utilities.results.DataResult;
import com.ecfcode.springstore.core.utilities.results.Result;
import com.ecfcode.springstore.domain.requests.orderDetails.CreateOrderDetailRequest;
import com.ecfcode.springstore.domain.requests.orderDetails.DeleteOrderDetailRequest;
import com.ecfcode.springstore.domain.requests.orderDetails.UpdateOrderDetailRequest;
import com.ecfcode.springstore.domain.responses.orderDetails.OrderDetailGetResponse;
import com.ecfcode.springstore.domain.responses.orderDetails.OrderDetailListResponse;

import java.util.List;

public interface OrderDetailService {

	Result add(CreateOrderDetailRequest createOrderDetailRequest);
	Result delete(DeleteOrderDetailRequest deleteOrderDetailRequest);
	Result update(UpdateOrderDetailRequest updateOrderDetailRequest);
	
	DataResult<OrderDetailGetResponse> getById(Long orderId,int productId);
	DataResult<List<OrderDetailListResponse>> getAll();
}

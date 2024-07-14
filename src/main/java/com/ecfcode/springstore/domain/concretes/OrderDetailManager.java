package com.ecfcode.springstore.domain.concretes;

import com.ecfcode.springstore.core.utilities.mapping.ModelMapperService;
import com.ecfcode.springstore.core.utilities.results.DataResult;
import com.ecfcode.springstore.core.utilities.results.Result;
import com.ecfcode.springstore.core.utilities.results.SuccessDataResult;
import com.ecfcode.springstore.core.utilities.results.SuccessResult;
import com.ecfcode.springstore.domain.abstracts.OrderDetailService;
import com.ecfcode.springstore.domain.requests.orderDetails.CreateOrderDetailRequest;
import com.ecfcode.springstore.domain.requests.orderDetails.DeleteOrderDetailRequest;
import com.ecfcode.springstore.domain.requests.orderDetails.UpdateOrderDetailRequest;
import com.ecfcode.springstore.domain.responses.orderDetails.OrderDetailGetResponse;
import com.ecfcode.springstore.domain.responses.orderDetails.OrderDetailListResponse;
import com.ecfcode.springstore.infrastructure.abstracts.OrderDetailRepository;
import com.ecfcode.springstore.infrastructure.entities.concretes.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderDetailManager implements OrderDetailService {

	private final OrderDetailRepository orderDetailRepository;
	private final ModelMapperService modelMapperService;


	@Autowired
	public OrderDetailManager(OrderDetailRepository orderDetailRepository, ModelMapperService modelMapperService) {
		this.orderDetailRepository = orderDetailRepository;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public Result add(CreateOrderDetailRequest createOrderDetailRequest) {
		OrderDetail orderDetail = this.modelMapperService.forRequest().map(createOrderDetailRequest, OrderDetail.class);
		this.orderDetailRepository.save(orderDetail);
		
		return new SuccessResult("ORDER.DETAIL.ADDED");
		
	}

	@Override
	public Result delete(DeleteOrderDetailRequest deleteOrderDetailRequest) {

	 	this.orderDetailRepository.deleteOrderDetailWithOrderIdAndProductId(deleteOrderDetailRequest.getOrderId(), deleteOrderDetailRequest.getProductId());
		
		return new SuccessResult("ORDER.DETAIL.DELETED");
	}

	@Override
	public Result update(UpdateOrderDetailRequest updateOrderDetailRequest) {
		OrderDetail orderDetail = this.modelMapperService.forRequest().map(updateOrderDetailRequest, OrderDetail.class);
		this.orderDetailRepository.save(orderDetail);
		
		return new SuccessResult("ORDER.DETAIL.UPDATED");
		
	}

	@Override
	public DataResult<OrderDetailGetResponse> getById(Long orderId,int productId) {
		OrderDetail orderDetail = this.orderDetailRepository.getByOrder_OrderIdAndProduct_ProductId(orderId,productId);
		OrderDetailGetResponse response = this.modelMapperService.forResponse().map(orderDetail, OrderDetailGetResponse.class);
		
		return new SuccessDataResult<OrderDetailGetResponse>(response);
	}
	
	@Override
	public DataResult<List<OrderDetailListResponse>> getAll() {
		List<OrderDetail> result = this.orderDetailRepository.findAll();
		List<OrderDetailListResponse> response = result.stream().map(
				orderDetail -> this.modelMapperService.forResponse().map(orderDetail, OrderDetailListResponse.class))
				.collect(Collectors.toList());

		return new SuccessDataResult<List<OrderDetailListResponse>>(response);
	}

}

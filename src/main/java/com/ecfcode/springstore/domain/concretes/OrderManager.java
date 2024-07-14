package com.ecfcode.springstore.domain.concretes;

import com.ecfcode.springstore.core.utilities.mapping.ModelMapperService;
import com.ecfcode.springstore.core.utilities.results.DataResult;
import com.ecfcode.springstore.core.utilities.results.Result;
import com.ecfcode.springstore.core.utilities.results.SuccessDataResult;
import com.ecfcode.springstore.core.utilities.results.SuccessResult;
import com.ecfcode.springstore.domain.abstracts.OrderService;
import com.ecfcode.springstore.domain.requests.orders.CreateOrderRequest;
import com.ecfcode.springstore.domain.requests.orders.DeleteOrderRequest;
import com.ecfcode.springstore.domain.requests.orders.UpdateOrderRequest;
import com.ecfcode.springstore.domain.responses.orders.OrderGetResponse;
import com.ecfcode.springstore.domain.responses.orders.OrderListResponse;
import com.ecfcode.springstore.infrastructure.abstracts.OrderRepository;
import com.ecfcode.springstore.infrastructure.entities.concretes.Order;
import com.ecfcode.springstore.infrastructure.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderManager implements OrderService {

	private final OrderRepository orderRepository;
	private final ModelMapperService modelMapperService;

	@Autowired
	public OrderManager(OrderRepository orderRepository, ModelMapperService modelMapperService) {
		this.orderRepository = orderRepository;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public Result add(CreateOrderRequest createOrderRequest) {
		Order order = this.modelMapperService.forRequest().map(createOrderRequest, Order.class);
		this.orderRepository.save(order);
		
		return new SuccessResult("ORDER.ADDED");
		
	}

	@Override
	public Result delete(DeleteOrderRequest deleteOrderRequest) {
		this.orderRepository.deleteById(deleteOrderRequest.getOrderId());
		
		return new SuccessResult("ORDER.DELETED");
	}

	@Override
	public Result update(UpdateOrderRequest updateOrderRequest) {
		Order order = this.modelMapperService.forRequest().map(updateOrderRequest, Order.class);
		this.orderRepository.save(order);
		
		return new SuccessResult("ORDER.UPDATED");
		
	}

	@Override
	public DataResult<OrderGetResponse> getById(Long id) {
		Order order = this.orderRepository.findById(id)
				.orElseThrow(()-> new NotFoundException("Order with given id: "+ id +" doesn't exist"));
		OrderGetResponse response = this.modelMapperService.forResponse().map(order, OrderGetResponse.class);

		return new SuccessDataResult<OrderGetResponse>(response);
	}
	
	@Override
	public DataResult<List<OrderListResponse>> getAll() {
		List<Order> result = this.orderRepository.findAll();
		List<OrderListResponse> response = result.stream()
				.map(order -> this.modelMapperService.forResponse().map(order, OrderListResponse.class))
				.collect(Collectors.toList());
		
		for(int i=0; i<response.size(); i++) {
			response.get(i).setEmployeeFullName(result.get(i).getEmployee().getFirstName() 
					+ " " + result.get(i).getEmployee().getLastName());
		}
		
		return new SuccessDataResult<List<OrderListResponse>>(response);
	}
}

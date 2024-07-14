package com.ecfcode.springstore.application.rest;

import com.ecfcode.springstore.core.utilities.results.DataResult;
import com.ecfcode.springstore.core.utilities.results.Result;
import com.ecfcode.springstore.domain.abstracts.OrderService;
import com.ecfcode.springstore.domain.requests.orders.CreateOrderRequest;
import com.ecfcode.springstore.domain.requests.orders.DeleteOrderRequest;
import com.ecfcode.springstore.domain.requests.orders.UpdateOrderRequest;
import com.ecfcode.springstore.domain.responses.orders.OrderGetResponse;
import com.ecfcode.springstore.domain.responses.orders.OrderListResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrdersController {

	private OrderService orderService;

	@Autowired
	public OrdersController(OrderService orderService) {
		this.orderService = orderService;
	}

	@PostMapping("/add")
	public Result add(@Valid @RequestBody CreateOrderRequest createOrderRequest){
		return this.orderService.add(createOrderRequest);
	}
	
	@PostMapping("/delete")
	public Result delete(@Valid @RequestBody DeleteOrderRequest deleteOrderRequest){
		return this.orderService.delete(deleteOrderRequest);
	}
	
	@PostMapping("/update")
	public Result update(@Valid @RequestBody UpdateOrderRequest updateOrderRequest){
		return this.orderService.update(updateOrderRequest);
	}
	
	
	@GetMapping("/getbyid")
	public DataResult<OrderGetResponse> getById(@RequestParam Long id){
		return this.orderService.getById(id);
	}
	@GetMapping("/getall")
	public DataResult<List<OrderListResponse>> getAll(){
		return this.orderService.getAll();
	}
}

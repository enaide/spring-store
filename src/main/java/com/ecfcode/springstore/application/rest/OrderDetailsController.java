package com.ecfcode.springstore.application.rest;

import com.ecfcode.springstore.core.utilities.results.DataResult;
import com.ecfcode.springstore.core.utilities.results.Result;
import com.ecfcode.springstore.domain.abstracts.OrderDetailService;
import com.ecfcode.springstore.domain.requests.orderDetails.CreateOrderDetailRequest;
import com.ecfcode.springstore.domain.requests.orderDetails.DeleteOrderDetailRequest;
import com.ecfcode.springstore.domain.requests.orderDetails.UpdateOrderDetailRequest;
import com.ecfcode.springstore.domain.responses.orderDetails.OrderDetailGetResponse;
import com.ecfcode.springstore.domain.responses.orderDetails.OrderDetailListResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orderdetails")
public class OrderDetailsController {


	private OrderDetailService orderDetailService;

	@Autowired
	public OrderDetailsController(OrderDetailService orderDetailService) {
		this.orderDetailService = orderDetailService;
	}

	@PostMapping("/add")
	public Result add(@Valid @RequestBody CreateOrderDetailRequest createOrderDetailRequest){
		return this.orderDetailService.add(createOrderDetailRequest);
	}
	
	@PostMapping("/delete")
	public Result delete(@Valid @RequestBody DeleteOrderDetailRequest deleteOrderDetailRequest){
		return this.orderDetailService.delete(deleteOrderDetailRequest);
	}
	
	@PostMapping("/update")
	public Result update(@Valid @RequestBody UpdateOrderDetailRequest updateOrderDetailRequest){
		return this.orderDetailService.update(updateOrderDetailRequest);
	}
	
	
	@GetMapping("/getbyid")
	public DataResult<OrderDetailGetResponse> getById(@RequestParam Long orderId,@RequestParam int productId){
		return this.orderDetailService.getById(orderId,productId);
	}
	
	@GetMapping("/getall")
	public DataResult<List<OrderDetailListResponse>> getAll(){
		return this.orderDetailService.getAll();
	}
}

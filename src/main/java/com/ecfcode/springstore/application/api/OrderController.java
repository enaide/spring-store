package com.ecfcode.springstore.application.api;

import com.ecfcode.springstore.domain.models.OrderDO;
import com.ecfcode.springstore.domain.models.Payment;
import com.ecfcode.springstore.domain.requests.demo.AddProductRequest;
import com.ecfcode.springstore.domain.requests.demo.CreateOrderRequest;
import com.ecfcode.springstore.domain.responses.CreateOrderResponse;
import com.ecfcode.springstore.domain.services.abstracts.OrderService;
import com.ecfcode.springstore.domain.services.concretes.PaymentService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    private final OrderService orderService;
    private final PaymentService paymentService;

    public OrderController(OrderService orderService, PaymentService paymentService) {
        this.orderService = orderService;
        this.paymentService = paymentService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    CreateOrderResponse createOrder(@RequestBody final CreateOrderRequest createOrderRequest) {
        final Long id = orderService.createOrder(List.of(createOrderRequest.orderLine()));

        return new CreateOrderResponse(id);
    }

    @PostMapping(value = "/{id}/products", consumes = MediaType.APPLICATION_JSON_VALUE)
    void addProduct(@PathVariable final Long id, @RequestBody final AddProductRequest addProductRequest) {
        orderService.addProduct(id, addProductRequest.product());
    }

    @DeleteMapping(value = "/{id}/products", consumes = MediaType.APPLICATION_JSON_VALUE)
    void deleteProduct(@PathVariable final Long id, @RequestParam final Long productId) {
        orderService.deleteProduct(id, productId);
    }

    @PostMapping("/{id}/complete")
    void completeOrder(@PathVariable final Long id) {
        orderService.completeOrder(id);
    }

    @GetMapping("/{id}")
    Payment fetchOrder(@PathVariable final Long id) {
        OrderDO orderDO = orderService.fetchOrder(id);
        Payment payment = new Payment(
                0L,
                orderDO,
                BigDecimal.ONE,
                "Master Card",
                "Donation"
        );
        paymentService.chargeCard(payment);
        return payment;
    }
}

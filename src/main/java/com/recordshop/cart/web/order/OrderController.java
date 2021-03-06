package com.recordshop.cart.web.order;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recordshop.cart.domain.order.Order;
import com.recordshop.cart.domain.order.OrderService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(value="/orders", produces= MediaType.APPLICATION_JSON_VALUE)
public class OrderController {

	private final OrderService orderService;
	private final OrderMapper orderMapper;
	
	@PreAuthorize("hasAuthority('SCOPE_cart.write')")
	@PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<OrderDTO> createOrder(@Valid @RequestBody CreateOrderRequest request) {
    	Order order = orderService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(orderMapper.toDto(order));
	}
	
}

package com.recordshop.cart.web.order;

import org.mapstruct.Mapper;

import com.recordshop.cart.domain.order.Order;

@Mapper(componentModel = "spring")
public interface OrderMapper {

	OrderDTO toDto(Order order);
	
}

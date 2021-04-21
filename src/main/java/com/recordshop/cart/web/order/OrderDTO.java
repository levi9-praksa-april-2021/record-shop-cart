package com.recordshop.cart.web.order;

import java.math.BigDecimal;
import java.util.List;

import com.recordshop.cart.web.item.OrderRecordItemDTO;

import lombok.Data;

@Data
public class OrderDTO {

	private Long id;
	private List<OrderRecordItemDTO> items;
	private BigDecimal priceSum;
}

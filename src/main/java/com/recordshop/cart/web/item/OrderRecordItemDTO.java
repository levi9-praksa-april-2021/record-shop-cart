package com.recordshop.cart.web.item;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class OrderRecordItemDTO {

	private Long recordId;
	private Integer count;
	private BigDecimal recordPrice;
	
	
}

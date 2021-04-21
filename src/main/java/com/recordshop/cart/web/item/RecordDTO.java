package com.recordshop.cart.web.item;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class RecordDTO {
	
	private Long id;
    private String title;
    private BigDecimal price;
    private Integer stock;
    
    
}

package com.recordshop.cart.web.client;

import java.math.BigDecimal;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RecordDTO {
	
	private Long id;
    private String title;
    private BigDecimal price;
    private Integer stock;
    
    
}

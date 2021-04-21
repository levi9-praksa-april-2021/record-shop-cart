package com.recordshop.cart.web.item;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import lombok.Data;

@Data
public class OrderRecordItemRequest {
	
	@NotBlank(message = "RecordId cannot be blank")
	private final Long recordId;
	@Positive(message = "Stock cannot be negative or zero")
	private final Integer count;

}

package com.recordshop.cart.web.item;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderRecordItemRequest {
	
	@NotBlank(message = "RecordId cannot be blank")
	private Long recordId;
	@Positive(message = "Stock cannot be negative or zero")
	private Integer count;

}

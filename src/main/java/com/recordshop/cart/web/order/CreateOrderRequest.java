package com.recordshop.cart.web.order;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import com.recordshop.cart.web.item.OrderRecordItemRequest;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class CreateOrderRequest {
	
	@NotEmpty(message = "Order must have at least one item")
	private List<OrderRecordItemRequest> itemsRequest;
		
}

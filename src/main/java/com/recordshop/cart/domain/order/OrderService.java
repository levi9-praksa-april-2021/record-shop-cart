package com.recordshop.cart.domain.order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.recordshop.cart.domain.item.OrderRecordItem;
import com.recordshop.cart.domain.item.OrderRecordItemRepository;
import com.recordshop.cart.web.client.RecordClient;
import com.recordshop.cart.web.item.OrderRecordItemRequest;
import com.recordshop.cart.web.item.RecordDTO;
import com.recordshop.cart.web.order.CreateOrderRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {
	
	private final OrderRepository orderRepository;
	private final RecordClient recordClient;

	public Order create(CreateOrderRequest request) {
		
		List<OrderRecordItem> items = new ArrayList<OrderRecordItem>();
		BigDecimal sumPriceOrder = new BigDecimal(0.0);
		
		for (OrderRecordItemRequest itemDto : request.getItemsRequest()) {			
			RecordDTO record = recordClient.findRecordById(itemDto.getRecordId());
			
			if(record.getStock() < itemDto.getCount()) {				
				throw new InvalidOrderStockException("Not enough in stock: " + record.getTitle());
			}			
			BigDecimal sumPriceItem = record.getPrice().multiply(new BigDecimal(itemDto.getCount()));
			
			OrderRecordItem item = OrderRecordItem.builder()
					.id(null)
					.recordId(itemDto.getRecordId())
					.count(itemDto.getCount())
					.price(sumPriceItem)
					.build();
			
			items.add(item);	
			
			sumPriceOrder = sumPriceOrder.add(sumPriceItem);		
			
			Integer newStock = record.getStock() - item.getCount();
			recordClient.updateStock(record.getId(), newStock);
			
		}
		
     	Order order = Order.builder()
				.id(null)
				.priceSum(sumPriceOrder)
				.items(items)
				.build();
     	
    	return orderRepository.save(order);
    	
	}

}

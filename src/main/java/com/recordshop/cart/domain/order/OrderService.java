package com.recordshop.cart.domain.order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.recordshop.cart.domain.item.OrderRecordItem;
import com.recordshop.cart.domain.item.OrderRecordItemRepository;
import com.recordshop.cart.web.item.OrderRecordItemRequest;
import com.recordshop.cart.web.item.RecordDTO;
import com.recordshop.cart.web.order.CreateOrderRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {
	
	private final OrderRepository orderRepository;
	private final OrderRecordItemRepository orderRecordItemRepository;
	
	private RecordDTO getRecord(Long recordId) {
		
		RestTemplate restTemplate = new RestTemplate();
		RecordDTO record = restTemplate.getForObject("http://localhost:8080/records/" + recordId, RecordDTO.class);
		
		return record;
	}
	
	public Order create(CreateOrderRequest request) {
		
		List<OrderRecordItem> items = new ArrayList<OrderRecordItem>();
		BigDecimal sumPriceOrder = new BigDecimal(0.0);
		
		for (OrderRecordItemRequest itemDto : request.getItemsRequest()) {			
			RecordDTO record = getRecord(itemDto.getRecordId());
			
			if(record.getStock() < itemDto.getCount()) {
				continue;
			}			
			BigDecimal sumPriceItem = record.getPrice().multiply(new BigDecimal(itemDto.getCount()));
			
			OrderRecordItem item = OrderRecordItem.builder()
					.id(null)
					.recordId(itemDto.getRecordId())
					.count(itemDto.getCount())
					.price(sumPriceItem)
					.build();
			
			orderRecordItemRepository.save(item);
			items.add(item);	
			
			sumPriceOrder = sumPriceOrder.add(sumPriceItem);							
		}
		
		System.out.println(sumPriceOrder.setScale(1));
     	Order order = Order.builder()
				.id(null)
				.priceSum(sumPriceOrder.setScale(1))
				.items(items)
				.build();
     	
    	return orderRepository.save(order);
	}

}

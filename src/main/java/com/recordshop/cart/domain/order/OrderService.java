package com.recordshop.cart.domain.order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.recordshop.cart.web.client.RecordsDTO;
import com.recordshop.cart.web.item.OrderRecordItemDTO;
import org.springframework.stereotype.Service;

import com.recordshop.cart.web.client.RecordClient;
import com.recordshop.cart.web.item.OrderRecordItemRequest;
import com.recordshop.cart.web.client.RecordDTO;
import com.recordshop.cart.web.order.CreateOrderRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {
	
	private final OrderRepository orderRepository;
	private final RecordClient recordClient;

	public Order create(CreateOrderRequest request) {
		String filter = buildFilter(request.getItemsRequest());
		List<RecordDTO> records = recordClient.getRecords(filter).getRecords();

		if (records.size() < request.getItemsRequest().size())
			throw new RuntimeException();

		List<OrderRecordItem> items = new ArrayList<>();
		for (int i = 0; i < records.size(); i++) {
			OrderRecordItemRequest orderItem = request.getItemsRequest().get(i);
			RecordDTO record = records.get(i);
			if(record.getStock() < orderItem.getCount()) {
				throw new InvalidOrderStockException("Not enough in stock: " + record.getTitle());
			}

			OrderRecordItem item = OrderRecordItem.builder()
					.id(null)
					.recordId(orderItem.getRecordId())
					.count(orderItem.getCount())
					.price(record.getPrice().multiply(new BigDecimal(orderItem.getCount())))
					.build();

			items.add(item);

			// update stock
			recordClient.updateStock(record.getId(), record.getStock() - item.getCount());
		}

		Order order = new Order(null, items);
    	return orderRepository.save(order);
    	
	}

	private String buildFilter(List<OrderRecordItemRequest> items) {
		StringBuilder sb = new StringBuilder();
		items.forEach(item -> sb.append(item.getRecordId()).append(','));
		sb.deleteCharAt(sb.lastIndexOf(","));

		return String.format("id=in=(%s)", sb.toString());
	}


}

package com.recordshop.cart.web.client;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.recordshop.cart.web.item.RecordDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RecordClient {

	private final RestTemplate restTemplate;
	
	public RecordDTO findRecordById(Long id) {
		RecordDTO record = restTemplate.getForObject("http://record-shop-cart/records/" + id, RecordDTO.class);
		return record;
	}
	
	public void updateStock(Long recordId, Integer stock) {
		restTemplate.put("http://record-shop-catalog/records/updateStock/" + recordId + "/" + stock, null);
	}
}

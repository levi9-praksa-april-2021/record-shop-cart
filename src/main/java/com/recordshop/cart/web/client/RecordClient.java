package com.recordshop.cart.web.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("record-shop-catalog")
public interface RecordClient {
	@RequestMapping(method = RequestMethod.GET, value="/records")
	RecordsDTO getRecords(@RequestParam String filter);

	@RequestMapping(method = RequestMethod.PUT, value="/records/updateStock/{recordId}/{stock}")
	void updateStock(@PathVariable Long recordId, @PathVariable int stock);
}

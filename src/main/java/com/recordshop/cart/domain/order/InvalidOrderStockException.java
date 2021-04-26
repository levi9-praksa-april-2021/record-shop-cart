package com.recordshop.cart.domain.order;

public class InvalidOrderStockException extends RuntimeException {
	public InvalidOrderStockException(String msg) {
		super(msg);
	}
}

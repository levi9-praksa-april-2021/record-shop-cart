package com.recordshop.cart.domain.order;

public class InvalidOrderStockException extends Exception {
	public InvalidOrderStockException(String msg) {
		super(msg);
	}
}

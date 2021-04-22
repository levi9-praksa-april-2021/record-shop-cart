package com.recordshop.cart.web.core.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.recordshop.cart.domain.order.InvalidOrderStockException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice("com.recordshop.cart.web")
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(InvalidOrderStockException.class)
    protected ResponseEntity<Object> handleInvalidOrderStock(
    		InvalidOrderStockException ex
    ) {
        ApiError error = new ApiError(HttpStatus.BAD_REQUEST, ex.getMessage());
        return ResponseEntity.status(error.getStatus()).body(error);
    }
}

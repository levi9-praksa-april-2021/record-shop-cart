package com.recordshop.cart.domain.order;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.recordshop.cart.domain.order.Order;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name="order_record_item")
public class OrderRecordItem {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name="record_id", nullable = false)
	private Long recordId;
	
	@Column(name="count", nullable = false)
	private Integer count;
	
	@Column(name="price", nullable = false)
	private BigDecimal price;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Order order;
	
}

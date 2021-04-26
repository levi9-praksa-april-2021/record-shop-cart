package com.recordshop.cart.domain.order;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name="[order]")
public class Order {

	public Order(Long id, List<OrderRecordItem> items) {
		this.id = id;
		this.items = items;
		this.priceSum = items.stream().map(OrderRecordItem::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@OneToMany(mappedBy = "order", cascade=CascadeType.ALL)
	private List<OrderRecordItem> items;
	
	@Column(name="price_sum", nullable = false)
	private BigDecimal priceSum;
	
}

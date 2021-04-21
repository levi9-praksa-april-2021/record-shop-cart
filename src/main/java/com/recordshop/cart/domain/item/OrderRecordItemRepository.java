package com.recordshop.cart.domain.item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface OrderRecordItemRepository extends JpaRepository<OrderRecordItem, Long>, JpaSpecificationExecutor<OrderRecordItem>{

}

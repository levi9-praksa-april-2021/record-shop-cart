package com.recordshop.cart.web.order;

import com.recordshop.cart.domain.order.Order;
import com.recordshop.cart.domain.order.OrderRecordItem;
import com.recordshop.cart.web.item.OrderRecordItemDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-05-05T13:13:55+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 14 (Oracle Corporation)"
)
@Component
public class OrderMapperImpl implements OrderMapper {

    @Override
    public OrderDTO toDto(Order order) {
        if ( order == null ) {
            return null;
        }

        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setId( order.getId() );
        orderDTO.setItems( orderRecordItemListToOrderRecordItemDTOList( order.getItems() ) );
        orderDTO.setPriceSum( order.getPriceSum() );

        return orderDTO;
    }

    protected OrderRecordItemDTO orderRecordItemToOrderRecordItemDTO(OrderRecordItem orderRecordItem) {
        if ( orderRecordItem == null ) {
            return null;
        }

        OrderRecordItemDTO orderRecordItemDTO = new OrderRecordItemDTO();

        orderRecordItemDTO.setRecordId( orderRecordItem.getRecordId() );
        orderRecordItemDTO.setCount( orderRecordItem.getCount() );
        orderRecordItemDTO.setPrice( orderRecordItem.getPrice() );

        return orderRecordItemDTO;
    }

    protected List<OrderRecordItemDTO> orderRecordItemListToOrderRecordItemDTOList(List<OrderRecordItem> list) {
        if ( list == null ) {
            return null;
        }

        List<OrderRecordItemDTO> list1 = new ArrayList<OrderRecordItemDTO>( list.size() );
        for ( OrderRecordItem orderRecordItem : list ) {
            list1.add( orderRecordItemToOrderRecordItemDTO( orderRecordItem ) );
        }

        return list1;
    }
}

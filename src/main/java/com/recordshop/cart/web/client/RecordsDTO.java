package com.recordshop.cart.web.client;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class RecordsDTO {
    private List<RecordDTO> records;
}

package com.supermarket.pos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/

@Data
@AllArgsConstructor
public class OrderDetailDTO {
    private String orderId;
    private String itemCode;
    private double price;
    private int qty;
}

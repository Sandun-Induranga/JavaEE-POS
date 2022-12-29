package com.supermarket.pos.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/

@Data
@AllArgsConstructor
public class OrderDetail {
    private String orderId;
    private String code;
    private double price;
    private int qty;
}

package com.supermarket.pos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/

@Data
@AllArgsConstructor
public class OrderDTO {
    private String orderId;
    private String cusId;
    private double cost;
    private String orderDate;
}

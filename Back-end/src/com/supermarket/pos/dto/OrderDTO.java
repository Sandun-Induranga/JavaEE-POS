package com.supermarket.pos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

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
    private List<OrderDetailDTO> orderDetails;
}

package com.supermarket.pos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/

@Data
@AllArgsConstructor
public class ItemDTO {
    private String code;
    private String name;
    private String qtyOnHand;
    private double price;
}

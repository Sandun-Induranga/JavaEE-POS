package com.supermarket.pos.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/

@Data
@AllArgsConstructor
public class Item {
    private String code;
    private String name;
    private int qty;
    private double price;
}

package com.supermarket.pos.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/

@Data
@AllArgsConstructor
@ToString
public class Customer {
    String customerId;
    String customerName;
    String address;
    double salary;
}

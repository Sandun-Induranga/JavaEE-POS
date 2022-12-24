package com.supermarket.pos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/

@AllArgsConstructor
@Data
@ToString
public class CustomerDTO {
    String cusId;
    String cusName;
    String address;
    String salary;
}

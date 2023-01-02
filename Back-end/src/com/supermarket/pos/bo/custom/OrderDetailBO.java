package com.supermarket.pos.bo.custom;

import com.supermarket.pos.bo.SuperBO;
import com.supermarket.pos.dto.OrderDetailDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/

public interface OrderDetailBO extends SuperBO {
    ArrayList<OrderDetailDTO> getAllOrderDetails(Connection connection) throws SQLException, ClassNotFoundException;
}

package com.supermarket.pos.dao.custom;

import com.supermarket.pos.dao.CrudDAO;
import com.supermarket.pos.entity.Order;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/

public interface OrderDAO extends CrudDAO<Connection, Order, String> {
    String generateNewOrderId(Connection connection) throws SQLException, ClassNotFoundException;
}

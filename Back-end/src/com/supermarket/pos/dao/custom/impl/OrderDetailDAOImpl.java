package com.supermarket.pos.dao.custom.impl;

import com.supermarket.pos.dao.SQLUtil;
import com.supermarket.pos.dao.custom.OrderDetailDAO;
import com.supermarket.pos.entity.OrderDetail;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/

public class OrderDetailDAOImpl implements OrderDetailDAO {
    @Override
    public ArrayList<OrderDetail> getAll(Connection connection) throws SQLException, ClassNotFoundException {

        ResultSet rst = SQLUtil.executeQuery(connection, "SELECT * FROM Order_Detail");
        ArrayList<OrderDetail> orderDetails = new ArrayList<>();

        while (rst.next()) {
            orderDetails.add(new OrderDetail(rst.getString(1), rst.getString(2),rst.getDouble(3),rst.getInt(4)));
        }

        return orderDetails;

    }

    @Override
    public boolean save(Connection connection, OrderDetail entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate(connection, "INSERT INTO Order_Detail VALUES (?,?,?,?)", entity.getOrderId(), entity.getCode(), entity.getPrice(), entity.getQty());
    }

    @Override
    public boolean update(Connection connection, OrderDetail dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public OrderDetail search(Connection connection, String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean exit(Connection connection, String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(Connection connection, String s) throws SQLException, ClassNotFoundException {
        return false;
    }
}

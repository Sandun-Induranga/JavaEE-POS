package com.supermarket.pos.dao.custom.impl;

import com.supermarket.pos.dao.SQLUtil;
import com.supermarket.pos.dao.custom.ItemDAO;
import com.supermarket.pos.entity.Item;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/

public class ItemDAOImpl implements ItemDAO {
    @Override
    public ArrayList<Item> getAll(Connection connection) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.executeQuery(connection, "SELECT * FROM Item");
        ArrayList<Item> allItems = new ArrayList<>();
        while (rst.next()) {
            allItems.add(new Item(rst.getString(1), rst.getString(2), rst.getInt(3), rst.getDouble(4)));
        }
        return allItems;
    }

    @Override
    public boolean save(Connection connection, Item entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate(connection, "INSERT INTO Item VALUES (?,?,?,?)", entity.getCode(), entity.getName(), entity.getQty(), entity.getPrice());
    }

    @Override
    public boolean update(Connection connection, Item entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate(connection, "UPDATE Customer name=?, qty=?, price=? WHERE code=?", entity.getCode(), entity.getName(), entity.getQty(), entity.getPrice());
    }

    @Override
    public Item search(Connection connection, String s) throws SQLException, ClassNotFoundException {
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

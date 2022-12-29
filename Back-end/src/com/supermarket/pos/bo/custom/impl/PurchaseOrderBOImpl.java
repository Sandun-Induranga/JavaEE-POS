package com.supermarket.pos.bo.custom.impl;

import com.supermarket.pos.bo.custom.PurchaseOrderBO;
import com.supermarket.pos.dao.DAOFactory;
import com.supermarket.pos.dao.custom.OrderDAO;
import com.supermarket.pos.dto.CustomerDTO;
import com.supermarket.pos.dto.ItemDTO;
import com.supermarket.pos.dto.OrderDTO;
import com.supermarket.pos.entity.Order;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/

public class PurchaseOrderBOImpl implements PurchaseOrderBO {

    OrderDAO orderDAO = (OrderDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ORDER);

    @Override
    public boolean purchaseOrder(Connection connection, OrderDTO order) throws SQLException, ClassNotFoundException {
        connection.setAutoCommit(false);

        if (orderDAO.save(connection, new Order(order.getOrderId(), order.getCusId(), order.getCost(), order.getOrderDate()))) {
            connection.rollback();
            connection.setAutoCommit(true);
            return false;
        }

    }

    @Override
    public CustomerDTO searchCustomer(Connection connection, String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ItemDTO searchItem(Connection connection, String code) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean checkItemIsAvailable(Connection connection, String code) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean checkCustomerIsAvailable(Connection connection, String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String generateNewOrderID(Connection connection) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomers(Connection connection) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<ItemDTO> getAllItems(Connection connection) throws SQLException, ClassNotFoundException {
        return null;
    }
}

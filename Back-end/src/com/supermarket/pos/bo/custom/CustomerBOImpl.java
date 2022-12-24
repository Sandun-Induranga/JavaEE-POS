package com.supermarket.pos.bo.custom;

import com.supermarket.pos.bo.SuperBO;
import com.supermarket.pos.dto.CustomerDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/
public class CustomerBOImpl implements CustomerBO, SuperBO {
    @Override
    public ArrayList<CustomerDTO> getAllCustomer(Connection connection) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean saveCustomer(Connection connection, CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean updateCustomer(Connection connection, CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean exitsCustomer(Connection connection, String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public void deleteCustomer(Connection connection, String id) throws SQLException, ClassNotFoundException {

    }

    @Override
    public String generateNewCustomerId(Connection connection) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<CustomerDTO> filterCustomers(Connection connection, String field, String value) throws SQLException, ClassNotFoundException {
        return null;
    }
}

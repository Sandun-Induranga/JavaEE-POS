package com.supermarket.pos.bo.custom;

import com.supermarket.pos.dto.CustomerDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/

public interface CustomerBO {
    ArrayList<CustomerDTO> getAllCustomers(Connection connection) throws SQLException, ClassNotFoundException;

    boolean saveCustomer(Connection connection, CustomerDTO customerDTO) throws SQLException, ClassNotFoundException;

    boolean updateCustomer(Connection connection, CustomerDTO customerDTO) throws SQLException, ClassNotFoundException;

    boolean exitsCustomer(Connection connection, String id) throws SQLException, ClassNotFoundException;

    void deleteCustomer(Connection connection, String id) throws SQLException, ClassNotFoundException;

    String generateNewCustomerId(Connection connection) throws SQLException, ClassNotFoundException;

    ArrayList<CustomerDTO> filterCustomers(Connection connection, String field, String value) throws SQLException, ClassNotFoundException;
}

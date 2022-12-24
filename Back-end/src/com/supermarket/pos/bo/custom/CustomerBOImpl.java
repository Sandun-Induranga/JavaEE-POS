package com.supermarket.pos.bo.custom;

import com.supermarket.pos.bo.SuperBO;
import com.supermarket.pos.dao.DAOFactory;
import com.supermarket.pos.dao.custom.CustomerDAO;
import com.supermarket.pos.dto.CustomerDTO;
import com.supermarket.pos.entity.Customer;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/
public class CustomerBOImpl implements CustomerBO, SuperBO {

    private final CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CUSTOMER);

    @Override
    public ArrayList<CustomerDTO> getAllCustomers(Connection connection) throws SQLException, ClassNotFoundException {
        ArrayList<CustomerDTO> allCustomers = new ArrayList<>();
        ArrayList<Customer> all = customerDAO.getAll(connection);
        for (Customer customer : all
        ) {
            allCustomers.add(new CustomerDTO(customer.getCustomerId(), customer.getCustomerName(), customer.getAddress(), customer.getSalary()));
        }
        return allCustomers;
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

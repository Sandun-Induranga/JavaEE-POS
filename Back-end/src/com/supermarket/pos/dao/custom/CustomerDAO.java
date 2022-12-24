package com.supermarket.pos.dao.custom;

import com.supermarket.pos.dao.CrudDAO;
import com.supermarket.pos.entity.Customer;

import java.sql.Connection;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/
public interface CustomerDAO extends CrudDAO<Connection, Customer, String> {
}

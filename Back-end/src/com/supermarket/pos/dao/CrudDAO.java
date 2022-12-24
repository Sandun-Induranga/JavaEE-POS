package com.supermarket.pos.dao;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/
public interface CrudDAO<CONNECTION, T, ID> extends SuperDAO {
    ArrayList<T> getAll(CONNECTION connection) throws SQLException, ClassNotFoundException;

    boolean save(CONNECTION connection, T dto) throws SQLException, ClassNotFoundException;

    boolean update(CONNECTION connection, T dto) throws SQLException, ClassNotFoundException;

    T search(CONNECTION connection, ID id) throws SQLException, ClassNotFoundException;

    boolean exit(CONNECTION connection, ID id) throws SQLException, ClassNotFoundException;

    boolean delete(CONNECTION connection, ID id) throws SQLException, ClassNotFoundException;

}

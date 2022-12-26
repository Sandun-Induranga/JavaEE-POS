package com.supermarket.pos.bo.custom;

import com.supermarket.pos.dto.ItemDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/

public interface ItemBO {

    ArrayList<ItemDTO> getAllItems(Connection connection) throws SQLException, ClassNotFoundException;

    void deleteItems(Connection connection, String id) throws SQLException, ClassNotFoundException;

    void saveItem(Connection connection, ItemDTO itemDTO) throws SQLException, ClassNotFoundException;

    void updateItem(Connection connection, ItemDTO itemDTO) throws SQLException, ClassNotFoundException;

    boolean exitsItem(Connection connection, String id) throws SQLException, ClassNotFoundException;

}

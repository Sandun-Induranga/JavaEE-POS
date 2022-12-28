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

    boolean deleteItems(Connection connection, String id) throws SQLException, ClassNotFoundException;

    boolean saveItem(Connection connection, ItemDTO itemDTO) throws SQLException, ClassNotFoundException;

    boolean updateItem(Connection connection, ItemDTO itemDTO) throws SQLException, ClassNotFoundException;

    boolean exitsItem(Connection connection, String id) throws SQLException, ClassNotFoundException;

}

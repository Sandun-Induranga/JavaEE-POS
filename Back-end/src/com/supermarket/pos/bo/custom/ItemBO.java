package com.supermarket.pos.bo.custom;

import com.supermarket.pos.dto.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/

public interface ItemBO {

    ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException;

    void deleteItems(String id) throws SQLException, ClassNotFoundException;

    void saveItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException;

    void updateItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException;

    boolean exitsItem(String id) throws SQLException, ClassNotFoundException;

}

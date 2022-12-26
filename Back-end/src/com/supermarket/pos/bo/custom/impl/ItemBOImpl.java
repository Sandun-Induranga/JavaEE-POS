package com.supermarket.pos.bo.custom.impl;

import com.supermarket.pos.bo.SuperBO;
import com.supermarket.pos.bo.custom.ItemBO;
import com.supermarket.pos.dto.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/

public class ItemBOImpl implements ItemBO, SuperBO {
    @Override
    public ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public void deleteItems(String id) throws SQLException, ClassNotFoundException {

    }

    @Override
    public void saveItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {

    }

    @Override
    public void updateItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {

    }

    @Override
    public boolean exitsItem(String id) throws SQLException, ClassNotFoundException {
        return false;
    }
}

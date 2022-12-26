package com.supermarket.pos.bo.custom.impl;

import com.supermarket.pos.bo.SuperBO;
import com.supermarket.pos.bo.custom.ItemBO;
import com.supermarket.pos.dao.DAOFactory;
import com.supermarket.pos.dao.custom.ItemDAO;
import com.supermarket.pos.dto.ItemDTO;
import com.supermarket.pos.entity.Item;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/

public class ItemBOImpl implements ItemBO, SuperBO {

    ItemDAO itemDAO = (ItemDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ITEM);

    @Override
    public ArrayList<ItemDTO> getAllItems(Connection connection) throws SQLException, ClassNotFoundException {
        ArrayList<Item> all = itemDAO.getAll(connection);
        ArrayList<ItemDTO> allItems = new ArrayList<>();
        for (Item item :
                all) {
            allItems.add(new ItemDTO(item.getCode(), item.getName(), item.getQty(), item.getPrice()));
        }
        return allItems;
    }

    @Override
    public void deleteItems(Connection connection, String id) throws SQLException, ClassNotFoundException {

    }

    @Override
    public void saveItem(Connection connection, ItemDTO item) throws SQLException, ClassNotFoundException {
        itemDAO.save(connection, new Item(item.getCode(), item.getName(), item.getQtyOnHand(), item.getPrice()))
    }

    @Override
    public void updateItem(Connection connection, ItemDTO itemDTO) throws SQLException, ClassNotFoundException {

    }

    @Override
    public boolean exitsItem(Connection connection, String id) throws SQLException, ClassNotFoundException {
        return false;
    }
}

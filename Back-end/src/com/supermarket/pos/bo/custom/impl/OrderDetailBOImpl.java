package com.supermarket.pos.bo.custom.impl;

import com.supermarket.pos.bo.SuperBO;
import com.supermarket.pos.bo.custom.OrderDetailBO;
import com.supermarket.pos.dao.DAOFactory;
import com.supermarket.pos.dao.custom.OrderDetailDAO;
import com.supermarket.pos.dto.OrderDetailDTO;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/

public class OrderDetailBOImpl implements OrderDetailBO, SuperBO {

    private final OrderDetailDAO orderDetailDAO = (OrderDetailDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ORDER_DETAILS);

    @Override
    public ArrayList<OrderDetailDTO> getAllOrderDetails() throws SQLException, ClassNotFoundException {
        return null;
    }
}

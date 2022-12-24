package com.supermarket.pos.dao;

import com.supermarket.pos.dao.custom.impl.CustomerDAOImpl;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {

    }

    public static DAOFactory getInstance() {
        return daoFactory == null ? new DAOFactory() : daoFactory;
    }

    public enum DAOTypes {
        CUSTOMER, ITEM, ORDER, ORDER_DETAILS
    }

    public SuperDAO getDAO(DAOTypes types) {
        switch (types) {
            case CUSTOMER:
                return new CustomerDAOImpl();
            default:
                return null;
        }
    }

}

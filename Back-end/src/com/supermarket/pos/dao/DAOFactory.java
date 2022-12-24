package com.supermarket.pos.dao;

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

}

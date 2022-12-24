package com.supermarket.pos.bo;

import com.supermarket.pos.bo.custom.CustomerBOImpl;
import com.supermarket.pos.dao.DAOFactory;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/
public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory() {

    }

    public static BOFactory getInstance() {
        return boFactory == null ? new BOFactory() : boFactory;
    }

    public enum DAOTypes {
        CUSTOMER, ITEM, ORDER, ORDER_DETAILS
    }

    public SuperBO getBO(DAOFactory.DAOTypes types) {
        switch (types) {
            case CUSTOMER:
                return new CustomerBOImpl();
            default:
                return null;
        }
    }

}

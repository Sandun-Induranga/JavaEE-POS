package com.supermarket.pos.bo;

import com.supermarket.pos.bo.custom.impl.CustomerBOImpl;
import com.supermarket.pos.bo.custom.impl.ItemBOImpl;
import com.supermarket.pos.bo.custom.impl.PurchaseOrderBOImpl;

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

    public enum BOTypes {
        CUSTOMER, ITEM, ORDER, ORDER_DETAILS
    }

    public SuperBO getBO(BOTypes types) {
        switch (types) {
            case CUSTOMER:
                return new CustomerBOImpl();
            case ITEM:
                return new ItemBOImpl();
            case ORDER:
                return new PurchaseOrderBOImpl();
            default:
                return null;
        }
    }

}

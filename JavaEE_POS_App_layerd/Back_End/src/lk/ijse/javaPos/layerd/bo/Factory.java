package lk.ijse.javaPos.layerd.bo;

import lk.ijse.javaPos.layerd.bo.custom.impl.CustomerBOImpl;

/**
 * @authority DUSHAN MALINDA
 */
public class Factory {

    private static Factory factory;

    private Factory(){
    }

    public static Factory getFactory(){
        if (factory==null){
            factory=new Factory();
        }
        return factory;
    }

    public enum BOType{
        CUSTOMER,ITEM,ORDERS,ORDERDETAILS;
    }

    public SuperBo getBO(BOType boType){
        switch (boType){
            case CUSTOMER:
                return new CustomerBOImpl();
           /* case ITEM:
                return new ItemBOImpl();
            case ORDERS:
                return new OrdersBOImpl();
            case ORDERDETAILS:
                return new OrderDetailsBOImpl();*/
        }
        return null;
    }
}

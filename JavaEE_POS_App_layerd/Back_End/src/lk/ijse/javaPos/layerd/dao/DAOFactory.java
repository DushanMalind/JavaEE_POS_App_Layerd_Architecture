package lk.ijse.javaPos.layerd.dao;

import lk.ijse.javaPos.layerd.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.javaPos.layerd.dao.custom.impl.ItemDAOImpl;
import lk.ijse.javaPos.layerd.dao.custom.impl.OrderDetailsDAOImpl;
import lk.ijse.javaPos.layerd.dao.custom.impl.OrdersDAOImpl;

/**
 * @authority DUSHAN MALINDA
 */
public class DAOFactory {

    private static DAOFactory daoFactory;

    private DAOFactory() {
    }

    public static DAOFactory getDaoFactory(){
        if (daoFactory==null){
            daoFactory=new DAOFactory();
        }
        return daoFactory;
    }

    public enum DAOTypes{
        CUSTOMER,ITEM,ORDERS,ORDERDETAILS;
    }

    public SuperDAO getDao(DAOTypes daoTypes){
        switch (daoTypes){
            case CUSTOMER:
                return new CustomerDAOImpl();
            case ITEM:
                return new ItemDAOImpl();
            case ORDERS:
                return new OrdersDAOImpl();
            case ORDERDETAILS:
                return new OrderDetailsDAOImpl();

        }
        return null;
    }
}

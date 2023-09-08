package lk.ijse.javaPos.layerd.bo.custom;

import lk.ijse.javaPos.layerd.bo.SuperBo;
import lk.ijse.javaPos.layerd.model.ItemDTO;
import lk.ijse.javaPos.layerd.model.OrdersDTO;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @authority DUSHAN MALINDA
 */
public interface PurchaseBO extends SuperBo {
    boolean purchaseOrder(OrdersDTO dto, Connection connection);

    ItemDTO searchItem(String id,Connection connection) throws SQLException, ClassNotFoundException;

    boolean UpdateQty(ItemDTO dto, Connection connection) throws SQLException, ClassNotFoundException;

    //boolean saveOrder(OrdersDTO ordersDTO,Connection connection) throws Exception;

}

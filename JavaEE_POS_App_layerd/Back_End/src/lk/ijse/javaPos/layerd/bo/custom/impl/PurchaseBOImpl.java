package lk.ijse.javaPos.layerd.bo.custom.impl;

import lk.ijse.javaPos.layerd.bo.custom.PurchaseBO;
import lk.ijse.javaPos.layerd.dao.DAOFactory;
import lk.ijse.javaPos.layerd.dao.custom.ItemDAO;
import lk.ijse.javaPos.layerd.dao.custom.OrdersDAO;
import lk.ijse.javaPos.layerd.dao.custom.OrdersDetailsDAO;
import lk.ijse.javaPos.layerd.entity.Item;
import lk.ijse.javaPos.layerd.entity.OrderDetails;
import lk.ijse.javaPos.layerd.entity.Orders;
import lk.ijse.javaPos.layerd.model.ItemDTO;
import lk.ijse.javaPos.layerd.model.OrderDetailsDTO;
import lk.ijse.javaPos.layerd.model.OrdersDTO;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @authority DUSHAN MALINDA
 */
public class PurchaseBOImpl implements PurchaseBO {

    OrdersDAO ordersDAO= (OrdersDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DAOTypes.ORDERS);

    OrdersDetailsDAO ordersDetailsDAO= (OrdersDetailsDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DAOTypes.ORDERDETAILS);

    ItemDAO itemDAO= (ItemDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DAOTypes.ITEM);



    @Override
    public boolean UpdateQty(ItemDTO dto, Connection connection) throws SQLException, ClassNotFoundException {
       return itemDAO.update(new Item(dto.getItemId(),dto.getDescription(),dto.getUnitPrice(),dto.getQtyOnHand()),connection);
    }

    /*@Override
    public boolean saveOrder(OrdersDTO ordersDTO, Connection connection) throws Exception {
        for (OrderDetailsDTO item:OrdersDTO.)
    }*/

    @Override
    public boolean purchaseOrder(OrdersDTO dto, Connection connection) {
        // connection=null;
        try {
            connection.setAutoCommit(false);
            boolean isAdded = ordersDAO.add(new Orders(dto.getOrdId(), dto.getDate(), dto.getCusId()),connection);
            if (!isAdded){
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }

           for(OrderDetailsDTO d: dto.getOrderDetails()){
               OrderDetails orderDetails = new OrderDetails(d.getOrdId(), d.getItemId(), d.getQty(), d.getUnitPrice());
                boolean isAdded1 = ordersDetailsDAO.add(orderDetails,connection);
                if (!isAdded1){
                    connection.rollback();
                    connection.setAutoCommit(true);
                    return false;
                }



           }

              ItemDTO itemDTO = new ItemDTO();
              for (OrderDetailsDTO d : dto.getOrderDetails()){
                itemDTO.setItemId(d.getItemId());
                  itemDTO.setQtyOnHand(itemDTO.getQtyOnHand() - d.getQty());
                    boolean isUpdated = itemDAO.update(new Item(itemDTO.getItemId(), itemDTO.getDescription(), itemDTO.getUnitPrice(), itemDTO.getQtyOnHand()),connection);
                if (!isUpdated){
                     connection.rollback();
                     connection.setAutoCommit(true);
                     return false;
                }
            }

            connection.commit();
            connection.setAutoCommit(true);
            return true;


        }catch (ClassNotFoundException e){
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //return false;
    }




}

package lk.ijse.javaPos.layerd.dao.custom.impl;

import lk.ijse.javaPos.layerd.dao.custom.OrdersDetailsDAO;
import lk.ijse.javaPos.layerd.entity.OrderDetails;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @authority DUSHAN MALINDA
 */
public class OrderDetailsDAOImpl implements OrdersDetailsDAO {
    @Override
    public ArrayList<OrderDetails> getAll(Connection connection) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean add(OrderDetails dto,Connection connection) throws SQLException, ClassNotFoundException {
        return connection.createStatement().executeUpdate("INSERT INTO orderdetails VALUES ('"+dto.getOrdId()+"','"+dto.getItemId()+"','"+dto.getQty()+"','"+dto.getUnitPrice()+"')")>0;
    }

    @Override
    public boolean update(OrderDetails dto,Connection connection) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean exist(String id,Connection connection) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String generateNewID(Connection connection) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean delete(String id,Connection connection) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public OrderDetails search(String id,Connection connection) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean UpdateQty(OrderDetails dto, Connection connection) throws SQLException, ClassNotFoundException {
        return false;
    }
}

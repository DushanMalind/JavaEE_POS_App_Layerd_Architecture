package lk.ijse.javaPos.layerd.dao.custom.impl;

import lk.ijse.javaPos.layerd.dao.custom.ItemDAO;
import lk.ijse.javaPos.layerd.entity.Item;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @authority DUSHAN MALINDA
 */
public class ItemDAOImpl implements ItemDAO {
    @Override
    public ArrayList<Item> getAll(Connection connection) throws SQLException, ClassNotFoundException {
        ArrayList<Item> allItem=new ArrayList<>();
        ResultSet rst=connection.createStatement().executeQuery("SELECT * FROM items");

        while (rst.next()){
            Item item=new Item(rst.getString("id"),rst.getString("description"),
                    rst.getDouble("unitPrice"),rst.getInt("qty"));
            allItem.add(item);
        }
        return allItem;
    }

    @Override
    public boolean add(Item dto,Connection connection) throws SQLException, ClassNotFoundException {
        return connection.createStatement().executeUpdate("INSERT INTO items VALUES ('"+dto.getItemId()+"','"+dto.getDescription()+"','"+dto.getQtyOnHand()+"','"+dto.getUnitPrice()+"')")>0;
    }

    @Override
    public boolean update(Item dto,Connection connection) throws SQLException, ClassNotFoundException {
        return connection.createStatement().executeUpdate("UPDATE items SET description='"+dto.getDescription()+"',qty='"+dto.getQtyOnHand()+"',unitPrice='"+dto.getUnitPrice()+"' WHERE id='"+dto.getItemId()+"'")>0;
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
    public Item search(String id,Connection connection) throws SQLException, ClassNotFoundException {
        return null;
    }
}

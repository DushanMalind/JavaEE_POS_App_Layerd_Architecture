package lk.ijse.javaPos.layerd.dao.custom.impl;

import lk.ijse.javaPos.layerd.dao.custom.ItemDAO;
import lk.ijse.javaPos.layerd.entity.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
        return connection.createStatement().executeUpdate("DELETE FROM items WHERE id='"+id+"'")>0;
    }

    @Override
    public Item search(String id,Connection connection) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean UpdateQty(Item dto, Connection connection) throws SQLException, ClassNotFoundException {
      //  return connection.createStatement().executeUpdate("UPDATE items SET qty=?'"+dto.getQtyOnHand()+"' WHERE id='"+dto.getItemId()+"'")>0;
        try {
            String updateQuery = "UPDATE items SET qty =qty - ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setInt(1, dto.getQtyOnHand()); // Assuming qty is an integer
            preparedStatement.setString(2, dto.getItemId()); // Assuming id is a string
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            // Handle any SQL exceptions here
            e.printStackTrace(); // Add appropriate error handling
            return false;
        }
    }
}

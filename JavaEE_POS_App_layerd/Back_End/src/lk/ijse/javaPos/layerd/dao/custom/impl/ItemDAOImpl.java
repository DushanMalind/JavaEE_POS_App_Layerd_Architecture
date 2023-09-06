package lk.ijse.javaPos.layerd.dao.custom.impl;

import lk.ijse.javaPos.layerd.dao.custom.ItemDAO;
import lk.ijse.javaPos.layerd.entity.Item;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @authority DUSHAN MALINDA
 */
public class ItemDAOImpl implements ItemDAO {
    @Override
    public ArrayList<Item> getAll(Connection connection) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean add(Item dto,Connection connection) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Item dto,Connection connection) throws SQLException, ClassNotFoundException {
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
    public Item search(String id,Connection connection) throws SQLException, ClassNotFoundException {
        return null;
    }
}

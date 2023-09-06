package lk.ijse.javaPos.layerd.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @authority DUSHAN MALINDA
 */
public interface CrudDAO <T>{
    ArrayList<T> getAll(Connection connection) throws SQLException, ClassNotFoundException;

    boolean add(T dto,Connection connection) throws SQLException, ClassNotFoundException;

    boolean update(T dto,Connection connection) throws SQLException, ClassNotFoundException;

    boolean exist(String id,Connection connection) throws SQLException, ClassNotFoundException;

    String generateNewID(Connection connection) throws SQLException, ClassNotFoundException;

    boolean delete(String id,Connection connection) throws SQLException, ClassNotFoundException;

    T search(String id,Connection connection) throws SQLException, ClassNotFoundException;
}

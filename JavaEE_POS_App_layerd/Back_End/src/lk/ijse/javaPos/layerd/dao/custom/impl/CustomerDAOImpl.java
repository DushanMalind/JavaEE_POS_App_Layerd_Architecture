package lk.ijse.javaPos.layerd.dao.custom.impl;

import lk.ijse.javaPos.layerd.dao.SQLUtil;
import lk.ijse.javaPos.layerd.dao.custom.CustomerDAO;
import lk.ijse.javaPos.layerd.entity.Customer;
import lk.ijse.javaPos.layerd.listener.MyListener;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @authority DUSHAN MALINDA
 */
public class CustomerDAOImpl implements CustomerDAO {


    @Override
    public ArrayList<Customer> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<Customer> allCustomers = new ArrayList<>();
        ResultSet rst = MyListener.connection.prepareStatement("SELECT * FROM Customer").executeQuery();
        while (rst.next()) {
            allCustomers.add(new Customer(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4)));
        }
        return allCustomers;
    }

    @Override
    public boolean add(Customer dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Customer dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Customer search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }
}

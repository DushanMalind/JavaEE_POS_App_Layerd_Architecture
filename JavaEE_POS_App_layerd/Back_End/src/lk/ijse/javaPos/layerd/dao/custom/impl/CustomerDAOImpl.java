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
    public ArrayList<Customer> getAll(Connection connection) throws SQLException, ClassNotFoundException {
        ArrayList<Customer> allCustomers = new ArrayList<>();
        //ResultSet rst = connection.createStatement().executeQuery("SELECT * FROM customer");
        ResultSet rst=connection.createStatement().executeQuery("SELECT * FROM customer");
       /* while (rst.next()) {
            allCustomers.add(new Customer(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4)));
        }
        return allCustomers;*/
        while (rst.next()){
            Customer customer=new Customer(rst.getString("id"),rst.getString("name"),
                    rst.getString("address"),rst.getString("contact"));
            allCustomers.add(customer);
        }


        //System.out.println("DAO"+allCustomers);

        return allCustomers;
    }

    @Override
    public boolean add(Customer dto,Connection connection) throws SQLException, ClassNotFoundException {
        return connection.createStatement().executeUpdate("INSERT INTO customer VALUES ('"+dto.getCusId()+"','"+dto.getName()+"','"+dto.getAddress()+"','"+dto.getContact()+"')")>0;
    }

    @Override
    public boolean update(Customer dto,Connection connection) throws SQLException, ClassNotFoundException {
        return connection.createStatement().executeUpdate("UPDATE customer SET name='"+dto.getName()+"',address='"+dto.getAddress()+"',contact='"+dto.getContact()+"' WHERE id='"+dto.getCusId()+"'")>0;
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
    public Customer search(String id,Connection connection) throws SQLException, ClassNotFoundException {
        return null;
    }
}

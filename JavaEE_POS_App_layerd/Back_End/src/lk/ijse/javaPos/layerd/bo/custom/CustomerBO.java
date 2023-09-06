package lk.ijse.javaPos.layerd.bo.custom;

import lk.ijse.javaPos.layerd.bo.SuperBo;
import lk.ijse.javaPos.layerd.model.CustomerDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @authority DUSHAN MALINDA
 */
public interface CustomerBO extends SuperBo {
    ArrayList<CustomerDTO> gelAllCustomer(Connection connection) throws SQLException, ClassNotFoundException;

    boolean addCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException;

    boolean updateCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException;

    boolean existCustomer(String id) throws SQLException, ClassNotFoundException;

    boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException;

    String genaRateNewId() throws SQLException, ClassNotFoundException;
}

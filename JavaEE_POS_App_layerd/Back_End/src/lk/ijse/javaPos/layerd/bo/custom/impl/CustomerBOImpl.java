package lk.ijse.javaPos.layerd.bo.custom.impl;

import lk.ijse.javaPos.layerd.bo.custom.CustomerBO;
import lk.ijse.javaPos.layerd.dao.DAOFactory;
import lk.ijse.javaPos.layerd.dao.custom.CustomerDAO;
import lk.ijse.javaPos.layerd.entity.Customer;
import lk.ijse.javaPos.layerd.model.CustomerDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @authority DUSHAN MALINDA
 */

public class CustomerBOImpl implements CustomerBO {

    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DAOTypes.CUSTOMER);

    @Override
    public ArrayList<CustomerDTO> gelAllCustomer(Connection connection) throws SQLException, ClassNotFoundException {
        ArrayList<CustomerDTO> allCustomer = new ArrayList<>();

        ArrayList<Customer> allEntity = customerDAO.getAll(connection);
        //System.out.println("DAO"+allEntity);
        for (Customer c:allEntity){
            allCustomer.add(new CustomerDTO(c.getCusId(),c.getName(),c.getAddress(),c.getContact()));
        }
        //System.out.println("BO"+allCustomer);
        return allCustomer;
    }

    @Override
    public boolean addCustomer(CustomerDTO dto,Connection connection) throws SQLException, ClassNotFoundException {
        return customerDAO.add(new Customer(dto.getCusId(),dto.getName(),dto.getAddress(),dto.getContact()),connection);
    }

    @Override
    public boolean updateCustomer(CustomerDTO dto,Connection connection) throws SQLException, ClassNotFoundException {
        return customerDAO.update(new Customer(dto.getCusId(),dto.getName(),dto.getAddress(),dto.getContact()),connection);
    }

    @Override
    public boolean existCustomer(String id,Connection connection) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean deleteCustomer(String id,Connection connection) throws SQLException, ClassNotFoundException {
        return customerDAO.delete(id,connection);
    }

    @Override
    public String genaRateNewId(Connection connection) throws SQLException, ClassNotFoundException {
        return null;
    }
}

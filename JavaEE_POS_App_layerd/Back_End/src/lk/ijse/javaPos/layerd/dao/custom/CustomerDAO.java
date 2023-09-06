package lk.ijse.javaPos.layerd.dao.custom;

import lk.ijse.javaPos.layerd.dao.CrudDAO;
import lk.ijse.javaPos.layerd.dao.SuperDAO;
import lk.ijse.javaPos.layerd.entity.Customer;

import java.sql.Connection;

/**
 * @authority DUSHAN MALINDA
 */
public interface CustomerDAO extends SuperDAO, CrudDAO<Customer> {
}

package lk.ijse.javaPos.layerd.bo.custom;

import lk.ijse.javaPos.layerd.bo.SuperBo;
import lk.ijse.javaPos.layerd.model.ItemDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @authority DUSHAN MALINDA
 */
public interface ItemBO extends SuperBo {
     ArrayList<ItemDTO> loadAllItem(Connection connection) throws SQLException, ClassNotFoundException;

     boolean updateItem(ItemDTO dto,Connection connection) throws SQLException, ClassNotFoundException;

     boolean deleteItem(String code,Connection connection) throws SQLException, ClassNotFoundException;

     boolean saveItem(ItemDTO dto,Connection connection) throws SQLException, ClassNotFoundException;

     boolean existItem(String code,Connection connection) throws SQLException, ClassNotFoundException;

     String generateNewIdItem(Connection connection) throws SQLException, ClassNotFoundException;
}

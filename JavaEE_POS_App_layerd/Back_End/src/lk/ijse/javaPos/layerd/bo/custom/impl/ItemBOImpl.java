package lk.ijse.javaPos.layerd.bo.custom.impl;

import lk.ijse.javaPos.layerd.bo.custom.ItemBO;
import lk.ijse.javaPos.layerd.dao.DAOFactory;
import lk.ijse.javaPos.layerd.dao.custom.ItemDAO;
import lk.ijse.javaPos.layerd.entity.Item;
import lk.ijse.javaPos.layerd.model.ItemDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @authority DUSHAN MALINDA
 */
public class ItemBOImpl implements ItemBO {

    ItemDAO itemDAO= (ItemDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DAOTypes.ITEM);

    @Override
    public ArrayList<ItemDTO> loadAllItem(Connection connection) throws SQLException, ClassNotFoundException {
        ArrayList<ItemDTO> allItem=new ArrayList<>();
        ArrayList<Item> allEntity=itemDAO.getAll(connection);

        for (Item i:allEntity){
            allItem.add(new ItemDTO(i.getItemId(),i.getDescription(),i.getUnitPrice(),i.getQtyOnHand()));
        }
        return allItem;

    }

    @Override
    public boolean updateItem(ItemDTO dto, Connection connection) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean deleteItem(String code, Connection connection) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean saveItem(ItemDTO dto, Connection connection) throws SQLException, ClassNotFoundException {
        return itemDAO.add(new Item(dto.getItemId(),dto.getDescription(),dto.getUnitPrice(),dto.getQtyOnHand()),connection);
    }

    @Override
    public boolean existItem(String code, Connection connection) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String generateNewIdItem(Connection connection) throws SQLException, ClassNotFoundException {
        return null;
    }
}

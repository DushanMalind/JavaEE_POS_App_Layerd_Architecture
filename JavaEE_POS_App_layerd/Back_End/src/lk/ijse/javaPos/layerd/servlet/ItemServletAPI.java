package lk.ijse.javaPos.layerd.servlet;

import lk.ijse.javaPos.layerd.bo.Factory;
import lk.ijse.javaPos.layerd.bo.custom.ItemBO;
import lk.ijse.javaPos.layerd.model.ItemDTO;
import lk.ijse.javaPos.layerd.util.ResponseUtil;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @authority DUSHAN MALINDA
 */

@WebServlet(urlPatterns = "/item")
public class ItemServletAPI extends HttpServlet {

    ItemBO itemBO= (ItemBO) Factory.getFactory().getBO(Factory.BOType.ITEM);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            BasicDataSource pool = (BasicDataSource) getServletContext().getAttribute("dbcp");
            Connection connection = pool.getConnection();

            ArrayList<ItemDTO> allItem = itemBO.loadAllItem(connection);
            JsonArrayBuilder allItems = Json.createArrayBuilder();

            for (ItemDTO i:allItem){
                JsonObjectBuilder itemObject = Json.createObjectBuilder();
                itemObject.add("id", i.getItemId());
                itemObject.add("description", i.getDescription());
                itemObject.add("unitPrice", i.getUnitPrice());
                itemObject.add("qty", i.getQtyOnHand());
                allItems.add(itemObject.build());
            }
            resp.getWriter().print(ResponseUtil.getJson("Success", "Loaded",allItems.build()));

            connection.close();

        }catch (ClassNotFoundException e){
            resp.setStatus(500);
            resp.getWriter().print(ResponseUtil.getJson("Error", "Something went wrong"));
        } catch (SQLException e) {
            resp.setStatus(500);
            resp.getWriter().print(ResponseUtil.getJson("Error", e.getMessage()));
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            BasicDataSource pool= (BasicDataSource) getServletContext().getAttribute("dbcp");
            Connection connection=pool.getConnection();

            String id=req.getParameter("code");
            String description=req.getParameter("description");
            double unitPrice=Double.parseDouble(req.getParameter("unitPrice"));
            int qty=Integer.parseInt(req.getParameter("qty"));

            itemBO.saveItem(new ItemDTO(id,description,unitPrice,qty),connection);

            resp.getWriter().print(ResponseUtil.getJson("Success","Item Added"));

            connection.close();

        }catch (ClassNotFoundException e){
            resp.setStatus(500);
            resp.getWriter().print(ResponseUtil.getJson("Error", "Something went wrong"));
        } catch (SQLException e) {
           resp.setStatus(500);
              resp.getWriter().print(ResponseUtil.getJson("Error", e.getMessage()));
        }
    }
}

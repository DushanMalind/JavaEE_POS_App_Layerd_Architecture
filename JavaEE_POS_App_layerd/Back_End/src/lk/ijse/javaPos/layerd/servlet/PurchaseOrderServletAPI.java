package lk.ijse.javaPos.layerd.servlet;

import lk.ijse.javaPos.layerd.bo.Factory;
import lk.ijse.javaPos.layerd.bo.custom.ItemBO;
import lk.ijse.javaPos.layerd.bo.custom.PurchaseBO;
import lk.ijse.javaPos.layerd.model.ItemDTO;
import lk.ijse.javaPos.layerd.model.OrderDetailsDTO;
import lk.ijse.javaPos.layerd.model.OrdersDTO;
import lk.ijse.javaPos.layerd.util.ResponseUtil;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.json.*;
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

@WebServlet(urlPatterns = "/purchaseOrder")
public class PurchaseOrderServletAPI extends HttpServlet {

    PurchaseBO purchaseBO = (PurchaseBO) Factory.getFactory().getBO(Factory.BOType.PURCHASE);

    ItemBO itemBO = (ItemBO) Factory.getFactory().getBO(Factory.BOType.ITEM);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BasicDataSource pool = (BasicDataSource) getServletContext().getAttribute("dbcp");
        try (Connection connection = pool.getConnection();){



            JsonReader reader = Json.createReader(req.getReader());
            JsonObject jsonObject = reader.readObject();

            String orderId = jsonObject.getString("orderId");
            String orderDate = jsonObject.getString("date");
            String customerId = jsonObject.getString("customerId");
            JsonArray cartItems = jsonObject.getJsonArray("cartItems");

            System.out.println(cartItems);

          /*  //boolean isUpdated = purchaseBO.UpdateQty(new ItemDTO(), connection);

            if (!isUpdated){
                resp.getWriter().print(ResponseUtil.getJson("Error", "Failed to update the qty"));
                //connection.close();
                return;
            }*/

            ArrayList<OrderDetailsDTO> orderDetailsDTOS = new ArrayList<>();
            for (JsonValue cartItem : cartItems) {
                String itemId = cartItem.asJsonObject().getString("code");
                String description = cartItem.asJsonObject().getString("description");
                String unitPrice = cartItem.asJsonObject().getString("unitPrice");
                String avQty=cartItem.asJsonObject().getString("qty");
                String qty = cartItem.asJsonObject().getString("qty");

                orderDetailsDTOS.add(new OrderDetailsDTO(orderId, itemId, Integer.parseInt(qty), Double.parseDouble(unitPrice)));

            }

            System.out.println(new OrdersDTO(orderId, orderDate, customerId,orderDetailsDTOS));

            boolean isAdded = purchaseBO.purchaseOrder(new OrdersDTO(orderId, orderDate, customerId,orderDetailsDTOS), connection);







            if (isAdded) {
                resp.getWriter().print(ResponseUtil.getJson("Success", "Orders Added"));
               // connection.close();
            } else {
                resp.getWriter().print(ResponseUtil.getJson("Success", "Orders Added"));
               // connection.close();
            }



            //connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}

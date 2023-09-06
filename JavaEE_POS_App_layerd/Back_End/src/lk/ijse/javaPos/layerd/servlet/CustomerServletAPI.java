package lk.ijse.javaPos.layerd.servlet;

import lk.ijse.javaPos.layerd.bo.Factory;
import lk.ijse.javaPos.layerd.bo.custom.CustomerBO;
import lk.ijse.javaPos.layerd.listener.MyListener;
import lk.ijse.javaPos.layerd.model.CustomerDTO;
import lk.ijse.javaPos.layerd.util.ResponseUtil;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
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

@WebServlet(urlPatterns = "/test")
public class CustomerServletAPI extends HttpServlet {

    CustomerBO customerBO = (CustomerBO) Factory.getFactory().getBO(Factory.BOType.CUSTOMER);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //System.out.println("Customer");
        try {

            BasicDataSource pool = (BasicDataSource) getServletContext().getAttribute("dbcp");
            //System.out.println("Pool:::"+pool);
            Connection connection = pool.getConnection();

            //System.out.println(connection);


           // customerBO.gelAllCustomer(connection);
            ArrayList<CustomerDTO> allCustomer = customerBO.gelAllCustomer(connection);
            JsonArrayBuilder allCustomers = Json.createArrayBuilder();
            System.out.println("API");
            //System.out.println("API"+allCustomer);
            for (CustomerDTO c : allCustomer) {
                JsonObjectBuilder customerObject = Json.createObjectBuilder();
                customerObject.add("id", c.getCusId());
                customerObject.add("name", c.getName());
                customerObject.add("address", c.getAddress());
                customerObject.add("contact", c.getContact());
                allCustomers.add(customerObject.build());
            }
            resp.getWriter().print(ResponseUtil.getJson("Success", "Loaded",allCustomers.build()));


            connection.close();
        } catch (SQLException e) {
            resp.setStatus(500);
            resp.getWriter().print(ResponseUtil.getJson("Error", e.getMessage()));
        } catch (ClassNotFoundException e) {
            resp.setStatus(500);
            resp.getWriter().print(ResponseUtil.getJson("Error", e.getMessage()));
            //  throw new RuntimeException(e);
        }
    }


}

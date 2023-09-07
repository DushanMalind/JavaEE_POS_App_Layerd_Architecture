package lk.ijse.javaPos.layerd.servlet;

import lk.ijse.javaPos.layerd.bo.Factory;
import lk.ijse.javaPos.layerd.bo.custom.CustomerBO;
import lk.ijse.javaPos.layerd.listener.MyListener;
import lk.ijse.javaPos.layerd.model.CustomerDTO;
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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
try {
            BasicDataSource pool = (BasicDataSource) getServletContext().getAttribute("dbcp");
            Connection connection = pool.getConnection();

            String id = req.getParameter("cusId");
            String name = req.getParameter("cusName");
            String address = req.getParameter("cusAddress");
            String contact = req.getParameter("contact");

            customerBO.addCustomer(new CustomerDTO(id,name,address,contact),connection);

            resp.getWriter().print(ResponseUtil.getJson("Success", "Customer Added"));

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

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            BasicDataSource pool = (BasicDataSource) getServletContext().getAttribute("dbcp");
            Connection connection = pool.getConnection();

            JsonReader reader = Json.createReader(req.getReader());
            JsonObject jsonObject = reader.readObject();
            String id = jsonObject.getString("cusId");
            String name = jsonObject.getString("cusName");
            String address = jsonObject.getString("cusAddress");
            String contact = jsonObject.getString("contact");

            customerBO.updateCustomer(new CustomerDTO(id,name,address,contact),connection);

            resp.getWriter().print(ResponseUtil.getJson("Success", "Customer update"));

            connection.close();

        }catch (ClassNotFoundException | SQLException e){
            resp.setStatus(500);
            resp.getWriter().print(ResponseUtil.getJson("Error", e.getMessage()));
        }
    }
}

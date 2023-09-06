package lk.ijse.javaPos.layerd.listener;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @authority DUSHAN MALINDA
 */
public class MyListener implements ServletContextListener {

    public static Connection connection;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("Context Initialized");

        ServletContext servletContext = servletContextEvent.getServletContext();

        BasicDataSource pool = new BasicDataSource();
        pool.setDriverClassName("com.mysql.jdbc.Driver");
        pool.setUrl("jdbc:mysql://localhost:3306/shop");
        pool.setUsername("root");
        pool.setPassword("1234");
        pool.setInitialSize(10);
        pool.setMaxTotal(10);

        try {
             connection=pool.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        servletContext.setAttribute("dbcp", pool);

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("Context Destroyed");
    }
}

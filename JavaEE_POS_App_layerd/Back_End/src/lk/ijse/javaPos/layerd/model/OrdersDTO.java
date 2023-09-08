package lk.ijse.javaPos.layerd.model;

import java.time.LocalDate;
import java.util.List;

/**
 * @authority DUSHAN MALINDA
 */
public class OrdersDTO {
    private String ordId;
    private String date;
    private String cusId;

    List<OrderDetailsDTO> orderDetails;

    public OrdersDTO() {
    }

    public OrdersDTO(String ordId, String date, String cusId) {
        this.ordId = ordId;
        this.date = date;
        this.cusId = cusId;
    }

    public OrdersDTO(String ordId, String date, String cusId, List<OrderDetailsDTO> orderDetails) {
        this.ordId = ordId;
        this.date = date;
        this.cusId = cusId;
        this.orderDetails = orderDetails;
    }

    public String getOrdId() {
        return ordId;
    }

    public void setOrdId(String ordId) {
        this.ordId = ordId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCusId() {
        return cusId;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
    }

    public List<OrderDetailsDTO> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetailsDTO> orderDetails) {
        this.orderDetails = orderDetails;
    }

    @Override
    public String toString() {
        return "OrdersDTO{" +
                "ordId='" + ordId + '\'' +
                ", date='" + date + '\'' +
                ", cusId='" + cusId + '\'' +
                ", orderDetails=" + orderDetails +
                '}';
    }
}



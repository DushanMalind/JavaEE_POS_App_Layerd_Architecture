package lk.ijse.javaPos.layerd.model;

import java.time.LocalDate;

/**
 * @authority DUSHAN MALINDA
 */
public class OrdersDTO {
    private String ordId;
    private String date;
    private String cusId;

    public OrdersDTO() {
    }

    public OrdersDTO(String ordId, String date, String cusId) {
        this.ordId = ordId;
        this.date = date;
        this.cusId = cusId;
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

    @Override
    public String toString() {
        return "OrdersDTO{" +
                "ordId='" + ordId + '\'' +
                ", date='" + date + '\'' +
                ", cusId='" + cusId + '\'' +
                '}';
    }
}



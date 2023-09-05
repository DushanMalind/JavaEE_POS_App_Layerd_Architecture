package lk.ijse.javaPos.layerd.model;

/**
 * @authority DUSHAN MALINDA
 */
public class OrderDetailsDTO {
    private String ordId;
    private String itemId;
    private int qty;
    private double unitPrice;


    public OrderDetailsDTO() {
    }

    public OrderDetailsDTO(String ordId, String itemId, int qty, double unitPrice) {
        this.ordId = ordId;
        this.itemId = itemId;
        this.qty = qty;
        this.unitPrice = unitPrice;
    }

    public String getOrdId() {
        return ordId;
    }

    public void setOrdId(String ordId) {
        this.ordId = ordId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "OrderDetailsDTO{" +
                "ordId='" + ordId + '\'' +
                ", itemId='" + itemId + '\'' +
                ", qty=" + qty +
                ", unitPrice=" + unitPrice +
                '}';
    }
}

package lk.ijse.javaPos.layerd.model;

/**
 * @authority DUSHAN MALINDA
 */
public class ItemDTO {
    private String itemId;
    private String description;
    private double unitPrice;
    private int qtyOnHand;


    public ItemDTO() {
    }

    public ItemDTO(String itemId, String description, double unitPrice, int qtyOnHand) {
        this.itemId = itemId;
        this.description = description;
        this.unitPrice = unitPrice;
        this.qtyOnHand = qtyOnHand;
    }


    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQtyOnHand() {
        return qtyOnHand;
    }

    public void setQtyOnHand(int qtyOnHand) {
        this.qtyOnHand = qtyOnHand;
    }

    @Override
    public String toString() {
        return "ItemDTO{" +
                "itemId='" + itemId + '\'' +
                ", description='" + description + '\'' +
                ", unitPrice=" + unitPrice +
                ", qtyOnHand=" + qtyOnHand +
                '}';
    }
}

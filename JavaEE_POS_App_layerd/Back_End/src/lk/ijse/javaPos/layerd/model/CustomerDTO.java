package lk.ijse.javaPos.layerd.model;

/**
 * @authority DUSHAN MALINDA
 */
public class CustomerDTO {
    private String cusId;
    private String name;
    private String address;
    private String contact;

    public CustomerDTO() {
    }

    public CustomerDTO(String cusId, String name, String address, String contact) {
        this.cusId = cusId;
        this.name = name;
        this.address = address;
        this.contact = contact;
    }

    public String getCusId() {
        return cusId;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }


    @Override
    public String toString() {
        return "CustomerDTO{" +
                "cusId='" + cusId + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }
}

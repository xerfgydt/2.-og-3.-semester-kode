package dk.adventurealley.app.Model.Entities;

public class Customer {

    private Integer id;
    private String companyName;
    private String customerName;
    private String phone;

    public Customer() {
    }

    public Customer(Integer id, String customerName, String phone) {
        this.id = id;
        this.customerName = customerName;
        this.phone = phone;
    }

    public Customer(Integer id, String companyName, String customerName, String phone) {
        this.id = id;
        this.companyName = companyName;
        this.customerName = customerName;
        this.phone = phone;
    }

    public Integer getId() {
    return id;
    }

    public void setId(Integer id) {
    this.id = id;
    }

    public String getCompanyName() {
    return companyName;
    }

    public void setCompanyName(String companyName) {
    this.companyName = companyName;
    }

    public String getCustomerName() {
    return this.customerName;
    }

    public void setCustomerName(String customerName) {
    this.customerName = customerName;
    }

    public String getPhone() {
    return phone;
    }

    public void setPhone(String phone) {
    this.phone = phone;
  }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", customerName='" + customerName + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}

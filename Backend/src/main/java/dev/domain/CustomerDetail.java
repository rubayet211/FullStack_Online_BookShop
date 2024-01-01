package dev.domain;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "customer_detail")
public class CustomerDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotBlank(message = "Name is required")
    @Column(name = "name")
    private String name;

    @NotBlank(message = "Phone is required")
    @Pattern(regexp = "^\\d{10}$", message = "Invalid phone number format")
    @Column(name = "phone")
    private String phone;

    @Past(message = "Date of birth must be in the past")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "dob")
    private LocalDate dob;

    @NotBlank(message = "Gender is required")
    @Column(name = "gender")
    private String gender;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    // Updated relationship to Order
    @OneToMany(mappedBy = "customerDetail", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Order> orders;

    public CustomerDetail() {
    }

    public CustomerDetail(int id, String name, String phone, LocalDate dob, String gender, Customer customer, List<Order> orders) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.dob = dob;
        this.gender = gender;
        this.customer = customer;
        this.orders = orders;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "CustomerDetail{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", dob=" + dob +
                ", gender='" + gender + '\'' +
                ", customer=" + customer +
                ", orders=" + orders +
                '}';
    }
}

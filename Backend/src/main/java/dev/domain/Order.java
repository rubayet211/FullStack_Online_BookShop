package dev.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private User user;

    @Column(name = "address")
    private String address;

    @ManyToOne
    @JoinColumn(name = "customer_detail_id")
    private UserDetail userDetail;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "order_books",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private List<Book> books;

    public Order() {
    }

    public Order(int id, User user, String address, UserDetail userDetail, List<Book> books) {
        this.id = id;
        this.user = user;
        this.address = address;
        this.userDetail = userDetail;
        this.books = books;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getCustomer() {
        return user;
    }

    public void setCustomer(User user) {
        this.user = user;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public UserDetail getCustomerDetail() {
        return userDetail;
    }

    public void setCustomerDetail(UserDetail userDetail) {
        this.userDetail = userDetail;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customer=" + user +
                ", address='" + address + '\'' +
                ", userDetail=" + userDetail +
                ", books=" + books +
                '}';
    }
}


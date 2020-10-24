package com.yalco.estore.entity.purchase;

import com.yalco.estore.entity.customer.Customer;
import com.yalco.estore.entity.enums.OrderStatus;
import com.yalco.estore.entity.product.Product;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name= "id",updatable = false, nullable = false)
    private UUID id;

    @Column(nullable = false)
    private String orderNumber;

    @Column(nullable = false)
    private LocalDate orderDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OrderStatus status;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;

    @ManyToMany
    @JoinTable(
            name="orders_products",
            joinColumns = @JoinColumn(name="oreder_id"),
            inverseJoinColumns = @JoinColumn(name="product_id")
    )
    private Set<Product> products;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}

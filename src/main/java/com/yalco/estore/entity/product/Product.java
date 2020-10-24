package com.yalco.estore.entity.product;

import com.yalco.estore.entity.customer.Cart;
import com.yalco.estore.entity.purchase.Order;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.UUID;


@Entity
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name= "id",updatable = false, nullable = false)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(name="code",nullable = false)
    private String productCode;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="category_id")
    private Category category;

    @Column(nullable = false)
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name="card_id")
    private Cart cart;

    @OneToMany
    @JoinColumn(name = "specification_id")
    private List<ProductSpecification> specifications;

    @ManyToMany(mappedBy = "products")
    private Set<Order> orders;

    //pictures


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public List<ProductSpecification> getSpecifications() {
        return specifications;
    }

    public void setSpecifications(List<ProductSpecification> specifications) {
        this.specifications = specifications;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
}

package com.yalco.estore.entity.product;

import com.yalco.estore.entity.customer.Cart;
import com.yalco.estore.entity.purchase.Order;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
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

    @ManyToOne
    @JoinColumn(name="categoty_id")
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
}

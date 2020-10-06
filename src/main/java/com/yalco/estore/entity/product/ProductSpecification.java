package com.yalco.estore.entity.product;

import com.yalco.estore.entity.customer.contacts.Address;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name="product_specifications")
public class ProductSpecification {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column
    private String manufacturer;

    @Column(name="count",nullable = false)
    private Integer productCount;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address releaseLocation;
}

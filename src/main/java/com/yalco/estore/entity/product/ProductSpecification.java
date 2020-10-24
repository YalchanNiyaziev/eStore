package com.yalco.estore.entity.product;

import com.yalco.estore.entity.customer.Address;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

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

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Integer getProductCount() {
        return productCount;
    }

    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }

    public Address getReleaseLocation() {
        return releaseLocation;
    }

    public void setReleaseLocation(Address releaseLocation) {
        this.releaseLocation = releaseLocation;
    }
}

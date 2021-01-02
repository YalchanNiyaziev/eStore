package com.yalco.estore.entity.product;

import com.yalco.estore.entity.enums.ProductCategoryType;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "categories", uniqueConstraints = {@UniqueConstraint(columnNames = "category_name")})
public class Category {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "category_name", nullable = false)
    private ProductCategoryType categoryType;

    @Column(name = "accessible", nullable = false)
    private boolean accessible;

    public Category() {

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ProductCategoryType getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(ProductCategoryType categoryType) {
        this.categoryType = categoryType;
    }

    public boolean isAccessible() {
        return accessible;
    }

    public void setAccessible(boolean accessible) {
        this.accessible = accessible;
    }
}

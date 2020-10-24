package com.yalco.estore.entity.product;

import com.yalco.estore.entity.enums.ProductCategoryType;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Enumerated(EnumType.STRING)
    @Column(name="type")
    private ProductCategoryType categoryType;

    @Column(name="is_accessible",nullable = false)
    private boolean isAccessible;

    public Category() {
        isAccessible=true;
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
        return isAccessible;
    }

    public void setAccessible(boolean accessible) {
        isAccessible = accessible;
    }
}

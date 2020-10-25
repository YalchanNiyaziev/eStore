package com.yalco.estore.model.view.product;

import com.yalco.estore.model.view.product.category.CategoryViewModel;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class ProductViewModel {
    private String id;
    private String name;
    private CategoryViewModel category;
    private BigDecimal price;
    private String manufacturer;
    private String releaseLocation;
    private String description;
    private List<String> pictures;
    private Map<String,String> customSpecifications;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryViewModel getCategory() {
        return category;
    }

    public void setCategory(CategoryViewModel category) {
        this.category = category;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getReleaseLocation() {
        return releaseLocation;
    }

    public void setReleaseLocation(String releaseLocation) {
        this.releaseLocation = releaseLocation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getPictures() {
        return pictures;
    }

    public void setPictures(List<String> pictures) {
        this.pictures = pictures;
    }

    public Map<String, String> getCustomSpecifications() {
        return customSpecifications;
    }

    public void setCustomSpecifications(Map<String, String> customSpecifications) {
        this.customSpecifications = customSpecifications;
    }
}

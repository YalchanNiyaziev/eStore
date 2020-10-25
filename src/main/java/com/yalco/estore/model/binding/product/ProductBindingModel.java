package com.yalco.estore.model.binding.product;

import com.yalco.estore.model.binding.product.category.CategoryBindingModel;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class ProductBindingModel {
    private String name;
    private CategoryBindingModel category;
    private BigDecimal price;
    private String manufacturer;
    private Integer productCount;
    private String releaseLocation;
    private String description;
    List<String> pictures;
    Map<String,String> customSpecifications;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryBindingModel  getCategory() {
        return category;
    }

    public void setCategory(CategoryBindingModel category) {
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

    public Integer getProductCount() {
        return productCount;
    }

    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
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

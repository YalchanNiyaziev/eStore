package com.yalco.estore.entity.enums.converter;

import com.yalco.estore.entity.enums.ProductCategoryType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class ProductCategoryConverter implements AttributeConverter<ProductCategoryType, String> {
    @Override
    public String convertToDatabaseColumn(ProductCategoryType productCategory) {
        return productCategory.getName();
    }

    @Override
    public ProductCategoryType convertToEntityAttribute(String productCategoryName) {
        return ProductCategoryType.getProductCategoryTypeByName(productCategoryName);
    }
}

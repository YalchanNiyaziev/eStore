package com.yalco.estore.service;

import com.yalco.estore.exception.NoSuchResultBySearchingCriteriaException;
import com.yalco.estore.exception.IdNotFoundException;
import com.yalco.estore.model.binding.product.ProductBindingModel;
import com.yalco.estore.model.view.product.ProductViewModel;

import java.util.List;

public interface ProductService {
    List<String> getAllBrandInSameCategory(String category) throws NoSuchResultBySearchingCriteriaException;

    List<ProductViewModel> getProductsByCategory(String category);

    List<ProductViewModel> getProductsByCategoryAndBrand(String categoryId, String brand) throws NoSuchResultBySearchingCriteriaException;

    List<ProductViewModel> getProductsByCategoryAndPrice(String categoryId, double priceRangeStart, double priceRangeEnd) throws NoSuchResultBySearchingCriteriaException;

    List<ProductViewModel> getProductsByCategoryAndBrandAndPrice(String categoryId, String brand, double priceRangeStart, double priceRangeEnd) throws NoSuchResultBySearchingCriteriaException;

    ProductViewModel createProduct(ProductBindingModel productBindingModel);

    ProductViewModel updateProduct(String id, ProductBindingModel productBindingModel) throws IdNotFoundException;
}

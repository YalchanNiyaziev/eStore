package com.yalco.estore.service;

import com.yalco.estore.exception.NoSuchResultBySearchingCriteriaException;
import com.yalco.estore.exception.IdNotFoundException;
import com.yalco.estore.model.binding.product.ProductBindingModel;
import com.yalco.estore.model.view.product.ProductViewModel;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface ProductService {
    List<String> getAllBrandInSameCategory(String category) throws NoSuchResultBySearchingCriteriaException;

    List<ProductViewModel> getProductsByCategory(String category, Integer page, Integer size, Sort sort) throws NoSuchResultBySearchingCriteriaException;

    List<ProductViewModel> getProductsByCategoryAndBrand(String categoryId, String brand,Integer page, Integer size, Sort sort) throws NoSuchResultBySearchingCriteriaException;

    List<ProductViewModel> getProductsByCategoryAndPrice(String categoryId, double priceRangeStart, double priceRangeEnd,Integer page, Integer size, Sort sort) throws NoSuchResultBySearchingCriteriaException;

    List<ProductViewModel> getProductsByCategoryAndBrandAndPrice(String categoryId, String brand, double priceRangeStart, double priceRangeEnd,Integer page, Integer size, Sort sort) throws NoSuchResultBySearchingCriteriaException;

    ProductViewModel createProduct(ProductBindingModel productBindingModel);

    ProductViewModel updateProduct(String id, ProductBindingModel productBindingModel) throws IdNotFoundException;
}

package com.yalco.estore.service;

import com.yalco.estore.exception.IdNotFoundException;
import com.yalco.estore.model.binding.product.ProductBindingModel;
import com.yalco.estore.model.view.product.ProductViewModel;

public interface ProductService {
    ProductViewModel createProduct(ProductBindingModel productBindingModel);
    ProductViewModel updateProduct(String id, ProductBindingModel productBindingModel) throws IdNotFoundException;
}

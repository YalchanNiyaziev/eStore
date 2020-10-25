package com.yalco.estore.service.impl;

import com.yalco.estore.entity.product.Category;
import com.yalco.estore.entity.product.Product;
import com.yalco.estore.exception.IdNotFoundException;
import com.yalco.estore.model.binding.product.ProductBindingModel;
import com.yalco.estore.model.view.product.ProductViewModel;
import com.yalco.estore.repository.ProductRepository;
import com.yalco.estore.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ProductViewModel createProduct(ProductBindingModel productBindingModel) {
        Product product = modelMapper.map(productBindingModel, Product.class);
        Product savedProduct = productRepository.save(product);
        return modelMapper.map(savedProduct, ProductViewModel.class);
    }

    @Override
    public ProductViewModel updateProduct(String id, ProductBindingModel productBindingModel) throws IdNotFoundException {
        Optional<Product> optionalProduct = Optional.ofNullable(productRepository.findById(UUID.fromString(id)).orElseThrow(() -> new IdNotFoundException("Could not found object with id: ", id)));
        Product product = optionalProduct.get();

        product.setName(productBindingModel.getName());
        product.setCategory(modelMapper.map(productBindingModel.getCategory(),Category.class));
        product.setPrice(productBindingModel.getPrice());
        product.setManufacturer(productBindingModel.getManufacturer());
        product.setProductCount(productBindingModel.getProductCount());
        product.setReleaseLocation(productBindingModel.getReleaseLocation());
        product.setDescription(productBindingModel.getDescription());

        if (isPicturesListModified(product.getPictures(), productBindingModel.getPictures())) {
            product.setPictures(productBindingModel.getPictures());
        }
        if (areCustomSpecificationsModified(product.getCustomSpecifications(),productBindingModel.getCustomSpecifications())){
            product.setCustomSpecifications(productBindingModel.getCustomSpecifications());
        }
        int b = 6;
        productRepository.save(product);
        return null;
    }

    private boolean isPicturesListModified(List<String> currentCollection, List<String> newCollection) {
       return !currentCollection.containsAll(newCollection);
    }
    private boolean areCustomSpecificationsModified(Map<String,String> currentSpecifications, Map<String,String> newSpecifications){
        return !currentSpecifications.equals(newSpecifications);
    }
}

package com.yalco.estore.service.impl;

import com.yalco.estore.entity.product.Category;
import com.yalco.estore.entity.product.Product;
import com.yalco.estore.exception.NoSuchResultBySearchingCriteriaException;
import com.yalco.estore.exception.IdNotFoundException;
import com.yalco.estore.model.binding.product.ProductBindingModel;
import com.yalco.estore.model.view.product.ProductViewModel;
import com.yalco.estore.repository.ProductRepository;
import com.yalco.estore.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

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
    public List<String> getAllBrandInSameCategory(String category) throws NoSuchResultBySearchingCriteriaException {
        List<String> sameCategoryBrands = productRepository.getAllManufacturersByProductCategory(UUID.fromString(category));
        if (sameCategoryBrands.isEmpty()) {
            throw new NoSuchResultBySearchingCriteriaException("No found brands by category");
        }
        return sameCategoryBrands
                .stream()
                .distinct()
                .collect(Collectors.toList());

    }

    @Override
    public List<ProductViewModel> getProductsByCategory(String category) {
        List<Product> productsByCategory = productRepository.getAllByCategoryId(UUID.fromString(category));
        return productsByCategory
                .stream()
                .map(e -> modelMapper.map(e, ProductViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductViewModel> getProductsByCategoryAndBrand(String categoryId, String brand) throws NoSuchResultBySearchingCriteriaException {
        List<Product> productsByCategoryAndBrand =
                productRepository.getAllByCategoryIdAndManufacturer(UUID.fromString(categoryId), brand);

        if (productsByCategoryAndBrand.isEmpty()) {
            throw new NoSuchResultBySearchingCriteriaException("No found products by category and brand ");
        }

        return productsByCategoryAndBrand
                .stream()
                .map(e -> modelMapper.map(e, ProductViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductViewModel> getProductsByCategoryAndPrice(String categoryId, double priceRangeStart, double priceRangeEnd) throws NoSuchResultBySearchingCriteriaException {
        List<Product> productsByCategoryAndPrice = productRepository.getAllByCategoryIdAndPriceBetween(UUID.fromString(categoryId),
                BigDecimal.valueOf(priceRangeStart), BigDecimal.valueOf(priceRangeEnd));

        if (productsByCategoryAndPrice.isEmpty()) {
            throw new NoSuchResultBySearchingCriteriaException("No found products by category and price ");
        }

        return productsByCategoryAndPrice
                .stream()
                .map(e -> modelMapper.map(e, ProductViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductViewModel> getProductsByCategoryAndBrandAndPrice(String categoryId, String brand, double priceRangeStart, double priceRangeEnd) throws NoSuchResultBySearchingCriteriaException {
        List<Product> productsByCategoryAndBrandAndPrice =
                productRepository.getAllByCategoryIdAndManufacturerAndPriceBetween(UUID.fromString(categoryId), brand,
                        BigDecimal.valueOf(priceRangeStart), BigDecimal.valueOf(priceRangeEnd));
        if (productsByCategoryAndBrandAndPrice.isEmpty()) {
            throw new NoSuchResultBySearchingCriteriaException("No found products by category and brand and price ");
        }
        return productsByCategoryAndBrandAndPrice
                .stream()
                .map(e -> modelMapper.map(e, ProductViewModel.class))
                .collect(Collectors.toList());
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
        product.setCategory(modelMapper.map(productBindingModel.getCategory(), Category.class));
        product.setPrice(productBindingModel.getPrice());
        product.setManufacturer(productBindingModel.getManufacturer());
        product.setProductCount(productBindingModel.getProductCount());
        product.setReleaseLocation(productBindingModel.getReleaseLocation());
        product.setDescription(productBindingModel.getDescription());

        if (isPicturesListModified(product.getPictures(), productBindingModel.getPictures())) {
            product.setPictures(productBindingModel.getPictures());
        }
        if (areCustomSpecificationsModified(product.getCustomSpecifications(), productBindingModel.getCustomSpecifications())) {
            product.setCustomSpecifications(productBindingModel.getCustomSpecifications());
        }
        productRepository.save(product);
        return null;
    }

    private boolean isPicturesListModified(List<String> currentCollection, List<String> newCollection) {
        return !currentCollection.containsAll(newCollection);
    }

    private boolean areCustomSpecificationsModified(Map<String, String> currentSpecifications, Map<String, String> newSpecifications) {
        return !currentSpecifications.equals(newSpecifications);
    }
}

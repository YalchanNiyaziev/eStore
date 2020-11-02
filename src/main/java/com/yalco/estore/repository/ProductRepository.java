package com.yalco.estore.repository;

import com.yalco.estore.entity.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

    Optional<Product> getById(UUID id);

    List<Product> getAllByCategoryId(UUID categoryId);

    @Query(value = "select p.manufacturer from Product p where p.category.id = :category_id")
    List<String> getAllManufacturersByProductCategory(@Param(value = "category_id") UUID categoryId);

    List<Product> getAllByCategoryIdAndManufacturer(UUID categoryId, String manufacturer);

    List<Product> getAllByCategoryIdAndPriceBetween(UUID categoryId, BigDecimal priceRangeBegin, BigDecimal priceRangeEnd);

    List<Product> getAllByCategoryIdAndManufacturerAndPriceBetween(UUID categoryOd,String manufacturer, BigDecimal priceRangeBegin, BigDecimal priceRangeEnd);
}

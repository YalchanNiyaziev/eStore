package com.yalco.estore.repository;

import com.yalco.estore.entity.product.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {

    @Query(value = "select c from Category c where c.id = :category_id and c.isAccessible = true")
   Optional<Category> findByIdAndAccessibleTrue(@Param(value = "category_id") UUID id);
}

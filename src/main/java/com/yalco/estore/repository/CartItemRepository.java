package com.yalco.estore.repository;

import com.yalco.estore.entity.cart.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, UUID> {
    Optional<CartItem> getCartItemById(UUID id);

    @Query(value = "select  item from CartItem item inner join item.cart as cart where cart.customer.id = :customer_id and item.isAccessible = true ")
    List<CartItem> getCartsItemByCustomerIdAndAccessibleIsTrue(@Param(value = "customer_id")UUID id);

    @Query(value = "select  item from CartItem item inner join item.cart as cart where cart.id = :cart_id and item.isAccessible = true ")
    List<CartItem> getCartItemsByAccessibleIsTrueAndCartId(@Param(value = "cart_id")UUID id);
}

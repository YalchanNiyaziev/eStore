package com.yalco.estore.web.controller;

import com.yalco.estore.model.binding.cart.CartItemBindingModel;
import com.yalco.estore.model.view.cart.CartViewModel;
import com.yalco.estore.service.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/carts")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartViewModel> getCartById(@PathVariable String id) {
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/items")
    public ResponseEntity<Void> addCartItem(@PathVariable("id") String cartId, @Valid @RequestBody CartItemBindingModel cartItem) {
        return ResponseEntity.ok().build();

    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> addCartItem(@PathVariable("id") String cartId) {
        return ResponseEntity.ok().build();

    }

    @DeleteMapping("/{cart-id}/items/{item-id}")
    public ResponseEntity<Void> addCartItem(@PathVariable("cart-id") String cartId, @PathVariable("item-id") String itemId) {
        return ResponseEntity.ok().build();

    }

}

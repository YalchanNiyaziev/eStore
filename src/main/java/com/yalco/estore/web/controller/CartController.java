package com.yalco.estore.web.controller;

import com.yalco.estore.exception.ElementNotFoundByIdException;
import com.yalco.estore.model.binding.cart.CartItemProductBindingModel;
import com.yalco.estore.model.view.cart.CartViewModel;
import com.yalco.estore.service.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/carts")
@Validated
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartViewModel> getCartById(@PathVariable String id) throws ElementNotFoundByIdException {
        CartViewModel cartViewModel = cartService.getCartById(id);
        return ResponseEntity.ok(cartViewModel);
    }

    @PostMapping("/{id}/items")
    public ResponseEntity<CartViewModel> addCartItem(@PathVariable("id") String cartId, @Valid @RequestBody CartItemProductBindingModel cartItem) throws ElementNotFoundByIdException {
        CartViewModel cartViewModel = cartService.addItem(cartId, cartItem);
        return ResponseEntity.ok(cartViewModel);

    }

    @DeleteMapping("/{cart-id}/items/{item-id}")
    public ResponseEntity<CartViewModel> removeCartItem(@PathVariable("cart-id") String cartId, @PathVariable("item-id") String itemId) throws ElementNotFoundByIdException {
        CartViewModel cartViewModel = cartService.removeItem(cartId, itemId);
        return ResponseEntity.ok(cartViewModel);

    }

}

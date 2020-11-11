package com.yalco.estore.web.controller;

import com.yalco.estore.exception.ElementNotFoundByIdException;
import com.yalco.estore.model.binding.cart.CartItemBindingModel;
import com.yalco.estore.model.view.cart.CartItemViewModel;
import com.yalco.estore.service.CartItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/cart-items")
@Validated
public class CartItemController {

    private final CartItemService cartItemService;

    public CartItemController(CartItemService cartItemService) {
        this.cartItemService = cartItemService;
    }

    @PutMapping("/{id}/items/{item-id}")
    public ResponseEntity<CartItemViewModel> updateCartItem(@PathVariable("item-id") String itemId, @Valid @RequestBody CartItemBindingModel carItemBindingModel) throws ElementNotFoundByIdException {
        CartItemViewModel cartItemViewModel = cartItemService.updateCartItem(itemId, carItemBindingModel);
        return ResponseEntity.ok(cartItemViewModel);

    }
}

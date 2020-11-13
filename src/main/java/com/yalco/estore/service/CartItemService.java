package com.yalco.estore.service;

import com.yalco.estore.exception.ElementNotFoundByIdException;
import com.yalco.estore.model.binding.cart.CartItemBindingModel;
import com.yalco.estore.model.view.cart.CartItemViewModel;

public interface CartItemService {
    CartItemViewModel updateCartItem(String cartItemId, CartItemBindingModel carItemBindingModel) throws ElementNotFoundByIdException;
}
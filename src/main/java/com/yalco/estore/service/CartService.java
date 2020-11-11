package com.yalco.estore.service;

import com.yalco.estore.exception.ElementNotFoundByIdException;
import com.yalco.estore.model.binding.cart.CartItemProductBindingModel;
import com.yalco.estore.model.view.cart.CartViewModel;

public interface CartService {
    CartViewModel getCartByCustomerId(String customerId) throws ElementNotFoundByIdException;
    CartViewModel getCartById(String id) throws ElementNotFoundByIdException;
    CartViewModel addItem(String cartId, CartItemProductBindingModel cartItemProductBindingModel) throws ElementNotFoundByIdException;
    CartViewModel removeItem(String cartId, String removeItemId) throws ElementNotFoundByIdException;
}

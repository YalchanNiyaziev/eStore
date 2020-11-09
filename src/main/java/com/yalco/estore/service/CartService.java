package com.yalco.estore.service;

import com.yalco.estore.model.binding.cart.CartBindingModel;
import com.yalco.estore.model.binding.cart.CartItemBindingModel;
import com.yalco.estore.model.view.cart.CartViewModel;

public interface CartService {
    CartViewModel getCartByCustomerId(String customerId);
    CartViewModel getCartById(String id);
    CartViewModel updateCart(CartBindingModel cartBindingModel);
    CartViewModel addItem(CartItemBindingModel cartItemBindingModel);
    CartViewModel removeItem(String removeItemId);
}

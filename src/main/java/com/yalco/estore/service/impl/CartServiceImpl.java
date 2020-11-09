package com.yalco.estore.service.impl;

import com.yalco.estore.model.binding.cart.CartBindingModel;
import com.yalco.estore.model.binding.cart.CartItemBindingModel;
import com.yalco.estore.model.view.cart.CartViewModel;
import com.yalco.estore.repository.CartRepository;
import com.yalco.estore.service.CartService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final ModelMapper mapper;

    public CartServiceImpl(CartRepository cartRepository, ModelMapper mapper) {
        this.cartRepository = cartRepository;
        this.mapper = mapper;
    }

    @Override
    public CartViewModel getCartByCustomerId(String customerId) {
        return null;
    }

    @Override
    public CartViewModel getCartById(String id) {
        return null;
    }

    @Override
    public CartViewModel updateCart(CartBindingModel cartBindingModel) {
        return null;
    }

    @Override
    public CartViewModel addItem(CartItemBindingModel cartItemBindingModel) {
        return null;
    }

    @Override
    public CartViewModel removeItem(String removeItemId) {
        return null;
    }
}

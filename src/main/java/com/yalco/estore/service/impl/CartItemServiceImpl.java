package com.yalco.estore.service.impl;

import com.yalco.estore.entity.cart.CartItem;
import com.yalco.estore.exception.ElementNotFoundByIdException;
import com.yalco.estore.model.binding.cart.CartItemBindingModel;
import com.yalco.estore.model.view.cart.CartItemViewModel;
import com.yalco.estore.repository.CartItemRepository;
import com.yalco.estore.service.CartItemService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
public class CartItemServiceImpl implements CartItemService {
    private final CartItemRepository cartItemRepository;
    private final ModelMapper mapper;


    public CartItemServiceImpl(CartItemRepository cartItemRepository, ModelMapper mapper) {
        this.cartItemRepository = cartItemRepository;
        this.mapper = mapper;
    }

    @Override
    public CartItemViewModel updateCartItem(String cartItemId, CartItemBindingModel carItemBindingModel) throws ElementNotFoundByIdException {
        CartItem cartItem =cartItemRepository.getCartItemById(UUID.fromString(cartItemId)).orElseThrow(() -> new ElementNotFoundByIdException("Cart Item not found with id", cartItemId));

        Integer newQuantityValue = carItemBindingModel.getQuantity();
        BigDecimal newTotalPrice = cartItem.getProduct().getPrice().multiply(BigDecimal.valueOf(newQuantityValue));

        cartItem.setQuantity(newQuantityValue);
        cartItem.setTotal(newTotalPrice);

        CartItem updatedItem = cartItemRepository.save(cartItem);
        return mapper.map(updatedItem,CartItemViewModel.class);
    }
}

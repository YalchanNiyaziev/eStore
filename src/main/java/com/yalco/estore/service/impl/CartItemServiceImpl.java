package com.yalco.estore.service.impl;

import com.yalco.estore.entity.cart.CartItem;
import com.yalco.estore.exception.ElementNotFoundByIdException;
import com.yalco.estore.exception.NoSuchResultBySearchingCriteriaException;
import com.yalco.estore.model.binding.cart.CartItemBindingModel;
import com.yalco.estore.model.view.cart.CartItemViewModel;
import com.yalco.estore.repository.CartItemRepository;
import com.yalco.estore.service.CartItemService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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

    @Override
    public List<CartItemViewModel> getAllByCustomer(String customerId) throws NoSuchResultBySearchingCriteriaException {
        List<CartItem> cartItemList = cartItemRepository.getCartsItemByCustomerIdAndAccessibleIsTrue(UUID.fromString(customerId));

        if (cartItemList.isEmpty()) {
            throw new NoSuchResultBySearchingCriteriaException("No found cart items by given customer id "+customerId);
        }

        return cartItemList
                .stream()
                .map( e -> mapper.map(e, CartItemViewModel.class))
                .collect(Collectors.toList());
    }


}

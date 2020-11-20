package com.yalco.estore.service.impl;

import com.yalco.estore.entity.cart.Cart;
import com.yalco.estore.entity.cart.CartItem;
import com.yalco.estore.entity.product.Product;
import com.yalco.estore.exception.ElementNotFoundByIdException;
import com.yalco.estore.model.binding.cart.CartItemProductBindingModel;
import com.yalco.estore.model.view.cart.CartItemViewModel;
import com.yalco.estore.model.view.cart.CartViewModel;
import com.yalco.estore.repository.CartItemRepository;
import com.yalco.estore.repository.CartRepository;
import com.yalco.estore.repository.ProductRepository;
import com.yalco.estore.service.CartService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final ProductRepository productRepository;
    private final CartItemRepository cartItemRepository;
    private final ModelMapper mapper;

    public CartServiceImpl(CartRepository cartRepository, ProductRepository productRepository, CartItemRepository cartItemRepository, ModelMapper mapper) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
        this.cartItemRepository = cartItemRepository;
        this.mapper = mapper;
    }

    @Override
    public CartViewModel getCartByCustomerId(String customerId) throws ElementNotFoundByIdException {
        Cart cart = cartRepository.getCartByCustomerId(UUID.fromString(customerId))
                .orElseThrow(() -> new ElementNotFoundByIdException("Cart not found with customer id", customerId));

        List<CartItemViewModel> items= cart.getCartItems()
                .stream()
                .filter(CartItem::isAccessible)
                .map(e -> mapper.map(e, CartItemViewModel.class))
                .collect(Collectors.toList());
        CartViewModel cartViewModel = new CartViewModel();
        cartViewModel.setId(cart.getId().toString());
        cartViewModel.setItems(items);

        return cartViewModel;
    }

    @Override
    public CartViewModel getCartById(String id) throws ElementNotFoundByIdException {
        List<CartItem> cartItemList = cartItemRepository.getCartItemsByAccessibleIsTrueAndCartId(UUID.fromString(id));
        if(cartItemList.isEmpty()){
            throw new ElementNotFoundByIdException("Cart not found with id", id);
        }
        List<CartItemViewModel> cartItemViewModels = cartItemList.stream().map(e -> mapper.map(e, CartItemViewModel.class)).collect(Collectors.toList());
        CartViewModel cartViewModel = new CartViewModel();
        cartViewModel.setId(id);
        cartViewModel.setItems(cartItemViewModels);

        return cartViewModel;
    }


    @Override
    public CartViewModel addItem(String cartId, CartItemProductBindingModel cartItemProductBindingModel) throws ElementNotFoundByIdException {
        String productId = cartItemProductBindingModel.getProductId();

        Cart cart = cartRepository.findById(UUID.fromString(cartId))
                .orElseThrow(() -> new ElementNotFoundByIdException("Cart not found with id", cartId));
        Product product = productRepository.getById(UUID.fromString(productId))
                .orElseThrow(() -> new ElementNotFoundByIdException("Product not found with id", productId));

        BigDecimal totalPrice = product.getPrice().multiply(BigDecimal.valueOf(cartItemProductBindingModel.getQuantity()));

        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        cartItem.setQuantity(cartItemProductBindingModel.getQuantity());
        cartItem.setTotal(totalPrice);

        cart.addItem(cartItem);

        Cart updatedCart = cartRepository.saveAndFlush(cart);

        return mapper.map(updatedCart, CartViewModel.class);
    }

    @Override
    public CartViewModel removeItem(String cartId, String removeItemId) throws ElementNotFoundByIdException {
        Cart cart = cartRepository.findById(UUID.fromString(cartId))
                .orElseThrow(() -> new ElementNotFoundByIdException("Cart not found with id", cartId));
        CartItem cartItem = cartItemRepository.getCartItemById(UUID.fromString(removeItemId))
                .orElseThrow(() -> new ElementNotFoundByIdException("Cart item not found with id", removeItemId));

        cart.removeItem(cartItem);

        cartItemRepository.delete(cartItem);

        Cart updatedCart = cartRepository.saveAndFlush(cart);

        return mapper.map(updatedCart, CartViewModel.class);
    }

    @Override
    public void clearCart(Cart cart) {
        List<CartItem> cartItems = cart.getCartItems();
        cartItems.forEach(e -> e.setAccessible(false));
        cartItemRepository.saveAll(cartItems);
    }


}

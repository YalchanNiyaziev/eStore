package com.yalco.estore.service.impl;

import com.yalco.estore.entity.cart.Cart;
import com.yalco.estore.entity.enums.OrderStatus;
import com.yalco.estore.entity.purchase.Order;
import com.yalco.estore.exception.ElementNotFoundByIdException;
import com.yalco.estore.exception.NoSuchResultBySearchingCriteriaException;
import com.yalco.estore.model.binding.purchase.OrderBindingModel;
import com.yalco.estore.model.binding.purchase.OrderStatusBindingModel;
import com.yalco.estore.model.view.purchase.OrderViewModel;
import com.yalco.estore.repository.CartRepository;
import com.yalco.estore.repository.OrderRepository;
import com.yalco.estore.service.CartService;
import com.yalco.estore.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final CartRepository cartRepository;
    private final CartService cartService;
    private final ModelMapper modelMapper;
    private static Long orderNumber = 1L;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, CartRepository cartRepository, CartService cartService, ModelMapper modelMapper) {
        this.orderRepository = orderRepository;
        this.cartRepository = cartRepository;
        this.cartService = cartService;
        this.modelMapper = modelMapper;
    }


    @Override
    public List<OrderViewModel> getOrdersWithPaging(Integer page, Integer size, Sort sort) throws NoSuchResultBySearchingCriteriaException {
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Order> pagedOrders = orderRepository.findAll(pageable);
        if (pagedOrders.isEmpty()) {
            throw new NoSuchResultBySearchingCriteriaException("No found orders by category  ");
        }
        return pagedOrders
                .stream()
                .map(e -> modelMapper.map(e, OrderViewModel.class))
                .collect(Collectors.toList());

    }

    @Override
    public OrderViewModel makeOrder(OrderBindingModel orderBindingModel) throws ElementNotFoundByIdException {
        String cartId = orderBindingModel.getCartId();
        Cart cart = cartRepository.findById(UUID.fromString(cartId))
                .orElseThrow(() -> new ElementNotFoundByIdException("Cart not found with id", cartId));

        Order order = new Order();
        order.setCart(cart);
        order.setStatus(OrderStatus.PENDING);
        order.setOrderDate(orderBindingModel.getOrderDate());
        order.setOrderTotal(calculateOrderTotal(cart));
        order.setOrderNumber(orderNumber++);

        Order savedOrder = orderRepository.save(order);
        return modelMapper.map(savedOrder, OrderViewModel.class);
    }

    @Override
    public OrderViewModel updateOrder(String id, OrderBindingModel orderBindingModel) {
        return null;
    }

    @Override
    public OrderViewModel updateOrderStatus(String orderId, OrderStatusBindingModel orderStatus) throws ElementNotFoundByIdException {
        Order order = orderRepository.findById(UUID.fromString(orderId))
                .orElseThrow(() -> new ElementNotFoundByIdException("Order not found with id", orderId));

        if(orderStatus.getStatus().equals(OrderStatus.COMPLETED)){
            cartService.clearCart(order.getCart());
        }
        order.setStatus(orderStatus.getStatus());

        Order updatedOrder = orderRepository.save(order);

        return modelMapper.map(updatedOrder, OrderViewModel.class);
    }

    private BigDecimal calculateOrderTotal(Cart cart){
        BigDecimal total = BigDecimal.ZERO;
        cart.getCartItems()
        .forEach(i -> total.add(i.getTotal()));
        return total;
    }

}

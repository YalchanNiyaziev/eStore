package com.yalco.estore.service.impl;

import com.yalco.estore.entity.purchase.Order;
import com.yalco.estore.model.binding.OrderPostModel;
import com.yalco.estore.model.view.OrderDto;
import com.yalco.estore.repository.OrderRepository;
import com.yalco.estore.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, ModelMapper modelMapper) {
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public OrderDto makeOrder(OrderPostModel orderPostModel) {
        Order order = modelMapper.map(orderPostModel,Order.class);
        return null;
    }

    @Override
    public OrderDto updateOrder(String id, OrderPostModel orderPostModel) {
        return null;
    }
}

package com.yalco.estore.service;

import com.yalco.estore.model.binding.OrderPostModel;
import com.yalco.estore.model.dto.OrderDto;

public interface OrderService {
    OrderDto makeOrder(OrderPostModel orderPostModel);
    OrderDto updateOrder(String id, OrderPostModel orderPostModel);
}

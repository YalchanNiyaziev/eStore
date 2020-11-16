package com.yalco.estore.service;

import com.yalco.estore.entity.enums.OrderStatus;
import com.yalco.estore.exception.ElementNotFoundByIdException;
import com.yalco.estore.exception.NoSuchResultBySearchingCriteriaException;
import com.yalco.estore.model.binding.purchase.OrderBindingModel;
import com.yalco.estore.model.binding.purchase.OrderStatusBindingModel;
import com.yalco.estore.model.view.purchase.OrderViewModel;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface OrderService {
    List<OrderViewModel> getOrdersWithPaging(Integer page, Integer size, Sort sort) throws NoSuchResultBySearchingCriteriaException;

    OrderViewModel makeOrder(OrderBindingModel orderBindingModel) throws ElementNotFoundByIdException;

    OrderViewModel updateOrder(String id, OrderBindingModel orderBindingModel);

    OrderViewModel updateOrderStatus(String id, OrderStatusBindingModel orderStatus) throws ElementNotFoundByIdException;
}

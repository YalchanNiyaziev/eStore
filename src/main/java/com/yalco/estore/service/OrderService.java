package com.yalco.estore.service;

import com.yalco.estore.exception.ElementNotFoundByIdException;
import com.yalco.estore.exception.NoSuchResultBySearchingCriteriaException;
import com.yalco.estore.model.binding.order.OrderBindingModel;
import com.yalco.estore.model.view.order.OrderViewModel;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface OrderService {
    List<OrderViewModel> getOrdersWithPaging(Integer page, Integer size, Sort sort) throws NoSuchResultBySearchingCriteriaException;

    OrderViewModel makeOrder(OrderBindingModel orderBindingModel) throws ElementNotFoundByIdException;

    OrderViewModel updateOrder(String id, OrderBindingModel orderBindingModel);

}

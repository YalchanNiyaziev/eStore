package com.yalco.estore.web.controller;

import com.yalco.estore.exception.ElementNotFoundByIdException;
import com.yalco.estore.exception.NoSuchResultBySearchingCriteriaException;
import com.yalco.estore.model.binding.order.OrderBindingModel;
import com.yalco.estore.model.view.order.OrderViewModel;
import com.yalco.estore.model.view.product.ProductViewModel;
import com.yalco.estore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Value("${orders.default.sorting.criteria}")
    private String defaultSortOrderCriteria;

    @Value("${orders.default.sorting.direction}")
    private String defaultSortDirection;

    @Value("${orders.default.page.number}")
    private Integer defaultPage;

    @Value("${orders.default.counts.elements.per.page}")
    private Integer defaultPageSize;

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping()
    private ResponseEntity<List<OrderViewModel>> getAll(@RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) throws NoSuchResultBySearchingCriteriaException {
        List<OrderViewModel> orders = orderService.getOrdersWithPaging(
                page.orElse(defaultPage),
                size.orElse(defaultPageSize),
                Sort.by(Sort.Direction.fromString(defaultSortDirection), defaultSortOrderCriteria));

        return ResponseEntity.ok(orders);
    }

    @PostMapping
    public ResponseEntity<Void> createOrder(@RequestBody OrderBindingModel orderBindingModel,
                                            UriComponentsBuilder uriBuilder) throws ElementNotFoundByIdException {

        OrderViewModel orderViewModel = orderService.makeOrder(orderBindingModel);

        return ResponseEntity
                .created(
                        uriBuilder.path("/api/orders/{id}")
                                .buildAndExpand(orderViewModel.getId())
                                .toUri())
                .build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateOrder(@PathVariable String id,
                                            @RequestBody OrderBindingModel orderBindingModel) {
        orderService.updateOrder(id, orderBindingModel);
        return null;

    }
}

package com.yalco.estore.web.controlleer;

import com.yalco.estore.model.binding.OrderPostModel;
import com.yalco.estore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<Void> createOrder(@RequestBody OrderPostModel orderPostModel,
                                            UriComponentsBuilder uriBuilder){
        orderService.makeOrder(orderPostModel);
        return null;
    }
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateOrder(@PathVariable String id,
                                            @RequestBody OrderPostModel orderPostModel){
        orderService.updateOrder(id, orderPostModel);
        return null;

    }
}

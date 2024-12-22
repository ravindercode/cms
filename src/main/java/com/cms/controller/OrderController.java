package com.cms.controller;

import com.cms.domain.OrderEntity;
import com.cms.mapper.OrderRequest;
import com.cms.service.OrderService;
import com.cms.utility.ApiRespone;
import com.cms.utility.Validator;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping
    public ResponseEntity<?> getAll(@RequestBody(required = false) Iterable<Long> orderIds) {
        if (Validator.isEmpty(orderIds)) {
            return ApiRespone.OK(orderService.getAll());
        } else {
            return ApiRespone.OK(orderService.getByIds(orderIds));
        }
    }

    @GetMapping("{orderId}")
    public ResponseEntity<?> getById(@PathVariable Long orderId) {
        Optional<OrderEntity> entityOptional = orderService.getById(orderId);
        if (entityOptional.isPresent()) {
            return ApiRespone.OK(entityOptional.get());
        } else {
            return ApiRespone.NOT_FOUND(orderId);
        }
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody OrderRequest orderRequest) {
        Optional<OrderEntity> entityOptional = orderService.create(orderRequest);
        if (entityOptional.isPresent()) {
            return ApiRespone.OK(entityOptional.get());
        } else {
            return ApiRespone.INTERNAL_SERVER_ERROR(null);
        }
    }

    @PutMapping("{orderId}")
    public ResponseEntity<?> update(@PathVariable Long orderId, @RequestBody OrderEntity orderEntity) {
        Optional<OrderEntity> entityOptional = orderService.update(orderId, orderEntity);
        if (entityOptional.isPresent()) {
            return ApiRespone.OK(entityOptional.get());
        } else {
            return ApiRespone.INTERNAL_SERVER_ERROR(null);
        }
    }

    @DeleteMapping("{orderId}")
    public ResponseEntity<?> delete(@PathVariable Long orderId) {
        if (orderService.existById(orderId)) {
            orderService.delete(orderId);
            return ApiRespone.OK(orderId);
        } else {
            return ApiRespone.BAD_REQUEST(orderId);
        }
    }
}
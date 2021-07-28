package com.ghost.order.controller;

import ch.qos.logback.core.db.dialect.MySQLDialect;
import com.ghost.order.aspect.TrackExecTime;
import com.ghost.order.config.ConfigProperties;
import com.ghost.order.model.Order;
import com.ghost.order.model.Sku;
import com.ghost.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/my")
    public Order myOrder(){

        return orderService.myOrder();
    }

    /**
     * Authenticated, Headers, Cookie, .......
     * Any logic specific HTTP Request
     *
     * @param item
     * @return
     */
    @PostMapping("/new")
    public Order newOrder(@RequestParam("item")String item){

        orderService.newOrder(item);
        return new Order(item);
    }

}
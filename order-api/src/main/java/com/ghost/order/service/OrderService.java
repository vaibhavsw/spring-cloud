package com.ghost.order.service;

import com.ghost.order.aspect.TrackExecTime;
import com.ghost.order.config.ConfigProperties;
import com.ghost.order.dao.OrderDao;
import com.ghost.order.model.Order;
import com.ghost.order.model.Sku;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

// Circuilar dependency

@Slf4j
@Service
public class OrderService {

    @Autowired
    private RestTemplate restTemplate;


    @Autowired
    private ConfigProperties configProperties;


    @Autowired
    private OrderDao orderDao;

    /**
     * Validate the order
     * Check SKU/Inventory
     * Check offers
     *
     *
     * @param name
     * @return
     */
    @TrackExecTime
    @Transactional
    public Order newOrder(String name){
        newOrder1(name);
        return orderDao.save(new Order(name));
    }

    @Transactional()
    private void newOrder1(String name){

//        return orderDao.save(new Order(name));
    }

    public Order myOrder() {
        Order order = new Order(configProperties.getItem());

        Sku forEntity = restTemplate.getForObject("http://sku/sku", Sku.class);
        if (forEntity != null) {
            order.setSku(forEntity);
            log.info(String.format("Sku [%s]", forEntity));
        }else{
            log.error("No sku found");
        }

        return order;

    }
}

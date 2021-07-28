package com.ghost.order.dao;

import com.ghost.order.model.Order;
import org.springframework.stereotype.Repository;

/**
 * CRUD
 */
@Repository
public interface OrderDao {

    public Order getOrder(String id);


    Order save(Order order);

}

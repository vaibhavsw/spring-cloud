package com.ghost.order.daoimpl;

import com.ghost.order.DatabaseConnection;
import com.ghost.order.dao.OrderDao;
import com.ghost.order.model.Order;
import com.ghost.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDaoImpl implements OrderDao {

    @Autowired
    private DatabaseConnection databaseConnection;

    @Autowired
    private OrderService orderService;

    @Override
    public Order getOrder(String id) {
        String query = "SELECT * FROM order WHERE order_id = " + id;
        Object object = databaseConnection.query(query);
        return new Order(id);
    }

    @Override
    public Order save(Order order) {
//        orderService.newOrder("foo");
        return order;
    }
}

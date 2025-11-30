package com.curiousity.tech.controller;

import com.curiousity.tech.services.OrderItemService;
import com.curiousity.tech.domain.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
public class OrderItemController {
    @Autowired
    private OrderItemService orderItemService;


    public OrderItem createOrderItem(String orderId, String quantity, String price) {
        return orderItemService.createOrderItem(orderId, quantity, price);
    }

    public Optional<OrderItem> getOrderItemById(String id) {
        return orderItemService.getOrderItemById(id);
    }

    public List<OrderItem> getAllOrderItems() {
        return orderItemService.getAllOrderItems();
    }

    public List<OrderItem> getOrderItemsByOrderId(String orderId) {
        return orderItemService.getOrderItemsByOrderId(orderId);
    }

    public OrderItem updateOrderItem(OrderItem orderItem) {
        return orderItemService.updateOrderItem(orderItem);
    }

    public boolean deleteOrderItem(String id) {
        return orderItemService.deleteOrderItem(id);
    }

    public double calculateOrderItemTotal(String orderItemId) {
        return orderItemService.calculateOrderItemTotal(orderItemId);
    }
}


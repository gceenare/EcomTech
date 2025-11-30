package com.curiousity.tech.controller;

import com.curiousity.tech.services.OrderService;
import com.curiousity.tech.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
public class OrderController {
    @Autowired
    private OrderService orderService;


    public Order createOrder(String date, String totalAmount, String status) {
        return orderService.createOrder(date, totalAmount, status);
    }

    public Optional<Order> getOrderById(String id) {
        return orderService.getOrderById(id);
    }

    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    public List<Order> getOrdersByUserId(String userId) {
        return orderService.getOrdersByUserId(userId);
    }

    public List<Order> getOrdersByStatus(String status) {
        return orderService.getOrdersByStatus(status);
    }

    public Order updateOrder(Order order) {
        return orderService.updateOrder(order);
    }

    public Order updateOrderStatus(String orderId, String newStatus) {
        return orderService.updateOrderStatus(orderId, newStatus);
    }

    public boolean deleteOrder(String id) {
        return orderService.deleteOrder(id);
    }

    public double calculateOrderTotal(String orderId) {
        return orderService.calculateOrderTotal(orderId);
    }
}


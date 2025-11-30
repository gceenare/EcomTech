package com.curiousity.tech.services;

import com.curiousity.tech.domain.Order;
import java.util.List;
import java.util.Optional;

public interface IOrderService {
    Order createOrder(String date, String totalAmount, String status);
    Optional<Order> getOrderById(String id);
    List<Order> getAllOrders();
    List<Order> getOrdersByUserId(String userId);
    List<Order> getOrdersByStatus(String status);
    Order updateOrder(Order order);
    Order updateOrderStatus(String orderId, String newStatus);
    boolean deleteOrder(String id);
    double calculateOrderTotal(String orderId);
}


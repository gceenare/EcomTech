package com.curiousity.tech.services;

import com.curiousity.tech.domain.OrderItem;
import java.util.List;
import java.util.Optional;

public interface IOrderItemService {
    OrderItem createOrderItem(String orderId, String quantity, String price);
    Optional<OrderItem> getOrderItemById(String id);
    List<OrderItem> getAllOrderItems();
    List<OrderItem> getOrderItemsByOrderId(String orderId);
    OrderItem updateOrderItem(OrderItem orderItem);
    boolean deleteOrderItem(String id);
    double calculateOrderItemTotal(String orderItemId);
}


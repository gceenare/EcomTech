package com.curiousity.tech.services;

import com.curiousity.tech.domain.OrderItem;
import java.util.List;
import java.util.Optional;

public interface IOrderItemService {
    OrderItem createOrderItem(Long orderId, Long productId, String productName, double price, int quantity);
    Optional<OrderItem> getOrderItemById(Long id);
    List<OrderItem> getAllOrderItems();
    List<OrderItem> getOrderItemsByOrderId(Long orderId);
    OrderItem save(OrderItem orderItem);
    void deleteOrderItem(Long id);
}

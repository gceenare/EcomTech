package com.curiousity.tech.services;

import com.curiousity.tech.domain.OrderItem;
import com.curiousity.tech.factory.OrderItemFactory;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class OrderItemService implements IOrderItemService {
    private List<OrderItem> orderItems;

    public OrderItemService() {
        this.orderItems = new java.util.ArrayList<>();
    }

    @Override
    public OrderItem createOrderItem(String orderId, String quantity, String price) {
        OrderItem orderItem = OrderItemFactory.create(orderId, quantity, price);
        orderItems.add(orderItem);
        return orderItem;
    }

    @Override
    public Optional<OrderItem> getOrderItemById(String id) {
        return orderItems.stream().filter(oi -> oi.getOrderId().equals(id)).findFirst();
    }

    @Override
    public List<OrderItem> getAllOrderItems() {
        return new java.util.ArrayList<>(orderItems);
    }

    @Override
    public List<OrderItem> getOrderItemsByOrderId(String orderId) {
        return orderItems.stream().filter(oi -> oi.getOrderId().equals(orderId)).toList();
    }

    @Override
    public OrderItem updateOrderItem(OrderItem orderItem) {
        Optional<OrderItem> existing = getOrderItemById(orderItem.getOrderId());
        if (existing.isPresent()) {
            orderItems.remove(existing.get());
            orderItems.add(orderItem);
        }
        return orderItem;
    }

    @Override
    public boolean deleteOrderItem(String id) {
        return orderItems.removeIf(oi -> oi.getOrderId().equals(id));
    }

    @Override
    public double calculateOrderItemTotal(String orderItemId) {
        Optional<OrderItem> orderItem = getOrderItemById(orderItemId);
        if (orderItem.isPresent()) {
            try {
                double quantity = Double.parseDouble(orderItem.get().getQuantity());
                double price = Double.parseDouble(orderItem.get().getPrice());
                return quantity * price;
            } catch (NumberFormatException e) {
                return 0.0;
            }
        }
        return 0.0;
    }
}


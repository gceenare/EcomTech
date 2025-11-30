package com.curiousity.tech.services;

import com.curiousity.tech.domain.Order;
import com.curiousity.tech.factory.OrderFactory;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService implements IOrderService {
    private List<Order> orders;

    public OrderService() {
        this.orders = new java.util.ArrayList<>();
    }

    @Override
    public Order createOrder(String date, String totalAmount, String status) {
        Order order = OrderFactory.create(date, totalAmount, status);
        orders.add(order);
        return order;
    }

    @Override
    public Optional<Order> getOrderById(String id) {
        return orders.stream().filter(o -> o.getId().equals(id)).findFirst();
    }

    @Override
    public List<Order> getAllOrders() {
        return new java.util.ArrayList<>(orders);
    }

    @Override
    public List<Order> getOrdersByUserId(String userId) {
        return orders.stream().filter(o -> o.getId().contains(userId)).toList();
    }

    @Override
    public List<Order> getOrdersByStatus(String status) {
        return orders.stream().filter(o -> o.getStatus().equals(status)).toList();
    }

    @Override
    public Order updateOrder(Order order) {
        Optional<Order> existing = getOrderById(order.getId());
        if (existing.isPresent()) {
            orders.remove(existing.get());
            orders.add(order);
        }
        return order;
    }

    @Override
    public Order updateOrderStatus(String orderId, String newStatus) {
        Optional<Order> order = getOrderById(orderId);
        if (order.isPresent()) {
            Order updatedOrder = new Order.Builder()
                    .copy(order.get())
                    .setStatus(newStatus)
                    .build();
            return updateOrder(updatedOrder);
        }
        return null;
    }

    @Override
    public boolean deleteOrder(String id) {
        return orders.removeIf(o -> o.getId().equals(id));
    }

    @Override
    public double calculateOrderTotal(String orderId) {
        Optional<Order> order = getOrderById(orderId);
        if (order.isPresent()) {
            try {
                return Double.parseDouble(order.get().getTotalAmount());
            } catch (NumberFormatException e) {
                return 0.0;
            }
        }
        return 0.0;
    }
}


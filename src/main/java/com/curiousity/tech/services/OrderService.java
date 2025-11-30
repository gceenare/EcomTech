package com.curiousity.tech.services;

import com.curiousity.tech.domain.*;
import com.curiousity.tech.repository.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    private final CartItemRepository cartRepo;
    private final OrderRepository orderRepo;
    private final ProductRepository productRepo;
    private final UserRepository userRepo;

    public OrderService(CartItemRepository cartRepo, OrderRepository orderRepo, ProductRepository productRepo, UserRepository userRepo) {
        this.cartRepo = cartRepo; this.orderRepo = orderRepo; this.productRepo = productRepo; this.userRepo = userRepo;
    }

    public Order checkout(String username) {
        User u = userRepo.findByUsername(username);
        if (u == null) throw new RuntimeException("User not found");
        List<CartItem> items = cartRepo.findByUserUsername(username);
        if (items.isEmpty()) throw new RuntimeException("Cart empty");

        Order order = new Order();
        order.setUser(u);
        order.setCreatedAt(LocalDateTime.now());
        List<OrderItem> orderItems = new ArrayList<>();
        double total = 0.0;
        for (CartItem ci : items) {
            Product p = productRepo.findById(ci.getProductId()).orElseThrow();
            if (p.getStock() < ci.getQuantity()) throw new RuntimeException("Insufficient stock for " + p.getName());
            p.setStock(p.getStock() - ci.getQuantity());
            productRepo.save(p);
            OrderItem oi = new OrderItem();
            oi.setProductId(p.getId());
            oi.setProductName(p.getName());
            oi.setPrice(p.getPrice());
            oi.setQuantity(ci.getQuantity());
            oi.setOrder(order);
            orderItems.add(oi);
            total += p.getPrice() * ci.getQuantity();
        }
        order.setItems(orderItems);
        order.setTotal(total);
        Order saved = orderRepo.save(order);
        // clear cart
        cartRepo.deleteAll(items);
        return saved;
    }
}

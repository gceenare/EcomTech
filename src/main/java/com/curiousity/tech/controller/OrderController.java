package com.curiousity.tech.controller;

import com.curiousity.tech.domain.Order;
import com.curiousity.tech.services.OrderService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) { this.orderService = orderService; }

    @PostMapping("/checkout")
    public ResponseEntity<?> checkout(HttpServletRequest req) {
        String username = (String) req.getAttribute("username");
        if (username == null) return ResponseEntity.status(401).body("Unauthenticated");
        try {
            Order order = orderService.checkout(username);
            return ResponseEntity.ok(order);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

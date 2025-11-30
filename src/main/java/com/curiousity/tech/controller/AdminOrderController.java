package com.curiousity.tech.controller;

import com.curiousity.tech.domain.Order;
import com.curiousity.tech.repository.OrderRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/orders")
public class AdminOrderController {
    private final OrderRepository orderRepo;
    public AdminOrderController(OrderRepository orderRepo){ this.orderRepo = orderRepo; }

    @GetMapping
    public List<Order> list(){ return orderRepo.findAll(); }

    @GetMapping("/{id}")
    public Order get(@PathVariable Long id){ return orderRepo.findById(id).orElse(null); }
}

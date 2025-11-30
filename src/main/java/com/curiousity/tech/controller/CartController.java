package com.curiousity.tech.controller;

import com.curiousity.tech.domain.CartItem;
import com.curiousity.tech.repository.ProductRepository;
import com.curiousity.tech.services.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    private final CartService cartService;
    private final ProductRepository productRepo;

    public CartController(CartService cartService, ProductRepository productRepo) {
        this.cartService = cartService; this.productRepo = productRepo;
    }

    @GetMapping
    public ResponseEntity<?> list(HttpServletRequest req) {
        String username = (String) req.getAttribute("username");
        if (username == null) return ResponseEntity.status(401).body("Unauthenticated");
        List<CartItem> items = cartService.listForUser(username);
        // enrich with product details
        var dto = items.stream().map(ci -> {
            var p = productRepo.findById(ci.getProductId()).orElse(null);
            return Map.of(
                "productId", ci.getProductId(),
                "quantity", ci.getQuantity(),
                "product", p
            );
        }).toList();
        return ResponseEntity.ok(dto);
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Map<String,Object> body, HttpServletRequest req) {
        String username = (String) req.getAttribute("username");
        if (username == null) return ResponseEntity.status(401).body("Unauthenticated");
        Long productId = Long.valueOf(String.valueOf(body.get("productId")));
        int qty = body.get("quantity") == null ? 1 : Integer.parseInt(String.valueOf(body.get("quantity")));
        cartService.add(username, productId, qty);
        return ResponseEntity.ok(Map.of("ok",true));
    }

    @PostMapping("/remove")
    public ResponseEntity<?> remove(@RequestBody Map<String,Object> body, HttpServletRequest req) {
        String username = (String) req.getAttribute("username");
        if (username == null) return ResponseEntity.status(401).body("Unauthenticated");
        Long productId = Long.valueOf(String.valueOf(body.get("productId")));
        cartService.remove(username, productId);
        return ResponseEntity.ok(Map.of("ok",true));
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody Map<String,Object> body, HttpServletRequest req) {
        String username = (String) req.getAttribute("username");
        if (username == null) return ResponseEntity.status(401).body("Unauthenticated");
        Long productId = Long.valueOf(String.valueOf(body.get("productId")));
        int qty = Integer.parseInt(String.valueOf(body.get("quantity")));
        cartService.update(username, productId, qty);
        return ResponseEntity.ok(Map.of("ok",true));
    }
}

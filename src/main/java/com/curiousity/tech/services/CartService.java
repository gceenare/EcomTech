package com.curiousity.tech.services;

import com.curiousity.tech.domain.CartItem;
import com.curiousity.tech.domain.Product;
import com.curiousity.tech.domain.User;
import com.curiousity.tech.repository.CartItemRepository;
import com.curiousity.tech.repository.ProductRepository;
import com.curiousity.tech.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    private final CartItemRepository cartRepo;
    private final UserRepository userRepo;
    private final ProductRepository productRepo;

    public CartService(CartItemRepository cartRepo, UserRepository userRepo, ProductRepository productRepo) {
        this.cartRepo = cartRepo; this.userRepo = userRepo; this.productRepo = productRepo;
    }

    public List<CartItem> listForUser(String username) {
        return cartRepo.findByUserUsername(username);
    }

    public void add(String username, Long productId, int qty) {
        User u = userRepo.findByUsername(username);
        if (u == null) throw new RuntimeException("User not found");
        Product p = productRepo.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));
        CartItem existing = cartRepo.findByUserUsernameAndProductId(username, productId);
        if (existing != null) {
            existing.setQuantity(existing.getQuantity() + qty);
            cartRepo.save(existing);
            return;
        }
        CartItem ci = new CartItem();
        ci.setUser(u); ci.setProductId(productId); ci.setQuantity(qty);
        cartRepo.save(ci);
    }

    public void remove(String username, Long productId) {
        CartItem existing = cartRepo.findByUserUsernameAndProductId(username, productId);
        if (existing != null) cartRepo.delete(existing);
    }

    public void update(String username, Long productId, int quantity) {
        CartItem existing = cartRepo.findByUserUsernameAndProductId(username, productId);
        if (existing == null) throw new RuntimeException("CartItem not found");
        if (quantity <= 0) cartRepo.delete(existing);
        else { existing.setQuantity(quantity); cartRepo.save(existing); }
    }

    public void clear(String username) {
        List<CartItem> items = cartRepo.findByUserUsername(username);
        cartRepo.deleteAll(items);
    }
}

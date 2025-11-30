package com.curiousity.tech.repository;

import com.curiousity.tech.domain.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    List<CartItem> findByUserUsername(String username);
    CartItem findByUserUsernameAndProductId(String username, Long productId);
}

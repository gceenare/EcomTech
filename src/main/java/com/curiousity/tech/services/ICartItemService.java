package com.curiousity.tech.services;

import com.curiousity.tech.domain.CartItem;
import java.util.List;
import java.util.Optional;

public interface ICartItemService {
    CartItem createCartItem(int quantity);
    Optional<CartItem> getCartItemById(String id);
    List<CartItem> getAllCartItems();
    List<CartItem> getCartItemsByCartId(String cartId);
    CartItem updateCartItem(CartItem cartItem);
    CartItem updateQuantity(String cartItemId, int newQuantity);
    boolean deleteCartItem(String id);
}


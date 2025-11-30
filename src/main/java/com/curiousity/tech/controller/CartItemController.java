package com.curiousity.tech.controller;

import com.curiousity.tech.services.CartItemService;
import com.curiousity.tech.domain.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
public class CartItemController {
    @Autowired
    private CartItemService cartItemService;


    public CartItem createCartItem(int quantity) {
        return cartItemService.createCartItem(quantity);
    }

    public Optional<CartItem> getCartItemById(String id) {
        return cartItemService.getCartItemById(id);
    }

    public List<CartItem> getAllCartItems() {
        return cartItemService.getAllCartItems();
    }

    public List<CartItem> getCartItemsByCartId(String cartId) {
        return cartItemService.getCartItemsByCartId(cartId);
    }

    public CartItem updateCartItem(CartItem cartItem) {
        return cartItemService.updateCartItem(cartItem);
    }

    public CartItem updateQuantity(String cartItemId, int newQuantity) {
        return cartItemService.updateQuantity(cartItemId, newQuantity);
    }

    public boolean deleteCartItem(String id) {
        return cartItemService.deleteCartItem(id);
    }
}

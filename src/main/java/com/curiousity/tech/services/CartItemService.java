package com.curiousity.tech.services;

import com.curiousity.tech.domain.CartItem;
import com.curiousity.tech.factory.CartItemFactory;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CartItemService implements ICartItemService {
    private List<CartItem> cartItems;

    public CartItemService() {
        this.cartItems = new java.util.ArrayList<>();
    }

    @Override
    public CartItem createCartItem(int quantity) {
        CartItem cartItem = CartItemFactory.create(quantity);
        cartItems.add(cartItem);
        return cartItem;
    }

    @Override
    public Optional<CartItem> getCartItemById(String id) {
        return cartItems.stream().filter(c -> c.getId().equals(id)).findFirst();
    }

    @Override
    public List<CartItem> getAllCartItems() {
        return new java.util.ArrayList<>(cartItems);
    }

    @Override
    public List<CartItem> getCartItemsByCartId(String cartId) {
        return cartItems.stream().filter(c -> c.getId().contains(cartId)).toList();
    }

    @Override
    public CartItem updateCartItem(CartItem cartItem) {
        Optional<CartItem> existing = getCartItemById(cartItem.getId());
        if (existing.isPresent()) {
            cartItems.remove(existing.get());
            cartItems.add(cartItem);
        }
        return cartItem;
    }

    @Override
    public CartItem updateQuantity(String cartItemId, int newQuantity) {
        Optional<CartItem> cartItem = getCartItemById(cartItemId);
        if (cartItem.isPresent()) {
            CartItem updated = new CartItem.Builder()
                    .copy(cartItem.get())
                    .setQuantity(newQuantity)
                    .build();
            return updateCartItem(updated);
        }
        return null;
    }

    @Override
    public boolean deleteCartItem(String id) {
        return cartItems.removeIf(c -> c.getId().equals(id));
    }
}

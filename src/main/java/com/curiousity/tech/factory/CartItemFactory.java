package com.curiousity.tech.factory;

import com.curiousity.tech.domain.CartItem;
import com.curiousity.tech.util.Helper;

public class CartItemFactory {

    public static CartItem create(int quantity) {
        Helper.logDebug("Creating cart item with quantity: " + quantity);
        return new CartItem.Builder()
                .setId(Helper.generateId())
                .setQuantity(quantity)
                .build();
    }

    public static CartItem copy(CartItem cartItem) {
        Helper.logDebug("Copying cart item: " + cartItem.getId());
        return new CartItem.Builder()
                .copy(cartItem)
                .build();
    }
}

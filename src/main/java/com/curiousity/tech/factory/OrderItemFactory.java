package com.curiousity.tech.factory;

import com.curiousity.tech.domain.OrderItem;
import com.curiousity.tech.util.Helper;

public class OrderItemFactory {

    public static OrderItem create(String orderId, String quantity, String price) {
        Helper.logDebug("Creating order item for order: " + orderId);
        return new OrderItem.Builder()
                .setOrderId(orderId)
                .setQuantity(quantity)
                .setPrice(price)
                .build();
    }

    public static OrderItem copy(OrderItem orderItem) {
        Helper.logDebug("Copying order item: " + orderItem.getOrderId());
        return new OrderItem.Builder()
                .copy(orderItem)
                .build();
    }
}



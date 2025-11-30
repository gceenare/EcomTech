package com.curiousity.tech.factory;

import com.curiousity.tech.domain.Order;
import java.util.UUID;

public class OrderFactory {

    public static Order create(String date, String totalAmount, String status) {
        return new Order.Builder()
                .setId(UUID.randomUUID().toString())
                .setDate(date)
                .setTotalAmount(totalAmount)
                .setStatus(status)
                .build();
    }

    public static Order copy(Order order) {
        return new Order.Builder()
                .copy(order)
                .build();
    }
}


package com.curiousity.tech.factory;

import com.curiousity.tech.domain.Product;

import java.util.Collections;

public class ProductFactory {

    public static Product create(String name, String description, double price, int stock, String category) {
        return Product.builder()
                .name(name)
                .description(description)
                .price(price)
                .stock(stock)
                .category(category)
                .images(Collections.emptyList())
                .specs(Collections.emptyMap())
                .build();
    }
}

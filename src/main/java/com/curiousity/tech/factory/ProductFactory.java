package com.curiousity.tech.factory;

import com.curiousity.tech.domain.Product;
import java.util.UUID;

public class ProductFactory {

    public static Product create(String name, String description, String price, String stockQuantity, String imageUrl) {
        return new Product.Builder()
                .setId(UUID.randomUUID().toString())
                .setName(name)
                .setDescription(description)
                .setPrice(price)
                .setStockQuantity(stockQuantity)
                .setImageUrl(imageUrl)
                .build();
    }

    public static Product copy(Product product) {
        return new Product.Builder()
                .copy(product)
                .build();
    }
}


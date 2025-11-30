package com.curiousity.tech.factory;

import com.curiousity.tech.domain.Category;
import java.util.UUID;

public class CategoryFactory {

    public static Category create(String name, String description) {
        return new Category.Builder()
                .setId(UUID.randomUUID().toString())
                .setName(name)
                .setDescription(description)
                .build();
    }

    public static Category copy(Category category) {
        return new Category.Builder()
                .copy(category)
                .build();
    }
}


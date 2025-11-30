package com.curiousity.tech.services;

import com.curiousity.tech.domain.Category;
import com.curiousity.tech.factory.CategoryFactory;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {
    private List<Category> categories;

    public CategoryService() {
        this.categories = new java.util.ArrayList<>();
    }

    @Override
    public Category createCategory(String name, String description) {
        Category category = CategoryFactory.create(name, description);
        categories.add(category);
        return category;
    }

    @Override
    public Optional<Category> getCategoryById(String id) {
        return categories.stream().filter(c -> c.getId().equals(id)).findFirst();
    }

    @Override
    public Optional<Category> getCategoryByName(String name) {
        return categories.stream().filter(c -> c.getName().equals(name)).findFirst();
    }

    @Override
    public List<Category> getAllCategories() {
        return new java.util.ArrayList<>(categories);
    }

    @Override
    public Category updateCategory(Category category) {
        Optional<Category> existing = getCategoryById(category.getId());
        if (existing.isPresent()) {
            categories.remove(existing.get());
            categories.add(category);
        }
        return category;
    }

    @Override
    public boolean deleteCategory(String id) {
        return categories.removeIf(c -> c.getId().equals(id));
    }
}


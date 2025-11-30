package com.curiousity.tech.controller;

import com.curiousity.tech.services.CategoryService;
import com.curiousity.tech.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
public class CategoryController {
    @Autowired
    private CategoryService categoryService;


    public Category createCategory(String name, String description) {
        return categoryService.createCategory(name, description);
    }

    public Optional<Category> getCategoryById(String id) {
        return categoryService.getCategoryById(id);
    }

    public Optional<Category> getCategoryByName(String name) {
        return categoryService.getCategoryByName(name);
    }

    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    public Category updateCategory(Category category) {
        return categoryService.updateCategory(category);
    }

    public boolean deleteCategory(String id) {
        return categoryService.deleteCategory(id);
    }
}


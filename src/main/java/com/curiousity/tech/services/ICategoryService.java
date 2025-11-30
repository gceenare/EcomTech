package com.curiousity.tech.services;

import com.curiousity.tech.domain.Category;
import java.util.List;
import java.util.Optional;

public interface ICategoryService {
    Category createCategory(String name, String description);
    Optional<Category> getCategoryById(String id);
    Optional<Category> getCategoryByName(String name);
    List<Category> getAllCategories();
    Category updateCategory(Category category);
    boolean deleteCategory(String id);
}


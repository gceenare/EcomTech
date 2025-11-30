package com.curiousity.tech.controller;

import com.curiousity.tech.services.ProductService;
import com.curiousity.tech.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
public class ProductController {
    @Autowired
    private ProductService productService;


    public Product createProduct(String name, String description, String price, String stockQuantity, String imageUrl) {
        return productService.createProduct(name, description, price, stockQuantity, imageUrl);
    }

    public Optional<Product> getProductById(String id) {
        return productService.getProductById(id);
    }

    public Optional<Product> getProductByName(String name) {
        return productService.getProductByName(name);
    }

    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    public List<Product> getProductsByCategory(String categoryId) {
        return productService.getProductsByCategory(categoryId);
    }

    public Product updateProduct(Product product) {
        return productService.updateProduct(product);
    }

    public boolean deleteProduct(String id) {
        return productService.deleteProduct(id);
    }

    public boolean isProductInStock(String productId) {
        return productService.isProductInStock(productId);
    }

    public Product decreaseStock(String productId, int quantity) {
        return productService.decreaseStock(productId, quantity);
    }

    public Product increaseStock(String productId, int quantity) {
        return productService.increaseStock(productId, quantity);
    }
}


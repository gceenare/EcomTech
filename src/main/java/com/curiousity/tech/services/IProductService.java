package com.curiousity.tech.services;

import com.curiousity.tech.domain.Product;
import java.util.List;
import java.util.Optional;

public interface IProductService {
    Product createProduct(String name, String description, String price, String stockQuantity, String imageUrl);
    Optional<Product> getProductById(String id);
    Optional<Product> getProductByName(String name);
    List<Product> getAllProducts();
    List<Product> getProductsByCategory(String categoryId);
    Product updateProduct(Product product);
    boolean deleteProduct(String id);
    boolean isProductInStock(String productId);
    Product decreaseStock(String productId, int quantity);
    Product increaseStock(String productId, int quantity);
}


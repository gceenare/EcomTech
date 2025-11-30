package com.curiousity.tech.services;

import com.curiousity.tech.domain.Product;
import java.util.List;
import java.util.Optional;

public interface IProductService {
    Product createProduct(String name, String description, double price, int stock, String category);
    Optional<Product> getProductById(Long id);
    Optional<Product> getProductByName(String name);
    List<Product> getAllProducts();
    List<Product> getProductsByCategory(String category);
    Product updateProduct(Product product);
    void deleteProduct(Long id);
    boolean isProductInStock(Long id);
    Product decreaseStock(Long id, int quantity);
    Product increaseStock(Long id, int quantity);
}

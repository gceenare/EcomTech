package com.curiousity.tech.services;

import com.curiousity.tech.domain.Product;
import com.curiousity.tech.factory.ProductFactory;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {
    private List<Product> products;

    public ProductService() {
        this.products = new java.util.ArrayList<>();
    }

    @Override
    public Product createProduct(String name, String description, String price, String stockQuantity, String imageUrl) {
        Product product = ProductFactory.create(name, description, price, stockQuantity, imageUrl);
        products.add(product);
        return product;
    }

    @Override
    public Optional<Product> getProductById(String id) {
        return products.stream().filter(p -> p.getId().equals(id)).findFirst();
    }

    @Override
    public Optional<Product> getProductByName(String name) {
        return products.stream().filter(p -> p.getName().equals(name)).findFirst();
    }

    @Override
    public List<Product> getAllProducts() {
        return new java.util.ArrayList<>(products);
    }

    @Override
    public List<Product> getProductsByCategory(String categoryId) {
        return products.stream().filter(p -> p.getId().contains(categoryId)).toList();
    }

    @Override
    public Product updateProduct(Product product) {
        Optional<Product> existing = getProductById(product.getId());
        if (existing.isPresent()) {
            products.remove(existing.get());
            products.add(product);
        }
        return product;
    }

    @Override
    public boolean deleteProduct(String id) {
        return products.removeIf(p -> p.getId().equals(id));
    }

    @Override
    public boolean isProductInStock(String productId) {
        Optional<Product> product = getProductById(productId);
        return product.isPresent() && Integer.parseInt(product.get().getStockQuantity()) > 0;
    }

    @Override
    public Product decreaseStock(String productId, int quantity) {
        Optional<Product> product = getProductById(productId);
        if (product.isPresent()) {
            int currentStock = Integer.parseInt(product.get().getStockQuantity());
            int newStock = currentStock - quantity;
            return updateProduct(product.get());
        }
        return null;
    }

    @Override
    public Product increaseStock(String productId, int quantity) {
        Optional<Product> product = getProductById(productId);
        if (product.isPresent()) {
            int currentStock = Integer.parseInt(product.get().getStockQuantity());
            int newStock = currentStock + quantity;
            return updateProduct(product.get());
        }
        return null;
    }
}


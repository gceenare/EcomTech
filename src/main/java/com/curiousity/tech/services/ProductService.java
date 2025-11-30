package com.curiousity.tech.services;

import com.curiousity.tech.domain.Product;
import com.curiousity.tech.factory.ProductFactory;
import com.curiousity.tech.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product createProduct(String name, String description, double price, int stock, String category) {
        Product product = ProductFactory.create(name, description, price, stock, category);
        return productRepository.save(product);
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Optional<Product> getProductByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public boolean isProductInStock(Long id) {
        return productRepository.findById(id)
                .map(product -> product.getStock() > 0)
                .orElse(false);
    }

    @Override
    public Product decreaseStock(Long id, int quantity) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));
        if (product.getStock() < quantity) {
            throw new IllegalStateException("Not enough stock");
        }
        product.setStock(product.getStock() - quantity);
        return productRepository.save(product);
    }

    @Override
    public Product increaseStock(Long id, int quantity) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));
        product.setStock(product.getStock() + quantity);
        return productRepository.save(product);
    }
}

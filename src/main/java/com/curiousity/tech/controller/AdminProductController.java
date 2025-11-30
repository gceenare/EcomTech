package com.curiousity.tech.controller;

import com.curiousity.tech.domain.Product;
import com.curiousity.tech.repository.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/admin/products")
public class AdminProductController {
    private final ProductRepository productRepo;
    private final Path uploadDir = Paths.get("uploads");

    public AdminProductController(ProductRepository productRepo) {
        this.productRepo = productRepo;
        try { Files.createDirectories(uploadDir); } catch(Exception ignored){}
    }

    @GetMapping
    public List<Product> list(){ return productRepo.findAll(); }

    @PostMapping
    public Product create(@RequestBody Product p){ return productRepo.save(p); }

    @GetMapping("/{id}")
    public ResponseEntity<Product> get(@PathVariable Long id){
        Optional<Product> op = productRepo.findById(id);
        return op.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product p){
        return productRepo.findById(id).map(existing -> {
            existing.setName(p.getName());
            existing.setDescription(p.getDescription());
            existing.setPrice(p.getPrice());
            existing.setStock(p.getStock());
            existing.setCategory(p.getCategory());
            existing.setSpecs(p.getSpecs());
            Product saved = productRepo.save(existing);
            return ResponseEntity.ok(saved);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        if (!productRepo.existsById(id)) return ResponseEntity.notFound().build();
        productRepo.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/image")
    public ResponseEntity<?> uploadImage(@PathVariable Long id, @RequestParam("file") MultipartFile file) throws IOException {
        var product = productRepo.findById(id).orElse(null);
        if (product == null) return ResponseEntity.notFound().build();
        String orig = StringUtils.cleanPath(file.getOriginalFilename());
        String ext = "";
        int i = orig.lastIndexOf('.');
        if (i >= 0) ext = orig.substring(i);
        String filename = UUID.randomUUID().toString() + ext;
        Path target = uploadDir.resolve(filename);
        Files.copy(file.getInputStream(), target);
        // assign first image (or push)
        List<String> imgs = product.getImages();
        if (imgs == null || imgs.isEmpty()){
            product.setImages(List.of("/uploads/" + filename));
        } else {
            imgs.add("/uploads/" + filename);
            product.setImages(imgs);
        }
        productRepo.save(product);
        return ResponseEntity.ok(Map.of("url", "/uploads/" + filename));
    }
}

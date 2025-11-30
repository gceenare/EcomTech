package com.curiousity.tech;

import com.curiousity.tech.domain.Product;
import com.curiousity.tech.domain.User;
import com.curiousity.tech.repository.ProductRepository;
import com.curiousity.tech.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.List;
import java.util.Map;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.curiousity.tech.repository")
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public static CommandLineRunner demoData(UserRepository userRepo, ProductRepository productRepo) {
        return args -> {
            // Seed admin user
            if (!userRepo.existsByUsername("admin")) {
                User admin = new User();
                admin.setUsername("admin");
                admin.setPassword("password"); // Storing plain text password for now
                userRepo.save(admin);
                System.out.println("Admin user created.");
            }

            // Seed sample products
            if (productRepo.count() == 0) {
                Product product1 = Product.builder()
                        .name("Laptop Pro")
                        .description("Powerful laptop for professionals")
                        .price(1200.00)
                        .stock(50)
                        .category("Electronics")
                        .images(List.of("laptop_pro.jpg"))
                        .specs(Map.of("CPU", "Intel i7", "RAM", "16GB"))
                        .build();

                Product product2 = Product.builder()
                        .name("Wireless Mouse")
                        .description("Ergonomic wireless mouse")
                        .price(25.00)
                        .stock(200)
                        .category("Accessories")
                        .images(List.of("wireless_mouse.jpg"))
                        .specs(Map.of("Connectivity", "2.4GHz", "DPI", "1200"))
                        .build();

                productRepo.saveAll(List.of(product1, product2));
                System.out.println("Sample products created.");
            }
        };
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("http://localhost:3000"); // Allow your frontend origin
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        config.setAllowCredentials(true);
        source.registerCorsConfiguration("/api/**", config); // Apply to your API endpoints
        return new CorsFilter(source);
    }
}

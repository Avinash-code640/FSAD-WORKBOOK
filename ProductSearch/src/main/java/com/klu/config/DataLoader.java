package com.klu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.klu.entity.Product;
import com.klu.repository.ProductRepository;

@Configuration
public class DataLoader {

    @Bean
    public org.springframework.boot.CommandLineRunner loadData(ProductRepository repo) {
        return args -> {
            repo.save(new Product("iPhone", "Electronics", 80000));
            repo.save(new Product("Laptop", "Electronics", 60000));
            repo.save(new Product("Shoes", "Fashion", 2000));
            repo.save(new Product("Shirt", "Fashion", 1500));
        };
    }
}

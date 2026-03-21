package com.klu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.klu.entity.Product;
import com.klu.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;
    
    @PostMapping("/add")
    public Product addProduct(@RequestBody Product product) {
        return service.saveProduct(product);
    }

    // a. Category
    @GetMapping("/category/{category}")
    public List<Product> getByCategory(@PathVariable String category) {
        return service.getByCategory(category);
    }

    // b. Price Filter
    @GetMapping("/filter")
    public List<Product> getByRange(@RequestParam double min, @RequestParam double max) {
        return service.getByPriceRange(min, max);
    }

    // c. Sorted
    @GetMapping("/sorted")
    public List<Product> getSorted() {
        return service.getSortedProducts();
    }

    // d. Expensive
    @GetMapping("/expensive/{price}")
    public List<Product> getExpensive(@PathVariable double price) {
        return service.getExpensiveProducts(price);
    }
}

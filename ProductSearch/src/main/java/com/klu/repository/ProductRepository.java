package com.klu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.klu.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

    // Derived Queries
    List<Product> findByCategory(String category);

    List<Product> findByPriceBetween(double min, double max);

    // JPQL Queries

    // Sorting by price
    @Query("SELECT p FROM Product p ORDER BY p.price ASC")
    List<Product> getAllSortedByPrice();

    // Products above price
    @Query("SELECT p FROM Product p WHERE p.price > :price")
    List<Product> getExpensiveProducts(double price);

    // Products by category (JPQL)
    @Query("SELECT p FROM Product p WHERE p.category = :category")
    List<Product> getProductsByCategory(String category);
}

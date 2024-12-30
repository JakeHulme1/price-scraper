package com.jakehulme.repository;

import com.example.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for managing Product entities.
 * 
 * This interface extends JpaRepository to provide CRUD operations for Product
 * entities.
 * The JpaRepository provides built-in methods fromcommon databse operations
 * like saving, finding and deleting entities
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // JpaRepository provides CRUD operations for Product entities
}
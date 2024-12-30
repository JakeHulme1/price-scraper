package com.jakehulme.controller;

import com.example.model.Product;
import com.example.repository.ProductRepository;
import com.example.service.PriceScraperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST controller for managing product-related requests.
 * 
 * This controller handles incoming HTTP requests and maps them to appropriate
 * service methods.
 */

// Mark this controller as a RESTful web service controller
// Combines @Controller and @ResponseBody, meaning that the methods in the class
// return data directly instead of a view.
@RestController

// Map HTTP requests to handler methods of MVC and REST controllers
// Specifies the base URL for all the methods in the controller
@RequestMapping("/api")
public class ProductController {

    // Marks a dependency to be injected by Spring's dependency injection mechanism.
    // Automatically injects
    // the required bean into the class.
    @Autowired
    private PriceScraperService priceScraperService;
    @Autowired
    private ProductRepository productRepository;

    /**
     * Retrieves a list of all products.
     *
     * @return a list of Product entities
     */
    @GetMapping("/products")
    public List<Product> getProducts() {
        // Fetch and return all products from the repository
        return productRepository.findAll();
    }

}

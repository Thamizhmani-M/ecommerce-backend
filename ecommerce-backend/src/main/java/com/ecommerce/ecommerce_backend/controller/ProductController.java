package com.ecommerce.ecommerce_backend.controller;

import com.ecommerce.ecommerce_backend.model.Product;
import com.ecommerce.ecommerce_backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // Endpoint to get all products: GET http://localhost:8080/api/products
    @GetMapping("/all")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // Endpoint to add a product: POST http://localhost:8080/api/products
    @PostMapping("/add")
    public Product addProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    // Update Product API: PUT http://localhost:8080/api/products/{id}
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    // Delete Product API: DELETE http://localhost:8080/api/products/{id}
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "Product deleted successfully with id: " + id;
    }
}





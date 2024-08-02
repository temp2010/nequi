package com.nequi.franchise_api.controllers;

import com.nequi.franchise_api.entities.Product;
import com.nequi.franchise_api.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(final ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public Mono<Product> createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteProduct(@PathVariable Long id) {
        return productService.deleteProduct(id);
    }

    @PutMapping("/{id}/name")
    public Mono<Product> updateProductName(@PathVariable Long id, @RequestBody String newName) {
        return productService.updateProductName(id, newName);
    }

    @PutMapping("/{id}/stock")
    public Mono<Product> updateProductStock(@PathVariable Long id, @RequestBody Integer newStock) {
        return productService.updateProductStock(id, newStock);
    }

}
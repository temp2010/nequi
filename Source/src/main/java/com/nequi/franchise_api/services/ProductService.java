package com.nequi.franchise_api.services;

import com.nequi.franchise_api.entities.Product;
import com.nequi.franchise_api.repositories.BranchRepository;
import com.nequi.franchise_api.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Comparator;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final BranchRepository branchRepository;

    @Autowired
    public ProductService(ProductRepository productRepository, BranchRepository branchRepository) {
        this.productRepository = productRepository;
        this.branchRepository = branchRepository;
    }

    public Mono<Product> createProduct(Product product) {

        return productRepository.save(product);
    }

    public Mono<Void> deleteProduct(Long id) {
        return productRepository.deleteById(id);
    }

    public Mono<Product> updateProductName(Long id, String newName) {

        return productRepository.findById(id)
                .flatMap(existingProduct -> {
                    existingProduct.setName(newName);
                    return productRepository.save(existingProduct);
                })
                .switchIfEmpty(Mono.error(new Exception("Producto con ID: " + id + " no encontrado")));
    }

    public Mono<Product> updateProductStock(Long id, Integer newStock) {

        return productRepository.findById(id)
                .flatMap(existingProduct -> {
                    existingProduct.setStock(newStock);
                    return productRepository.save(existingProduct);
                })
                .switchIfEmpty(Mono.error(new Exception("Producto con ID: " + id + " no encontrado")));
    }

    public Flux<Product> getTopProductsByBranchForFranchise(Long franchiseId) {
        return branchRepository.findByFranchiseId(franchiseId)
                .flatMap(branch ->
                        productRepository.findByBranchId(branch.getId())
                                .collectList()
                                .flatMap(products -> {
                                    Product topProduct = products.stream()
                                            .max(Comparator.comparingInt(Product::getStock))
                                            .orElse(null);
                                    return topProduct != null ? Mono.just(topProduct) : Mono.empty();
                                })
                                .flux()
                                .map(product -> {
                                    product.setBranchId(branch.getId());
                                    return product;
                                })
                );
    }

}
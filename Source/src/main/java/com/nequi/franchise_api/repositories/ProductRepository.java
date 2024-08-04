package com.nequi.franchise_api.repositories;

import com.nequi.franchise_api.entities.Branch;
import com.nequi.franchise_api.entities.Product;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ProductRepository extends ReactiveCrudRepository<Product, Long> {
    Flux<Product> findByBranchId(Long branchId);
}
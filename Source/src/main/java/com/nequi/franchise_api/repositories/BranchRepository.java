package com.nequi.franchise_api.repositories;

import com.nequi.franchise_api.entities.Branch;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Flux;

@Repository
public interface BranchRepository extends ReactiveCrudRepository<Branch, Long> {
    Flux<Branch> findByFranchiseId(Long franchiseId);
}
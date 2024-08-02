package com.nequi.franchise_api.services;

import com.nequi.franchise_api.entities.Franchise;
import com.nequi.franchise_api.repositories.FranchiseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class FranchiseService {

    private final FranchiseRepository franchiseRepository;

    @Autowired
    public FranchiseService(FranchiseRepository franchiseRepository) {
        this.franchiseRepository = franchiseRepository;
    }

    public Mono<Franchise> createFranchise(Franchise franchise) {

        return franchiseRepository.save(franchise);
    }

    public Mono<Franchise> updateFranchiseName(Long id, String newName) {

        return franchiseRepository.findById(id)
                .flatMap(existingFranchise -> {
                    existingFranchise.setName(newName);
                    return franchiseRepository.save(existingFranchise);
                })
                .switchIfEmpty(Mono.error(new Exception("Franquicia con ID: " + id + " no encontrada")));
    }

}
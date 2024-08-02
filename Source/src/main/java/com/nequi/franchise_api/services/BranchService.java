package com.nequi.franchise_api.services;

import com.nequi.franchise_api.entities.Branch;
import com.nequi.franchise_api.repositories.BranchRepository;
import com.nequi.franchise_api.repositories.FranchiseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class BranchService {

    private final BranchRepository branchRepository;
    private final FranchiseRepository franchiseRepository;

    @Autowired
    public BranchService(BranchRepository branchRepository, FranchiseRepository franchiseRepository) {
        this.branchRepository = branchRepository;
        this.franchiseRepository = franchiseRepository;
    }

    public Mono<Branch> createBranch(Branch branch) {

        Long franchiseId = branch.getFranchiseId();

        return franchiseRepository.findById(franchiseId)
                .flatMap(franchise -> branchRepository.save(branch))
                .switchIfEmpty(Mono.error(new Exception("Franquicia con ID: " + franchiseId + " no encontrada")));
    }

    public Mono<Branch> updateBranchName(Long id, String newName) {

        return branchRepository.findById(id)
                .flatMap(existingBranch -> {
                    existingBranch.setName(newName);
                    return branchRepository.save(existingBranch);
                })
                .switchIfEmpty(Mono.error(new Exception("Sucursal con ID: " + id + " no encontrada")));
    }

}
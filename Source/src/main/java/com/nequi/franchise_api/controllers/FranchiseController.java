package com.nequi.franchise_api.controllers;

import com.nequi.franchise_api.entities.Franchise;
import com.nequi.franchise_api.services.FranchiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/franchises")
public class FranchiseController {

    private final FranchiseService franchiseService;

    @Autowired
    public FranchiseController(FranchiseService franchiseService) {
        this.franchiseService = franchiseService;
    }

    @PostMapping
    public Mono<Franchise> createFranchise(@RequestBody Franchise franchise) {

        return franchiseService.createFranchise(franchise);
    }

    @PutMapping(value = "/{id}")
    public Mono<Franchise> updateFranchiseName(@PathVariable Long id, @RequestBody String newName) {

        return franchiseService.updateFranchiseName(id, newName);
    }

}
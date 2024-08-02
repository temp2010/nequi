package com.nequi.franchise_api.controllers;

import com.nequi.franchise_api.entities.Branch;
import com.nequi.franchise_api.services.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/branches")
public class BranchController {

    private final BranchService branchService;

    @Autowired
    public BranchController(final BranchService branchService) {
        this.branchService = branchService;
    }

    @PostMapping
    public Mono<Branch> createBranch(@RequestBody Branch branch) {

        return branchService.createBranch(branch);
    }

    @PutMapping(value = "/{id}")
    public Mono<Branch> updateBranchName(@PathVariable Long id, @RequestBody String newName) {

        return branchService.updateBranchName(id, newName);
    }

}
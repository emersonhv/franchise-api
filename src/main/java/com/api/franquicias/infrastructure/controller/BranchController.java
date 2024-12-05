package com.api.franquicias.infrastructure.controller;

import com.api.franquicias.domain.dto.BranchDTO;
import com.api.franquicias.domain.entity.Branch;
import com.api.franquicias.application.service.BranchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/branches")
@RequiredArgsConstructor
public class BranchController {

    private final BranchService branchService;

    @PostMapping("/{franchiseId}")
    public ResponseEntity<BranchDTO> addBranch(@PathVariable Long franchiseId, @RequestBody BranchDTO branchDTO) {
        BranchDTO branch = branchService.addBranch(franchiseId, branchDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(branch);
    }
}

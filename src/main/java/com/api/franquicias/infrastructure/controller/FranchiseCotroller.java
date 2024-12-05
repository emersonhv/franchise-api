package com.api.franquicias.infrastructure.controller;

import com.api.franquicias.domain.dto.FranchiseDTO;
import com.api.franquicias.application.service.FranchiseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/franchise")
@RequiredArgsConstructor
public class FranchiseCotroller {

    private final FranchiseService franchiseService;

    @PostMapping
    public ResponseEntity<FranchiseDTO> addFranchise(@RequestBody FranchiseDTO franchiseDTO) {
        FranchiseDTO franchise = franchiseService.addFranchise(franchiseDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(franchise);
    }

    @PutMapping("/{franchiseId}")
    public ResponseEntity<FranchiseDTO> updateFranchiseName(@PathVariable Long franchiseId, @RequestParam String name) {
        return ResponseEntity.ok(franchiseService.updateFranchiseName(franchiseId, name));
    }
}

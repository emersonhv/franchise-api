package com.api.franquicias.application.service;

import com.api.franquicias.domain.dto.FranchiseDTO;
import com.api.franquicias.domain.entity.Franchise;
import com.api.franquicias.infrastructure.repository.FranchiseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FranchiseService {

    private final FranchiseRepository franchiseRepository;

    public Franchise addFranchise(FranchiseDTO franchiseDTO) {
        return franchiseRepository.save(Franchise.builder()
                .name(franchiseDTO.getName())
                .build());
    }

    public Franchise updateFranchiseName(Long franchiseId, String name) {
        Franchise franchise = franchiseRepository.findById(franchiseId)
                .orElseThrow(() -> new RuntimeException("Not Found Element"));
        franchise.setName(name);
        return franchiseRepository.save(franchise);
    }
}

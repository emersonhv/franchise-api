package com.api.franquicias.service;

import com.api.franquicias.domain.dto.FranchiseDTO;
import com.api.franquicias.domain.entity.Franchise;
import com.api.franquicias.infrastructure.repository.FranchiseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FranchiseService {
    @Autowired
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

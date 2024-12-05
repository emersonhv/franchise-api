package com.api.franquicias.application.service;

import com.api.franquicias.application.mappers.FranchiseMapper;
import com.api.franquicias.domain.dto.FranchiseDTO;
import com.api.franquicias.domain.entity.Franchise;
import com.api.franquicias.infrastructure.repository.FranchiseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FranchiseService {

    private final FranchiseRepository franchiseRepository;
    private final FranchiseMapper franchiseMapper;
    public FranchiseDTO addFranchise(FranchiseDTO franchiseDTO) {
        return franchiseMapper.toDto(franchiseRepository.save(Franchise.builder()
                .name(franchiseDTO.getName())
                .build()));
    }

    public FranchiseDTO updateFranchiseName(Long franchiseId, String name) {
        Franchise franchise = franchiseRepository.findById(franchiseId)
                .orElseThrow(() -> new RuntimeException("Not Found Element"));
        franchise.setName(name);
        return franchiseMapper.toDto(franchiseRepository.save(franchise));
    }
}

package com.api.franquicias.application.service;

import com.api.franquicias.application.mappers.BranchMapper;
import com.api.franquicias.domain.dto.BranchDTO;
import com.api.franquicias.domain.entity.Branch;
import com.api.franquicias.domain.entity.Franchise;
import com.api.franquicias.infrastructure.repository.BranchRepository;
import com.api.franquicias.infrastructure.repository.FranchiseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BranchService {

    private final BranchRepository branchRepository;
    private final FranchiseRepository franchiseRepository;
    private final BranchMapper branchMapper;

    public BranchDTO addBranch(Long franchiseId, BranchDTO branchDTO) {
        Franchise franchise = franchiseRepository.findById(franchiseId)
                .orElseThrow(() -> new RuntimeException("Not Found Element"));

        return branchMapper.toDto(branchRepository.save(Branch.builder()
                .name(branchDTO.getName())
                .franchise(franchise)
                .build()));
    }
}

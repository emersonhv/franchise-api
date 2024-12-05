package com.api.franquicias.application.mappers;

import com.api.franquicias.domain.dto.BranchDTO;
import com.api.franquicias.domain.entity.Branch;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BranchMapper {
    BranchDTO toDto(Branch branch);
    Branch toEntity(BranchDTO branchDTO);
    List<BranchDTO> toDtoList(List<Branch> branches);
    List<Branch> toEntityList(List<BranchDTO> branchDTOs);
}

package com.api.franquicias.application.mappers;

import com.api.franquicias.domain.dto.FranchiseDTO;
import com.api.franquicias.domain.entity.Franchise;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FranchiseMapper {
    FranchiseDTO toDto(Franchise franchise);
    Franchise toEntity(FranchiseDTO franchiseDTO);
    List<FranchiseDTO> toDtoList(List<Franchise> franchises);
    List<Franchise> toEntityList(List<FranchiseDTO> franchiseDTOs);
}

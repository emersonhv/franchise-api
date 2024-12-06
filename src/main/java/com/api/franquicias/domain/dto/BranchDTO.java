package com.api.franquicias.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BranchDTO implements Serializable {
    private String name;
    private FranchiseDTO franchise;
}

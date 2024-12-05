package com.api.franquicias.application.mappers;

import com.api.franquicias.domain.dto.ProductDTO;
import com.api.franquicias.domain.entity.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDTO toDto(Product product);
    Product toEntity(ProductDTO productDTO);
    List<ProductDTO> toDtoList(List<Product> products);
    List<Product> toEntityList(List<ProductDTO> productDTOs);
}

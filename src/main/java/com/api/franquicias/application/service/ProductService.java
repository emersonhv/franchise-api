package com.api.franquicias.application.service;

import com.api.franquicias.application.mappers.ProductMapper;
import com.api.franquicias.domain.dto.ProductDTO;
import com.api.franquicias.domain.entity.Branch;
import com.api.franquicias.domain.entity.Franchise;
import com.api.franquicias.domain.entity.Product;
import com.api.franquicias.infrastructure.repository.BranchRepository;
import com.api.franquicias.infrastructure.repository.FranchiseRepository;
import com.api.franquicias.infrastructure.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final BranchRepository branchRepository;
    private final FranchiseRepository franchiseRepository;
    private final ProductMapper productMapper;

    public ProductDTO addProduct(Long branchId, ProductDTO productDTO) {
        Branch branch = branchRepository.findById(branchId)
                .orElseThrow(() -> new RuntimeException("Not Fount Element"));
        return productMapper.toDto(
                productRepository.save(
                        Product.builder()
                                .name(productDTO.getName())
                                .stock(productDTO.getStock())
                                .price(productDTO.getPrice())
                                .branch(branch)
                                .build()
                )
        );
    }

    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }

    public ProductDTO updateStock(Long productId, Integer stock) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Not Found Element"));
        product.setStock(stock);
        return productMapper.toDto(
                productRepository.save(product)
        );
    }

    public List<ProductDTO> getTopProducts(Long franchiseId) {
        Franchise franchise = franchiseRepository.findById(franchiseId)
                .orElseThrow(() -> new RuntimeException("Not Found Element"));

        return productMapper.toDtoList(franchise.getBranches().stream()
                .flatMap(branch -> branch.getProducts().stream())
                .collect(Collectors.groupingBy(Product::getBranch,
                        Collectors.maxBy(Comparator.comparing(Product::getStock))))
                .values().stream()
                .map(Optional::get)
                .toList());
    }
}

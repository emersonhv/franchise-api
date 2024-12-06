package com.api.franquicias.infrastructure.controller;

import com.api.franquicias.application.service.ProductService;
import com.api.franquicias.domain.dto.ProductDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/{branchId}")
    public ResponseEntity<ProductDTO> addProduct(
            @PathVariable Long branchId, @RequestBody ProductDTO productDTO) {
        ProductDTO product = productService.addProduct(branchId, productDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long productId) {
        productService.deleteProduct(productId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{productId}/stock")
    public ResponseEntity<ProductDTO> updateStock(
            @PathVariable Long productId, @RequestParam Integer stock) {
        ProductDTO product = productService.updateStock(productId, stock);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/{franchiseId}/top-products")
    public ResponseEntity<List<ProductDTO>> getTopProducts(@PathVariable Long franchiseId) {
        return ResponseEntity.ok(productService.getTopProducts(franchiseId));
    }


}

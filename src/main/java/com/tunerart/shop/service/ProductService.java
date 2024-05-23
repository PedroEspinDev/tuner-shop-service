package com.tunerart.shop.service;

import com.tunerart.shop.entity.Product;
import com.tunerart.shop.repository.IProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final IProductRepository productRepository;

    public Product newProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long productId) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        return optionalProduct.orElseThrow(
                () -> new RuntimeException("Not found product with this id"));
    }


}

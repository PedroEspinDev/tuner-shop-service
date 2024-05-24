package com.tunerart.shop.controller;

import com.tunerart.shop.entity.Product;
import com.tunerart.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/newProduct")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productService.newProduct(product));
    }

    @GetMapping("/products")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Product>> allProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/productById/{productId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Product> getProductById(@PathVariable Long productId) {
        Product product = productService.getProductById(productId);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/productByName/{name}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> getProductByName(@PathVariable String name) {
        Optional<Product> optionalProduct = productService.findProductByName(name);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
package com.tunerart.shop.controller;

import com.tunerart.shop.entity.Product;
import com.tunerart.shop.service.ProductService;
import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/shop")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/newProduct")
    @ResponseStatus (HttpStatus.CREATED)
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productService.newProduct(product));
    }
    @GetMapping("/products")
    @ResponseStatus (HttpStatus.OK)
    public ResponseEntity<List<Product>> allProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/productById/{productId}")
    @ResponseStatus (HttpStatus.OK)
    public ResponseEntity<Product> getProductById(@PathVariable UUID productId) {
        Product product = productService.getProductById(productId);
        return ResponseEntity.ok(product);
    }

}

package com.william.springboot.msvc.products.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.william.springboot.msvc.products.entities.Product;
import com.william.springboot.msvc.products.services.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<?> list(){
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> details(@PathVariable Long id){
        Optional<Product> productOptional = service.findById(id);

        if(productOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(productOptional.orElseThrow());
        }

        return ResponseEntity.notFound().build();
    }
}

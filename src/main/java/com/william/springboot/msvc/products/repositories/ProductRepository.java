package com.william.springboot.msvc.products.repositories;

import org.springframework.data.repository.CrudRepository;

import com.william.springboot.msvc.products.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{
    
}

package com.example.demo.services;

import com.example.demo.domain.Product;
import com.example.demo.repositories.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService extends CrudService<Product, Integer, ProductRepository> {
    public ProductService(ProductRepository repository) {
        super(repository);
    }
}

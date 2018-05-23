package com.example.demo.repositories;

import com.example.demo.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    Page<Product> findAllByDescriptionAndPriceGreaterThan(String description, String Price, Pageable pageable);

}

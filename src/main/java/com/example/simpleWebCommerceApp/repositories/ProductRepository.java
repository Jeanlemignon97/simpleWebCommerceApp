package com.example.simpleWebCommerceApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.simpleWebCommerceApp.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}

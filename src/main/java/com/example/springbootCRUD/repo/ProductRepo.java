package com.example.springbootCRUD.repo;

import com.example.springbootCRUD.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Integer> {


    Product findByName(String name);
}

package com.example.springbootCRUD.repository;

import com.example.springbootCRUD.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepo extends JpaRepository<ProductModel, Integer> {


    ProductModel findByName(String name);

    //NATIVE QUERY
    @Query(value = "select * from product_model where price <= :price", nativeQuery = true)
    public List<ProductModel> productLessThan(@Param("price") double price);
    @Query(value = "select * from product_model where name = :name order by price", nativeQuery = true)
    public List<ProductModel> findByNameSorted(@Param("name") String name);

}

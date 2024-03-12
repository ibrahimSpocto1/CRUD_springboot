package com.example.springbootCRUD.service;

import com.example.springbootCRUD.model.ProductModel;

import java.util.List;

public interface ProductService {

    ProductModel saveProduct(ProductModel product);

    List<ProductModel> saveProducts(List<ProductModel> products);

    List<ProductModel> getProducts();


    ProductModel getProductById(int id);

    ProductModel getProductByName(String name);
    String deleteProduct(int id);
    ProductModel updateProduct(ProductModel product);

    List<ProductModel> productLessThan(double price);
    List<ProductModel> findByNameSorted(String name);

}

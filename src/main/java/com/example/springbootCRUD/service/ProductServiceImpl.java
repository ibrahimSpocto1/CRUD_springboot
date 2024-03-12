package com.example.springbootCRUD.service;

import com.example.springbootCRUD.model.ProductModel;
import com.example.springbootCRUD.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo repo;

    @Override
    public ProductModel saveProduct(ProductModel product) {
        return repo.save(product);
    }

    @Override
    public List<ProductModel> saveProducts(List<ProductModel> products) {
        return repo.saveAll(products);

    }

    @Override
    public List<ProductModel> getProducts() {
        return repo.findAll();
    }

    @Override
    public ProductModel getProductById(int id) {
        return repo.findById(id).orElse(null);

    }

    @Override
    public ProductModel getProductByName(String name) {
        return repo.findByName(name);
    }

    @Override
    public String deleteProduct(int id) {
        repo.deleteById(id);
        return "product removed !! " + id;
    }


    @Override
    public ProductModel updateProduct(ProductModel product) {
        ProductModel existingProduct = repo.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());
        return repo.save(existingProduct);
    }

    @Override
    public List<ProductModel> productLessThan(double price) {
        return repo.productLessThan(price);
    }

    @Override
    public List<ProductModel> findByNameSorted(String name) {
        return repo.findByNameSorted(name);
    }
}

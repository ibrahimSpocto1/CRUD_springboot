package com.example.springbootCRUD.controller;

import com.example.springbootCRUD.model.ProductModel;
import com.example.springbootCRUD.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping("/addProduct")
    public ProductModel addProduct(@RequestBody ProductModel product) {
        return service.saveProduct(product);
    }

    @PostMapping("/addProducts")
    public List<ProductModel> addProducts(@RequestBody List<ProductModel> products) {
        return service.saveProducts(products);
    }

    @GetMapping("/products")
    public List<ProductModel> findAllProducts() {
        return service.getProducts();
    }

    @GetMapping("/productById/{id}")
    public ProductModel findProductById(@PathVariable int id) {
        return service.getProductById(id);
    }


    @GetMapping("/product/{name}")
    public ProductModel findProductByName(@PathVariable String name) {
        return service.getProductByName(name);
    }

    @PutMapping("/update")
    public ProductModel updateProduct(@RequestBody ProductModel product) {
        return service.updateProduct(product);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        return service.deleteProduct(id);
    }


    @GetMapping("/priceLessThan/{price}")
    public List<ProductModel> priceLessThan(@PathVariable double price){
        return service.productLessThan(price);
    }
    @GetMapping("/findByNameSorted/{name}")
    public List<ProductModel> findByNameSorted(@PathVariable String name){
        return service.findByNameSorted(name);
    }

}

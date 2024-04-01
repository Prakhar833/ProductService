package com.example.product.controllers;

import com.example.product.dtos.ProductRequestDto;
import com.example.product.models.Product;
import com.example.product.services.IProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {


    private IProductServices productServices;
    @Autowired
    public ProductController(@Qualifier("fakeStoreProductService") IProductServices productServices){
        this.productServices = productServices;
    }
    //get all products
    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productServices.getAllProducts();
    }


    //get a product with id
    @GetMapping("/products/{id}")
    public Product getSingleProduct(@PathVariable("id") Long id){
        return productServices.getSingleProduct(id);
    }


    //add product
    @PostMapping("/products")
    public Product addProduct(@RequestBody ProductRequestDto productRequestDto){
        return new Product();
    }

    //update
    @PutMapping("/products/{id}")
    public Product updateProduct(@PathVariable("id") Long id ,
                                 @RequestBody ProductRequestDto productRequestDto){
        return productServices.updateProduct(id,productRequestDto);
    }

    //delete
    @DeleteMapping("/products/{id}")
    public boolean deleteProduct(@PathVariable("id") Long id){
        return true;
    }

}

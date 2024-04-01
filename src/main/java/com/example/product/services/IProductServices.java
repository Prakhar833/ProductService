package com.example.product.services;

import com.example.product.dtos.ProductRequestDto;
import com.example.product.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IProductServices {
    public Product getSingleProduct(Long id);

    List<Product> getAllProducts();

    Product updateProduct(Long id, ProductRequestDto productRequestDto);
}

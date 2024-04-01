package com.example.product.services;

import com.example.product.dtos.ProductRequestDto;
import com.example.product.dtos.ProductResponseDto;
import com.example.product.models.Category;
import com.example.product.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@Qualifier("fakeStoreProductService")
public class FakeStoreProductService implements IProductServices{


    @Autowired
    RestTemplate restTemplate;
    public Product getProductFromResponseDto(ProductResponseDto responseDto){
        Product product = new Product();
        product.setId(responseDto.getId());
        product.setPrice(responseDto.getPrice());
        product.setName(responseDto.getTitle());
        product.setDescription(responseDto.getDescription());
        product.setImage(responseDto.getImage());

        Category category = new Category();
        category.setName(responseDto.getCategory());

        product.setCategory(category);
        return product;
    }
    @Override
    public Product getSingleProduct(Long id) {

        //pass 'id' to get product from fakeStore

        ProductResponseDto response = restTemplate.getForObject("https://fakestoreapi.com/products/" + id,
                ProductResponseDto.class);

        return getProductFromResponseDto(response);

    }

    @Override
    public List<Product> getAllProducts() {


        ProductResponseDto[] responseDtoList = restTemplate.getForObject("https://fakestoreapi.com/products",
                ProductResponseDto[].class);

        List<Product> output = new ArrayList<>();
        for(ProductResponseDto productResponseDto : responseDtoList){
            output.add(getProductFromResponseDto(productResponseDto));
        }
        return output;
    }

    @Override
    public Product updateProduct(Long id, ProductRequestDto productRequestDto) {
        return null;
    }


}

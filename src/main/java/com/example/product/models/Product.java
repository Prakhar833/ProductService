package com.example.product.models;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Getter
@Setter
@JsonSerialize
//@RedisHash(timeToLive = 300L)
public class Product implements Serializable {
    private Long id;
    private String name;
    private String description;
    private int price;
    private String image;
    private Category category;

}

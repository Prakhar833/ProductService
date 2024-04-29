package com.example.product.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.swing.*;

@RestController
public class dummyController {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/dummy")
    public void dummyApi(){
        String answer = restTemplate.getForObject("http://userservice/hi", String.class);
        System.out.println(answer);
    }

}

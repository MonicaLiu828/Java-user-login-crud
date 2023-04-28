package com.example.demo.entity;


import lombok.Data;

@Data
public class Restaurant {

    private Integer id;
    private String name;
    private Double distance;
    private String price;
    private String display_address;
    private String image_url;
}

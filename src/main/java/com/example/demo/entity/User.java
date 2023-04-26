package com.example.demo.entity;

import lombok.Data;

// lombok to make getter and setter easily
@Data
public class User {
    private Integer id;
    private String name;
    private String address;
    private Integer age;
    private String sex;
    private String phone;

}

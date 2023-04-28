package com.example.demo.controller;

import com.example.demo.entity.Restaurant;
import com.example.demo.entity.User;
import com.example.demo.mapper.RestaurantMapper;
import com.example.demo.mapper.UserMapper;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
    @Resource
    RestaurantMapper restaurantMapper;
    @GetMapping
    public List<Restaurant> getRestaurant(){
        return restaurantMapper.findAll();
    }

    @PostMapping
    public String addRestaurant(@RequestBody Restaurant restaurant){
        restaurantMapper.save(restaurant);
        return "success";
    }
}

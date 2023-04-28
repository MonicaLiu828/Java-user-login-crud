package com.example.demo.mapper;

import com.example.demo.entity.Restaurant;
import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RestaurantMapper {
    @Select("select * from restaurant")
    List<Restaurant> findAll();

    @Update("INSERT INTO restaurant (name, distance, price, display_address, image_url) VALUES (#{name}, #{distance}, #{price}, #{display_address}, #{image_url});")
    @Transactional
    void save(Restaurant restaurant);

}

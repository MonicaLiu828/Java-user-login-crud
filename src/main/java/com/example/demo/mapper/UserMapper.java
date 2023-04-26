package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserMapper {
    @Select("select * from user")
    List<User> findAll();


    // In mybatis send args need #{}
    @Update("INSERT INTO user (name, address, age, sex, phone) VALUES (#{name}, #{address}, #{age}, #{sex}, #{phone});")
    @Transactional
    void save(User user);

    @Update("UPDATE user set name = #{name}, address = #{address}, age = #{age}, sex = #{sex}, phone = #{phone} WHERE id = #{id};")
    @Transactional
    void updateById(User user);

    @Delete("DELETE from user where id = #{id};")
    void deleteById(Long id);
    @Select("select * from user where id = #{id};")
    User findById(Long id);

    @Select("select * from user limit #{offset}, #{pageSize};")
    List<User> findByPage(Integer offset, Integer pageSize);
    @Select("select count(id) from user")
    Integer countUser();
}

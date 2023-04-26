package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.vo.Page;
import jakarta.annotation.Resource;
import org.apache.ibatis.jdbc.Null;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//to get json format to front-end
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    UserMapper userMapper;

    // getMapping can give another path to change /user into this new path
    @GetMapping
    public List<User> getUser(){
        return userMapper.findAll();
    }

    // requestbody can get front-end json data into user instance
    @PostMapping
    public String addUser(@RequestBody User user){
        userMapper.save(user);
        return "success";
    }

    @PutMapping
    public String updateUser(@RequestBody User user){
        userMapper.updateById(user);
        return "success";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        if (findById(id) != null) {
            userMapper.deleteById(id);
            return "success";
        }
        else {
            return "Don not find this record and can't delete";
        }

    }


    @GetMapping("/{id}")
    public User findById(@PathVariable("id") Long id){
        return userMapper.findById(id);
    }

    @GetMapping("/page")
    public Page<User> findByPage(@RequestParam(defaultValue = "1") Integer pageNum,
                                 @RequestParam(defaultValue = "10") Integer pageSize){
        Integer offset = (pageNum-1) * pageSize;
        List<User> userData = userMapper.findByPage(offset, pageSize);
        Page<User> page = new Page<>();
        page.setData(userData);

        Integer total = userMapper.countUser();
        page.setTotal(total);
        page.setPageSize(pageSize);
        page.setPageNum(pageNum);
        return page;
    }

}


// 1. in resources application.properties to setup the config of mysql
// 2. setup entity to match the instance of the schema of dbs
// 3. write a userMapper this interface should also be setup in DemoApplication, to scan this path to make mybatis can
// find this path and inject into spring
// 4.  finally in userController declare this controller and then use @Resource to get this mapper from spring container
// and then call findAll method to get object  of List<User>
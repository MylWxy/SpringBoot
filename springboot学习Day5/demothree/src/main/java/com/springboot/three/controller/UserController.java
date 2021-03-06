package com.springboot.three.controller;


import com.springboot.three.entity.UserEntity;
import com.springboot.three.jpa.UserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*",maxAge = 3600)

@RequestMapping(value = "/api/user")
public class UserController {
    @Autowired
    private UserJPA userJPA;
    @RequestMapping(value ="/queryUser",method = RequestMethod.GET)
    public UserEntity login(String name,Long password) {
        UserEntity userEntity= userJPA.findByNameAndPassword(name,password);
        return userEntity;
    }
    @RequestMapping(value ="/info",method = RequestMethod.GET)
    public Optional<UserEntity> userInfo(Long id) {
        return userJPA.findById(id);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<UserEntity> list() {
        return userJPA.findAll();//SpringDataJPA为我们提供的内置方法，它可以查询表内所有的数据
    }

    /**
     * 添加、更新用户方法
     * @param entity
     * @return
     */
    @RequestMapping(value = "/save",method = RequestMethod.GET)
    public UserEntity save(UserEntity entity){
        return userJPA.save(entity);
    }
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public List<UserEntity> delete(Long id){
        userJPA.deleteById(id);
        return userJPA.findAll();
    }















}


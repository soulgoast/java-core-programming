/*
 * Copyright (c) 1995, 2100, QunCe and/or its affiliates. All rights reserved.
 * QUNCE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */
package com.example.example1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author soul goodman
 * @email m18967896507_1@163.com
 * @Date 2020/4/8 20:34
 * @ModifyDate 2020/4/8 20:34
 * @Version 1.0
 */
@RestController
@RequestMapping(path = "/demo")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(path = "/add")
    public void addNewUser(@RequestParam String name, @RequestParam String email) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        userRepository.save(user);
    }

    @GetMapping(path = "/all")
    public Iterable<User> getAllUser() {
        return userRepository.findAll();
    }

    @GetMapping(path = "/page")
    public Page<User> getAllUserByPage() {
        return userRepository.findAll(PageRequest.of(1, 20, Sort.by(Sort.Direction.ASC, "name")));
    }

    @GetMapping(path = "/sort")
    public Iterable<User> getAllUserWithSort() {
        return userRepository.findAll(Sort.by(Sort.Direction.DESC, "email", "name")); // 前面的优先级高
    }
}
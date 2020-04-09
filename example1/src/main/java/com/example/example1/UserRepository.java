/*
 * Copyright (c) 1995, 2100, QunCe and/or its affiliates. All rights reserved.
 * QUNCE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */
package com.example.example1;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @ClassName UserRepository
 * @Description TODO
 * @Author soul goodman
 * @email m18967896507_1@163.com
 * @Date 2020/4/8 20:34
 * @ModifyDate 2020/4/8 20:34
 * @Version 1.0
 */
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * 根据名词查询用户列表
     * @param name
     * @return
     */
    List<User> findByName(String name);

    /**
     * 根据用户的邮箱和名称查询
     * @param name
     * @param email
     * @return
     */
    List<User> findByNameAndEmail(String name, String email);

}
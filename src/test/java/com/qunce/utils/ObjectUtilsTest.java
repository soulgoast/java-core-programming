/*
 * Copyright (c) 1995, 2100, QunCe and/or its affiliates. All rights reserved.
 * QUNCE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */

package com.qunce.utils;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

/**
 * @ClassName ObjectUtilsTest
 * @Description ObjectUtils的测试类
 * @Author soul goodman
 * @email m18967896507_1@163.com
 * @Date 2019/11/13 10:02
 * @ModifyDate 2019/11/13 10:02
 * @Version 1.0
 */
public class ObjectUtilsTest {

    @Test
    public void addForNullProperty() throws Exception {
        Person person = new Person();
        person = ObjectUtils.checkNullAndInit(person);
        Assert.assertEquals("", person.getName());
        Assert.assertEquals("", person.getAddress());
    }

}

class Person {

    private String name;

    private String address;

    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
/*
 * Copyright (c) 1995, 2100, QunCe and/or its affiliates. All rights reserved.
 * QUNCE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */
package com.qunce.reactor;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;

/**
 * @ClassName PubAndSub
 * @Description TODO
 * @Author soul goodman
 * @email m18967896507_1@163.com
 * @Date 2021/2/2 20:46
 * @ModifyDate 2021/2/2 20:46
 * @Version 1.0
 */
public class PubAndSub {

    @Test
    public void normal() {
        String hello = "hello";
        System.out.println(hello);
    }

    @Test
    public void reactor() {
        String hello = "hello";

        Publisher pub = new Publisher();
        pub.subscribe(new Subscriber());

        pub.submit(hello);
    }



}
/*
 * Copyright (c) 1995, 2100, QunCe and/or its affiliates. All rights reserved.
 * QUNCE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */
package com.qunce.reactor;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName Subscriber
 * @Description TODO
 * @Author soul goodman
 * @email m18967896507_1@163.com
 * @Date 2021/2/2 21:03
 * @ModifyDate 2021/2/2 21:03
 * @Version 1.0
 */
public class Subscriber {

    private Publisher.Subscription subscription;

    public void onSubscribe(Publisher.Subscription subscription) {
        this.subscription = subscription;
    }

    public void onNext(String item) {
        try {
            TimeUnit.MILLISECONDS.sleep(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(item);
    }
}
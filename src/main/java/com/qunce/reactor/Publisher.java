/*
 * Copyright (c) 1995, 2100, QunCe and/or its affiliates. All rights reserved.
 * QUNCE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */
package com.qunce.reactor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;

/**
 * @ClassName Publisher
 * @Description TODO
 * @Author soul goodman
 * @email m18967896507_1@163.com
 * @Date 2021/2/2 21:02
 * @ModifyDate 2021/2/2 21:02
 * @Version 1.0
 */
public class Publisher {
    private ExecutorService executorService = ForkJoinPool.commonPool();

    private Subscription subscription;

    public void subscribe(Subscriber subscriber) {
        subscription = new Subscription(subscriber);
        subscriber.onSubscribe(new Subscription(subscriber));
    }

    public void submit(String param) {
        executorService.submit(() -> subscription.subscriber.onNext(param));
    }

    class Subscription {

        private Subscriber subscriber;

        public Subscription(Subscriber subscriber) {
            this.subscriber = subscriber;
        }
    }
}
/*
 * Copyright (c) 1995, 2100, QunCe and/or its affiliates. All rights reserved.
 * QUNCE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */
package com.qunce.reactor;

import org.junit.Test;
import reactor.core.publisher.Flux;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName AsyncHandler
 * @Description TODO
 * @Author soul goodman
 * @email m18967896507_1@163.com
 * @Date 2021/2/2 21:02
 * @ModifyDate 2021/2/2 21:02
 * @Version 1.0
 */
public class AsyncHandler {

    // 56091
    @Test
    public void normal() throws InterruptedException {
        long start = System.currentTimeMillis();

        Subscriber subscriber = new Subscriber();
        String hello = "hello";
        int i = 0;
        while (i < Short.MAX_VALUE) {
            subscriber.onNext(hello);
            ++i;
        }
        long complete = System.currentTimeMillis();
        System.out.println(complete -start);
    }

    // 13
    @Test
    public void reactor() {
        long start = System.currentTimeMillis();

        Publisher publisher = new Publisher();
        publisher.subscribe(new Subscriber());
        String hello = "hello";
        int i = 0;
        while (i < Short.MAX_VALUE) {
            publisher.submit(hello);
            ++i;
        }
        long complete = System.currentTimeMillis();
        System.out.println(complete -start);
    }

    /**
     * 1。去掉含有字符F的月份
     * 2。按首字母进行分类
     */
    @Test
    public void multiStepNormal() {
        List<String> mouths = Arrays.asList("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov");
        Map<String, Integer> mouthCount = new HashMap<>();
        for (String mouth : mouths) {
            String toUpperCase = mouth.toUpperCase();
            if (toUpperCase.contains("F")) {
                continue;
            }
            String initials = toUpperCase.substring(0, 1);
            Integer count = mouthCount.get(initials);
            if (Objects.isNull(count)) {
                mouthCount.put(initials, BigInteger.ONE.intValue());
            } else {
                mouthCount.put(initials, count + BigInteger.ONE.intValue());
            }
        }

        mouthCount.keySet().stream().map(item -> "首字母" + item + "出现" + mouthCount.get(item)).forEach(System.out::println);
    }

    @Test
    public void multiLambda() {
        List<String> mouths = Arrays.asList("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov");
        Map<String, Long> mouthCount = mouths.stream()
                .map(String::toUpperCase)
                .filter(item -> !item.contains("F"))
                .collect(Collectors.groupingBy(item -> item.substring(0, 1), Collectors.counting()));
        mouthCount.keySet().stream().map(item -> "首字母" + item + "出现" + mouthCount.get(item)).forEach(System.out::println);
    }

    @Test
    public void multiReactor() {
        Flux<String> mouths = Flux.fromStream(Stream.of("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov"));
        Map<String, Long> mouthCount = mouths.map(String::toUpperCase)
                .filter(item -> !item.contains("F"))
                .collect(Collectors.groupingBy(item -> item.substring(0, 1), Collectors.counting())).block();
        mouthCount.keySet().stream().map(item -> "首字母" + item + "出现" + mouthCount.get(item)).forEach(System.out::println);
    }
}
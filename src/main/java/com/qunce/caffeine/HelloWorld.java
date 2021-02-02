/*
 * Copyright (c) 1995, 2100, QunCe and/or its affiliates. All rights reserved.
 * QUNCE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */
package com.qunce.caffeine;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName HelloWorld
 * @Description TODO
 * @Author soul goodman
 * @email m18967896507_1@163.com
 * @Date 2020/9/12 9:06
 * @ModifyDate 2020/9/12 9:06
 * @Version 1.0
 */
@Slf4j
public class HelloWorld {

    LoadingCache<String, String> cache;

    @Before
    public void sayHello() {
        /**
         *
         */
        cache = Caffeine.newBuilder()
                .maximumSize(10_1000)
                .expireAfterWrite(5, TimeUnit.SECONDS)
                .refreshAfterWrite(1, TimeUnit.SECONDS)
                .build(key -> key);
    }

    @Test
    public void fill() throws InterruptedException {
        cache.put("aaa", "aaa");
        log.info("从缓存中获取数据：{}", cache.get("aaa"));
        log.info("等待5秒");
        TimeUnit.SECONDS.sleep(6);
        log.info("从缓存中获取数据：{}", cache.get("aaa")); // 还是有数据
    }

    @Test
    public void load() {

    }

}
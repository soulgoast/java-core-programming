/*
 * Copyright (c) 1995, 2100, QunCe and/or its affiliates. All rights reserved.
 * QUNCE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */

package com.qunce.message;

import java.util.Date;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * @ClassName MessageQueue
 * @Description TODO
 * @Author soul goodman
 * @email m18967896507_1@163.com
 * @Date 2019/12/12 8:50
 * @ModifyDate 2019/12/12 8:50
 * @Version 1.0
 */
public class MessageQueue {

    private PriorityBlockingQueue<Message> messages = new PriorityBlockingQueue<>(10); // 不同topic的消息队列

    public void add(Message message) {
        messages.add(message);
    }

    private Date date; // 最后更新的时间

    private Integer expirationDate = -1; // 有效期，单位是秒，默认为-1，标识不过期。

    public MessageQueue(Date date) {
        this.date = date;
    }
}

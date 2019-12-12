/*
 * Copyright (c) 1995, 2100, QunCe and/or its affiliates. All rights reserved.
 * QUNCE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */

package com.qunce.message;

import java.util.Date;
import java.util.Objects;
import java.util.concurrent.*;

/**
 * @ClassName MessageManager
 * @Description
 * MessageManager的职责有：
 * 1、从消息队列中获取消息，并发送。如果该消息没有对应的队列，则创建队列并将消息发送出去。
 * 2、消息队列超时设计：队列中没有消息，超过十分钟，自销毁。（心跳消息不在队列的管辖范围内，所以如果没有对机柜中的设备进行操作，是不会创建改队列的）。
 * 3、线程模型，设计线程池，一个机柜对应一个U位条，对应一个数据队列，如果有3000个机柜，那么就需要3000个线程，显然不符合现实。所以需要引入线程池。
 * 4、升级队列在发送数据的时候，其他队列都是出于阻塞状态。
 * 5、
 * @Author soul goodman
 * @email m18967896507_1@163.com
 * @Date 2019/12/12 9:24
 * @ModifyDate 2019/12/12 9:24
 * @Version 1.0
 */
public class MessageManager {

    private String all = "ZH/KFZX";
    private String upgrade = "ZH/KFZX/UP"; // 升级
    private String one = "ZH/KFZX/";  // 用于

    private String upgradeQueue = "upgrade";

    private final Integer TimeToFailure = 10 * 60 * 1000; // 消息队列的失效销毁时间，默认为10分钟

    private Executor executor = Executors.newCachedThreadPool(); // 用于处理消息队列中的线程池

    private ConcurrentHashMap<String, MessageQueue> messageQueues = new ConcurrentHashMap<>(); // 与U位条对应的消息队列

    private PriorityBlockingQueue<Message> messages = new PriorityBlockingQueue<>(10); // 即将发出的消息组成的消息队列，保证每个U位条只有一条消息在队列中。

    public static void receice(String message) {


    }

    public void preparatorySendMessage(Message message) {
        String topic = message.getTopic();
        if(topic.equals(upgrade)) { // 升级消息
            MessageQueue messageQueue = messageQueues.get(upgradeQueue);

            if(Objects.nonNull(messageQueue)) { // 创建队列
                messageQueue = new MessageQueue(new Date());
                messageQueues.put(upgradeQueue, messageQueue);
            }
            messageQueue.add(message);
        } else if (topic.equals(all)) {

        } else if (topic.startsWith(one)) {

        }

    }

    static {
        new Thread(() -> {
            while (true) {
                System.out.println("启动轮训");
            }
        }).start();
    }

    public static void main(String[] args) throws InterruptedException {
        TimeUnit.SECONDS.sleep(10);
    }

}

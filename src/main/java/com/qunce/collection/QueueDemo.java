/*
 * Copyright (c) 1995, 2100, QunCe and/or its affiliates. All rights reserved.
 * QUNCE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */

package com.qunce.collection;

import java.util.Queue;

/**
 * @ClassName QueueDemo
 * @Description
 * Queue是用来保存等待处理的元素的集合。除了基本的Collection提供的操作。Queue提供了额外的添加, 移除, 和检查操作。
 * 其中每个方法存在两种表现形式：一种操作失败抛出异常，另一种是根据操作的不同返回指定的结果（比如null或者false）。
 * 后一种添加方式专为使用容量受限的实现而设计；大多数实现，插入操作不会失败。
 * Queue的方法总结
 *          会抛出异常       返回指定的值
 * 添加       add(e)          offer(e)
 * 移除       remove()        poll()
 * 检查       element()       peek()
 *
 * 通常情况下，但不是必须的，Queue按照先入先出的方式对元素进行排序。例外的有（priority queue）优先级队列，
 * 它根据支持的比较器或者元素的自然顺序进行排序，LIFO队列（比如栈结构）按照后入先出的顺序对元素进行排序。
 * 不管使用哪种排序方式，使用remove()或者poll()方法移除的必须是队列的头元素。在一个FIFO队列中，所有元素都会被添加到
 * 队列的尾部。其他种类的Queue可能使用不同的放置规则。每个Queue的实现必须指定它的排序规则。
 *
 * offer()方法在可能的情况下添加一个元素，否则返回false。与Collection的add方法不同的是，后者只能通过抛出一个未检查异常
 * 通知客户端添加元素失败。
 *
 *
 * @Author soul goodman
 * @email m18967896507_1@163.com
 * @Date 2019/12/12 18:33
 * @ModifyDate 2019/12/12 18:33
 * @Version 1.0
 */
public interface QueueDemo {



}

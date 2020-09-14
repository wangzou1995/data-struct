package com.yanwentech.queue;

/**
 * @author wangzou1995
 * @Title: null.java
 * @Package com.yanwentech.linkedlist
 * @Description:
 * @date 2020/9/11/ 3:42 下午
 */
public interface Queue<E> {
    void push(E data);

    E pop();

    int size();
}

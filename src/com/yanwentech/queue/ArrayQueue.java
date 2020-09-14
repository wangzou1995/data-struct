package com.yanwentech.queue;

import java.io.UncheckedIOException;

/**
 * @author wangzou1995
 * @Title: null.java
 * @Package com.yanwentech.linkedlist
 * @Description: 队列FIFO （first in first out） 先进先出队列
 * @date 2020/9/11/ 2:24 下午
 */
public class ArrayQueue<E> implements Queue<E> {
    private final Object[] elements;

    private int front;  // 头指针
    private int rear;  // 尾指针

    private static final Integer DEFAULT_SIZE = 8;
    private int size;

    ArrayQueue() {
        this.elements = new Object[DEFAULT_SIZE];
        this.front = 0;
        this.rear = 0;
    }

    @Override
    public void push(E data) {
        if (isFull()) {
            throw new IndexOutOfBoundsException();
        }
        elements[rear] = data;
        rear = (rear + 1) % DEFAULT_SIZE;
    }

    @Override
    public E pop() {
        if (isClear()) {
            throw new NullPointerException();
        }
        E element = (E) elements[this.front];
        elements[this.front] = null;
        this.front = (this.front + 1) % DEFAULT_SIZE;
        return element;
    }

    @Override
    public int size() {
        return (rear - front + DEFAULT_SIZE) % DEFAULT_SIZE;
    }

    public boolean isFull() {
        return (this.rear + 1) % DEFAULT_SIZE == front;
    }

    public boolean isClear() {
        return rear == front;
    }
}

package com.yanwentech.queue;


/**

 * @author wangzou1995
 * @Title: null.java
 * @Package com.yanwentech.queue
 * @Description:
 * @date 2020/9/11/ 3:46 下午
 */
public class LinkedQueue<E> implements Queue<E> {
    private Node<E> front;
    private Node<E> rear;
    private int size;

    LinkedQueue() {
    }

    @Override
    public void push(E data) {
        if (front == null) {
            front = new Node<>(data, null);
            rear = front;
        } else {
            front = new Node<>(data,rear);
        }
        size++;
    }

    @Override
    public E pop() {
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    static class Node<E> {
        E data;
        Node<E> next;

        public Node(E data, Node<E> o) {
            this.data = data;
            next = o;
        }
    }
}

package com.yanwentech.linkedlist;


/**
 * @author wangzou1995
 * @Title: null.java
 * @Package com.yanwentech.linkedlist
 * @Description: 单向链表
 * @date 2020/9/8/ 10:37 上午
 */
public class SingleList<T> {
    private int size;
    private Node head;

    /**
     * 节点信息内部类
     */
    class Node {
        private final T data;
        private Node next;

        Node(T data, Node next) {
            this.next = next;
            this.data = data;
        }

        Node(T data) {
            this.next = null;
            this.data = data;
        }
    }

    /**
     * 添加
     *
     * @param data  元素
     * @param index 下标
     */
    public void add(T data, int index) {
        checkIndex(index);
        if (index == 0) {
            this.head = new Node(data, head);
            this.size++;
            return;
        }
        Node preNode = this.head;
        for (int i = 0; i < index - 1; i++) {
            preNode = preNode.next;
        }
        Node node = new Node(data);
        node.next = preNode.next;
        preNode.next = node;
        this.size++;
    }

    /**
     * 移除
     *
     * @param index 下标
     * @return 元素
     */
    public T remove(int index) {
        checkIndex(index);
        T data;
        if (index == 0) {
            data = head.data;
            head = head.next;
        } else {
            Node node = head;
            for (int i = 0; i < index - 1; i++) {
                node = node.next;
            }
            data = node.next.data;
            node.next = node.next.next;
        }
        this.size--;
        return data;
    }

    /**
     * 移除
     *
     * @param data 元素
     * @return 是否成功
     */
    public boolean remove(T data) {
        if (head == null) {
            throw new NullPointerException();
        }
        if (head.data.equals(data)) {
            head = head.next;
            this.size--;
            return true;
        }
        Node node = head;
        while (node.next != null) {
            if (node.next.data.equals(data)) {
                node.next = node.next.next;
                this.size--;
                return true;
            }
            node = node.next;
        }
        return false;
    }

    /**
     * 添加元素
     *
     * @param data 元素
     */
    public void add(T data) {
        add(data, size);
    }

    /**
     * 获取元素
     *
     * @param index 下标
     * @return 元素
     */
    public T get(int index) {
        checkGetIndex(index);
        if (index == 0) {
            return this.head.data;
        }
        Node preNode = head;
        for (int i = 0; i < index; i++) {
            preNode = preNode.next;
        }
        return preNode.data;
    }

    private void checkIndex(int index) {
        if (index > size || index < 0) {
            throw new IllegalArgumentException("下标异常");
        }
    }
    private void checkGetIndex(int index) {
        if (index >= size || index < 0) {
            throw new IllegalArgumentException("下标异常");
        }
    }

    /**
     * 获取长度
     *
     * @return 长度
     */
    public int size() {
        return size;
    }
}

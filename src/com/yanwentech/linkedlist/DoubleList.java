package com.yanwentech.linkedlist;

/**
 * @author wangzou1995
 * @Title: null.java
 * @Package com.yanwentech.linkedlist
 * @Description: 双向链表
 * @date 2020/9/9/ 2:28 下午
 */
public class DoubleList<T> {
    private int size;
    private Node head;

    class Node {
        private final T data;
        private Node pre;
        private Node next;


        public Node(T data, Node pre, Node next) {
            this.data = data;
            this.pre = pre;
            this.next = next;
        }
    }

    public boolean remove(T data) {
        if (head == null) {
            throw new NullPointerException();
        }
        Node node = head;
        if (head.next == null) {
            if (head.data.equals(data)) {
                head = null;
                size--;
                return true;
            }
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (node.data.equals(data)) {
                node.pre.next = node.next;
                if (node.next != null) {
                    node.next.pre = node.pre;
                }
                size--;
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public void add(T data) {
        add(data, size);
    }

    public void add(T data, int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index 异常");
        }
        if (index == 0) {
            if (head == null) {
                head = new Node(data, null, null);
            } else {
                Node node = new Node(data, null, head);
                this.head.pre = node;
                this.head = node;
            }
            size++;
            return;
        }
        if (index == size) {
            Node node = head;
            while (node.next != null) {
                node = node.next;
            }
            node.next = new Node(data, node, null);
            size++;
            return;
        }
        Node node = head;
        for (int i = 0; i < index - 1; i++) {
            node = node.next;
        }
        Node addNode = new Node(data, node, node.next);
        node.next = addNode;
        node.next.next.pre = addNode;
        this.size++;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index 异常");
        }
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.data;
    }

    public int size() {
        return this.size;
    }
}

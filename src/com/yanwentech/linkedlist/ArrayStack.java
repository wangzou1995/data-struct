package com.yanwentech.linkedlist;

/**
 * @author wangzou1995
 * @Title: null.java
 * @Package com.yanwentech.linkedlist
 * @Description: 栈
 * @date 2020/9/9/ 3:53 下午
 */
public class ArrayStack<T>  {
    private Object[] stack;
    private int size;
    private int top;

    ArrayStack() {
        stack = new Object[10];
    }

    public void push(T data) {
        stack[size++] = data;
    }

    public T pop() {
        T t = peek();
        if (size > 0) {
            stack[--size] = null;
        }
        return (T) stack[size--];
    }

    private T peek() {
        T t = null;
        if (size > 0) t = (T) stack[size - 1];
        return t;
    }

}

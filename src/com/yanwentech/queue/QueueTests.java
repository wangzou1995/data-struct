package com.yanwentech.queue;

/**
 * @author wangzou1995
 * @Title: null.java
 * @Package com.yanwentech.linkedlist
 * @Description:
 * @date 2020/9/11/ 3:25 下午
 */
public class QueueTests {
    public static void main(String[] args) {

        Queue<String> arrayQueue = new ArrayQueue<>();
        arrayQueue.push("s");
        arrayQueue.push("c");
        arrayQueue.push("a");
        arrayQueue.pop();
        arrayQueue.push("b");
        arrayQueue.pop();
        System.out.println(arrayQueue.size());
    }
}

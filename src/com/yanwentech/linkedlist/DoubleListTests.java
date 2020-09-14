package com.yanwentech.linkedlist;

/**
 * @author wangzou1995
 * @Title: null.java
 * @Package com.yanwentech.linkedlist
 * @Description:
 * @date 2020/9/9/ 2:37 下午
 */
public class DoubleListTests {
    public static void main(String[] args) {
        DoubleList<String> doubleList = new DoubleList<>();
        doubleList.add("sss1");
        doubleList.add("sss2");
        doubleList.add("sss3");
        doubleList.add("sss4");
        doubleList.add("sss5");
//        doubleList.add("ssss11", 1);
//        doubleList.add("ssss11", 2);
//        doubleList.add("ssss11", 6);
//        System.out.println(doubleList.remove("ssss11"));
//        System.out.println(doubleList.size());
        System.out.println(doubleList.get(0));
        System.out.println(doubleList.get(1));
        System.out.println(doubleList.get(4));
    }
}

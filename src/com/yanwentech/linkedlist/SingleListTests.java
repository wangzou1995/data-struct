package com.yanwentech.linkedlist;

import java.util.LinkedList;

/**
 * @author wangzou1995
 * @Title: null.java
 * @Package com.yanwentech.linkedlist
 * @Description:
 * @date 2020/9/9/ 10:38 上午
 */
public class SingleListTests {
    public static void main(String[] args) {
        SingleList<String> stringSingleList = new SingleList<>();
        stringSingleList.add("sss1");
        stringSingleList.add("sss2");
        stringSingleList.add("sss3");
        stringSingleList.add("sss4");
        stringSingleList.add("sss5");
        stringSingleList.add("ssss11",5);
        System.out.println(stringSingleList.get(6));
        System.out.println(stringSingleList.size());
    }
}

package com.yanwentech.linkedlist;

import java.util.Queue;

/**
 * @author wangzou1995
 * @Title: null.java
 * @Package com.yanwentech.linkedlist
 * @Description:
 * @date 2020/9/10/ 3:26 下午
 */
public class CalcTests {
    public static void main(String[] args) {
        String s = "19.1*(0-8)*1+ 1.22*(1+2)+1 /3 - 4 ";
        int i = 0 ;
        long start = System.currentTimeMillis();
        while (i< 2) {
            System.out.println(CalcUtils.calcByInfix(s));
            i++;
        }
        System.out.println( (System.currentTimeMillis()-start)/1000.00);
    }
}

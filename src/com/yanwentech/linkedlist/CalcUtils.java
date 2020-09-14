package com.yanwentech.linkedlist;

/**
 * @author wangzou1995
 * @Title: null.java
 * @Package com.yanwentech.linkedlist
 * @Description: 计算工具类
 * @date 2020/9/10/ 3:24 下午
 */
public class CalcUtils {

    public static float calcByInfix(String infix) {
        return RPN.calcSuffix(RPN.parse(infix));
    }
}

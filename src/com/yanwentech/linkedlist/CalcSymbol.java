package com.yanwentech.linkedlist;

/**
 * @author wangzou1995
 * @Title: null.java
 * @Package com.yanwentech.linkedlist
 * @Description:
 * @date 2020/9/9/ 5:12 下午
 */
public enum CalcSymbol {

    ADD("+", 1), DIFF("-", 1), LM("(", 3), RM(")", 3), MULTIPLY("*", 2), EXCEPT("/", 2);
    String key;
    int value;

    CalcSymbol(String s, int i) {
        this.key = s;
        this.value = i;
    }
}

package com.yanwentech.linkedlist;

import java.util.regex.Pattern;

/**
 * @author wangzou1995
 * @Title: null.java
 * @Package com.yanwentech.linkedlist
 * @Description: 规则校验工具类
 * @date 2020/9/10/ 3:19 下午
 */
public class RegexUtils {
    private final static Pattern PATTERN = Pattern.compile("^(-?\\d+)(\\.\\d+)?$");

    public static boolean isRPN(String str) {
        return PATTERN.matcher(str).matches();
    }
}

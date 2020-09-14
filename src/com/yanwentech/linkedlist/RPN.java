package com.yanwentech.linkedlist;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author wangzou1995
 * @Title: null.java
 * @Package com.yanwentech.linkedlist
 * @Description: 逆波兰
 * @date 2020/9/10/ 1:57 下午
 */
public class RPN {
    private final static char[] OP = new char[]{'+', '-', '*', '/', '(', ')'};

    /**
     * 判断是否是操作符
     *
     * @param op 字符
     * @return false ｜ true
     */
    public static boolean isOperator(char op) {
        for (char c : OP) {
            if (op == c) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断是否是操作符
     *
     * @param op 字符
     * @return false ｜ true
     */
    public static boolean isOperator(String op) {
        for (char c : OP) {
            if (op.equals(String.valueOf(c))) {
                return true;
            }
        }
        return false;
    }

    /**
     * 获取操作符的优先级
     *
     * @param op 操作符
     * @return 优先级
     */
    public static int getOperatorPriorityValue(char op) {
        return (String.copyValueOf(OP).indexOf(op)) / 2;
    }

    /**
     * 解析表达式字符串，将中缀表达式转换成后缀表达式(逆波兰表达式)
     * 算法描述：
     * 1、正序遍历表达式中的每一个字符c。
     * 3、判断字符c是否为运算符。
     * (1) 若运算符c之前有可保存的信息则将其作为一个整体保存至output链表。
     * (2) 若运算符c为左括号"("，则直接存入运算符栈。
     * (3) 若运算符c为右括号")"，则依次从运算符栈中弹出运算符并保存至output链表，直到遇到左括号为止。
     * (4) 若运算符c为非括号运算符（即：四则运算符号）。
     * (a) 若运算符栈为空则直接将c压栈至运算符栈。
     * (b) 若运算符栈栈顶的运算符为左括号，则将c直接压栈至运算符栈。
     * (c) 若运算符c的优先级高于运算符栈栈顶的运算符优先级，则将c压栈至运算符栈。
     * (d) 若运算符c的优先级小于或等于运算符栈栈顶的运算符优先级，则依次从运算符栈中弹出运算符并保存至output链表，直到遇到左括号或c的优先级高于栈顶运算符优先级的为止。再将c压栈至运算符栈。
     * 4、当表达式遍历完成后，将尚未保存的非运算符信息作为整体保存至output链表。若运算符栈中尚有运算符时，则依序弹出运算符到output链表。
     *
     * @param infix 中缀表达式
     * @return 后缀链表
     */
    public static List<String> parse(String infix) {
        String temp = infix.replaceAll(" +", "");
        // 判断负数的情况
//        StringBuilder sb = new StringBuilder();


        // 结果输出栈
        List<String> output = new LinkedList<>();
        // 运算符栈
        Stack<Character> operators = new Stack<>();

        // 字符串截取起始位置
        int startPos = 0;
        // 字符串截取末尾位置
        int endPos = 0;

        // 正序遍历表达式中的每一个字符c
        for (char c : temp.toCharArray()) {
            // 字符串截取的结束位置+1
            ++endPos;
            // 判断字符c是否为运算符。
            if (isOperator(c)) {
                // 若运算符c之前有可保存的信息则将其作为一个整体保存至output链表。
                if (startPos < endPos - 1)
                    output.add(temp.substring(startPos, endPos - 1));

                // 更新字符串截取的起始位置
                startPos = endPos;

                // 若运算符c为左括号"("，则直接存入运算符栈。
                if (c == '(') {
                    operators.push(c);

                    // 若运算符c为右括号")"，则依次从运算符栈中弹出运算符并保存至output链表，直到遇到左括号为止。
                } else if (c == ')') {
                    char op;
                    while (!operators.isEmpty() && (op = operators.pop()) != '(') {
                        output.add(String.valueOf(op));
                    }

                    // 若运算符c为非括号运算符（即：四则运算符号）
                } else {

                    // 若运算符栈为空则直接将c压栈至运算符栈。
                    if (operators.isEmpty()) {
                        operators.push(c);

                        // 若运算符栈栈顶的运算符为左括号，则将c直接压栈至运算符栈。
                    } else if (operators.peek() == '(') {
                        operators.push(c);

                        // 若运算符c的优先级高于运算符栈栈顶的运算符优先级，则将c压栈至运算符栈。
                    } else if (getOperatorPriorityValue(c) > getOperatorPriorityValue(operators.peek())) {
                        operators.push(c);

                        // 若运算符c的优先级小于或等于运算符栈栈顶的运算符优先级，则依次从运算符栈中弹出运算符并保存至output链表，直到遇到左括号或c的优先级高于栈顶运算符优先级的为止。再将c压栈至运算符栈。
                    } else {
                        while (!operators.isEmpty() && getOperatorPriorityValue(c) <= getOperatorPriorityValue(operators.peek()) && operators.peek() != '(') {
                            output.add(String.valueOf(operators.pop()));
                        }
                        operators.push(c);
                    }
                }
            }
        }

        // 当表达式遍历完成后，将尚未保存的非运算符信息作为整体保存至output链表。若运算符栈中尚有运算符时，则依序弹出运算符到output链表。
        if (startPos < temp.length()) output.add(temp.substring(startPos));
        while (!operators.isEmpty()) {
            output.add(String.valueOf(operators.pop()));
        }
        return output;
    }

    /**
     * 计算后缀表达式
     *
     * @param suffix 后缀表达式
     * @return 结果
     */
    public static float calcSuffix(List<String> suffix) {
        Stack<BigDecimal> bigDecimals = new Stack<>();
        for (String temp : suffix) {
            if (!isOperator(temp)) {
                bigDecimals.push(BigDecimal.valueOf(Double.parseDouble(temp)));
            } else {
                bigDecimals.push(calcOP(bigDecimals.pop(), bigDecimals.pop(), temp));
            }
        }
        return Float.parseFloat(String.valueOf(bigDecimals.pop()));
    }

    /**
     * 通过四元运算符 运算
     *
     * @param a  a
     * @param b  b
     * @param op op
     * @return BigDecimal
     */
    private static BigDecimal calcOP(BigDecimal a, BigDecimal b, String op) {
        switch (op) {
            case "+":
                return b.add(a);
            case "-":
                return b.subtract(a);
            case "*":
                return b.multiply(a);
            case "/":
                return b.divide(a, 5, RoundingMode.HALF_UP);
            default:
                throw new IllegalArgumentException("不支持 op:" + op);
        }
    }


}

package com.yanwentech.linkedlist;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author wangzou1995
 * @Title: null.java
 * @Package com.yanwentech.linkedlist
 * @Description: 逆波兰算法
 * @date 2020/9/9/ 5:07 下午
 */
public class ReversePoland {

    private final static Map<String, Integer> SYMBOL_MAP = new LinkedHashMap<>(12);

    static {
        SYMBOL_MAP.put("+", 1);
        SYMBOL_MAP.put("-", 1);
        SYMBOL_MAP.put("*", 2);
        SYMBOL_MAP.put("/", 2);
    }

    /**
     * 中缀表达式转换成后缀表达式
     * 1.从左到右扫描中缀表达式
     * 2.若读取的是操作数，则判断操作数类型，并将该操作数存入操作数栈中
     * 3.如读取到的是运算符
     * （1）若运算符为左括号"(" 则直接存入运算符栈中
     * （2）若运算符为右括号")" 则输出运算符栈中的运算符到操作数栈中，直到遇到左括号为止
     * （3）若运算符为非括号运算符：
     * a. 若运算符堆栈栈顶的运算符为括号，则直接存入运算符栈
     * b. 若比运算符栈顶的运算符优先级高或相等，则直接存入运算符栈
     * c. 若比运算符栈顶的运算符优先级低，则输出栈顶运算符到操作数栈，并将当前运算符压入运算符栈中
     * 4. 当表达式读取完成后运算符堆栈尚有运算符时，则依序取出运算符到操作数栈中，直到运算符栈为空
     *
     * @param infixStr 中缀表达式
     * @return 后缀表达式
     */
    public static String infix2Suffix(String infixStr) {
        // 首先是去掉无用的空格
        String temp = infixStr.replaceAll(" +", " ");
        String[] tempArray = temp.split(" ");
        // 初始化符号栈
        Stack<String> symbolStack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (String str : tempArray) {
            if (isNum(str)) {
                sb.append(str).append(" ");
                continue;
            }
            if (str.equals("(")) {
                symbolStack.push(str);
                continue;
            }
            if (str.equals(")")) {
                while (!symbolStack.peek().equals("(")) {
                    sb.append(symbolStack.pop()).append(" ");
                }
                symbolStack.pop();
                continue;
            }
            if (symbolStack.isEmpty() || symbolStack.peek().equals("(")) {
                symbolStack.push(str);
                continue;
            }
            if (SYMBOL_MAP.get(str) < SYMBOL_MAP.get(symbolStack.peek())) {
                sb.append(symbolStack.pop()).append(" ");
            }
            symbolStack.push(str);
        }

        while (!symbolStack.isEmpty()) {
            sb.append(symbolStack.pop()).append(" ");
        }


        // 初始化数字栈

        return sb.toString();
    }

    private static double calcSuffix(String ops) {
        String[] strings = ops.split(",");
        List<String> s = Arrays.asList(strings);
        Stack<Double> numStack = new Stack<>();
        int i = 0;
        while (!s.isEmpty()) {
            String op = s.remove(i);
            System.out.println(op);
            if (isNum(op)) {
                numStack.push(Double.parseDouble(op));
            } else {
                s.add(String.valueOf(calc(numStack.pop(), numStack.pop(), op)));
                StringBuilder stringBuilder = new StringBuilder();
                for (int j = 0 ; j < s.size(); j ++){
                    stringBuilder.append(s.get(i)).append(",");
                }
                calcSuffix(stringBuilder.toString());
            }
            i++;
        }
        return numStack.pop();
    }

    private static double calc(Double a, Double b, String op) {
        switch (op) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "/":
                return a * b;
            case "*":
                return a / b;
            default:
                return 0d;
        }
    }

    private static boolean isNum(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        return isNum.matches();
    }

    public static void main(String[] args) {
        String s = "9 * 8 * 1 + 1 * ( 1 + 2 )";
        System.out.println(s);

        // 9 8 1 * 1 1 2 + * + *
        // 99
        String suffix = infix2Suffix(s);


        System.out.println(suffix);
    }
}

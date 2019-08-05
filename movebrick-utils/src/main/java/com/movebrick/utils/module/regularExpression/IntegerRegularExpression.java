package com.movebrick.utils.module.regularExpression;

import java.util.regex.Pattern;

/**
 * @ClassName IntegerRegularExpression
 * @Author 李嘉伟
 * @Date 2019/8/4 16:56
 * @Version 1.0
 * @Description TODO
 */
public class IntegerRegularExpression {

    public static void main(String[] args) {
        //一位0-9
        System.err.println(Pattern.matches("[0-9]", "1"));
        //无数位0-9
        System.err.println(Pattern.matches("[0-9]*", "0"));

        //n位0-9
        System.err.println(Pattern.matches("[0-9]{3}", "023"));
        //2-3位0-9
        System.err.println(Pattern.matches("[0-9]{2,3}", "023"));
        System.err.println(Pattern.matches("[0-9]{2,3}", "23"));
        //两位 89
        System.err.println(Pattern.matches("[8-9]{2}", "88"));
        //至少两位 89
        System.err.println(Pattern.matches("[8-9]{2,}", "888"));
        //最多两位 89
        System.err.println(Pattern.matches("[8-9]{0,2}", "88"));


        //两位小数
        System.err.println(Pattern.matches("^[1-9][0-9]*.[0-9]{2}$", "10888.10"));


        //三位数字
        System.err.println(Pattern.matches("^\\d{3}$", "333"));

        //负数
        System.err.println(Pattern.matches("^(\\-)?", "-123"));
        //负数带两位小数或者不带
        System.err.println(Pattern.matches("^(\\-)?\\d+(\\.\\d{1,2})?$", "123.00"));

    }
}

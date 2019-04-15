package com.movebrick.datastructure.compute;

/**
 * 题目4：给一个不多于5位的正整数，要求：一、求它是几位数，二、逆序打印出各位数字。
 */
public class No4 {
    public static void main(String[] args) {
        int n = 12345;
        String str = String.valueOf(n);
        for(int i = str.length()-1;i>=0;i--){
            System.out.print(str.charAt(i)+" ");
        }
    }
}

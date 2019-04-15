package com.movebrick.datastructure.compute;

/**
 * 题目1：输入两个正整数m和n，求其最大公约数和最小公倍数。
 * 程序分析：利用辗除法
 */
public class No1 {

    public static void main(String[] args) {

        int a=5,b=6,temp,num1=a,num2=b;
        System.err.println(a+","+b);
        if(a<b){
            temp = b;
            b = a;
            a = temp;
        }
        System.err.println(a+","+b);
        while(b!=0){
            temp=a%b;         //3 6 3       0 3 3      1 3 2    1 2 1
            a=b;              //3 3 3       0 3 3      1 2 3    1 1 1
            b=temp;           //3 3 3       0 3 0      1 2 1    1 1 1
        }
        System.err.println("最大公约数"+a);
        System.err.println("最小公倍数"+num1*num2/a);
        //两个数相乘除以最大公约数得最小公倍数
    }
}

package com.movebrick.datastructure.compute;

import java.util.Scanner;

/**
 * 题目3：一球从h米高度自由落下，每次落地后反跳回原高度的一半；再落下，求它在 第n次落地时，共经过多少米？第n次反弹多高？
 */
public class No3 {
//    public static void main(String[] args) {
//        float hight = 100,reboundNum = hight/2;
//        Scanner sc = new Scanner(System.in);
//        System.err.print("弹跳次数：");
//        int i = sc.nextInt();
//        for(int k = 1;k<=i;k++){
//            //总路程
//            hight += reboundNum*2;
//            //下一次反弹高度
//            reboundNum = reboundNum/2;
//        }
//        System.err.println("第"+i+"次落地，经过路程:"+hight);        //150 75 37.5
//        System.err.println("第"+i+"次反弹，回弹高度:"+reboundNum);   //50 25 12.5
//        /**
//         * i:3
//         * countNum:262.5
//         * reboundNum:12.5
//         */
//    }

    public static void main(String[] args) {
        double sn = 100;// 高度100米
        double hn = sn / 2; //第一次反弹反弹高度
        int i = 0;
        for (i = 2; i <= 1; i++) {
            sn += hn * 2; //第i次落地经过多少米
            hn = hn / 2;//第i次反弹的高度
        }
        System.out.println("第" + (i-1) + "次落地经过" + sn + "米");
        System.out.println("第" + (i-1) + "次反弹" + hn + "米");
    }
}

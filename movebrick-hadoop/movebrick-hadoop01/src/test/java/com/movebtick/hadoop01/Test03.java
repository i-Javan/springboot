package com.movebtick.hadoop01;

import javax.annotation.PostConstruct;

public class Test03 {
    {
        System.err.println("=== Test03:parant代码块 ===");
    }
    static {
        System.err.println("=== Test03:parant静态块 ===");
    }

    public Test03() {
        System.err.println("=== Test03:parant构造函数 ===");
    }

    public static void getParant(){
        System.err.println("=== Test03:getParant ===");
    }

    @PostConstruct
    public void PostConstruct3() {
        System.err.println("=== Test03:PostConstruct ===");
    }
}
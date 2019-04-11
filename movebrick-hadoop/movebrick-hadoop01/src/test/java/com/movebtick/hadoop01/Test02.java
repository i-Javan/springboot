package com.movebtick.hadoop01;

import javax.annotation.PostConstruct;

public class Test02 extends Test03{
    {
        System.err.println("=== parant代码块 ===");
    }
    static {
        System.err.println("=== parant静态块 ===");
    }

    public Test02() {
        System.err.println("=== parant构造函数 ===");
    }

    public static void getParant(){
        System.err.println("=== parant:getParant ===");
    }

    @PostConstruct
    public void PostConstruct1() {
        System.err.println("=== parant:PostConstruct ===");
    }
}

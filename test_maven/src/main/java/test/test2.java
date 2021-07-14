package test;

import static com.google.common.collect.ComparisonChain.start;

public class test2 {

    public static void main(String[] args) {


        System.out.printf("--"+colorEnum.RED);
        ThreadLocal myThreadLocal = new ThreadLocal();
        ThreadLocal myThreadLoca2 = new ThreadLocal();
        new Thread(new Runnable() {
            @Override
            public void run() {
                myThreadLocal.set("hello1");
                System.out.printf("---"+myThreadLocal.get());
                myThreadLoca2.set("1111hello1");
                System.out.printf("---"+myThreadLoca2.get());
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                myThreadLocal.set("hello2");
                System.out.printf("---"+myThreadLocal.get());
                myThreadLoca2.set("2222hello1");
                System.out.printf("---"+myThreadLoca2.get());
            }
        }).start();

    }



}

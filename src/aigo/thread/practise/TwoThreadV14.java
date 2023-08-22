package aigo.thread.practise;

import java.util.concurrent.Exchanger;

/**
 * @Description 创建两个线程，分别大打印a和b，一共打印100次结束,且先打印“a”再打印“b” ababab 无法实现打印顺序
 * 方案6：采用交换器exchanger来处理
 * @Author Administrator
 * @Date 2023/8/8 0:01
 * @Version 1.0.0
 */
public class TwoThreadV14 extends TwoThreadSuper {
    private static Exchanger exchanger = new Exchanger();
    void printOutA() {
        try {
//            String s1 = "b";
//            System.out.println("交换前的s1:" + s1);
//            String ss1 = (String) exchanger.exchange("b");
//            System.out.println("交换后的s1:" + s1);
            System.out.println("ss1:" + (String) exchanger.exchange("b"));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    void printOutB(){
        try {
//            String s2 = "a";
//            System.out.println("交换前的s2:" + s2);
//            String ss2 = (String) exchanger.exchange("a");
//            System.out.println("交换后的s2:" + s2);
            System.out.println("ss2:" +  (String) exchanger.exchange("a"));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        TwoThreadV14 twoThread = new TwoThreadV14();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                twoThread.printOutA();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                twoThread.printOutB();
            }
        });
        t1.start();
        t2.start();
    }
}

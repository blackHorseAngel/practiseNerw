package aigo.thread.practise;

/**
 * @Description 创建两个线程，分别打印a和b，一共打印100次结束,且先打印“a”再打印“b”.ababab
 * TwoThreadV8_3优化版一，单纯使用wait/notify
 * @Author Administrator
 * @Date 2023/8/6 18:17
 * @Version 1.0.0
 */
public class TwoThreadV8_4_SingleThreadWaitAndNotify2 {
    synchronized void printOutA() {
        try {
            for (int i = 0; i < 50; i++) {
                System.out.println("a");
                notify();
                wait();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    synchronized void printOutB() {
        try {
            for (int i = 0; i < 50; i++) {
                wait();
                System.out.println("b");
                notify();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        TwoThreadV8_4_SingleThreadWaitAndNotify2 twoThread = new TwoThreadV8_4_SingleThreadWaitAndNotify2();
        long startTime = System.currentTimeMillis();
        Thread t1 = new Thread(() -> {
            twoThread.printOutA();
        });
        Thread t2 = new Thread(() -> {
            twoThread.printOutB();
        });
        t2.start();
        t1.start();
        long endTime = System.currentTimeMillis();
        System.out.println("总耗时：" + (endTime - startTime));
    }
}

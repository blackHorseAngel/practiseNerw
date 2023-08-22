package aigo.thread.practise;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description 创建两个线程，分别大打印a和b，一共打印100次结束,且先打印“a”再打印“b” 没实现
 * 方案八改进：在方案八的基础上，不使用for循环，使用AtomicInteger原子类进行递增操作
 * @Author Administrator
 * @Date 2023/8/6 5:52
 * @Version 1.0.0
 */
public class TwoThreadV8_2 {
    private volatile boolean flag = false;

    static AtomicInteger atomicInteger = new AtomicInteger(0);

    synchronized void printOutA() {
        try {
            while (flag) {
                wait();
            }
            int a = atomicInteger.incrementAndGet();
            if (a < 100) {
                if (a / 2 != 0) {
                    System.out.println("a");
                }
            }
            flag = true;
            notify();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    synchronized void printOutB() {
        try {
            while (!flag) {
                wait();
            }
            int b = atomicInteger.incrementAndGet();
            if (b < 100) {
                if (b / 2 == 0) {
                    System.out.println("b");
                }
            }
            flag = false;
            notify();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        TwoThreadV8_2 twoThread = new TwoThreadV8_2();
        long startTime = System.currentTimeMillis();
        Thread t1 = new Thread(() -> {
            twoThread.printOutA();
        });
        Thread t2 = new Thread(() -> {
            twoThread.printOutB();
        });
        t1.start();
        t2.start();
        long endTime = System.currentTimeMillis();
        System.out.println("总耗时：" + (endTime - startTime));
    }
}

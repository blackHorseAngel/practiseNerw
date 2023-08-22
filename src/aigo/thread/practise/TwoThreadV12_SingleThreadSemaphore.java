package aigo.thread.practise;

import java.util.concurrent.Semaphore;

/**
 * @Description 创建两个线程，分别大打印a和b，一共打印100次结束,且先打印“a”再打印“b” ababab
 * 发难4：采用信号量semaphore来处理线程间同步
 * @Author Administrator
 * @Date 2023/8/7 21:46
 * @Version 1.0.0
 */
public class TwoThreadV12_SingleThreadSemaphore extends TwoThreadSuper {
    private static Semaphore semaphoreA = new Semaphore(0);
    private static Semaphore semaphoreB = new Semaphore(0);

    @Override
    void printOutA() {
        try {
            for (int i = 0; i < 50; i++) {
//            System.out.println("A有效信号量1：" + semaphoreA.availablePermits());
                System.out.println(Thread.currentThread().getName() + "打印的a" + i);
                semaphoreB.release();
                semaphoreA.acquire();
//            System.out.println("A有效信号量2：" + semaphoreA.availablePermits());
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    void printOutB() {
        try {
            for (int i = 0; i < 50; i++) {
//            System.out.println("B有效信号量1：" + semaphoreB.availablePermits());
                semaphoreB.acquire();
                System.out.println(Thread.currentThread().getName() + "打印的b" + i);
//            System.out.println("B有效信号量2：" + semaphoreB.availablePermits());
                semaphoreA.release();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        TwoThreadV12_SingleThreadSemaphore twoThread = new TwoThreadV12_SingleThreadSemaphore();
        Thread t1 = new Thread(() -> twoThread.printOutA());
        t1.setName("A");
        t1.start();
        Thread t2 = new Thread(() -> twoThread.printOutB());
        t2.setName("B");
        t2.start();
    }
}

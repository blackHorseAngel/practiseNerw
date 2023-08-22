package aigo.thread.practise;

import java.util.concurrent.SynchronousQueue;

/**
 * @Description 创建两个线程，分别大打印a和b，一共打印100次结束,且先打印“a”再打印“b” ababab
 * 方案5：采用同步队列SynchronousQueue解决
 * @Author Administrator
 * @Date 2023/8/7 23:55
 * @Version 1.0.0
 */
public class TwoThreadV13_SingleThreadSynchronousQueue extends TwoThreadSuper {
    private static SynchronousQueue queue = new SynchronousQueue();

    @Override
    void printOutA() {
        try {
            System.out.println("A线程打印的是："+queue.take());
            queue.put("b");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    void printOutB() {
        try {
            queue.put("a");
            System.out.println("B线程打印的是："+queue.take());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        TwoThreadV13_SingleThreadSynchronousQueue twoThread = new TwoThreadV13_SingleThreadSynchronousQueue();
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

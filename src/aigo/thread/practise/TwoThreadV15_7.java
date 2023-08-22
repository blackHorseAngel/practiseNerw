package aigo.thread.practise;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description 创建m个线程t1和n个线程t2，其中t1打印a，t2打印b，实现ababab的交替打印，打印5个A和5个B之后，结束
 * 方案四：采用信号量实现
 * @Author Administrator
 * @Date 2023/8/18 15:27
 * @Version 1.0.0
 */
public class TwoThreadV15_7 extends TwoThreadSuper {
    /**
     * 对于线程A的信号量
     */
    private Semaphore semaphoreA = new Semaphore(1);
    /**
     * 对于线程B的信号量
     */
    private Semaphore semaphoreB = new Semaphore(0);
    /**
     * 线程A的计数器
     */
    private AtomicInteger atomicIntegerA = new AtomicInteger(0);
    /**
     * 线程B的计数器
     */
    private AtomicInteger atomicIntegerB = new AtomicInteger(0);
    /**
     * 要求打印的次数
     */
    public static final int printed = 5;

    @Override
    void printOutA() {
        try {
            while (atomicIntegerA.get() < printed) {
                semaphoreA.acquire();
                if (atomicIntegerA.get() >= printed) {
                    semaphoreA.release();
                    return;
                }
                System.out.println(Thread.currentThread().getName() + "打印的A" + "  atomicIntegerA:" + atomicIntegerA.incrementAndGet());
                semaphoreB.release();
            }
            if (atomicIntegerA.get() >= printed) {
                semaphoreA.release();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    void printOutB() {
        try {
            while (atomicIntegerB.get() < printed) {
                semaphoreB.acquire();
                if (atomicIntegerB.get() >= printed) {
                    semaphoreB.release();
                    return;
                }
                System.out.println(Thread.currentThread().getName() + "打印的B" + "  atomicIntegerB:" + atomicIntegerB.incrementAndGet());
                semaphoreA.release();

            }
            if (atomicIntegerB.get() >= printed) {
                semaphoreB.release();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        TwoThreadV15_7 twoThread = new TwoThreadV15_7();
        int m = 10;
        int n = 20;
        for (int i = 0; i < m; i++) {
            Thread t1 = new Thread(twoThread::printOutA);
            t1.setName("A" + i);
            t1.start();
        }
        for (int i = 0; i < n; i++) {
            Thread t2 = new Thread(twoThread::printOutB);
            t2.setName("B" + i);
            t2.start();
        }
    }
}

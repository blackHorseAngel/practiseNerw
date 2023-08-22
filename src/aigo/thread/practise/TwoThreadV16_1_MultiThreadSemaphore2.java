package aigo.thread.practise;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description m个线程t1，t1打印A，n个线程t2，，t2打印B，一次打印5个A之后再打印5个B，一共打印20个A和20个B
 * 方案一：使用信号量
 * 思路：
 * 1、创建m个线程t1，n个线程t2，信号量A-5个，信号量B-5个，计数器A-countA用来记录打印了多少个A，计数器B-countB用来记录打印了多少个B
 * 2、当启动线程t1的时候，连续打印5个A，信号量A连续获取5个令牌，释放信号量B，然后阻塞
 * 3、同理，当启动线程t2的时候，连续打印5个B，信号量B连续获取5个令牌，释放信号量A，然后阻塞，
 * 4、当countA等于20的时候，停止t1线程，当countB等于20的时候，停止t2线程
 * @Author Administrator
 * @Date 2023/8/14 19:58
 * @Version 1.0.0
 */
public class TwoThreadV16_1_MultiThreadSemaphore2 extends TwoThreadSuper {
    /**
     * 需要打印的次数
     */
    public static final int printed = 20;
    /**
     * 信号量中允许通过的令牌数
     */
    public static final int permission = 5;
    /**
     * 对于打印A方法的线程组的信号量
     */
    private Semaphore semaphoreA = new Semaphore(permission);
    /**
     * 对于打印B方法的线程组的信号量
     */
    private Semaphore semaphoreB = new Semaphore(0);
    /**
     * 对于打印A方法的计数器
     */
    private AtomicInteger atomicIntegerA = new AtomicInteger(0);
    /**
     * 对于打印B方法的计数器
     */
    private AtomicInteger atomicIntegerB = new AtomicInteger(0);

    @Override
    void printOutA() {
        try {
            while (true) {
                semaphoreA.acquire();
                if (atomicIntegerA.get() >= printed) {
                    System.out.println(Thread.currentThread().getName() + "结束了");
                    semaphoreA.release();
                    return;
                }
                System.out.println(Thread.currentThread().getName() + "打印的A");
                int a = atomicIntegerA.incrementAndGet();
                if (a % permission == 0){
                    synchronized (this){
                        semaphoreB.release(permission);
                    }
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    void printOutB() {
        try {
            while (true) {
                semaphoreB.acquire();
                if (atomicIntegerB.get() >= printed) {
                    System.out.println(Thread.currentThread().getName() + "结束了");
                    semaphoreB.release();
                    return;
                }
                System.out.println(Thread.currentThread().getName() + "打印的B");
                int b = atomicIntegerB.incrementAndGet();
                if(b < printed){
                    if (b % permission == 0){
                        synchronized (this){
                            semaphoreA.release(permission);
                        }
                    }
                }else {
                    semaphoreA.release();
                    semaphoreB.release();
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        TwoThreadV16_1_MultiThreadSemaphore2 twoThread = new TwoThreadV16_1_MultiThreadSemaphore2();
        int m = 10;
        int n = 20;
        for (int i = 0; i < m; i++) {
            Thread t1 = new Thread(() -> twoThread.printOutA());
            t1.setName("A" + i);
            t1.start();
        }
        for (int i = 0; i < n; i++) {
            Thread t2 = new Thread(() -> twoThread.printOutB());
            t2.setName("B" + i);
            t2.start();
        }

    }
}

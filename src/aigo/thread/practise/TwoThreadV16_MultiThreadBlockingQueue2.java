package aigo.thread.practise;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description m个线程t1，t1打印A，n个线程t2，，t2打印B，一次打印5个A之后再打印5个B，一共打印20个A和20个B
 * 方案二：使用阻塞队列
 * 思路：
 * 1、创建m个线程t1和n个线程t2，阻塞队列A，阻塞队列B，计数器A用来记录打印了几个A，计数器B用来记录打印了几个B。
 * 2、当启动线程t1的时候，连续打印5个A，然后阻塞，
 * 3、同理，换线程t2，连续打印5个B
 * 4、当计数器A等于20的时候，停止线程t1，当计数器B等于20的时候，停止线程t2.
 * 注意：因为是线程B最后打印结束，所以当线程B打印结束之后，需要往A阻塞队列放入一个A，往B阻塞队列中放入一个B，以至于线程A和线程B可以被唤醒，再在判断退出的条件中，对A和B没退出一个线程，
 * 在其对应的阻塞队列中放入一个A或B，用来唤醒下一个线程，直至所有的线程都结束。
 * @Author Administrator
 * @Date 2023/8/13 21:31
 * @Version 1.0.0
 */
public class TwoThreadV16_MultiThreadBlockingQueue2 extends TwoThreadSuper {
    /**
     * 阻塞队列容量
     */
    public static final int capacity = 5;
    /**
     * 规定的打印次数
     */
    public static final int printed = 20;
    /**
     * 计数器A
     */
    private volatile AtomicInteger atomicIntegerA = new AtomicInteger(0);
    /**
     * 计数器B
     */
    private volatile AtomicInteger atomicIntegerB = new AtomicInteger(0);
    /**
     * 阻塞队列A
     */
    private ArrayBlockingQueue blockingQueueA = new ArrayBlockingQueue(capacity);
    /**
     * 阻塞队列B
     */
    private ArrayBlockingQueue blockingQueueB = new ArrayBlockingQueue(capacity);

    @Override
    void printOutA() {
        try {
            while (true) {
                String aStr = String.valueOf(blockingQueueA.take());
                if (atomicIntegerA.get() >= printed) {
                    System.out.println(Thread.currentThread().getName() + "结束了");
                    blockingQueueA.offer("A");
                    return;
                }
                System.out.println(Thread.currentThread().getName() + "打印的" + aStr);
                int a = atomicIntegerA.incrementAndGet();
                if (a % 5 == 0) {
                    synchronized (this) {
                        for (int i = 0; i < 5; i++) {
                            blockingQueueB.offer("B");
                        }
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
                String bStr = String.valueOf(blockingQueueB.take());
                if (atomicIntegerB.get() >= printed) {
                    System.out.println(Thread.currentThread().getName() + "结束了");
                    blockingQueueB.offer("B");
                    return;
                }
                System.out.println(Thread.currentThread().getName() + "打印的" + bStr);
                int b = atomicIntegerB.incrementAndGet();
                if (b < printed) {
                    if (b % 5 == 0) {
                        synchronized (this) {
                            for (int i = 0; i < 5; i++) {
                                blockingQueueA.offer("A");
                            }
                        }
                    }
                } else {
                    blockingQueueA.offer("A");
                    blockingQueueB.offer("B");
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        TwoThreadV16_MultiThreadBlockingQueue2 twoThread = new TwoThreadV16_MultiThreadBlockingQueue2();
        int m = 10;
        int n = 20;
        for (int i = 0; i < 5; i++) {
            twoThread.blockingQueueA.offer("A");
        }
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

   /* private String sql = null;
    private synchronized String buildSql(){
        if (sql == null){
            sql = "";
        }
    }

    public String getSql(){
        if (sql == null){
            sql = buildSql();
        }
        return  sql;
    }*/
}

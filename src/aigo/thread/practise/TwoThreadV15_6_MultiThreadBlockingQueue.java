package aigo.thread.practise;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description 创建m个线程t1和n个线程t2，其中t1打印a，t2打印b，实现ababab的交替打印，打印5个A和5个B之后，结束
 * 方案三：使用阻塞队列实现控制
 * @Author Administrator
 * @Date 2023/8/18 15:10
 * @Version 1.0.0
 */
public class TwoThreadV15_6_MultiThreadBlockingQueue extends TwoThreadSuper {
    /**
     * 队列容量
     */
    public static final int capacity = 1;
    /**
     * 对于A的阻塞队列
     */
    private ArrayBlockingQueue blockingQueueA = new ArrayBlockingQueue(capacity);
    /**
     * 对于B的阻塞队列
     */
    private ArrayBlockingQueue blockingQueueB = new ArrayBlockingQueue(capacity);
    /**
     * 对于A的计数器
     */
    private AtomicInteger atomicIntegerA = new AtomicInteger(0);
    /**
     * 对于B的计数器
     */
    private AtomicInteger atomicIntegerB = new AtomicInteger(0);
    /**
     * A和B各打印5次后结束
     */
    public static final int printed = 5;


    @Override
    void printOutA() {
        try {
            while (atomicIntegerA.get() < printed) {
                int a = atomicIntegerA.incrementAndGet();
                //TODO
                if(a > printed){
                    return;
                }
                String aStr = String.valueOf(blockingQueueA.take());
                System.out.println(Thread.currentThread().getName() + "打印的" + aStr  + "  atomicIntegerA:" + a);
                blockingQueueB.offer("B");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    void printOutB() {
        try {
            while (atomicIntegerB.get() < printed) {
                int b = atomicIntegerB.incrementAndGet();
                //TODO
                if(b > printed){
                    return;
                }
                String bStr = String.valueOf(blockingQueueB.take());
                System.out.println(Thread.currentThread().getName() + "打印的" + bStr + "  atomicIntegerB:" + b);
                blockingQueueA.offer("A");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
        TwoThreadV15_6_MultiThreadBlockingQueue twoThread = new TwoThreadV15_6_MultiThreadBlockingQueue();
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
        twoThread.blockingQueueA.offer("A");
    }
}

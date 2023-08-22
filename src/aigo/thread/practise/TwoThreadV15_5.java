package aigo.thread.practise;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description 创建m个线程t1和n个线程t2，其中t1打印a，t2打印b，实现ababab的交替打印
 * 方案二：使用lock+condition实现控制
 * @Author Administrator
 * @Date 2023/8/13 18:53
 * @Version 1.0.0
 */
public class TwoThreadV15_5 extends TwoThreadSuper {
    /**
     * printed:==1:打印A，==2：打印B
     */
    private volatile int printed = 1;
    /**
     * 用来记录线程t1的打印次数
     */
    private volatile int countA = 0;
    /**
     * 用来记录线程t2的打印次数
     */
    private volatile int countB = 0;
    /**
     * 打印次数
     */
    public static final int printedTime = 5;
    /**
     * 初始化
     */
    private Lock lock = new ReentrantLock();
    /**
     * 对于t1的条件A，用于等待和唤醒t1
     */
    private Condition conditionA = lock.newCondition();
    /**
     * 对于t2的条件B，用于等待和唤醒t2
     */
    private Condition conditionB = lock.newCondition();

    @Override
    void printOutA() {
        try {
            lock.lock();
            while (countA < printedTime) {
                while (printed != 1) {
                    conditionA.await();
                    if (countA >= printedTime) {
                        return;
                    }
                }
                System.out.print(Thread.currentThread().getName() + "打印A");
                countA++;
                System.out.println("   countA:" + countA);
                printed = 2;
                conditionB.signalAll();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            lock.unlock();
        }
    }
    @Override
    void printOutB() {
        try {
            lock.lock();
            while (countB < printedTime) {
                while (printed != 2) {
                    conditionB.await();
                    if (countA >= printed) {
                        return;
                    }
                }
                System.out.print(Thread.currentThread().getName() + "打印B");
                countB++;
                System.out.println("   countB:" + countB);
                printed = 1;
                conditionA.signalAll();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        TwoThreadV15_5 twoThread = new TwoThreadV15_5();
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

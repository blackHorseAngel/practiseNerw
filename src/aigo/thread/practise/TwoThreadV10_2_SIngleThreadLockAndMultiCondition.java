package aigo.thread.practise;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description 创建两个线程，分别大打印a和b，一共打印100次结束,且先打印“a”再打印“b”.ababab
 * 方案2改进：采用Reentrantlock和condition对象搭配，每个功能对应一个condition对象
 * @Author Administrator
 * @Date 2023/8/7 8:28
 * @Version 1.0.0
 */
public class TwoThreadV10_2_SIngleThreadLockAndMultiCondition extends TwoThreadSuper{
    private Lock lock = new ReentrantLock();
    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();
    //硬币的正面是true，打印A，反面是false，打印B
    private volatile boolean coin = false;
    @Override
    void printOutA() {
        try {
            lock.lock();
            while (coin) {
                conditionA.await();
            }
            System.out.println("a");
            coin = true;
            conditionB.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    @Override
    void printOutB() {
        try {
            lock.lock();
            while (!coin) {
                conditionB.await();
            }
            System.out.println("b");
            coin = false;
            conditionA.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

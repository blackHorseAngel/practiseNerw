package aigo.thread.practise;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description 创建两个线程，分别大打印a和b，一共打印100次结束,且先打印“a”再打印“b”.ababab
 * 方案2：采用Reentrantlock和condition对象搭配
 * @Author Administrator
 * @Date 2023/8/6 7:26
 * @Version 1.0.0
 */
public class TwoThreadV10_SingleThreadLockAndOneCondition extends TwoThreadSuper {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    //硬币的正面是true，打印A，反面是false，打印B
    private volatile boolean coin = false;
    @Override
    void printOutA() {
        try {
            lock.lock();
            while(coin){
                condition.await();
            }
            System.out.println("a");
            coin = true;
            condition.signal();
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
            while(!coin){
                condition.await();
            }
            System.out.println("b");
            coin = false;
            condition.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}

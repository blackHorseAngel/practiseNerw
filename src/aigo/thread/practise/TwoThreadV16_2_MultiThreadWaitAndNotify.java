package aigo.thread.practise;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description m个线程t1，t1打印A，n个线程t2，，t2打印B，一次打印5个A之后再打印5个B，一共打印20个A和20个B
 * 方案三：使用synchronized + notify/wait
 * 思路：1、创建m个线程1和n个线程2，并给它们分别命名为Ai和Bi,创建两个对象objA和objB，线程A都使用A对象，线程B都使用B对象，这两个对象并没有实际的含义；
 * 2、当不同的A线程打印了5个A之后，wait，换B线程打印；
 * 3、当不同的B线程打印了5个B之后，wait，换A线程打印；
 * 4、当A线程打印了20个之后，结束自己；（存在当B结束第20个B的打印的时候，此时需要同时唤醒A线程和B线程去启动结束模块）
 * 5、当B线程打印20个之后，结束自己；
 * @Author Administrator
 * @Date 2023/8/23 0:03
 * @Version 1.0.0
 */
public class TwoThreadV16_2_MultiThreadWaitAndNotify extends TwoThreadSuper {
    /**
     * 线程A的计数器
     */
    private AtomicInteger atomicIntegerA = new AtomicInteger(0);
    /**
     * 线程B的计数器
     */
    private AtomicInteger atomicIntegerB = new AtomicInteger(0);

    /**
     * 打印次数
     */
    public static final int printed = 20;
    /**
     * 每次打印几个切换线程
     */
    public static final int section = 2;
    /**
     * 标识位，当线程A打印为5个A之后，将其改为true，线程B看到true之后开始打印；同理，当线程B打印完5个B之后，将其改成false，线程A看到之后开始打印
     */
    private volatile boolean flag = false;


    @Override
    void printOutA() {
        try {
            int a = 0;
            while (true) {
                synchronized (this) {
                    while (flag) {
                        notifyAll();
                        wait();
                        if (atomicIntegerA.get() >= printed) {
                            System.out.println(Thread.currentThread().getName() + "结束了");
                            notifyAll();
                            return;
                        }
                    }


                    System.out.println(Thread.currentThread().getName() + "打印的A");
                    a = atomicIntegerA.incrementAndGet();
                    if (a % section == 0) {
                        flag = true;
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
            int b = 0;
            while (true) {
                synchronized (this) {
                    while (!flag) {
                        notifyAll();
                        wait();
                        if (atomicIntegerB.get() >= printed) {
                            System.out.println(Thread.currentThread().getName() + "结束了");
                            notifyAll();
                            return;
                        }
                    }


                    System.out.println(Thread.currentThread().getName() + "打印的B");
                    b = atomicIntegerB.incrementAndGet();
                    if (b % section == 0) {
                        flag = false;
                    }
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
        TwoThreadV16_2_MultiThreadWaitAndNotify twoThread = new TwoThreadV16_2_MultiThreadWaitAndNotify();
        int m = 10;
        int n = 20;
//        for (int i = 0; i < m; i++) {
//            Thread t1 = new Thread(() -> twoThread.printOutA());
//            t1.setName("A" + i);
//            t1.start();
//        }
        for (int i = 0; i < n; i++) {
            Thread t2 = new Thread(() -> twoThread.printOutB());
            t2.setName("B" + i);
            t2.start();
        }
        for (int i = 0; i < m; i++) {
            Thread t1 = new Thread(() -> twoThread.printOutA());
            t1.setName("A" + i);
            t1.start();
        }

    }
}

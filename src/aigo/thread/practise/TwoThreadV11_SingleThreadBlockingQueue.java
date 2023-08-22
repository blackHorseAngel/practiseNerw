package aigo.thread.practise;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @Description 创建两个线程，分别大打印a和b，一共打印100次结束,且先打印“a”再打印“b” ababab
 * 方案3：采用LinkedBlockQueue阻塞队列，设计两个队列，队列长度都是1.t1线程对队列1放元素a的同时从队列2取元素b，同理，t2线程对队列2放元素b的同事取元素a
 * @Author Administrator
 * @Date 2023/8/7 6:30
 * @Version 1.0.0
 */
public class TwoThreadV11_SingleThreadBlockingQueue extends TwoThreadSuper{
    /**
     * 阻塞队列的容量
     */
    public static final int capacity = 1;
    /**
     * 对于线程A，阻塞队列A
     */
    private static ArrayBlockingQueue blockingQueueA = new ArrayBlockingQueue(capacity);
    /**
     * 对于线程B，阻塞队列B
     */
    private static ArrayBlockingQueue blockingQueueB = new ArrayBlockingQueue(capacity);
    @Override
    void printOutA() {
        try {
            for (int i = 0; i < 50; i++) {
                System.out.println(Thread.currentThread().getName() + "打印的" + blockingQueueA.take() + ",次数是：" + i);
                blockingQueueB.put("B");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    void printOutB() {
        try {
            for (int i = 0; i < 50; i++) {
                System.out.println(Thread.currentThread().getName() + "打印的" + blockingQueueB.take() + ",次数是：" + i);
                blockingQueueA.put("A");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        TwoThreadV11_SingleThreadBlockingQueue twoThread = new TwoThreadV11_SingleThreadBlockingQueue();
        blockingQueueA.offer("A");
        Thread t1= new Thread(() -> twoThread.printOutA());
        t1.setName("A");
        Thread t2=  new Thread(() -> twoThread.printOutB());
        t2.setName("B");
        t1.start();
        t2.start();
    }

}

package aigo.thread.practise;

/**
 * @Description 创建两个线程，分别大打印a和b，一共打印100次结束,且先打印“a”再打印“b”
 * 方案八：创建两个打印方法并加锁，使用wait/notify来进行线程间通信。创建两个线程，在线程里分别调用方法A和B
 * @Author Administrator
 * @Date 2023/8/5 19:53
 * @Version 1.0.0
 */
public class TwoThreadV8 {
    private volatile boolean flag = false;

    synchronized void printOutA() {
        try {
            while (flag) {
                wait();
            }
            for (int i = 0; i < 50; i++) {
                System.out.println("a");
            }
            flag = true;
            notify();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    synchronized void printOutB() {
        try {
            while (!flag) {
                wait();
            }
            for (int i = 0; i < 50; i++) {
                System.out.println("b");
            }
            flag = false;
            notify();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        TwoThreadV8 twoThread = new TwoThreadV8();
        long startTime = System.currentTimeMillis();
        Thread t1 = new Thread(() -> {
            twoThread.printOutA();
        });
        Thread t2 = new Thread(() -> {
            twoThread.printOutB();
        });
        t1.start();
        t2.start();
        long endTime = System.currentTimeMillis();
        System.out.println("总耗时：" + (endTime - startTime));
    }
}

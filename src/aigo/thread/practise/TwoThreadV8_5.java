package aigo.thread.practise;

/**
 * @Description 创建两个线程，分别大打印a和b，一共打印100次结束,且先打印“a”再打印“b”.ababab
 * 方案1的优化版：解决t1和t2线程的启动问题
 * @Author Administrator
 * @Date 2023/8/6 19:18
 * @Version 1.0.0
 */
public class TwoThreadV8_5 {
    void printOutA() {
        try {
            for (int i = 0; i < 50; i++) {
                System.out.println("a");
                notify();
                wait();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    void printOutB() {
        try {
            for (int i = 0; i < 50; i++) {
                wait();
                System.out.println("b");
                notify();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        TwoThreadV8_5 twoThread = new TwoThreadV8_5();
        long startTime = System.currentTimeMillis();
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(1);
                synchronized (twoThread){
                    twoThread.printOutA();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });
        Thread t2 = new Thread(() -> {
            synchronized (twoThread){
                twoThread.printOutB();
            }
        });
        t1.start();
        t2.start();
        long endTime = System.currentTimeMillis();
        System.out.println("总耗时：" + (endTime - startTime));
    }
}

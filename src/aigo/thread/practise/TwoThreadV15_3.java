package aigo.thread.practise;

/**
 * @Description 创建m个线程t1和n个线程t2，其中t1打印a，t2打印b，实现ababab的交替打印
 * 方案一：synchronized +wait/notifyAll，使用两个volatile变量分别记录次数，连个volatile变量分别记录线程组A和线程组B的状态
 * @Author Administrator
 * @Date 2023/8/10 10:10
 * @Version 1.0.0
 */
public class TwoThreadV15_3 extends TwoThreadSuper {
    /**
     * 当ARunning是true的时候等待，是false的时候打印A
     */
    private volatile boolean ARunning = false;
    /**
     * 当BRunning是true的时候等待，是false的时候打印B
     */
    private volatile boolean BRunning = false;
    /**
     * 记录A的次数
     */
    private volatile int countA = 0;
    /**
     * 记录B的次数
     */
    private volatile int countB = 0;

    @Override
    synchronized void printOutA() {
        if (countA >= 5) {
            return;
        }
        try {
            while (ARunning) {
                this.wait();
                if (countA >= 5) {
                    return;
                }
            }

            System.out.print(Thread.currentThread().getName() + "打印的a");
            countA++;
            System.out.println("    countA:" + countA);
            ARunning = true;
            if (BRunning) {
                BRunning = false;
                notifyAll();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    synchronized void printOutB() {
        try {
            while (BRunning) {
                wait();
                if (countB >= 5) {
                    return;
                }
            }
            System.out.print(Thread.currentThread().getName() + "打印的b");
            countB++;
            System.out.println("    countB:" + countB);
            BRunning = true;
            if (ARunning) {
                ARunning = false;
                notifyAll();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        TwoThreadV15_3 twoThread = new TwoThreadV15_3();
        int m = 10;
        int n = 20;
        int printTime = 5;
        for (int i = 0; i < m; i++) {
            Thread t1 = new Thread(() -> {
                while (twoThread.countA < printTime) {
                    twoThread.printOutA();
                }
            });
            t1.setName("A" + i);
            t1.start();
        }
        for (int i = 0; i < n; i++) {
            Thread t2 = new Thread(() -> {
                while (twoThread.countB < printTime) {
                    twoThread.printOutB();
                }
            });
            t2.setName("b" + i);
            t2.start();
        }
    }
}

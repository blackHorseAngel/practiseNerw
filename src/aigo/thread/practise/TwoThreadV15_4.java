package aigo.thread.practise;

/**
 * @Description 创建m个线程t1和n个线程t2，其中t1打印a，t2打印b，实现ababab的交替打印
 * 方案一的改进版：在V15_3的基础上，使用一个volatile变量实现状态的监控，并且将循环放入具体的方法中，而不是main函数中
 * @Author Administrator
 * @Date 2023/8/13 18:05
 * @Version 1.0.0
 */
public class TwoThreadV15_4 extends TwoThreadSuper {
    /**
     * printed:==1:打印A；==2：打印B
     */
    private volatile int printed = 1;
    /**
     * 记录打印A的次数
     */
    private volatile int countA = 0;
    /**
     * 记录打印B的次数
     */
    private volatile int countB = 0;
    /**
     * 打印次数，常数
     */
    public static final int printedTime = 5;
    @Override
   synchronized void printOutA() {
        try {
            while (countA < printedTime) {
                while (printed == 2) {
                    wait();
                    if (countA >= printedTime) {
                        return;
                    }
                }
                System.out.print(Thread.currentThread().getName() + "打印的a");
                countA++;
                System.out.println("    countA:" + countA);
                printed = 2;
                notifyAll();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
   synchronized void printOutB() {
        try {
            while (countB < printedTime) {
                while (printed == 1) {
                    wait();
                    if (countB >= printedTime) {
                        return;
                    }
                }
                System.out.print(Thread.currentThread().getName() + "打印的b");
                countB++;
                System.out.println("    countB:" + countB);
                printed = 1;
                notifyAll();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        TwoThreadV15_4 twoThread = new TwoThreadV15_4();
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

package aigo.thread.practise;

/**
 * @Description 创建两个线程，分别大打印a和b，一共打印100次结束,且先打印“a”再打印“b”.ababab
 * 方案1的再次优化：彻底解决t1和t2的启动顺序问题
 * @Author Administrator
 * @Date 2023/8/6 19:29
 * @Version 1.0.0
 */
public class TwoThreadV8_6_SingleThreadWaitAndNotify extends TwoThreadSuper {
    private volatile boolean bRunning = false;
    @Override
    synchronized void printOutA() {
        try {
            while (!bRunning){
                wait();
            }
            for (int i = 0; i < 50; i++) {
                System.out.println("a");
                notify();
                wait();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    synchronized void printOutB() {
        try {
            bRunning = true;
            notify();
            for (int i = 0; i < 50; i++) {
                wait();
                System.out.println("b");
                notify();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

package aigo.thread.practise;

/**
 * @Description 创建两个线程，分别大打印a和b，一共打印100次结束,且先打印“a”再打印“b”.ababab
 * 方案1：采用wait/notify + volatile辅助，但是有缺陷，必须t2先启动，原因在于sychronized
 * @Author Administrator
 * @Date 2023/8/6 10:59
 * @Version 1.0.0
 */
public class TwoThreadV8_3_SingleThreadWaitAndNotify extends TwoThreadSuper {

    private volatile boolean flag = false;
    @Override
    synchronized void printOutA() {
        try {
            for (int i = 0; i < 50; i++) {
                if (flag) {
                    wait();
                }
                System.out.println("a");
                flag = true;
                notify();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    synchronized void printOutB() {
        try {
            for (int i = 0; i < 50; i++) {
                if (!flag) {
                    wait();
                }
                System.out.println("b");
                flag = false;
                notify();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

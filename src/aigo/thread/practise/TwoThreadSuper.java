package aigo.thread.practise;

/**
 * @Description 测试类
 * @Author Administrator
 * @Date 2023/8/9 8:03
 * @Version 1.0.0
 */
public class TwoThreadSuper {
    void printOutA() {

    }

    void printOutB() {

    }

    public static void main(String[] args) {
        TwoThreadSuper[] twoThreads = {new TwoThreadV8_3(), new TwoThreadV8_6_SingleThreadWaitAndNotify(), new TwoThreadV10_SingleThreadLockAndOneCondition(), new TwoThreadV10_2_SIngleThreadLockAndMultiCondition(), new TwoThreadV11_SingleThreadBlockingQueue(), new TwoThreadV12_SingleThreadSemaphore(), new TwoThreadV13_SingleThreadSynchronousQueue(), new TwoThreadV14()};
        for (TwoThreadSuper twoThread : twoThreads) {
            try {
                Thread t1 = new Thread(() -> {
                        twoThread.printOutA();
                });
                Thread t2 = new Thread(() -> {
                        twoThread.printOutB();
                });
                t1.start();
                t2.start();

                t1.join();
                t2.join();
                System.out.println(twoThread.getClass().getName() + "对象测试结束");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}

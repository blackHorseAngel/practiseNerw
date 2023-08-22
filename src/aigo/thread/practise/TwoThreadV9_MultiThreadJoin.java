package aigo.thread.practise;

/**
 * @Description 创建线程t1打印a，线程t2打印b，线程t3打印c，实际的打印顺序是 b c a
 * 方案九：
 * @Author Administrator
 * @Date 2023/8/6 5:50
 * @Version 1.0.0
 */
public class TwoThreadV9_MultiThreadJoin {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        Thread t2 = new Thread(() -> {
            System.out.println("b");
        });
        Thread t3 = new Thread(() -> {
            try {
                t2.join();
                System.out.println("c");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });
        Thread t1 = new Thread(() -> {
            try {
                t3.join();
                System.out.println("a");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });
        t1.start();
        t2.start();
        t3.start();
        long endTime = System.currentTimeMillis();
        System.out.println("总耗时：" + (endTime - startTime));
    }
}

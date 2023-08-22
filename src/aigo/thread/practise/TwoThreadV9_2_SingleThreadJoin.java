package aigo.thread.practise;

/**
 * @Description 创建两个线程，分别打印a和b，一共打印100次结束,且先打印“a”再打印“b”
 * 方案十：使用join函数（在某个线程结束之后再运行别的程序）
 * @Author Administrator
 * @Date 2023/8/6 6:28
 * @Version 1.0.0
 */
public class TwoThreadV9_2_SingleThreadJoin extends TwoThreadSuper{

    @Override
    void printOutA(){
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName());
        }
    }

    @Override
    void printOutB() {
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        TwoThreadV9_2_SingleThreadJoin twoThread = new TwoThreadV9_2_SingleThreadJoin();
        Thread t1 = new Thread(() -> {
            twoThread.printOutA();
        });
        t1.setName("A");
        Thread t2 = new Thread(() -> {
            try {
                t1.join();
                twoThread.printOutB();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });
        t2.setName("B");
        t1.start();
        t2.start();
    }
}

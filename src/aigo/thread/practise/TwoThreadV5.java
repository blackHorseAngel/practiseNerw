package aigo.thread.practise;

/**
 * @Description 创建两个线程，分别大打印a和b，一共打印100次结束,且先打印“a”再打印“b”
 * 方案五：创建一个实例对象和两个线程，在每个线程里，实例调用加锁的方法。循环放在方法中，但是不生效
 * @Author Administrator
 * @Date 2023/8/5 19:01
 * @Version 1.0.0
 */
public class TwoThreadV5 {
    synchronized public void printOut() {
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        TwoThreadV5 twoThread1 = new TwoThreadV5();
        Thread t1 = new Thread(() -> twoThread1.printOut());
        t1.setName("a");
        TwoThreadV5 twoThread2 = new TwoThreadV5();
        Thread t2 = new Thread(() -> twoThread2.printOut());
        t2.setName("b");
        long endTime = System.currentTimeMillis();
        System.out.println("总耗时：" + (endTime - startTime));
    }

}

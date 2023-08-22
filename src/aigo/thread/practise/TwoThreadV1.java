package aigo.thread.practise;

/**
 * @Description 创建两个线程，分别大打印a和b，一共打印100次结束,且先打印“a”再打印“b”
 * 方案1：采用线程优先级的方式
 * @Author Administrator
 * @Date 2023/8/5 18:28
 * @Version 1.0.0
 */
public class TwoThreadV1 {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                System.out.println(Thread.currentThread().getName());
            }
        });
        t1.setName("a");
        t1.setPriority(10);
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                System.out.println(Thread.currentThread().getName());
            }
        });
        t2.setName("b");
        t2.setPriority(1);
        t1.start();
        t2.start();
        long endTime = System.currentTimeMillis();
        System.out.println("总耗时：" + (endTime - startTime));
    }
}

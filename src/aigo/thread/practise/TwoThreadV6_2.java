package aigo.thread.practise;

/**
 * @Description 创建两个线程，分别大打印a和b，一共打印100次结束,且先打印“a”再打印“b”
 * 方法六改进：创建静态方法printOut并对其加锁synchronized和两个线程，循环放在静态方法内，再每个线程内部调用该静态方法,
 * @Author Administrator
 * @Date 2023/8/5 19:48
 * @Version 1.0.0
 */
public class TwoThreadV6_2 {
    synchronized public static void printOut() {
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Thread t1 = new Thread(() -> {
            printOut();
        });
        t1.setName("a");
        Thread t2 = new Thread(() -> {
            printOut();
        });
        t2.setName("b");
        t1.start();
        t2.start();
        long endTime = System.currentTimeMillis();
        System.out.println("总耗时：" + (endTime - startTime));
    }
}

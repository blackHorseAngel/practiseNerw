package aigo.thread.practise;

/**
 * @Description 创建两个线程，分别大打印a和b，一共打印100次结束,且先打印“a”再打印“b”
 * 方案七改进：对类进行加锁，创建两个线程和该类的静态方法，循环放在静态方法内，在每个线程内部调用该类的静态方法
 * @Author Administrator
 * @Date 2023/8/5 19:51
 * @Version 1.0.0
 */
public class TwoThreadV7_2 {
    static void printOut(){
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName());
        }
    }
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Thread t1 = new Thread(() -> {
            synchronized (TwoThreadV7_2.class){
                printOut();
            }
        });
        t1.setName("a");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (TwoThreadV7.class){
                    printOut();
                }
            }
        });
        t2.setName("b");
        t1.start();
        t2.start();
        long endTime = System.currentTimeMillis();
        System.out.println("总耗时：" + (endTime - startTime));
    }
}

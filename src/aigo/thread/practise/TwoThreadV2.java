package aigo.thread.practise;

/**
 * @Description 创建两个线程，分别大打印a和b，一共打印100次结束,且先打印“a”再打印“b”
 * 方案二：采用synchronized同步锁,创建两个实例对象，分别调用这个加锁的方法
 * @Author Administrator
 * @Date 2023/8/5 18:34
 * @Version 1.0.0
 */
public class TwoThreadV2 {
    /**
     *
     */
    synchronized public void printOut(){
        System.out.println(Thread.currentThread().getName());
    }
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Thread t1 = new Thread(() -> {
            TwoThreadV2 twoThread1 = new TwoThreadV2();
            for (int i = 0; i < 50; i++) {
                twoThread1.printOut();
            }
        });
        t1.setName("a");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                TwoThreadV2 twoThread2 = new TwoThreadV2();
                for (int i = 0; i < 50; i++) {
                    twoThread2.printOut();
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

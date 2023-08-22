package aigo.thread.practise;

/**
 * @Description 创建两个线程，分别大打印a和b，一共打印100次结束,且先打印“a”再打印“b”
 * 方案三：创建一个实例对象，分别创建两个线程，用此对象实例在两个线程里分别调用
 * @Author Administrator
 * @Date 2023/8/5 18:44
 * @Version 1.0.0
 */
public class TwoThreadV3 {
    synchronized public void printOut(){
        System.out.println(Thread.currentThread().getName());
    }
    public static void main(String[] args) {
        TwoThreadV3 twoThread = new TwoThreadV3();
        long startTime = System.currentTimeMillis();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                twoThread.printOut();
            }
        });
        t1.setName("a");
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                twoThread.printOut();
            }
        });
        t2.setName("b");
        t1.start();
        t2.start();
        long endTime = System.currentTimeMillis();
        System.out.println("总耗时：" + (endTime - startTime));
    }
}

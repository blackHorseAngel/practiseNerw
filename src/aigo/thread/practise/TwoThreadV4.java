package aigo.thread.practise;

/**
 * @Description 创建两个线程，分别大打印a和b，一共打印100次结束,且先打印“a”再打印“b”
 * 方案四：创建一个实例对象和两个线程，在每个线程里，实例调用方法的时候，加锁synchronized(this)，
 * @Author Administrator
 * @Date 2023/8/5 18:57
 * @Version 1.0.0
 */
public class TwoThreadV4 {
   public void printOut(){
        System.out.println(Thread.currentThread().getName());
    }
    public static void main(String[] args) {
       long startTime = System.currentTimeMillis();
       TwoThreadV4 twoThread = new TwoThreadV4();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (this){
                    for (int i = 0; i < 50; i++) {
                        twoThread.printOut();
                    }
                }
            }
        });
        t1.setName("a");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (this){
                    for (int i = 0; i < 50; i++) {
                        twoThread.printOut();
                    }
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

package aigo;

import static aigo.util.Print.printArray;

/**
 *@Desprition
 * 插入排序算法：每次取数组中的上一轮拍完序的元素的下一个作为本轮将要插入的元素，将该元素与排好序的元素做比较。
 * 第一次排序的时候取第一个元素，因为没有比较，所以不需要排序，默认是第一个元素即可。
 *@author zhangshenming
 *@date 2021-8-18 9:20
 *@Version 1.0
 */
public class InsertSort {
    /**
     *@Description 原始版本的插入排序
     *@Author zhangshenming
     *@Param array
     *@Date 2021/9/18 21:59
     *@Return void
     */
    public static void insert1(int[]array) {
        int temp = 0;
        for (int i = 0; i <= array.length - 1; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    printArray(array);
                }
            }
        }
    }
    /**
     *@Description 插入排序优化：优化第二轮循环：将判断条件放在for循环中，交换两个数使用异或运算
     *@Author zhangshenming
     *@Param array
     *@Date 2021/10/5 9:09
     *@Return void
     */
    public static void insert2(int[]array){
        for(int i = 0;i <= array.length - 1;i++){
          for(int j = i - 1;j >= 0 && array[j]>array[j + 1];j--){
              array[j] = array[j]^array[j+1];
              array[j+1] = array[j]^array[j+1];
              array[j] = array[j]^array[j+1];
          }
        }
    }
    /**
     *@Description 插入排序优化：使用二分法
     *@Author zhangshenming
     *@Param array
     *@Date 2021/9/18 22:01
     *@Return void
     */
    public static void insert3(int[]array) {


    }
    public static void main(String[] args) {
//        int[] array = initArray(10);
//        printArray(array);
//        long startTime1 = System.currentTimeMillis();
//        System.out.println("插入排序1的开始时间："+startTime1);

//        insert1(array);
//        long endTime1 = System.currentTimeMillis();
//        System.out.println("插入排序1的结束时间："+endTime1);
//        System.out.println("插入排序1耗时："+(endTime1-startTime1));
//        long startTime2 = System.currentTimeMillis();
//        System.out.println("插入排序1的开始时间："+startTime2);
//        int[]array = {8,1,4,9,6,3,5};
//        insert2(array);
//        long endTime2 = System.currentTimeMillis();
//        System.out.println("插入排序1的结束时间："+endTime2);
//        System.out.println("插入排序1耗时："+(endTime2-startTime2));
    }

}

package aigo;

import static aigo.util.Init.initArray;
import static aigo.util.Print.printArray;

/**
 *@Desprition 冒泡算法：每次内层循环找出数组中最大的数放到最后面，外层循环每次找一个数。
 * 优化：1、内层循环的优化：每次内层循环比上一次少1；2、如果内层循环已经排好序了，那么后面的外层循环就不用再循环了；
 *@Author zhangshenming
 *@Date 2021/8/18 21:12
 *@Version 1.0
 */
public class BubbleSort {
    /**
     *@Description 原始版冒泡排序没有任何优化
     *@Author zhangshenming
     *@Param array
     *@Date 2021/9/18 18:01
     *@Return void
     */
    public static void bubble0(int[]array){
        int temp = 0;
        for (int i = 0;i < array.length;i++){
            for(int j = 0;j < array.length-1;j++){
                if(array[j] >= array[j+1]){
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    printArray(array);
                }
            }
        }
        printArray(array);
    }
    /**
     *@Description 冒泡排序算法优化1
     *@Author zhangshenming
     *@Param
     *@Date 2021/9/18 17:51
     *@Return void
     */
    public static void bubble1(int[]array){
        int temp = 0;
        for (int i = 0;i < array.length;i++){
            for(int j = 0;j < array.length-1-i;j++){
                if(array[j] >= array[j+1]){
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    printArray(array);
                }
            }
        }
    }
    /**
     *@Description 冒泡排序算法优化2
     *@Author zhangshenming
     *@Param array
     *@Date 2021/9/18 17:56
     *@Return void
     */
    public static void bubble2(int[]array){
        int temp = 0;
        boolean flag;
        for (int i = 0;i < array.length;i++){
            flag = true;
            for(int j = 0;j < array.length-1-i;j++){
                if(array[j] >= array[j+1]){
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    flag = false;
                    printArray(array);
                }
            }
            if(flag){
                break;
            }
        }
        printArray(array);
    }
    public static void main(String[] args) {
        int[]array = initArray(10);
        printArray(array);
        long startTime0 = System.currentTimeMillis();
        System.out.println("冒泡排序开始时间0："+startTime0);
        bubble0(array);
        long endTime0 = System.currentTimeMillis();
        System.out.println("冒泡排序结束时间0："+endTime0);
        System.out.println("冒泡排序0耗时："+(endTime0-startTime0));
        long startTime1 =  System.currentTimeMillis();
        System.out.println("冒泡排序开始时间1："+startTime1);
//        int[]array = {1,7,4,6,9,2};
        bubble1(array);
        long endTime1 = System.currentTimeMillis();
        System.out.println("冒泡排序结束时间1："+endTime1);
        System.out.println("冒泡排序1耗时："+(endTime1-startTime1));
        long startTime2 = System.currentTimeMillis();
        System.out.println("冒泡排序开始时间2："+startTime2);
        bubble2(array);
        long endTime2 = System.currentTimeMillis();
        System.out.println("冒泡排序结束时间2："+endTime2);
        System.out.println("冒泡排序2耗时："+(endTime2-startTime2));
    }
}

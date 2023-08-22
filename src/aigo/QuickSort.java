package aigo;

import static aigo.util.Print.printArray;

/**
 *@Desprition 快速排序：给定两个整形变量i,j，其中i为数组中第一个元素的位置s，j为数组中最后一个元素的位置t
 * 1、反复执行i+1给i，直到满足array[s]<=arr[i]或者i=t;然后反复执行j-1给j,知道满足array[s]>=array[j]或者j=s
 * 2、若i<j,将array[i]与array[j]交换位置，重复1；
 * 3、若i>=j,将array[s]与array[j]交换位置，分别对array[0~j-1]和array[j+1~t]执行1,2过程，直到整个数组排出顺序
 *@Author zhangshenming
 *@Date 2021/8/18 18:24
 *@Version 1.0
 */
public class QuickSort {
    public static void main(String[] args) {
//        int[]array = initArray(10);
        int[]array = {27,1,44,12,37,15,22,4,43,20};
        printArray(array);
        quick(array,0,array.length-1);
        printArray(array);
    }
    /**
     *@Description 交换两个值
     *@Author zhangshenming
     *@Param m, n
     *@Date 2021/8/18 19:41
     *@Return void
     */
    private static void swap(int m, int n) {
        int temp = m;
        m = n;
        n = temp;
    }
    /**
     *@Description  快速排序第一轮排序过程
     *@Author zhangshenming
     *@Param array, s, t
     *@Date 2021/8/18 19:42
     *@Return void
     */
    public static void quick(int[]array,int s,int t){
        if(s>=t){
            System.out.println("不符合规则");
            return;
        }
        int i = s;
        int j = t;
        while(true){
            while (!(array[s]<=array[i]||i==t)){
                i++;
            }
            while(!(array[s]>=array[j]||j==s)){
                j--;
            }
            if(i<j){
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }else{
                break;
            }
        }
        if(i>=j){
            int temp = array[s];
            array[s] = array[j];
            array[j] = temp;
            quick(array,s,j-1);
            quick(array,j+1,t);
        }
    }
}

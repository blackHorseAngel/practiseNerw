package Aigo.HollandFlag;

import static Aigo.util.Print.printArray;

/**
 *@Desprition 给定一个数组，将其中的数字按照小于或大于某个给定数字（该数字不在数组中）进行分成两个区域。
 *@Author zhangshenming
 *@Date 2021/11/23 20:17
 *@Version 1.0
 */
public class HollandFlag1 extends HollandFlagSuper {
    public  int[] handle(int[]array,int target){
        int start = 0;
        int end = array.length - 1;
        int temp = 0;
        while(start < end){
            //从左边开始找到第一个大于target的数
            while((start < end) && (array[start] < target)){
                start++;
            }
            //从右边开始找到第一个小于target的数
            while((start < end) && (array[end] > target)){
                end--;
            }
            //分别将左边大于target的数和右边小于target的数依次做交换
            if((array[start] > target) && (array[end] < target)){
                temp = array[start];
                array[start] = array[end];
                array[end] = temp;
                start++;
                end--;
            }
        }
        return array;
    }
    public static void main(String[] args) {
        HollandFlag1 hollandFlag1 = new HollandFlag1();
//        int[]array = {1,9,4,7,8,3,2,5};
        int[]array = {1,8,2,8,3,8,5,9};
        int target = 6;
        int[]result = hollandFlag1.handle(array,target);
       printArray(result);
    }
}

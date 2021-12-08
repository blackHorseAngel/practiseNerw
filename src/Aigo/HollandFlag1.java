package Aigo;

/**
 *@Desprition 给定一个数组，将其中的数字按照小于或大于某个给定数字（该数字不在数组中）进行分成两个区域。
 *@Author zhangshenming
 *@Date 2021/11/23 20:17
 *@Version 1.0
 */
public class HollandFlag1 {
    public static int[] handle(int[]array,int target){
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
//        int[]array = {1,9,4,7,8,3,2,5};
        int[]array = {1,8,2,8,3,8,5,9};
        /*int[][]array = new int[5][];
        int[][]
        for(int i = 0;i < array.length-1;i++){
            for(int j = 0;j < i;j++){

            }
        }*/
        int[]arr = handle(array,6);
        for(int i:arr){
            System.out.println(i);
        }
    }
}

package Aigo.HollandFlag;

import static Aigo.util.Print.printArray;

/**
 *@Desprition 给定一个数组，将这个数组按照大于等于小于某个数的划分成三块区域，不需要保证数字的有序性
 *@Author zhangshenming
 *@Date 2021/11/23 20:40
 *@Version 1.0
 */
public class HollandFlag2 extends HollandFlagSuper{
    /**
     *@Description
     *@Author zhangshenming
     *@Param array, target
     *@Date 2021/11/23 21:21
     *@Return int[]
     */
    public int[]handle(int[]array,int target){
        int left = 0;
        int right = array.length - 1;
        int temp = 0;
        while(left < right){
            //从左边开始找出第一个大于target的数
            while((left < right) && (array[left] <= target)){
                left++;
            }
            //从右边开始找出第一个小于target的数
            while((left < right) && (array[right] >= target)){
                right--;
            }
            //分别将左边大于target的数和右边小于target的数依次做交换
            if((array[left] > target) && (array[right] < target)){
                temp = array[left];
                array[left] = array[right];
                array[right] = temp;
                left++;
                right--;
            }
        }
        int middle = left - 1;
        int middle2 = left;
        left = 0;
        //从左边到中间（上面循环中的left等于right的值）找出等于targer的值，并依次交换到中间
        while (left < middle){
            if(array[left] == target){
                if(array[middle] != target){
                    temp = array[left];
                    array[left] = array[middle];
                    array[middle] = temp;
                    left++;
                    middle--;
                }else{
                    middle--;
                }
            }else{
                left++;
            }
        }
        right = array.length-1;
        //从中间（上面循环中的left等于right的值）到右边找出等于targer的值，并依次交换到中间
        while (middle2 < right){
            if(array[right] == target){
                if(array[middle2] != target){
                    temp = array[right];
                    array[right] = array[middle2];
                    array[middle2] = temp;
                    middle2++;
                    right--;
                }else{
                    middle2++;
                }
            }else{
                right--;
            }
        }
        return array;
    }
    public static void main(String[] args) {
        HollandFlag2 hollandFlag2 = new HollandFlag2();
        int[]array = {1,5,4,8,2,9,1,7,5,5};
        int target = 5;
        int[]result =hollandFlag2.handle(array,target);
        printArray(result);
    }
}

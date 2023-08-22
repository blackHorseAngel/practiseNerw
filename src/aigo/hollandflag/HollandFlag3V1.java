package aigo.hollandflag;

import static aigo.util.Print.printArray;

/**
 *@Desprition 给定一个数组，将这个数组按照大于等于小于某个数的划分成三块区域，切保证这三块区域中的数字的有序性
 *@Author zhangshenming
 *@Date 2021/10/27 11:04
 *@Version 1.0
 */
public class HollandFlag3V1 extends HollandFlagSuper {

    /**
     *@Description
     *@Author zhangshenming
     *@Param array
     *@Date 2021/10/27 11:04
     *@Return int[]
     */
    public int[]handle(int[]array,int target){
        //创建该数组的左指针
        int left = 0;
        //创建该数组的右指针
        int right = array.length - 1;
        int temp1 = 0;
        while (left <= right){
            //从左边开始，找到第一个比target大的数
            while((left <= right) && (array[left] <= target)){
                left++;
            }
            //从右边开始，找到第一个比target小的数
            while((left <= right) && (array[right] >= target)){
                right--;
            }
            //将左边比target大的数和右边比target小的数依次做交换
            if((array[left] > target) && (array[right] < target)){
                temp1 = array[left];
                array[left] = array[right];
                array[right] = temp1;
                left++;
                right--;
            }
        }
        int middle = left;
        //从左边到中间（上面循环中left=right的值）遍历，把左边等于target的数字换到中间
        for(int i = 0;i < middle; i++){
            if(array[i] == target){
                for(int j = middle-1;j > i;j--){
                    if(array[j] < target){
                        temp1 = array[i];
                        array[i] = array[j];
                        array[j] = temp1;
                        break;
                    }
                }
            }
        }
        //从右边到中间，把右边等于target的数换到中间
        for(int k = array.length-1;k >= middle;k--){
            if(array[k] == target){
               for(int m = middle;m < k;m++){
                   if (array[m] > target){
                       temp1 = array[m];
                       array[m] = array[k];
                       array[k] = temp1;
                       break;
                   }
               }
            }
        }
        return array;
    }
    public static void main(String[] args) {
        HollandFlag3V1 hollandFlag3V1 = new HollandFlag3V1();
        // int[]array = {5,1,2,3,8,7,4,5,4,7,8,3,2,1,5};
        int[]array = {1, 5 , 6};
        int target = 5;
        int[]result = hollandFlag3V1.handle(array,target);
        printArray(result);
    }
}

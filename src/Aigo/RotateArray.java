package Aigo;

import static Aigo.util.Init.initArray;
import static Aigo.util.Print.printArray;

/**
 *@Desprition https://leetcode-cn.com/problems/rotate-array/
 * 给定一个数组，将数组中的元素向右移动k个位置，其中k是非负数。
 *@Author zhangshenming
 *@Date 2021/8/30 19:52
 *@Version 1.0
 */
public class RotateArray {
    /**
     *@Description 对数组进行移动位置操作，一次移动一个位置移动K次
     *@Author zhangshenming
     *@Param nums, k
     *@Date 2021/8/30 19:54
     *@Return void
     */
    public static void rotate1(int[] nums, int k) {
        int a = 0;
            for(int i = 1;i <= k;i++){
                a = nums[nums.length-1];
                for(int j = nums.length-1;j >= 0;j--){
                    if(j==0){
                        nums[j] = a;
                    }else{
                        nums[j] = nums[j-1];
                    }
                }
        }
    }
    /**
     *@Description 对数组进行移动位置操作，一次移动K个位置移动一次
     *@Author zhangshenming
     *@Param nums, k
     *@Date 2021/8/31 12:24
     *@Return void
     */
    public static void rotate2(int[]nums,int k){
        int length = nums.length;
        if(length == 0 || k == 0){
            System.out.println("数组长度为0或k为0不需要移动");
            return;
        }
        if(k > length){
            k = k%length;
        }
        int a = 0;
        int b = 0;
        if(length % k == 0){
            for(int i = 0;i < length;i++){
                a = (i+k)%length;
                if(a == i){

                }
            }
        }else{
            for(int i = 0;i < length;i++){
                a = (i+k)%length;
                b = nums[a];
                nums[a] = nums[i];
                nums[i] = b;
            }
        }
        printArray(nums);
    }
    /**
     *@Description 借助额外的数组，将原来数组移动完之后放入新数组
     *@Author zhangshenming
     *@Param nums, k
     *@Date 2021/9/4 19:47
     *@Return void
     */
    public static void rotate3(int[]nums,int k){
        int length = nums.length;
        if(nums.length == 0 || nums.length==1 || k == 0){
            return;
        }
        int[]arr = new int[length];
        for(int i = 0;i < length;i++){
            arr[(i+k)%length] = nums[i];
        }
        printArray(arr);
    }
    /**
     *@Description 给定数组nums从第K个位置切分拆成前后两个数组并将前后两个数组对调
     *@Author zhangshenming
     *@Param nums, k
     *@Date 2021/9/6 0:01
     *@Return void
     */
    public static void rotate4(int[]nums,int k){
        k %= nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
        printArray(nums);
    }
    /**
     *@Description 反转数组
     *@Author zhangshenming
     *@Param nums, left, right
     *@Date 2021/10/6 10:04
     *@Return void
     */
    private static void reverse(int[] nums, int left, int right) {
        int temp = 0;
        while(left < right){
            temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
//        int[]array = initArray(5);
//        printArray(array);
        int[]array1 = {1,2,3,4,5,6,7};
        int[]array2 = {-1,-100,3,99};
        int[]array3 = {1,2,3};
//        rotate1(array1,3);
//        rotate1(array2,2);
//        rotate1(array3,2);
//        rotate3(array1,3);
//        rotate3(array2,2);
//        rotate3(array3,2);
//        rotate4(array1,3);
//        rotate4(array2,2);
        rotate4(array3,2);
    }
}

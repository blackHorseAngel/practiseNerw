package Aigo;

import java.util.Arrays;

/**
 *@Desprition https://leetcode-cn.com/problems/squares-of-a-sorted-array/
 * 给你一个按非递减顺序排序的整数数组nums，返回每个数字的平方组成的新数组,要求也按非递减顺序排序。
 *@Author zhangshenming
 *@Date 2021/8/30 19:44
 *@Version 1.0
 */
public class SortedSquareArray {
    /**
     *@Description 排序平方后的数组中的元素，方法一直接求解
     *@Author zhangshenming
     *@Param nums
     *@Date 2021/8/30 19:48
     *@Return int[]
     */
    public static int[]sortedSquaresOld(int[]nums){
        int[]arr = new int[nums.length];
        for(int i = 0;i < nums.length;i++){
            arr[i] = nums[i] * nums[i];
        }
        Arrays.sort(arr);
        return arr;
    }
    /**
     *@Description 排序平方后的数组中的元素，方法二采用双指针，即前后指针，用来遍历数组
     *@Author zhangshenming
     *@Param nums
     *@Date 2021/8/30 19:44
     *@Return int[]
     */
    public static int[] sortedSquaresNew(int[] nums) {
        int[]arr = new int[nums.length];
        for(int i = 0,j = nums.length-1,pos = nums.length-1;i <= j;pos--){
            if(nums[i]*nums[i] > nums[j]*nums[j]){
                arr[pos] = nums[i] * nums[i];
                i++;
            }else{
                arr[pos] = nums[j] * nums[j];
                j--;
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        int[]nums = {-4,-1,0,3,10};
        int[]arr = sortedSquaresNew(nums);
        for(int i:arr){
            System.out.println("排序后的数组中的元素是："+i);
        }
    }
}

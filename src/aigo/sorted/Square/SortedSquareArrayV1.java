package aigo.sorted.Square;

import java.util.Arrays;

import static aigo.util.Print.printArray;

/**
 *@Desprition https://leetcode-cn.com/problems/squares-of-a-sorted-array/
 * 给你一个按非递减顺序排序的整数数组nums，返回每个数字的平方组成的新数组,要求也按非递减顺序排序。
 *@Author zhangshenming
 *@Date 2021/8/30 19:44
 *@Version 1.0
 */
public class SortedSquareArrayV1 extends SortedSquareArraySuper {
    /**
     *@Description 排序平方后的数组中的元素，方法一直接求解
     *@Author zhangshenming
     *@Param nums
     *@Date 2021/8/30 19:48
     *@Return int[]
     */
    public int[]sortedSquares(int[]nums){
        int[]arr = new int[nums.length];
        for(int i = 0 ; i < nums.length ; i++){
            arr[i] = nums[i] * nums[i];
        }
        Arrays.sort(arr);
        return arr;
    }
    public static void main(String[] args) {
        int[]nums = {-4,-1,0,3,10};
        SortedSquareArrayV1 sortedSquareArrayV1 = new SortedSquareArrayV1();
        int[]result = sortedSquareArrayV1.sortedSquares(nums);
        printArray(result);
    }
}

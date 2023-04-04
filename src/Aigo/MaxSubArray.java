package Aigo;

/**
 * @Description https://leetcode.cn/problems/maximum-subarray/?envType=study-plan&id=shu-ju-jie-gou-ru-men&plan=data-structures&plan_progress=jfjr95m
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组 是数组中的一个连续部分。
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * 输入：nums = [1]
 * 输出：1
 * 输入：nums = [5,4,-1,7,8]
 * 输出：23
 * 思路：动态规划的是首先对数组进行遍历，当前最大连续子序列和为 sum，结果为 ans
 * 如果 sum > 0，则说明 sum 对结果有增益效果，则 sum 保留并加上当前遍历数字
 * 如果 sum <= 0，则说明 sum 对结果无增益效果，需要舍弃，则 sum 直接更新为当前遍历数字
 * 每次比较 sum 和 ans的大小，将最大值置为ans，遍历结束返回结果
 * 时间复杂度：O(n)
 * @Author Administrator
 * @Date 2023/2/22 20:03
 * @Version 1.0.0
 */
public class MaxSubArray {
    //动态规划
    public static int maxSubArray(int[] nums) {
       int[]dp = new int[nums.length];
       dp[0] = nums[0];
       int max = nums[0];
       for(int i = 1 ; i < nums.length ; i++){
           dp[i] = Math.max(dp[i-1] + nums[i],nums[i]);
           if(max < dp[i]){
               max = dp[i];
           }
       }
       return max;
    }

    public static int maxSubArray2(int[]nums){
        int[][]matrix = matrix(nums);
        int max = 0;
        for(int i = 0 ; i < matrix.length ; i++){
            for(int j = i ; j < matrix.length ; j++){
                max = Math.max(max,matrix[i][j]);
            }
        }
        return max;
    }

    public static int[][]matrix(int[]nums){
        int[][]matrix = new int[nums.length][nums.length];
        for (int i = 0 ; i < nums.length ; i++){
            int sum = 0;
            for (int j = i ; j < nums.length ; j++){
               sum += nums[j];
               matrix[i][j] = sum;
               }
            }
        return matrix;
    }
    public static void main(String[] args) {
//        int[]array0 = {4,-1,2,1};
//        int max0 = maxSubArray(array0);
//        System.out.println(max0);
//        int[]array1 = {-2,1,-3,4,-1,2,1,-5,4};
//        int max1 = maxSubArray(array1);
//        int max1 = maxSubArray2(array1);
//        System.out.println(max1);
//        int[]array2 = {5,4,-1,7,8};
//        int max2 = maxSubArray(array2);
//        int max2 = maxSubArray2(array2);
//        System.out.println(max2);
        int[]nums = {-1};
        int max3 = maxSubArray2(nums);
        System.out.println(max3);
    }
}

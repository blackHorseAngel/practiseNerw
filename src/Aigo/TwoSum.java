package Aigo;

import java.util.*;

/**
 * @Description https://leetcode.cn/problems/two-sum/?envType=study-plan&id=shu-ju-jie-gou-ru-men&plan=data-structures&plan_progress=jfjr95m
 * 给定一个整数数组 nums一个整数目标值 target，请你在该数组中找出 和为目标值 target的那两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 * @Author Administrator
 * @Date 2023/2/23 14:33
 * @Version 1.0.0
 */
public class TwoSum {
    //数组遍历,双向指针
    public static int[] twoSum(int[] nums, int target) {
        int[]index = new int[2];
        int temp = 0;
        for(int i = 0 ; i < nums.length; i++){
            for(int j = nums.length - 1 ; j > 0 ; j--){
                temp = nums[i] + nums[j];
                if(temp == target && i != j){
                   index[0] = i;
                   index[1] = j;
                }
            }
        }
        return index;
    }
    //map中的containsKey方法特性
    public static int[]twoSum2(int[]nums,int target){
        int[]index = new int[2];
        int key = 0;
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int i : nums){
            key = target - nums[i];
            if(map.containsKey(key)){
                index[0] = i;
                index[1] = map.get(key);
            }else{
                map.put(nums[i],i);
            }
        }
        return index;
    }
    //数组遍历，同向双指针，快慢指针
    public static int[]twoSum3(int[]nums,int target){
        int[]index = new int[2];
        for(int i = 0 ; i < nums.length ; i++){
            for(int j = i + 1 ; j < nums.length ; j++){
                if(nums[i] + nums[j] == target){
                    index[0] = i;
                    index[1] = j;
                }
            }
        }
        return index;
    }
    public static void main(String[] args) {
//        int[]nums0 = {2,7,11,15};
//        int[]array0 = twoSum(nums0,9);
//        int[]nums1 = {3,3};
//        int[]array1 = twoSum(nums1,6);
        int[]nums2 = {3,2,4};
        int[]array2 = twoSum2(nums2,6);
        for(int i : array2){
            System.out.println(i);
        }
    }
}

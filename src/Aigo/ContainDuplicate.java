package Aigo;

import java.util.*;

/**
 * @Description https://leetcode.cn/problems/contains-duplicate/?envType=study-plan&id=shu-ju-jie-gou-ru-men&plan=data-structures&plan_progress=jfjr95m
 * 给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
 * 输入：nums = [1,2,3,1]
 * 输出：true
 * 输入：nums = [1,2,3,4]
 * 输出：false
 * 输入：nums = [1,1,1,3,3,4,3,2,4,2]
 * 输出：true
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * @Author Administrator
 * @Date 2023/2/22 19:45
 * @Version 1.0.0
 */
public class ContainDuplicate {
    //hash表
    public static  boolean containsDuplicate(int[] nums) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i : nums){
            if(map.containsKey(i)){
                return true;
            }else {
                map.put(i,1);
            }
        }
        return false;
    }
    //hash表2
    public static boolean containsDuplicate2(int[]nums){
        Set<Integer> set = new HashSet<Integer>();
        for(int i : nums){
           if(!set.add(i)){
               return true;
           }
        }
        return false;
    }
    //排序
    public static boolean containsDuplicate3(int[]nums){
        Arrays.sort(nums);
        for(int i = 0 ; i < nums.length - 1; i++){
            if(nums[i] == nums[i + 1]){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[]nums0 = {1,2,3,1};
        int[]nums1 = {1,2,3,4};
        int[]nums2 = {1,1,13,3,4,3,2,4,2};
//        boolean b0 = containsDuplicate(nums0);
//        boolean b1 = containsDuplicate(nums1);
//        boolean b2 = containsDuplicate(nums2);
//        boolean b0 = containsDuplicate2(nums0);
//        boolean b1 = containsDuplicate2(nums1);
//        boolean b2 = containsDuplicate2(nums2);
        boolean b0 = containsDuplicate3(nums0);
        boolean b1 = containsDuplicate3(nums1);
        boolean b2 = containsDuplicate3(nums2);
        System.out.println(b0);
        System.out.println(b1);
        System.out.println(b2);

    }
}

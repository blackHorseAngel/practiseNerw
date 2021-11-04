package Aigo;

import java.util.HashMap;
import java.util.Map;

/**
 *@Desprition https://leetcode-cn.com/problems/two-sum/
 * 给定一个整数数组nums和一个整数目标值target在该数组中找出和为目标值target的那两个整数并返回数组下标。
 *@Author zhangshenming
 *@Date 2021/8/29 20:29
 *@Version 1.0
 */
public class IntegerAdd {
    /**
     *@Description 两数相加，双层循环
     *@Author zhangshenming
     *@Param nums, target
     *@Date 2021/8/29 20:39
     *@Return int[]
     */
    public static int[] twoSum1(int[] nums, int target) {
        int[]arr = new int[2];
        for(int i = 0;i<=nums.length-1;i++){
            for(int j = i+1;j <=nums.length-1;j++){
                if(nums[i]+nums[j]==target){
                    arr[0] = i;
                    arr[1] = j;
                }
            }
        }
        return arr;
    }
    /**
     *@Description 将整个数组放在一个map中，key为数组中的值，value为数组中每个值对应的下标，
     * 使用target-其中一个数看是否在map中，如果在，取出对应的value
     *@Author zhangshenming
     *@Param array, target
     *@Date 2021/8/31 19:48
     *@Return int[]
     */
    public static int[]twoSum2(int[]nums,int target){
        int[]arr = new int[2];
        int key = 0;
        Map<Integer,Integer>map = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            key = target-nums[i];
            if(map.containsKey(key)){
                arr[0] = i;
                arr[1] = map.get(key);
            }
            map.put(nums[i],i);
        }
        return arr;
    }
    public static void main(String[] args) {
//        int[]array = {2,7,9,13,15};
        int[]array = {3,3};
        int[]arr = new int[2];
//        arr = twoSum1(array,17);
        arr = twoSum2(array,6);
        for (int i:arr) {
            System.out.println(i);
        }
    }
}

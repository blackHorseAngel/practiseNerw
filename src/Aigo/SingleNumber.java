package Aigo;

import java.util.HashMap;
import java.util.Map;

/**
 *@Desprition https://leetcode-cn.com/problems/single-number/
 * 给定一个非空整数数组,除了某个元素只出现一次以外,其余每个元素均出现两次.找出那个只出现了一次的元素.
 * 你的算法应该具有线性时间复杂度.
 *@Author zhangshenming
 *@Date 2021/10/3 10:23
 *@Version 1.0
 */
public class SingleNumber {
    /**
     *@Description
     *@Author zhangshenming
     *@Param nums
     *@Date 2021/10/3 10:23
     *@Return int
     */
    public static int findSingleNumber(int[] nums) {
        int num = 0;
        if(nums.length == 0){
            return 0;
        }
        for(int i : nums){
            num ^=i;
        }
        return num;
    }
    /**
     *@Description 空间换时间，创建一个map用来接收每个数字的出现次数
     *@Author zhangshenming
     *@Param nums
     *@Date 2021/10/5 21:59
     *@Return int
     */
    public static int findSingleNumber2(int[]nums){
        //如果数组为空，直接返回0
        if(nums.length == 0){
            return 0;
        }
        //如果数组长度是1，直接返回数组中的这个元素
        if(nums.length == 1){
            return nums[0];
        }
        Map<Integer, Integer>map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else{
                map.put(nums[i],1);
            }
        }
        int temp = 0;
        for (int i:map.keySet()) {
            temp = map.get(i);
            if(temp == 1){
                return i;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
//        int[]nums = {1,2,2};
        int[]nums = {4,1,2,1,2};
//        int num1 = findSingleNumber(nums);
//        System.out.println("不重复的那个数是：" + num1);
        int num2 = findSingleNumber2(nums);
        System.out.println("不重复的那个数是：" + num2);
    }
}

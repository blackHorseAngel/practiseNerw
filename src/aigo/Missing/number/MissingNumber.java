package aigo.Missing.number;

import java.util.HashSet;
import java.util.Set;

/**
 *@Desprition 给定一个包含[0,n]中n个数的数组nums,找出[0,n]这个范围内没有出现在数组中的那个数。nums中的所有数字都独一无二
 * 输入：nums=[3,0,1]
 * 输出：2
 * 解释：n=3，因为有3个数字,所以所有的数字都在范围[0,3]内.2是丢失的数字,因为它没有出现在nums中。
 * 输入：nums=[0,1]
 * 输出：2
 * 解释：n=2,因为有2个数字,所以所有的数字都在范围[0,2]内.2是丢失的数字,因为它没有出现在nums中。
 * 输入：nums=[9,6,4,2,3,5,7,0,1]
 * 输出：8
 * 解释：n=9,因为有9个数字,所以所有的数字都在范围[0,9]内.8是丢失的数字,因为它没有出现在nums中。
 * 输入：nums=[0]
 * 输出：1
 * 解释：n=1,因为有1个数字,所以所有的数字都在范围[0,1]内.1是丢失的数字,因为它没有出现在nums中。
 *@Author zhangshenming
 *@Date 2021/11/17 19:31
 *@Version 1.0
 */
public class MissingNumber {
    /**
     *@Description
     *@Author zhangshenming
     *@Param nums
     *@Date 2021/11/17 19:34
     *@Return int
     */
    public int missingNumber(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0 ; i < nums.length ; i++){
            set.add(nums[i]);
        }
        for(int i = 0 ; i < nums.length ; i++){
            if(!set.contains(i)){
                return i;
            }
        }
        return nums.length;
    }

    public static void main(String[] args) {
        int[]nums1 = {3,0,1};
        int[]nums2 = {};
        MissingNumber missingNumber = new MissingNumber();
        int number = missingNumber.missingNumber(nums1);
        System.out.println("缺失的数字是：" + number);

    }
}

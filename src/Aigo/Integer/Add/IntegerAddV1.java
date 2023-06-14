package Aigo.Integer.Add;

import static Aigo.util.Print.printArray;

/**
 *@Desprition https://leetcode-cn.com/problems/two-sum/
 * 给定一个整数数组nums和一个整数目标值target在该数组中找出和为目标值target的那两个整数并返回数组下标。
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * 只会存在一个有效答案
 *@Author zhangshenming
 *@Date 2021/8/29 20:29
 *@Version 1.0
 */
public class IntegerAddV1 extends IntegerAddSuper {
    /**
     *@Description 两数相加，双层循环
     *@Author zhangshenming
     *@Param nums, target
     *@Date 2021/8/29 20:39
     *@Return int[]
     */
    public int[] twoAdd(int[] nums, int target) {
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

    public static void main(String[] args) {
        //[1,2]
//        int[]array = {2,7,9,13,15};
//        int target = 9;
        //[0,1]
//        int[]array = {3,3};
//        int target = 6;
        //[1,2]
        int[]array = {3,2,4};
        int target = 6;
        IntegerAddV1 integerAddV1 = new IntegerAddV1();
        int[]arr = integerAddV1.twoAdd(array,target);
        printArray(arr);
    }
}

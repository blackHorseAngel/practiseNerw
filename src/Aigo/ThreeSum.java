package Aigo;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description https://leetcode.cn/problems/3sum
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足
 * nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 解释：
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 * 注意，输出的顺序和三元组的顺序并不重要。
 * 输入：nums = [0,1,1]
 * 输出：[]
 * 解释：唯一可能的三元组和不为 0 。
 * 输入：nums = [0,0,0]
 * 输出：[[0,0,0]]
 * 解释：唯一可能的三元组和为 0 。
 * 3 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 *  @Author Administrator
 * @Date 2023/3/1 15:41
 * @Version 1.0.0
 */
public class ThreeSum {
    //数组遍历
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>>sumList = new ArrayList<>();
        List<Integer>numList = null;
        int temp = 0;
        for(int i = 0 ; i < nums.length ; i++){
            for (int j = i + 1 ; j < nums.length ; j++){
                for(int k = j + 1 ; k < nums.length ; k++){
                    numList = new ArrayList<>();
                    temp = nums[i] + nums[j];
                    if(temp + nums[k] == 0){
                        numList.add(nums[i]);
                        numList.add(nums[j]);
                        numList.add(nums[k]);
                        sumList.add(numList);
                    }
                }
            }
        }
        return sumList;
    }

    public static void main(String[] args) {
        int[]nums = new int[]{-1,0,1,2,-1,4};
//        int[]nums = new int[]{0,0,0};
//        int[]nums = new int[]{0,1,1};
        List<List<Integer>>sumList = threeSum(nums);
        for(List<Integer>list:sumList){
            for(int i : list){
                System.out.print(i);
                System.out.print("   ");
            }
            System.out.println();
        }
    }
}

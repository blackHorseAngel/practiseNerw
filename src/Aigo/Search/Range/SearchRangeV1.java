package Aigo.Search.Range;

import static Aigo.util.Print.printArray;

/**
 * @Description
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回[-1, -1]。
 * 你必须设计并实现时间复杂度为O(log n)的算法解决此问题。
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 *
 * @Author Administrator
 * @Date 2023/2/24 9:16
 * @Version 1.0.0
 */
public class SearchRangeV1 extends SearchRangeSuper {
    //数组遍历
    public int[]searchRange(int[]nums,int target){
        if(nums.length == 0){
            return new int[]{-1,-1};
        }
        int[]index = new int[2];
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] == target){
                index[0] = i;
                break;
            }
        }
        for(int j = nums.length - 1 ; j > 0 ; j--){
            if(nums[j] == target){
                index[1] = j;
                break;
            }
        }
        if(index[0] == 0 && index[1] == 0){
            index[0] = -1;
            index[1] = -1;
        }
        return index;
    }





    public static void main(String[] args) {

//        int[]nums = {5,7,7,8,8,10};
//        int[]nums = {};
//        int[]nums = {6,6,6,6,6,6};
//        int[]nums = {1};
//        int[]nums = {1,3};
//        int[]nums = {1,2,3};
        int[]nums ={2,2};
        int target = 2;
        SearchRangeV1 searchRangeV1 = new SearchRangeV1();
        int[]result = searchRangeV1.searchRange(nums,target);
        printArray(result);
    }
}

package Aigo.Search.Range;

import static Aigo.util.Print.printArray;

/**
 * @Description
 * @Author Administrator
 * @Date 2023/6/14 17:37
 * @Version 1.0.0
 */
public class SearchRangeV3 extends SearchRangeSuper{
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0){
            return new int[]{-1,-1};
        }
        int leftIndex = binarySearch(nums,target,0);
        int rightIndex = 0;
        if(leftIndex < 0){
            return new int[]{-1,-1};
        }else{
            rightIndex =  binarySearch(nums,target,leftIndex + 1);
            if(rightIndex == -1){
                rightIndex = leftIndex;
            }
            return new int[]{leftIndex,rightIndex} ;
        }
    }

    /**
     *
     * @param nums
     * @param target
     * @param index
     * @return
     */
    private int binarySearch(int[]nums,int target,int index){
        int left = index;
        int right = nums.length-1;
        int middle = -1;
        int comparasion = -1;
        while(left <= right){
            middle = (right-left)/2 + left;
            comparasion = comparatorResult(nums,target,middle);
            if(comparasion == 0){
                break;
            }else if(comparasion > 0){
                right = middle - 1;
            }else{
                left = middle + 1;
            }
        }
        return middle;
    }

    /**
     *
     * @param nums
     * @param target
     * @param index
     * @return
     */
    private int comparatorResult(int[] nums, int target, int index) {
        if(index >= 1 && index < nums.length-1){
            if(nums[index] > target){
                return 1;
            }else if(nums[index] < target){
                return -1;
            }else{
                return 0;
            }
        }
        return -1;
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
        SearchRangeV3 searchRangeV3 = new SearchRangeV3();
        int[]result = searchRangeV3.searchRange(nums,target);
        printArray(result);
    }
}

package Aigo.Search.Range;

import static Aigo.util.Print.printArray;

/**
 * @Description
 * @Author Administrator
 * @Date 2023/6/14 17:35
 * @Version 1.0.0
 */
public class SearchRangeV2 extends SearchRangeSuper{
    /**
     * 二分查找法
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0){
            return new int[]{-1,-1};
        }
        int leftIndex = binarySearchForLeft(nums,target,0);
        int rightIndex = 0;
        if(leftIndex < 0){
            return new int[]{-1,-1};
        }else{
            rightIndex =  binarySearchForRight(nums,target,leftIndex + 1);
            if(rightIndex == -1){
                rightIndex = leftIndex;
            }
            return new int[]{leftIndex,rightIndex} ;
        }
    }
    private int comparatorLeft(int[]nums,int target,int index){
        if(nums[index] == target){
            if((index-1) >= 0 && (nums[index-1] < target)){
                return 0;
            }else if(index == 0){
                return 0;
            }else{
                return 1;
            }
        }else if (nums[index] < target){
            return -1;
        }else{
            return 1;
        }
    }

    /**
     *
     * @param nums
     * @param target
     * @param index
     * @return
     */
    private int binarySearchForRight(int[]nums,int target,int index) {
        int left = index;
        int right = nums.length - 1;
        int middle = 0;
        int comparasionRight = 0;
        while (left <= right) {
            middle = (right - left) / 2 + left;
            /**
             *
             * f返回0，  表示找到了
             * 返回 -1 ， 需要需要往左找
             * 返回1， 需要往右找
             * */
            comparasionRight =comparatorRight(nums,target,middle);
            if (comparasionRight > 0) {
                right = middle - 1;
            } else if (comparasionRight < 0) {
                left = middle + 1;
            }else if (comparasionRight == 0){
                return middle;
            }
        }
        return -1;
    }

    /**
     *
     * @param nums
     * @param target
     * @param index
     * @return
     */
    private int binarySearchForLeft(int[]nums,int target,int index){
        int left = index;
        int right = nums.length-1;
        int middle = 0;
        int comparasionLeft = 0;
        while(left <= right){
            middle = (right -left)/2 + left;
            comparasionLeft = comparatorLeft(nums,target,middle);
            if(comparasionLeft > 0){
                right = middle - 1;
            }else if(comparasionLeft < 0){
                left = middle + 1;
            }else{
                return middle;
            }
        }
        return -1;
    }

    /**
     *
     * @param nums
     * @param target
     * @param index
     * @return
     */
    private int comparatorRight(int[]nums,int target,int index){
        if (nums[index] == target){
            if(((index+1) <= nums.length-1) && (nums[index+1] > target)) {
                return 0;
            }else  if(index == nums.length-1){
                return 0;
            }else{
                return -1;
            }
        }else if(nums[index] > target){
            return 1;
        }else{
            return -1;
        }
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
        SearchRangeV2 searchRangeV2 = new SearchRangeV2();
        int[]result = searchRangeV2.searchRange(nums,target);
        printArray(result);
    }
}

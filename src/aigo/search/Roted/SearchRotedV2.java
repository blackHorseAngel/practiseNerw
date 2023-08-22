package aigo.search.Roted;

/**
 * @Description
 * @Author Administrator
 * @Date 2023/6/14 17:43
 * @Version 1.0.0
 */
public class SearchRotedV2 extends SearchRotedSuper{
    /**
     * 二分法查找
     * @param nums
     * @param target
     * @return
     */
    public int search(int[]nums,int target){
        if(nums.length == 1){
            if(nums[0] == target){
                return 0;
            }else{
                return -1;
            }
        }else if(nums.length == 2){
            if(nums[0] == target){
                return 0;
            }else if(nums[1] == target){
                return 1;
            }else{
                return -1;
            }
        }
        int maxIndex = getMaxIndex(nums);
        int leftIndex = binarySearch(nums,target,0,maxIndex);
        int rightIndex = 0;
        if(leftIndex != -1){
            return leftIndex;
        }else{
            rightIndex = binarySearch(nums,target,maxIndex+1,nums.length-1);
            if(rightIndex != -1){
                return rightIndex;
            }
        }
        return -1;
    }

    /**
     * 获取到数组单调增的最高点的数字值所对应的下标
     * @param nums
     * @return
     */
    private int getMaxIndex(int[]nums) {
        for(int i = 0 ; i < nums.length ; i++){
            int temp = 0;
            if((i + 1) < nums.length){
                temp = nums[i+1] - nums[i];
                if(temp < 0){
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     *
     * @param nums
     * @param target
     * @param start
     * @param end
     * @return
     */
    private int binarySearch(int[]nums,int target,int start,int end){
        int left = start;
        int right = end;
        int middle = 0;
        while(left <= right){
            middle = (right - left)/2 + left;
            if(nums[middle] > target){
                right = middle - 1;
            }else if(nums[middle] < target){
                left = middle + 1;
            }else{
                return middle;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
//        int[]nums = {1};
//        int[]nums = {1,2};
//        int[]nums = {2,3,1};
//        int[]nums = {3,1,2};
        int[]nums = {1,3,5};
        int target = 0;
//        int[]nums = {4,5,6,7,0,1,2};
        SearchRotedV2 searchRotedV2 = new SearchRotedV2();
        int index = searchRotedV2.search(nums,target);
        System.out.println(index);
    }
}

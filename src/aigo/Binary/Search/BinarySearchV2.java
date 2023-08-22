package aigo.Binary.Search;

/**
 * @Description
 * @Author Administrator
 * @Date 2023/6/13 19:17
 * @Version 1.0.0
 */
public class BinarySearchV2 extends BinarySearchSuper{
    public  int search(int[]nums,int target){
        int left = 0;
        int right = nums.length-1;
        int middle = 0;
        while(left <= right){
            middle = (right - left)/2 + left;
            int comparasion = comparator(nums,target,middle);
            if(comparasion > 0){
                right = middle -1;
            }else if (comparasion < 0){
                left = middle + 1;
            }else{
                return middle;
            }
        }
        return -1;
    }

    /**
     * 重写比较器
     * @param nums
     * @param target
     * @param index
     * @return
     */
    public static int comparator(int[]nums,int target,int index){
        if(index >= 0 && index < nums.length){
            if(nums[index] > target){
                return 1;
            } else if (nums[index] < target) {
                return -1;
            }else{
                return 0;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        //4
//        int[]nums = {-1,0,3,5,9,12};
//        int target = 9;
        //-1
        int[]nums = {-1,0,3,5,9,12};
        int target = 2;
        BinarySearchV2 binarySearchV2 = new BinarySearchV2();
        int num = binarySearchV2.search(nums,target);
        System.out.println(num);
    }
}

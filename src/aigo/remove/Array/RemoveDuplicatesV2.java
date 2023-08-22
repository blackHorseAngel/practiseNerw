package aigo.remove.Array;

/**
 * @Description
 * @Author Administrator
 * @Date 2023/6/14 13:46
 * @Version 1.0.0
 */
public class RemoveDuplicatesV2 extends RemoveArraySuper{
    //
    public int removeDuplicates(int[]nums){
        int temp = Integer.MIN_VALUE;
        int count = 0;

        for(int i = 0 ; i < nums.length ; i++){
            while(temp == nums[i] && temp != nums[nums.length-1]){
                //TODO 从i+1开始到nums结束往前移动i
                moveOne(i,nums);
            }
            temp = nums[i];
        }
        for(int j = 0 ; j < nums.length ; j++){
            if(nums[j] == nums[nums.length-1]){
                break;
            }
            count++;
        }
        return count+1 ;
    }
    /**
     *
     * @param i
     * @param nums
     */
    private static void moveOne(int i, int[] nums) {
        for(int k = i + 1 ; k < nums.length ; k++){
            nums[k-1] = nums[k];
        }
    }
    public static void main(String[] args) {
        //2
//        int[] nums = {1,1,2};
        //5
        int[]nums = {0,0,1,1,1,2,2,3,3,4};
        RemoveDuplicatesV2 removeDuplicatesV2 = new RemoveDuplicatesV2();
        int count = removeDuplicatesV2.removeDuplicates(nums);
        System.out.println(count);
    }
}

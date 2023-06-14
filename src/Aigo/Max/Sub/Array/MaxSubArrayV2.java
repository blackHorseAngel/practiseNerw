package Aigo.Max.Sub.Array;

/**
 * @Description
 * @Author Administrator
 * @Date 2023/6/14 13:03
 * @Version 1.0.0
 */
public class MaxSubArrayV2 extends MaxSubArraySuper{
    /**
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[]nums){
        int[][]matrix = matrix(nums);
        int max = 0;
        for(int i = 0 ; i < matrix.length ; i++){
            for(int j = i ; j < matrix.length ; j++){
                max = Math.max(max,matrix[i][j]);
            }
        }
        return max;
    }
    private int[][]matrix(int[]nums){
        int[][]matrix = new int[nums.length][nums.length];
        for (int i = 0 ; i < nums.length ; i++){
            int sum = 0;
            for (int j = i ; j < nums.length ; j++){
                sum += nums[j];
                matrix[i][j] = sum;
            }
        }
        return matrix;
    }
    public static void main(String[] args) {
        MaxSubArrayV2 maxSubArrayV2 = new MaxSubArrayV2();
//        int[]array0 = {4,-1,2,1};
//        int max0 = maxSubArrayV1.maxSubArray(array0);
//        System.out.println(max0);
//        int[]array1 = {-2,1,-3,4,-1,2,1,-5,4};
//        int max1 = maxSubArrayV1.maxSubArray(array1);
//        int max1 = maxSubArray2(array1);
//        System.out.println(max1);
//        int[]array2 = {5,4,-1,7,8};
//        int max2 = maxSubArrayV1.maxSubArray(array2);
//        int max2 = maxSubArrayV1.maxSubArray2(array2);
//        System.out.println(max2);
        int[]nums = {-1};
        int max3 = maxSubArrayV2.maxSubArray(nums);
        System.out.println(max3);
    }
}

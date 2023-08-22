package aigo.Product.exception;

import static aigo.util.Print.printArray;

/**
 * @Description
 * @Author Administrator
 * @Date 2023/6/14 14:07
 * @Version 1.0.0
 */
public class ProductExcepSelfV3 extends ProduceExceptionSuper{
    /**
     *
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[]answer = new int[length];
        int placeHolder = 1;
        for(int i = length - 1 ; i >= 0 ; i--){
            if(i == length - 1){
                answer[i] = placeHolder;
            }else{
                answer[i] = nums[i + 1] * answer[i + 1];
            }
        }
        for(int i = 0 ; i < length ; i++){
            if (i == 0) {
                answer[i] *= placeHolder;
            }else {
                placeHolder *= nums[i-1];
                answer[i] *= placeHolder;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        ProductExceptSelfV1 productExceptSelfV1 = new ProductExceptSelfV1();
        //[24,12,8,6]
        int[]nums1 = {1,2,3,4};
        int[]answer1 = productExceptSelfV1.productExceptSelf(nums1);
        printArray(answer1);
        //[0,0,9,0,0]
        int[]nums2 = {-1,1,0,-3,3};
        int[]answer2 = productExceptSelfV1.productExceptSelf(nums2);
        printArray(answer2);
    }
}

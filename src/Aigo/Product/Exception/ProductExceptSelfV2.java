package Aigo.Product.Exception;

import static Aigo.util.Print.printArray;

/**
 * @Description
 * @Author Administrator
 * @Date 2023/6/14 14:05
 * @Version 1.0.0
 */
public class ProductExceptSelfV2 extends ProduceExceptionSuper{
    /**
     * 采用1个临时数组，一个用来保存当前数组中数字在它前面的全部数字之积，用结果数组answer保存当前数组中数字在它后面的全部数字之积，
     * 结果数组answer等于这两个数组对应下标之积
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[]beforeTarget = new int[length];
        int[]answer = new int[length];
        int placeHolder = 1;
        for(int i = 0 ; i < nums.length ; i++){
            if(i == 0){
                beforeTarget[i] = placeHolder;
            }else{
                beforeTarget[i] = nums[i - 1] *  beforeTarget[i - 1];
            }
        }
        for(int i = length - 1 ; i >= 0 ; i--){
            if(i == length - 1){
                answer[i] = placeHolder;
            }else{
                answer[i] = nums[i + 1] * answer[i + 1];
            }
        }
        for(int i = 0 ; i < length ; i++){
            answer[i] *= beforeTarget[i];
        }
        return answer;
    }
    public static void main(String[] args) {
        ProductExceptSelfV2 productExceptSelfV2 = new ProductExceptSelfV2();
        //[24,12,8,6]
        int[]nums1 = {1,2,3,4};
        int[]answer1 = productExceptSelfV2.productExceptSelf(nums1);
        printArray(answer1);
        //[0,0,9,0,0]
        int[]nums2 = {-1,1,0,-3,3};
        int[]answer2 = productExceptSelfV2.productExceptSelf(nums2);
        printArray(answer2);
    }
}

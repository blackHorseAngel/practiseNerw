package aigo.sorted.Square;

import static aigo.util.Print.printArray;

/**
 * @Description
 * @Author Administrator
 * @Date 2023/6/14 18:21
 * @Version 1.0.0
 */
public class SortedSquareArrayV2 extends SortedSquareArraySuper{
    /**
     *@Description 排序平方后的数组中的元素，方法二采用双指针，即前后指针，用来遍历数组
     *@Author zhangshenming
     *@Param nums
     *@Date 2021/8/30 19:44
     *@Return int[]
     */
    public int[] sortedSquares(int[] nums) {
        int[]arr = new int[nums.length];
        for(int i = 0,j = nums.length-1 , pos = nums.length - 1 ; i <= j ; pos--){
            if(nums[i] * nums[i] > nums[j] * nums[j]){
                arr[pos] = nums[i] * nums[i];
                i++;
            }else{
                arr[pos] = nums[j] * nums[j];
                j--;
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        int[]nums = {-4,-1,0,3,10};
        SortedSquareArrayV2 sortedSquareArrayV2 = new SortedSquareArrayV2();
        int[]result = sortedSquareArrayV2.sortedSquares(nums);
        printArray(result);
    }
}

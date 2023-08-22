package aigo;

/**
 * @desprition 选择排序方法
 * @version 1.0
 * @date 2021-10-04 11:09
 * @author 86185
 */
public class SelectedSort {
    /**
     *@Description 选择排序方法具体实现
     *@Author zhangshenming
     *@Param nums
     *@Date 2021/10/4 11:10
     *@Return int[]
     */
    public static int[]selected(int[]nums){
        if(nums.length == 0 || nums.length == 1){
            return nums;
        }else{
            int temp = 0;
            for(int i = 0;i < nums.length;i++){
                int minIndex = i;
                for(int j = i+1;j < nums.length;j++){
                    if(nums[j] < nums[minIndex]){
                        temp = nums[minIndex];
                        nums[minIndex] = nums[j];
                        nums[j] = nums[minIndex];
                    }
                }

            }
        }
        return nums;
    }
    public static void main(String[] args) {
        int[]nums = {1,5,4,7,6,9};
        int[]arr = selected(nums);
        System.out.println("排序后的数组中的元素顺序是：");
        for(int i:arr){
            System.out.println(i);
        }
    }
}

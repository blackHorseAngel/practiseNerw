package aigo;

import static aigo.util.Print.printArray;

/**
 *@Desprition 归并排序
 *@Author zhangshenming
 *@Date 2021/10/5 16:59
 *@Version 1.0
 */
public class MergeSort {
    public static void mergeSort(int[]nums){
        int length = nums.length;
        if(length == 0){
            System.out.println("数组为空");
        }
        if(length == 1){
            System.out.println("数组中只有一个元素");
        }
        int left = 0;
        int right = length-1;
        part(nums,left,right);
    }
    /**
     *@Description 对数组从中间开始进行拆分，一直拆分到每个小数组只有两个数字，即不能再分为止
     *@Author zhangshenming
     *@Param nums
     *@Date 2021/10/5 17:00
     *@Return void
     */
    public static void part(int[]nums,int left,int right){
        if(left == right){
            return;
        }
        int middle = left + ((right-left)>>1);
        part(nums,left,middle);
        part(nums,middle+1,right);
        merge(nums,left,middle,right);
    }
    /**
     *@Description
     *@Author zhangshenming
     *@Param nums, left, middle, right
     *@Date 2021/10/5 17:08
     *@Return void
     */
    private static void merge(int[]nums,int left,int middle,int right) {
        int[]array = new int[right-left+1];
        int p = left;
        int q = middle + 1;
        int i = 0;
        while(p <= middle && q <= right){
            if(nums[p] >= nums[q]){
                array[i] = nums[q];
                q++;
            }else{
                array[i] = nums[p];
                p++;
            }
            i++;
        }
        while(p <= middle){
            array[i] = nums[p];
            i++;
            p++;
        }
        while(q <= right){
            array[i] = nums[q];
            i++;
            q++;
        }
        for(int j = 0;j < array.length;j++){
            nums[j] = array[j];
        }
        printArray(nums);
    }

    public static void main(String[] args) {
//        int[]nums = initArray(5);
        int[]nums = {1,3,5,4,2};
        mergeSort(nums);
    }
}

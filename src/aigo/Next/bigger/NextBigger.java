package aigo.Next.bigger;

import static aigo.util.Print.printArray;

/**
 *@Desprition https://leetcode-cn.com/problems/next-greater-element-i/
 *给你两个没有重复元素的数组nums1和nums2,其中nums1是nums2的子集.找出nums1中每个元素在nums2中的下一个比其大的值。
 *nums1中数字x的下一个更大元素是指x在nums2中对应位置的右边的第一个比x大的元素.如果不存在,对应位置输出-1。
 *@Author zhangshenming
 *@Date 2021/9/10 23:45
 *@Version 1.0
 */
public class NextBigger extends NextBiggerSuper {
   /**
    *@Description
    *@Author zhangshenming
    *@Param nums1, nums2
    *@Date 2021/9/10 23:47
    *@Return int[]
    */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[]arr = new int[nums1.length];
        if(nums1.length == 0 || nums2.length == 0){
            return null;
        }
        for(int i = 0;i < nums1.length;i++) {
            for(int k = 0;k < nums2.length;k++){
                if(nums1[i] == nums2[k]){
                    for(int j = k;j < nums2.length;j++){
                        if(j+1 >= nums2.length){
                            arr[i] = -1;
                        }else{
                            if(nums2[j+1] > nums1[i]){
                                arr[i] = nums2[j+1];
                                break;
                            }
                        }
                    }
                }
                if(arr[i] != 0){
                    break;
                }
            }
        }
        return arr;
    }
    public static void main(String[] args) {
       int[]arr1 = {4,1,2};
       int[]arr2 = {1,3,4,2};
//        int[]arr1 = {3,1,7,9,2,6};
//        int[]arr2 = {1,2,11,3,9,6,7};
        NextBigger nextBigger = new NextBigger();
        int[]result = nextBigger.nextGreaterElement(arr1,arr2);
        if(result == null){
           System.out.println("null");
        }else{
           printArray(result);
        }
    }
}

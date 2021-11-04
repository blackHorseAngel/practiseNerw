package Aigo;

import java.util.Arrays;

import static Aigo.util.Init.initArray;
import static Aigo.util.Print.printArray;

/**
 *@Desprition https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 * 给定两个大小分别为m和n的正序从小到大数组nums1和nums2.请你找出并返回这两个正序数组的中位数.
 *@Author zhangshenming
 *@Date 2021/8/31 22:22
 *@Version 1.0
 */
public class FindMedia {
    /**
     *@Description 直接合并用Arrays进行排序
     *@Author zhangshenming
     *@Param nums1, nums2
     *@Date 2021/8/31 22:23
     *@Return double
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double mid = 0.0;
        if(nums1.length == 0 && nums2.length == 0){
            return 0;
        }
        if(nums1.length == 0){
            if(nums2.length%2 == 0){
                mid = (nums2[nums2.length/2-1]+nums2[nums2.length])/2;
            }else{
                mid = nums2[nums2.length/2];
            }
            return mid;
        }
        if(nums2.length ==0){
            if(nums1.length%2 == 0){
                mid = (nums1[nums1.length-1]+nums1[nums1.length])/2;
            }else{
                mid = nums1[nums1.length/2];
            }
            return mid;
        }
        int[]arr = new int[nums1.length+ nums2.length];
        for(int i = 0;i < nums1.length;i++){
            arr[i] = nums1[i];
        }
        for(int j=0;j < nums2.length;j++){
            arr[nums1.length+j] = nums2[j];
        }
        Arrays.sort(arr);
        if(arr.length%2 == 0){
            mid = (arr[arr.length/2-1]+arr[arr.length])/2;
        }else{
            mid = arr[arr.length/2];
        }
        return mid;
    }
    public static void main(String[] args) {
        int[]nums1 = initArray(3);
        printArray(nums1);
        int[]nums2 = initArray(3);
        printArray(nums2);
        double a = findMedianSortedArrays(nums1,nums2);
        System.out.println(a);
    }
}

package aigo.find.Middle.Number;

import java.util.Arrays;

/**
 *@Desprition https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 * 给定两个大小分别为m和n的正序从小到大数组nums1和nums2.请你找出并返回这两个正序数组的中位数.
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 *@Author zhangshenming
 *@Date 2021/8/31 22:22
 *@Version 1.0
 */
public class FindMediaV1 extends FindMediaSuper {
    /**
     *@Description 直接合并用Arrays进行排序,暴力法
     *@Author zhangshenming
     *@Param nums1, nums2
     *@Date 2021/8/31 22:23
     *@Return double
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double mid = 0.0;
        if(nums1.length == 0 && nums2.length == 0){
            return 0;
        }
        if(nums1.length == 0){
            if(nums2.length%2 == 0){
                mid = (nums2[nums2.length / 2 - 1] + nums2[nums2.length]) / 2;
            }else{
                mid = nums2[nums2.length / 2];
            }
            return mid;
        }
        if(nums2.length == 0){
            if(nums1.length % 2 == 0){
                mid = (nums1[nums1.length-1] + nums1[nums1.length]) / 2;
            }else{
                mid = nums1[nums1.length / 2];
            }
            return mid;
        }
        int[]arr = new int[nums1.length + nums2.length];
        for(int i = 0 ; i < nums1.length ; i++){
            arr[i] = nums1[i];
        }
        for(int j = 0 ; j < nums2.length ; j++){
            arr[nums1.length + j] = nums2[j];
        }
        Arrays.sort(arr);
        if(arr.length % 2 == 0){
            mid = (arr[arr.length / 2 - 1] + arr[arr.length]) / 2;
        }else{
            mid = arr[arr.length / 2];
        }
        return mid;
    }
    public static void main(String[] args) {
        FindMediaV1 findMediaV1 = new FindMediaV1();
        //2.0
//        int[]nums1 = {1,3};
//        int[]nums2 = {2};
        //2.5
        int[]nums1 = {1,2};
        int[]nums2 = {3,4};
        double middle = findMediaV1.findMedianSortedArrays(nums1,nums2);
        System.out.println(middle);
    }
}

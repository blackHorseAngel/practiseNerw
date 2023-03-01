package Aigo;

import java.util.Arrays;

/**
 * @Description https://leetcode.cn/problems/merge-sorted-array/
 * 给你两个按 非递减顺序 排列的整数数组nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，
 * 其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 *输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 解释：需要合并 [1,2,3] 和 [2,5,6] 。
 * 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
 *输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 * 解释：需要合并 [1] 和 [] 。
 * 合并结果是 [1] 。
 * 输入：nums1 = [0], m = 0, nums2 = [1], n = 1
 * 输出：[1]
 * 解释：需要合并的数组是 [] 和 [1] 。
 * 合并结果是 [1] 。
 * 注意，因为 m = 0 ，所以 nums1 中没有元素。nums1 中仅存的 0 仅仅是为了确保合并结果可以顺利存放到 nums1 中。
 *
 * @Author Administrator
 * @Date 2023/2/23 17:54
 * @Version 1.0.0
 */
public class Merge {
    //利用Arrays.sort方法
    public static void merge1(int[]nums1,int m,int[]nums2,int n){
        if(nums2.length == 0 || n == 0){
           return;
        }
        for(int i = 0 ; i < n ; i++){
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
        for(int i : nums1){
            System.out.println(i);
        }
    }
    //数组遍历，同向双指针,需要新建过渡数组
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        if(n == 0 || nums2.length == 0){
            return;
        }
        int[]temp = new int[m + n];
        int p1 = 0;
        int p2 = 0;
        int cur = 0;
        while(p1 < m || p2 < n){
            cur = p1 + p2;
            if(p1 == m){
                temp[cur] = nums2[p2];
                p2++;
            }else if(p2 == n){
                temp[cur] = nums1[p1];
                p1++;
            }else if(nums1[p1] < nums2[p2]){
                temp[cur] = nums1[p1];
                p1++;
            }else{
               temp[cur] = nums2[p2];
               p2++;
            }
        }
        nums1 = temp;
        for(int i : nums1){
            System.out.println(i);
        }
    }
  //数组遍历，反向双指针，建立过渡数组
    public static void main(String[] args) {
        int[]nums1 = {1,2,4};
        int[]nums2 = {2,5,6};
//        merge1(nums1,3,nums2,3);
//        int[]nums1 = {0};
//        int[]nums2 = {1};
//        int[]nums1 = {1,2,4,7};
//        int[]nums2 = {3,6,8};
        merge2(nums1,3,nums2,3);
    }
}

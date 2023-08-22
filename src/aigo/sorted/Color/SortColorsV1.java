package aigo.sorted.Color;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description https://leetcode.cn/problems/sort-colors
 * 给定一个包含红色、白色和蓝色、共n 个元素的数组nums，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 我们使用整数 0、1 和 2 分别表示红色、白色和蓝色。
 * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 * 输入：nums = [2,0,1]
 * 输出：[0,1,2]
 * n == nums.length
 * 1 <= n <= 300
 * nums[i] 为 0、1 或 2
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 * @Author Administrator
 * @Date 2023/6/1 19:25
 * @Version 1.0.0
 */
public class SortColorsV1 extends SortColorsSuper {
    /**
     * 通过3个list，每一个对应一种颜色的球，最后一个list是结果集
     * @param nums
     */
    public void sortColors(int[] nums) {
        //对应数字0
        List<Integer> redList = new ArrayList<>();
        //对应数字1
        List<Integer> whiteList = new ArrayList<>();
        //对应数字2
        List<Integer> blueList = new ArrayList<>();

        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] == 0){
                redList.add(nums[i]);
            }else if(nums[i] == 1){
                whiteList.add(nums[i]);
            }else{
                blueList.add(nums[i]);
            }
        }
        //创建结果集
        List<Integer>resultList = new ArrayList<>();
        resultList.addAll(redList);
        resultList.addAll(whiteList);
        resultList.addAll(blueList);
        for(int i = 0 ; i < resultList.size() ; i++){
            nums[i] = resultList.get(i);
        }
    }

    public static void main(String[] args) {
        SortColorsV1 sortColors = new SortColorsV1();
        int[][]nums = new int[2][];
        int[]nums1 = {2,0,2,1,1,0};
        int[]nums2 = {2,0,1};
        nums[0] = nums1;
        nums[1] = nums2;
        for(int i = 0 ; i < nums.length ; i++){
                sortColors.sortColors(nums[i]);
                for(int a:nums[i]){
                    System.out.print(a);
                    System.out.print("  ");
                }
        }
    }
}

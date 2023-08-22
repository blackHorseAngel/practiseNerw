package aigo.remove.Array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * 说明：
 * 为什么返回数值是整数，但输出的答案是数组呢？
 * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 * 你可以想象内部操作如下:
 * // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
 * int len = removeDuplicates(nums);
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
 * for (int i = 0; i < len; i++) {
 *  print(nums[i]);
 * }
 *输入：nums = [1,1,1,2,2,3]
 * 输出：5, nums = [1,1,2,2,3]
 * 解释：函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。 不需要考虑数组中超出新长度后面的元素。
 *
 * 输入：nums = [0,0,1,1,1,1,2,3,3]
 * 输出：7, nums = [0,0,1,1,2,3,3]
 * 解释：函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为0, 0, 1, 1, 2, 3, 3 。 不需要考虑数组中超出新长度后面的元素。
 *
 * 1 <= nums.length <= 3 * 104
 * -104 <= nums[i] <= 104
 * nums 已按升序排列
 * @Author Administrator
 * @Date 2023/5/16 16:31
 * @Version 1.0.0
 */
public class RemoveDuplicates2 extends RemoveArraySuper {
    /**
     * 同向双指针
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        if(length == 1){
            return length;
        }
        int p = 0;
        int q = 0;
        int count = 1;
        int deleteTime = 0;
        Map<Integer,Integer>countMap = new HashMap<>();
            while(q <= length - 1 - deleteTime){
                if(nums[p] != nums[q]){
                    p++;
                }else{
                    if(countMap.containsKey(nums[p])){
                        count = count + 1;
                    }else{
                        count = 1;
                    }
                   countMap.put(nums[p],count);
                   int value = countMap.get(nums[p]);
                    if(value > 2){
                        deleteTime++;
                      moveOne(q,nums);
                    }else{
                        q++;
                    }
            }
        }
            for(int i = 0 ; i < length - deleteTime ; i++){
                System.out.println(nums[i]);
            }
        return nums.length-deleteTime;
    }
    private static void moveOne(int i, int[] nums) {
        for(int k = i + 1 ; k < nums.length ; k++){
            nums[k-1] = nums[k];
        }
    }

    public static void main(String[] args) {
        //5
//        int[]nums1 = {1,1,1,2,2,3};
        //7
        int[]nums2 = {0,0,1,1,1,1,2,3,3};
        //2
//        int[]nums3 = {1,1,1};
        RemoveDuplicates2 removeDuplicates2 = new RemoveDuplicates2();
        int num = removeDuplicates2.removeDuplicates(nums2);
        System.out.println(num);
    }
}

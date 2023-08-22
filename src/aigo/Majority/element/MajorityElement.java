package aigo.Majority.element;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description https://leetcode.cn/problems/majority-element
 * 给定一个大小为 n 的数组nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于n/2的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * 输入：nums = [3,2,3]
 * 输出：3
 * 输入：nums = [2,2,1,1,1,2,2]
 * 输出：2
 * n == nums.length
 * 1 <= n <= 5 * 104
 * -109 <= nums[i] <= 109
 *  @Author Administrator
 * @Date 2023/5/18 12:35
 * @Version 1.0.0
 */
public class MajorityElement extends MajorityElementSuper{
    /**
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int length = nums.length / 2;
        if(length == 0){
            return 0;
        }
        Map<Integer,Integer> countMap = new HashMap<>();
        for (int i : nums){
            if(countMap.containsKey(i)){
                countMap.put(i, countMap.get(i) + 1);
                int value = countMap.get(i);
                if(value > length){
                    return i;
                }
            }else{
                countMap.put(i,1);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        //3
        int[]nums1 = {3,2,3};
        //2
        int[]nums2 = {2,2,2,1,1,1,2,2};
        MajorityElement majorityElement = new MajorityElement();
        int num = majorityElement.majorityElement(nums2);
        System.out.println(num);
    }
}

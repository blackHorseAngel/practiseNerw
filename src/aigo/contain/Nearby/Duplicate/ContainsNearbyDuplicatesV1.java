package aigo.contain.Nearby.Duplicate;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description https://leetcode.cn/problems/contains-duplicate-ii
 * 给你一个整数数组nums和一个整数k ，判断数组中是否存在两个 不同的索引i和j ，
 * 满足 nums[i] == nums[j] 且 abs(i - j) <= k 。如果存在，返回 true ；否则，返回 false 。
 * 输入：nums = [1,2,3,1], k = 3
 * 输出：true
 * 输入：nums = [1,0,1,1], k = 1
 * 输出：true
 * 输入：nums = [1,2,3,1,2,3], k = 2
 * 输出：false
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * 0 <= k <= 105
 * @Author Administrator
 * @Date 2023/7/3 18:47
 * @Version 1.0.0
 */
public class ContainsNearbyDuplicatesV1 extends ContainsNearbyDuplicatesSuper{
    @Override
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                int index = map.get(nums[i]);
                if(Math.abs(i - index) <= k){
                    return true;
                }else{
                    map.put(nums[i],i);
                }
            }else{
                map.put(nums[i],i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsNearbyDuplicatesV1 containsNearbyDuplicatesV1 = new ContainsNearbyDuplicatesV1();
        //true
//        int[]nums = {1,2,3,1};
//        int k = 3;
        //true
//        int[]nums = {1,0,1,1};
//        int k = 1;
        //false
        int[]nums = {1,2,3,1,2,3};
        int k = 2;
        boolean flag = containsNearbyDuplicatesV1.containsNearbyDuplicate(nums,k);
        System.out.println(flag);
    }
}

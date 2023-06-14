package Aigo.Contain.Duplicate;

import java.util.Arrays;

/**
 * @Description
 * @Author Administrator
 * @Date 2023/6/13 19:50
 * @Version 1.0.0
 */
public class ContainDuplicateV3 extends ContainDuplicateSuper {
    /**
     * 排序
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[]nums){
        Arrays.sort(nums);
        for(int i = 0 ; i < nums.length - 1; i++){
            if(nums[i] == nums[i + 1]){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[]nums0 = {1,2,3,1};
        int[]nums1 = {1,2,3,4};
        int[]nums2 = {1,1,13,3,4,3,2,4,2};
        ContainDuplicateV3 containDuplicateV3 = new ContainDuplicateV3();
        boolean b0 = containDuplicateV3.containsDuplicate(nums0);
        boolean b1 = containDuplicateV3.containsDuplicate(nums1);
        boolean b2 = containDuplicateV3.containsDuplicate(nums2);
        System.out.println(b0);
        System.out.println(b1);
        System.out.println(b2);

    }
}

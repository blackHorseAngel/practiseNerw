package Aigo.Contain.Duplicate;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description
 * @Author Administrator
 * @Date 2023/6/13 19:47
 * @Version 1.0.0
 */
public class ContainDuplicateV2 extends ContainDuplicateSuper{
    /**
     * hash表2
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[]nums){
        Set<Integer> set = new HashSet<Integer>();
        for(int i : nums){
            if(!set.add(i)){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[]nums0 = {1,2,3,1};
        int[]nums1 = {1,2,3,4};
        int[]nums2 = {1,1,13,3,4,3,2,4,2};
        ContainDuplicateV2 containDuplicateV2 = new ContainDuplicateV2();
        boolean b0 = containDuplicateV2.containsDuplicate(nums0);
        boolean b1 = containDuplicateV2.containsDuplicate(nums1);
        boolean b2 = containDuplicateV2.containsDuplicate(nums2);
//        boolean b0 = containsDuplicate3(nums0);
//        boolean b1 = containsDuplicate3(nums1);
//        boolean b2 = containsDuplicate3(nums2);
        System.out.println(b0);
        System.out.println(b1);
        System.out.println(b2);

    }
}

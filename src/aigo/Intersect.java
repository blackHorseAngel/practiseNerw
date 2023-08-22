package aigo;

import java.util.HashMap;

/**
 * @Description https://leetcode.cn/problems/intersection-of-two-arrays-ii/?envType=study-plan&id=shu-ju-jie-gou-ru-men&plan=data-structures&plan_progress=jfjr95m
 * 给你两个整数数组nums1 和 nums2 ，请你以数组形式返回两数组的交集。返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致
 * （如果出现次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 1000
 *
 * @Author Administrator
 * @Date 2023/2/27 19:30
 * @Version 1.0.0
 */
public class Intersect {
    //
    public static int[] intersect(int[] nums1, int[] nums2) {
      int length1 = nums1.length;
      int length2 = nums2.length;
      int[]temp1 = null;
      int[]temp2 = null;
      StringBuilder builder = new StringBuilder();
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        if(length1 > length2){
          temp1 =nums1;
          temp2 = nums2;
      }else{
          temp1 = nums2;
          temp2 = nums1;
      }
        for(int i = 0 ; i < temp1.length ; i++){
            if(map.containsKey(temp1[i])){
                map.put(temp1[i],map.get(temp1[i])+1);
            }else{
                map.put(temp1[i],1);
            }
        }
        for(int j = 0 ; j < temp2.length ; j++){
            if(map.containsKey(temp2[j]) && (map.get(temp2[j]) != 0)){
               builder.append(temp2[j]);
               builder.append(",");
                map.put(temp2[j],map.get(temp2[j])-1);
            }
        }
        String str = builder.toString();
        int[]result = null;
        if(str.length() != 0){
            str = str.substring(0,str.length()-1);
            String[]ss = str.split(",");
            result = new int[ss.length];
            for(int i = 0 ; i < ss.length ; i++){
                result[i] = Integer.parseInt(ss[i]);
            }
        }else{
            return new int[]{};
        }

        return result;
    }

    public static void main(String[] args) {
//        int[]nums1 = {1,2,2,1};
//        int[]nums2 = {2,2};
//        int[]nums1 = {4,9,5};
//        int[]nums2 = {9,4,9,8,4};
//        int[]nums1 = {3,1,2};
//        int[]nums2 = {1,1};
//        int[]nums1 = {1,2,2,1};
//        int[]nums2 = {1,1};
        int[]nums1 = {4,3,9,3,1,9,7,6,9,7};
        int[]nums2 = {5,0,8};
        int[]result = intersect(nums1,nums2);
        for(int i : result){
            System.out.println(i);
        }

    }
}

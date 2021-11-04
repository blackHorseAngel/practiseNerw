package Aigo;
import java.util.*;
/**
 *@Desprition 一个数组中只有两个元素出现了奇数次，其他元素都出现偶数次，找出这两个元素
 *@Author zhangshenming
 *@Date 2021/10/4 11:32
 *@Version 1.0
 */
public class SingleNumber3 {
    /**
     *@Description 找到只出现奇数次的数
     *@Author zhangshenming
     *@Param nums
     *@Date 2021/10/4 11:34
     *@Return int[]
     */
    public static int[]finsSingleNumber(int[]nums){
        int[]arr = new int[2];
        int num = 0;
        for(int i = 0;i < nums.length;i++){
            num ^= nums[i];
        }
        //提取出不为0的数字的位数中最右侧的1
        int rightOne = num & (~num + 1);
        int onlyOne = 0;
        for(int j = 0;j < nums.length;j++){
            if((j & rightOne) == 1){
                onlyOne ^= nums[j];
            }
        }
        arr[0] = onlyOne;
        arr[1] = num ^ onlyOne;
        return arr;
    }
    /**
     *@Description 空间换时间，新增一个map用来统计每个数字出现的次数
     *@Author zhangshenming
     *@Param nums
     *@Date 2021/10/5 21:42
     *@Return int[]
     */
    public static int[]findSingleNUmber2(int[]nums){
        int[]array = new int[2];
        int temp = 0;
        Map<Integer, Integer>map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else{
                map.put(nums[i],1);
            }
        }
        for(int i:map.keySet()){
            temp = map.get(i);
            if(temp%2 == 0){
               continue;
            }else{
                if(array[0] == 0){
                    array[0] = i;
                }else{
                    array[1] = i;
                }
            }
        }
        return array;
    }
    public static void main(String[] args) {
        int[]nums = {1,3,2,2,2,2,4,4,4,4,6,6,6,6,5,5,5,5,7,7};
//        int[]arr = finsSingleNumber(nums);
        int[]arr = findSingleNUmber2(nums);
        System.out.println("找到的该数组中的出现一次的数字是：");
        for(int i = 0;i < arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}

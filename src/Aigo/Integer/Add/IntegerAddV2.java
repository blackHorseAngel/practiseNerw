package Aigo.Integer.Add;

import java.util.HashMap;
import java.util.Map;

import static Aigo.util.Print.printArray;

/**
 * @Description
 * @Author Administrator
 * @Date 2023/6/13 18:56
 * @Version 1.0.0
 */
public class IntegerAddV2 extends IntegerAddSuper{
    /**
     *@Description 将整个数组放在一个map中，key为数组中的值，value为数组中每个值对应的下标，
     * 使用target-其中一个数看是否在map中，如果在，取出对应的value
     *@Author zhangshenming
     *@Param array, target
     *@Date 2021/8/31 19:48
     *@Return int[]
     */
    public  int[]twoAdd(int[]nums,int target){
        int[]arr = new int[2];
        int key = 0;
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0 ; i < nums.length ; i++){
            key = target - nums[i];
            if(map.containsKey(key)){
                arr[0] = i;
                arr[1] = map.get(key);
            }
            map.put(nums[i],i);
        }
        return arr;
    }
    public static void main(String[] args) {
        //[1,2]
//        int[]array = {2,7,9,13,15};
//        int target = 9;
        //[0,1]
//        int[]array = {3,3};
//        int target = 6;
        //[1,2]
        int[]array = {3,2,4};
        int target = 6;
        IntegerAddV2 integerAddV2 = new IntegerAddV2();
        int[]arr = integerAddV2.twoAdd(array,target);
        printArray(arr);
    }
}

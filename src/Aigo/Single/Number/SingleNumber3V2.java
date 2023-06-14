package Aigo.Single.Number;

import java.util.HashMap;
import java.util.Map;

import static Aigo.util.Print.printArray;

/**
 * @Description
 * @Author Administrator
 * @Date 2023/6/14 17:19
 * @Version 1.0.0
 */
public class SingleNumber3V2 extends SingleNumberSuper {
    /**
     *@Description 空间换时间，新增一个map用来统计每个数字出现的次数
     *@Author zhangshenming
     *@Param nums
     *@Date 2021/10/5 21:42
     *@Return int[]
     */
    public int[]findSingleNumberArray(int[]nums){
        int[]array = new int[2];
        int temp = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
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
        SingleNumber3V2 singleNumber3V2 = new SingleNumber3V2();
        int[]result = singleNumber3V2.findSingleNumberArray(nums);
        printArray(result);
    }
}

package Aigo.Integer.Add;

import static Aigo.util.Print.printArray;

/**
 * @Description
 * @Author Administrator
 * @Date 2023/6/13 19:05
 * @Version 1.0.0
 */
public class IntegerAdd2V2 extends IntegerAddSuper{
    /**
     *@Description 前后双指针
     *@Author zhangshenming
     *@Param numbers, target
     *@Date 2021/8/31 20:59
     *@Return int[]
     */
    public int[]twoAdd(int[]numbers,int target){
        int[]arr = new int[2];
        int low = 0;
        int high = numbers.length-1;
        int sum = 0;
        while(low < high){
            sum = numbers[low] + numbers[high];
            if(sum > target){
                high--;
            }else if(sum < target){
                low++;
            }else if(sum == target){
                arr[0] = low + 1;
                arr[1] = high + 1;
                break;
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        //[1,3]
//        int[]array = {2,3,4};
//        int target = 6;
        //[1,2]
//        int[]array = {2,7,11,15};
//        int target = 9;
        //[1,2]
        int[]array = {-1,0};
        int target = -1;
        IntegerAdd2V2 integerAdd2V2 = new IntegerAdd2V2();
        int[]arr = integerAdd2V2.twoAdd(array,target);
        printArray(arr);
    }
}

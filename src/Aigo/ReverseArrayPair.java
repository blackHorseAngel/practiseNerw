package Aigo;

/**
 *@Desprition 一个数组中如果左边的数比右边的数大,则这俩个数构成一个逆序对,打印一个数组中的所有这样的逆序对
 *@Author zhangshenming
 *@Date 2021/10/5 22:34
 *@Version 1.0
 */
public class ReverseArrayPair {
    /**
     *@Description
     *@Author zhangshenming
     *@Param nums
     *@Date 2021/10/5 22:36
     *@Return void
     */
    public static void findReverseArray(int[]nums){
        if(nums.length < 2){
            System.out.println("该数组中不存在这样的逆序对");
            return;
        }
        //变量a，用来判断当数组的长度大于2的时候且该数组中没有逆序对，在程序结束前打印无逆序对这句话
        int a = 0;
        //计数器，打印的时候用来计算有几对这样的逆序对
        int count = 0;
        for(int i = 0;i < nums.length-1;i++){
            if(nums[i] > nums[i+1]){
                a = nums[i+1];
                System.out.println("该数组中存在这样的逆序对,第"+(++count)+"对:["+nums[i]+","+nums[i+1]+"]");
            }
        }
        if(a == 0){
            System.out.println("该数组中不存在这样的逆序对");
        }
    }
    public static void main(String[] args) {
        //数组中的元素个数分别为0,1,2
//        int[]nums = {};
//        int[]nums = {1};
//        int[]nums = {1,2};
//        int[]nums = {2,1};
        //数组中的元素格个数为多个且存在多对逆序对,5
        int[]nums = {1,2,1,9,3,7,6,8,5,4};
        findReverseArray(nums);
    }
}

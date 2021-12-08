package Aigo;
/**
 *@Desprition 给定一个正整数num,编写一个函数,如果num是一个完全平方数,则返回true,否则返回false。
 * 进阶：不要使用任何内置的库函数，如  sqrt 。
 *输入：num = 16
 * 输出：true
 * 输入：num = 14
 * 输出：false
 *@Author zhangshenming
 *@Date 2021/11/17 11:34
 *@Version 1.0
 */
public class validSqrt {
    /**
     *@Description 数学开根号
     *@Author zhangshenming
     *@Param num
     *@Date 2021/11/17 11:37
     *@Return boolean
     */
    public static boolean isPerfectSquare1(int num){
        int a = (int) Math.sqrt(num);
        if(num == a * a){
            return true;
        }
        return false;
    }
    /***
     *@Description
     *@Author zhangshenming
     *@Param num
     *@Date 2021/11/17 14:41
     *@Return boolean
     */
    public static boolean isPerfectSquare2(int num) {
        for(int i = 1,square = 0;square < num;i++) {
            square = i * i;
            if (num == square) {
                return true;
            }
        }
        return false;
    }
    /**
     *@Description 使用二分法
     *@Author zhangshenming
     *@Param num
     *@Date 2021/11/17 14:53
     *@Return boolean
     */
    public static boolean isPerfectSquare3(int num){
        long start = 0;
        long end = num;
        long middle = 0;
        long square = 0;
        int count = 0;
        while(start <= end){
            count++;
            middle = (end - start)/2 + start;
            square = middle * middle;
            if(square < num){
                start = middle + 1;
            }else if(square > num){
                end = middle - 1;
            }else{
                System.out.println("count:" + count);
                return true;
            }
        }
        System.out.println("count:" + count);
        return false;
    }
    public static void main(String[] args) {
        int num = 2147483647;
        boolean flag = isPerfectSquare3(num);
        System.out.println(flag);

//        int[]num = {1,10,100,1000,10000,100000,1000000,10000000,100000000,100000000,2000000000,
//                2100000000,2140000000,2147000000,2147400000,2147480000,2147483000,2147483600,2147483640,2147483646};
//        boolean flag = false;
//        for(int i:num){
//            flag = isPerfectSquare3(i);
//            System.out.println("i:" + i + " 是否是完全平方数：" + flag);
//        }
    }
}

package aigo.reverse.Integer;

/**
 * @Description https://leetcode.cn/problems/reverse-integer
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围[−231, 231− 1] ，就返回 0。
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 * 输入：x = 123
 * 输出：321
 * 输入：x = -123
 * 输出：-321
 * 输入：x = 120
 * 输出：21
 * 输入：x = 0
 * 输出：0
 * -231 <= x <= 231 - 1
 * @Author Administrator
 * @Date 2023/3/13 16:23
 * @Version 1.0.0
 */
public class ReverseIntegerV1 extends ReverseIntegerSuper {
    //求余数方法
    public int reverse(int x) {
        int result = reverseInt(x);
        return result;
    }
    private int reverseInt(int x) {
        int sum = 0;
        int result = 0;
        while(x != 0) {
            result = x % 10;
            if (sum > 0) {
                if (Integer.MAX_VALUE / sum < 10) {
                    return 0;
                }else{
                    if(result > Integer.MAX_VALUE - sum * 10 ){
                        return 0;
                    }
                }
            } else if(sum < 0) {
                if (Integer.MIN_VALUE / Math.abs(sum) > -10) {
                    return 0;
                }else{
                    if(result < Integer.MIN_VALUE - sum * 10){
                        return 0;
                    }
                }
            }
            sum = sum * 10 + result;
            x = x / 10;
        }
        return sum;
    }
    public static void main(String[] args) {
        //321
//        int a = 123;
        //-321
//        int a = -123;
        //21
//        int a = 120;
        //0
//        int a = 0;
        //0
//        int a = Integer.MAX_VALUE;
        //0
//        int a = Integer.MIN_VALUE;
        //0
//        int a = 1534236469;
        //-109
        int a = -901000;
        ReverseIntegerV1 reverseIntegerV1 = new ReverseIntegerV1();
        int result =reverseIntegerV1.reverse(a);
        System.out.println(result);
    }
}

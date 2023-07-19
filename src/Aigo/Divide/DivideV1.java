package Aigo.Divide;

/**
 * @Description https://leetcode.cn/problems/divide-two-integers
 * 给你两个整数，被除数dividend和除数divisor。将两数相除，要求 不使用 乘法、除法和取余运算。
 * 整数除法应该向零截断，也就是截去（truncate）其小数部分。例如，8.345 将被截断为 8 ，-2.7335 将被截断至 -2 。
 * 返回被除数dividend除以除数divisor得到的 商 。
 * 注意：假设我们的环境只能存储 32 位 有符号整数，其数值范围是 [−231, 231− 1] 。本题中，如果商 严格大于 231− 1 ，则返回 231− 1 ；如果商 严格小于 -231 ，则返回 -231 。
 *
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 解释: 10/3 = 3.33333.. ，向零截断后得到 3 。
 *
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 解释: 7/-3 = -2.33333.. ，向零截断后得到 -2 。
 *
 * -231 <= dividend, divisor <= 231 - 1
 * divisor != 0
 *
 * @Author Administrator
 * @Date 2023/3/31 14:23
 * @Version 1.0.0
 */
public class DivideV1 extends DivideSuper {
    //
    public int divide(int dividend, int divisor) {
        if(dividend == 0){
            return 0;
        }
        //被除数的符号位
        int signForDivedend = 0;
        //除数的符号位
        int signFordivisor = 0;
        if(dividend < 0){
            signForDivedend = -1;
        }
        if(divisor < 0){
            signFordivisor = -1;
        }
        int count= 1;
        int calculator = dividend - divisor;
//        while(){
//
//        }

        return 0;
    }

    public static void main(String[] args) {
//        3
//        int dividend = 10;
//        int divisor = 3;
//        int num = divide(dividend,divisor);
//        -2
        int dividend = 7;
        int divisor = -3;
        DivideV1 divide = new DivideV1();
        int num = divide.divide(dividend,divisor);
        System.out.println(num);

    }

}

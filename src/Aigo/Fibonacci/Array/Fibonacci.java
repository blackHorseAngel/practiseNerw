package Aigo.Fibonacci.Array;

/**
 *@Desprition https://leetcode.cn/problems/fibonacci-number
 * 斐波那契数列 通常用F(n) 表示）形成的序列称为 斐波那契数列 。该数列由0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * F(0) = 0，F(1)= 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * 给定n ，请计算 F(n) 。
 * 输入：n = 2
 * 输出：1
 * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1
 * 输入：n = 3
 * 输出：2
 * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2
 * 输入：n = 4
 * 输出：3
 * 解释：F(4) = F(3) + F(2) = 2 + 1 = 3
 * 0 <= n <= 30
 *@Author zhangshenming
 *@Date 2021/8/31 21:40
 *@Version 1.0
 */
public class Fibonacci {
    /**
     *@Description 循环操作
     *@Author zhangshenming
     *@Param n
     *@Date 2021/8/31 21:52
     *@Return int
     */
    public static int fib1(int n){
        int a = 1;
        int b = 0;
        int sum = 0;
        for(int i = 2;i <= n;i++){
           sum = a + b;
            b = sum-b;
            a = sum;
        }
        return sum;
    }
    /**
     *@Description 递归操作
     *@Author zhangshenming
     *@Param n
     *@Date 2021/8/31 21:41
     *@Return int
     */
    public static int fib(int n){
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 1;
        }
       return fib(n - 1)+fib(n - 2);
    }
    public static void main(String[] args) {
        int a = 0;
//        a = fib(8);
        a = fib1(8);
        System.out.println(a);
    }
}

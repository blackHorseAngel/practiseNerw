package Aigo;

/**
 *@Desprition 斐波那契数列
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

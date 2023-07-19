package Aigo.Fibonacci.Array;

import java.util.Set;

/**
 * @Description
 * @Author Administrator
 * @Date 2023/4/1 23:31
 * @Version 1.0.0
 */
public class Fibonacci2 {

    /**
     * 斐波那契数列的最终项fib(n) = fib(n-1) + fib(n-2),打印每一项，需要避免重复项，
     * 只需要打印数列的前n-2项，第n-1项和第n项
     * @param n
     * @return
     */
    public static int fib(int n){
        //这是程序的总入口
        if(n == 1 || n == 2){
            System.out.println("第" + n + "个数是：" + 1);
            return 1;
        }
        int num2 = calAndPrint(n-2);
        int num1 = cal(n-1);
        System.out.println("第" + (n-1) + "个数是：" + num1);
        int sum  = num1 + num2;
        System.out.println("第" + n + "个数是：" + sum);
        return sum;
    }

    /**
     * 计算前n-1项
     * @param n
     * @return
     */
    public static int cal(int n){
        if(n == 1 || n == 2){
            return 1;
        }
        int num2 = cal(n-2);
        int num1 = cal(n-1);
        int sum = num1 + num2;
        return sum;
    }

    /**
     * 计算并打印前n-2项
     * @param n
     * @return
     */
    public static int calAndPrint(int n){
        int num1 = 0;
        int num2 = 0;
        if(n == 1){
            System.out.println("第" + n + "个数是：" + 1);
            return 1;
        } else if (n == 2) {
            System.out.println("第1个数是：" + 1);
            System.out.println("第" + n + "个数是：" + 1);
            return 1;
        } else{
            num2 = calAndPrint(n-2);
            num1 = cal(n-1);
        }
        System.out.println("第" + (n-1) + "个数是：" + num1);
        int sum = num1 + num2;
        System.out.println("第" + n + "个数是：" + sum);
        return sum;
    }
    public static int fib2(int n,Set<Integer>set){
        if(n == 1 || n == 2){
            return 1;
        }
        int num2 = fib2(n - 2,set);
        int num1 = fib2(n - 1,set);
        int sum = 0;
        sum = num1 + num2;
        if(!set.contains(n)){
            set.add(n);
            System.out.println(sum);
        }
        return sum;
    }
    public static void main(String[] args) {
        //1,1,2,3,5,8,13,21,34,55,89,144,233,377,610
        int n = 55;
        System.out.println(fib(n));
    }
}

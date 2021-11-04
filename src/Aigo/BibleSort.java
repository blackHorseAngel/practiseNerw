package Aigo;/**
 * @description
 * @author 86185
 * @date 2021/9/17 13:33
 * @see 1.0.0
 */

import java.math.BigInteger;
import java.util.Scanner;

import static Aigo.util.Print.printArray;

/**
 *@Desprition TODO
 *@Author zhangshenming
 *@Date 2021/9/17 13:33
 *@Version 1.0
 */
public class BibleSort {
    public static void main1(String[] args) {
        int[] array = {1, 4, 3, 9, 6, 5};
        int a = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[j] >= array[i]) {
                    a = array[j];
                    array[j] = array[i];
                    array[i] = a;
                }
            }
        }
//        printArray(array);
    }

    public static void main2(String[] args) {
        int[] array = {1, 4, 3, 9, 6, 5};
        int a = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] >= array[j + 1]) {
                    a = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = a;
                }
            }
            printArray(array);
        }
    }
    public static int f1(int n){
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 1;
        }
        if(n == 3){
            return 2;
        }
        return f1(n-1)+f1(n-2)+f1(n-3)+f1(n-4);
    }
    public static void f2(long n){
        BigInteger d = new BigInteger("0");
        BigInteger c = new BigInteger("1");
        BigInteger b = new BigInteger("1");
        BigInteger a = new BigInteger("2");
        BigInteger sum = new BigInteger("0");
        System.out.println("第1个数是：1");
        System.out.println("第2个数是：1");
        System.out.println("第3个数是：2");
        for(int i=4;i <= n;i++){
            sum = a.add(b).add(c).add(d);
            switch(i%4){
                case 0:d = sum;
                       break;
                case 1:c = sum;
                       break;
                case 2:b = sum;
                       break;
                case 3:a = sum;
                       break;
                default:;
            }
            System.out.println("第"+i+"个数字是："+sum);
        }
    }
    public static void f3(long n,int m){
        BigInteger sum = new BigInteger("0");
        BigInteger[]nums = new BigInteger[m];
        nums[0] = new BigInteger("0");
        for(int k = 1;k < m;k++){
            nums[k] = new BigInteger("1");
            System.out.println("第"+k+"个数是："+nums[k]);
        }
        for(int i=m;i <= n;i++){
            for(int j = 0;j < m;j++){
                sum = sum.add(nums[j]);
            }
            nums[i%m] = sum;
            System.out.println("第"+i+"个数字是："+sum);
        }
    }
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      System.out.println("请输入方法需要的数字n：");
      long n = scanner.nextLong();
      System.out.println("n="+n);
//      f2(n);
      f3(n,4);
    }
}

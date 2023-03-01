package Aigo4;

import java.io.IOException;

/**
 * @Description
 * @Author Administrator
 * @Date 2023/2/16 17:33
 * @Version 1.0.0
 */
public class Chapter1_1 {
    //1.1.3
    public static void outEqual() throws IOException {
        System.out.println("请输入3个数字：");
        int a = System.in.read();
        System.out.println("a:" + a);
        int b = System.in.read();
        System.out.println("b:" + b);
        int c = System.in.read();
        System.out.println("c:" + c);
        if(a==b && a==c && b==c){
            System.out.println("equal");
        }else{
            System.out.println("not equal");
        }
    }
    //1.1.5
    public  static void judge(double x,double y){
        boolean flagX = x > 0 && x < 1;
        boolean flagY = y > 0 && y < 1;
        if(flagX && flagY){
            System.out.println(true);
        }else {
            System.out.println(false);
        }
    }
    //1.1.6
    public static void printNumber(){
        int f = 0;
        int g = 1;
        for(int i = 0 ; i <= 15 ; i++){
            System.out.println(f);
            f = f + g;
            g = f - g;
        }
    }
    //1.1.7.a
    public static void print7A(){
        double t = 9.0;
        while(Math.abs(t - 9.0/t) > 0.001){
            t = (9.0/t + t )/2.0;
            System.out.printf("%.5f\n",t);
        }
        System.out.printf("%.5f\n",t);
    }
    //1.1.7.b
    public static void print7B(){
        int sum = 0;
        for(int i = 1 ; i < 1000 ; i++){
            for(int j = 0; j < i ; j++){
                sum++;
            }
        }
        System.out.println(sum);
    }
    //1.1.7.c
    public static void print7C(){
        int sum = 0;
        for(int i = 1 ; i < 1000 ; i *= 2){
            for(int j = 0 ; j < 1000 ; j++){
                sum++;
            }
        }
        System.out.println(sum);
    }
    //1.1.8
    public static void  print8(){
        System.out.println('b');
        System.out.println('b' + 'c');
        System.out.println((char)('a'+4));
    }
    //1.1.9
    public static String toBinary(int N){
        StringBuilder builder = new StringBuilder();
        while(N != 0){
            int a = N%2;
            N /= 2;
            builder.append(a);
        }
        builder = builder.reverse();
        String s = builder.toString();
        return s;
    }
    public static String toBinary2(int N){
        String s = "";
        for(int n = N ; n > 0;n /= 2){
            s = (n%2) + s;
        }
        return s;
    }
    //1.1.13
    public static int[][] printMatrix(int m , int n){
        int[][]matrix = new int[m][n];
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(i < j){
                    matrix[i][j] = i + j + 1;
                }else {
                    matrix[i][j] = i + j + 2;
                }

                System.out.print(matrix[i][j]);
                System.out.print("  ");
            }
            System.out.println();
        }
        return matrix;
    }
    public static void transposition(int[][]matrix){
        for(int i = 0 ; i < matrix.length ; i++){
            for(int  j = 0; j < matrix[i].length ; j++) {
                if(j > i){
                    int t = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = t;
                }
                System.out.print(matrix[i][j]);
                if(j != matrix.length - 1){
                    System.out.print("  ");
                }
            }
            if(i != matrix.length - 1){
                System.out.println();
            }
        }
    }
    //1.1.15
    public static int[]histogram(int[]a,int M){
        if(M <= 0){
            System.out.println("M的值应该大0");
            return null;
        }
        int[]arr = new int[M];
        int count = 0;
        for (int j = 0 ; j <M ; j++){
            for(int i = 0 ; i < a.length ; i++) {
                if (j == a[i] ) {
                    count++;
                }
            }
            arr[j] = count;
            count = 0;
        }
        return arr;
    }
        //1.1.16
    public static String exR1(int n){
        if(n <= 0){
            return "";
        }
        return exR1(n-3) + n + exR1(n-2) + n;
    }
    //1.1.18
    public static int mystery(int a , int b){
        if(b == 0){
            return 0;
        }
        if(b % 2 == 0){
            return mystery(a + a,b / 2);
        }
        return mystery(a + a,b / 2) + a;
    }
    public static int newMystery(int a , int b){
        if(b == 0){
            return 1;
        }
        if(b % 2 == 0){
            return newMystery(a * a,b / 2);
        }
        return newMystery(a * a , b / 2) + a;
    }
    //1.1.20
    public static double getLn(int N){
        if(N == 1){
            return 0;
        }
        return Math.log(N)+getLn(N-1);
    }

    //1.1.24
    /**
     * 欧几里得算法求解最大公约数：
     * 1、给定两个正整数p，q；
     * 2、选取其中最小的数，假设是p；
     * 3、若q%p为0，那么最大公约是就是p；
     * 4、若q%p不为0，即存在余数，蒋p，q中较大的数替换为余数，重复2
     * @param p
     * @param q
     * @return
     */
    public static int euclid(int p , int q){
        if(p == 0 || q == 0){
            return 0;
        }
        if(p - q > 0){
            int temp = p;
            p = q;
            q = temp;
        }
            if(q % p == 0){
                return p;
            }else{
                 return euclid(p,q%p);
            }
    }
    //1.1.30
    public static boolean[][] getBooleanMatrix(int N){
        boolean[][]arr = new boolean[N][N];
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                if(euclid(i,j)==1){
                    arr[i][j] = true;
                }else{
                    arr[i][j] = false;
                }
            }
        }
        return arr;
    }
    public static void main(String[] args) throws IOException {
        //1.1.1
//        System.out.println((0+15)/2);
//        System.out.println(2.0e-6*100000000.1);
//        System.out.println(true&&false||true&&false);
        //1.1.2
//        System.out.println((1+2.236)/2);
//        System.out.println(1+2+3+4.0);
//        System.out.println(4.1>=4);
//        System.out.println(1+2+"3");
        //1.1.3
//        outEqual();
        //1.1.5
//        judge(0.6,0.78);
//        judge(1.0,0.9);
        //1.1.6
//        printNumber();
        //1.1.7_A
//        print7A();
        //1.1.7_B
//        print7B();
        //1.1.7_C
//        print7C();
        //1.1.8
//        print8();
        //1.1.9
//        String s = toBinary2(8);
//        System.out.println(s);
        //1.1.13
//        int[][]matrix = printMatrix(2,3);
//        System.out.println("--------------------------------------------------------");
//        transposition(matrix);
        //1.1.15
//        int[]arr = histogram(new int[]{1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5},20);
//        for(int a : arr){
//            System.out.println(a);
//        }
        //1.1.16
//        String s = exR1(6);
//        System.out.println(s);
        //1.1.18
//        int a = newMystery(2,25);
//        System.out.println(a);
//        int b = newMystery(3,11);
//        System.out.println(b);
        //1.1.20
//        double d = getLn(3);
//        System.out.println(d);
        //1.1.24
//        int a = euclid(105,24);
//        System.out.println(a);
        //1.1.30
//        boolean[][]arr = getBooleanMatrix(5);
//        for(int i = 0 ; i < arr.length ; i++){
//            System.out.println();
//            for(int j = 0 ; j < arr.length ; j++){
//                System.out.print(arr[i][j]);
//                System.out.print("  ");
//            }
//        }
    }
}

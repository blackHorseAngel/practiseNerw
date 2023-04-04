package Aigo;

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
public class ReverseInteger {
    //求余数方法
    public static int reverse(int x) {
        int result = reverseInt(x);
        return result;
    }
    private static int reverseInt(int x) {
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
    //转string
    public static int reverse2(int x){
        String s = String.valueOf(x);
        StringBuilder builder = new StringBuilder();
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(0) == '-'){
               builder.append(s.charAt(i));
            }
            builder.append(s.charAt(i));
        }
        String newStr = builder.toString();
        if(s.charAt(0) == '-'){
            if(newStr.charAt(1) > s.charAt(1)){

            }
        }else{
            if(newStr.charAt(0) > s.charAt(0)){

            }
        }

        return 0;
    }

    /**
     * 使用二进制最高位判断溢出问题
     * @param x
     * @return
     */
    public static int reverse3(int x){
        int sum = 0;
        int temp = 0;
        int result = 0;
        while(x != 0) {
            result = x % 10;
            temp = sum;
            sum = sum * 10 + result;
            //-90100这个数字在取二进制最高位的时候也是会存在问题的
            int a = Integer.highestOneBit(temp);
            int b = Integer.highestOneBit(sum);
            if(a!= b){
                return 0;
            }
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
        int result = reverse3(a);
        System.out.println(result);
//        int b = Integer.MIN_VALUE;
//        System.out.println(b/-1);

//        int a = -123;
        /*while(a>>1 != 0){
            String aToBinary = Integer.toBinaryString(a);
            System.out.println("a的二进制：" + aToBinary);
            System.out.println("数字a: " + a);
            a =  a >> 1;
        }*/
//        int b = Integer.highestOneBit(a);
//        System.out.println(b);


            /*int x = -901000;
                int ans = 0;
                while (x != 0) {
                    int pop = x % 10;
                    if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && pop > 7)){
                        System.out.println(0);
                        break;
                    }
                    if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && pop < -8)){
                        System.out.println(0);
                        break;

                    }
                    ans = ans * 10 + pop;
                    x /= 10;
                }
                System.out.println(ans);*/
            }
}

package aigo.reverse.Integer;

/**
 * @Description
 * @Author Administrator
 * @Date 2023/6/14 16:53
 * @Version 1.0.0
 */
public class ReverseIntegerV3 extends ReverseIntegerSuper{
    /**
     * 使用二进制最高位判断溢出问题
     * @param x
     * @return
     */
    public int reverse(int x){
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
        ReverseIntegerV3 reverseIntegerV3 = new ReverseIntegerV3();
        int result =reverseIntegerV3.reverse(a);
        System.out.println(result);
    }
}

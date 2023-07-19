package Aigo.Reverse.Integer;

/**
 * @Description
 * @Author Administrator
 * @Date 2023/6/14 14:25
 * @Version 1.0.0
 */
public class ReverseIntegerV2 extends ReverseIntegerSuper{
    //整数最大值的字符串
    public static final String INTEGER_MAX_STRING = "2147483647";

    public static final String INTEGER_MIN_STRING = "-2147483648";
    //整数最大值的最后一位数字
    public  static  final int INTEGER_MAX_STRING_LAST_BIT = 7;
    //整数最小值的最后一位数字
    public  static final int INTEGER_MIN_STRING_LAST_BIT = 8;
    public int reverse(int x){
        String s = String.valueOf(x);
        //用来记录正负号,默认是正号
        int flag = 1;
        StringBuilder builder = new StringBuilder();
        if(s.charAt(0) == '-'){
            flag = -1;
        }

        if(flag == 1){
            for(int i = s.length()-1 ; i >= 0 ; i--){
                builder.append(s.charAt(i));
            }
            if(builder.length() > INTEGER_MAX_STRING.length()){
                return 0;
            } else if (builder.length() < INTEGER_MAX_STRING.length()) {
                return Integer.parseInt(builder.toString());
            }else{
                //TODO 判断翻转过来的整数最大值的比较
                for(int i = 0 ; i < builder.length() ; i++){
                    int newNum = Integer.parseInt(String.valueOf(builder.charAt(i)));
                    int oldNum = Integer.parseInt(String.valueOf(s.charAt(i)));
                    if( newNum - oldNum > 0){

                    }
                }
            }
        } else {
            for(int i = s.length()-1 ; i >= 1 ; i--){
                builder.append(s.charAt(i));
            }
            if(builder.length() > INTEGER_MIN_STRING.length()){
                return 0;
            } else if (builder.length() < INTEGER_MIN_STRING.length()) {
                return Integer.parseInt(builder.toString()) * flag;
            }else{
                int lastBit = Integer.parseInt(String.valueOf(builder.charAt(builder.length()-1)));
                if(lastBit <= INTEGER_MIN_STRING_LAST_BIT){
                    return 0;
                }else{
                    return Integer.parseInt(builder.toString());
                }
            }
        }
        return 0;
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
//        int a = -901000;
        ReverseIntegerV2 reverseIntegerV2 = new ReverseIntegerV2();
        int[]nums = {123,-123,120,0,Integer.MAX_VALUE,Integer.MIN_VALUE,1534236469,-901000};
        for(int num : nums){
            int result =reverseIntegerV2.reverse(num);
            System.out.println(result);
        }
    }
}

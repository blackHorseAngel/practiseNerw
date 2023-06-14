package Aigo.Reverse.Integer;

/**
 * @Description
 * @Author Administrator
 * @Date 2023/6/14 14:25
 * @Version 1.0.0
 */
public class ReverseIntegerV2 extends ReverseIntegerSuper{
    //TODO 转string
    public int reverse(int x){
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
        ReverseIntegerV2 reverseIntegerV2 = new ReverseIntegerV2();
        int result =reverseIntegerV2.reverse(a);
        System.out.println(result);
    }
}

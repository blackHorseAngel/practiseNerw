package Aigo.Multiply.Str;

/**
 * @Description https://leetcode.cn/problems/multiply-strings
 * 给定两个以字符串形式表示的非负整数num1和num2，返回num1和num2的乘积，它们的乘积也表示为字符串形式。
 * 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 1 <= num1.length, num2.length <= 200
 * num1和 num2只能由数字组成。
 * num1和 num2都不包含任何前导零，除了数字0本身。
 *
 * @Author Administrator
 * @Date 2023/4/13 16:59
 * @Version 1.0.0
 */
public class MultiplyString extends MultiplyStrSuper{
    //
    public  String multiply(String num1, String num2) {
        if(Integer.parseInt(String.valueOf(num1.charAt(0)))== 0 || Integer.parseInt(String.valueOf(num2.charAt(0))) == 0){
            return "0";
        }
        //保证num1 >= num2
        if(num2.length() > num1.length()){
            String tempStr = "";
            tempStr = num1;
            num1 = num2;
            num2 = tempStr;
        }
        //大数 * 小数，temp记录进位的数字，result记录两个字符串，一个是每次做乘法得到的数字转化成的字符串，另一个是这次的结果和上一次的结果的相加
        int temp = 0;
        String[]result = new String[2];
        StringBuilder builder = new StringBuilder();
        for(int i = num2.length() - 1 ; i >= 0 ; i--){
            //乘法每次两个数字相乘，都会错一位，其实就是多一个0，所以只需要计算乘数的位数长度差然后补0即可
            for(int k = i ; k < num2.length() - 1 ; k++){
                builder.append(0);
            }
            int a = Integer.parseInt(String.valueOf(num2.charAt(i)));
            for(int j = num1.length() - 1 ; j >= 0 ; j--){
                int b = Integer.parseInt(String.valueOf(num1.charAt(j)));
                int multiply = a * b + temp;
                if(multiply < 10){
                    builder.append(multiply);
                    temp = 0;
                }else{
                    int ge = multiply % 10;
                    builder.append(ge);
                    multiply = multiply / 10;
                    int shi = multiply % 10;
                    temp = shi;
                }
            }
            if(temp != 0){
                builder.append(temp);
            }
            result[0] = builder.toString();
            result[1]= bigIntegerAdd(result[0],result[1]);
            builder.setLength(0);
            temp = 0;
        }
        //将stringBuilder清空
        if(builder.length() != 0){
            builder.setLength(0);
        }
        //把result[1]中的数字翻转过来
        for(int m = result[1].length() - 1 ; m >= 0 ; m--){
            builder.append(result[1].charAt(m));
        }
        String str = builder.toString();
        return str;
    }

    /**
     * 大数加法
     * @param s
     * @param s1
     * @return
     */
    private String bigIntegerAdd(String s, String s1) {
        //如果s1为空，直接返回s
        if(s1 == null || s1.length() == 0){
            return s;
        }
        //保证第一个字符串的长度不比第二个字符串的长度短,即s.length >= s1.length
        if(s.length() < s1.length()){
            String tempStr = "";
            tempStr = s;
            s = s1;
            s1 = tempStr;
        }
        // temp记录进位数，先从[0，s1.length-1]进行加法，然后从[s1.length,s.length-1]进行加法，最后补上进位数
        int temp = 0;
        StringBuilder builder = new StringBuilder();
        for(int i = 0 ; i < s1.length() ; i++) {
            int a = Integer.parseInt(String.valueOf(s1.charAt(i)));
            int b = Integer.parseInt(String.valueOf(s.charAt(i)));
            int sum1 = a + b + temp;
            if (sum1 >= 10) {
                builder.append(sum1 % 10);
                sum1 = sum1 / 10;
                temp = sum1 % 10;
            } else {
                builder.append(sum1);
                temp = 0;
            }
        }
            for(int j = s1.length() ; j < s.length() ; j++){
                int c = Integer.parseInt(String.valueOf(s.charAt(j)));
                int sum2 = c + temp;

                if(sum2 >= 10){
                    builder.append(sum2 % 10);
                    sum2 = sum2 / 10;
                    temp = sum2 % 10;
                }else{
                    builder.append(sum2 % 10);
                    temp = 0;
                }
            }
            if(temp > 0){
                builder.append(temp);
            }
        return builder.toString();
    }

    public static void main(String[] args) {
        //"6"
//        String num1 = "2";
//        String num2 = "3";
        //"56088"
//        String num1 = "123";
//        String num2 = "456";
        //"891"
//        String num1 = "9";
//        String num2 = "99";
        //"0"
//        String num1 = "9133";
//        String num2 = "0";
        //"121932631112635269"
        String num1 = "123456789";
        String num2 = "987654321";
        MultiplyString multiplyString = new MultiplyString();
        String s = multiplyString.multiply(num1,num2);
        System.out.println(s);
    }
}

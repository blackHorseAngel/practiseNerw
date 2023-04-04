package Aigo;

/**
 * @Description https://leetcode.cn/problems/integer-to-roman
 *罗马数字包含以下七种字符：I，V，X，L，C，D和M。
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做II，即为两个并列的 1。12 写做XII，即为X+II。 27 写做XXVII, 即为XX+V+II。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做IIII，而是IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为IX。这个特殊的规则只适用于以下六种情况：
 *
 * I可以放在V(5) 和X(10) 的左边，来表示 4 和 9。
 * X可以放在L(50) 和C(100) 的左边，来表示 40 和90。
 * C可以放在D(500) 和M(1000) 的左边，来表示400 和900。
 * 给你一个整数，将其转为罗马数字。
 * 输入: num = 3
 * 输出: "III"
 * 输入: num = 4
 * 输出: "IV"
 * 输入: num = 9
 * 输出: "IX"
 * 输入: num = 58
 * 输出: "LVIII"
 * 解释: L = 50, V = 5, III = 3.
 * 输入: num = 1994
 * 输出: "MCMXCIV"
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 * 1 <= num <= 3999
 * @Author Administrator
 * @Date 2023/3/23 9:57
 * @Version 1.0.0
 */
public class IntToRoman {
    //
    public static String intToRoman(int num) {
        return intToRomeAboveThousand(num,new StringBuilder()).toString();
    }
    //1~5不包含5
    private static StringBuilder intToRomeBelowFive(int num,StringBuilder builder){
        int temp = num%5;
        if(temp == 4){
            builder.append("IV");
        }else{
            for(int i = 0 ; i < num ; i++){
                builder.append("I");
            }
        }
        return builder;
    }
    //5~10不包含10
    private static StringBuilder intToRomeBetweenFiveToTen(int num,StringBuilder builder){
        int temp = num%5;
         if(temp == 4){
            builder.append("IX");
        }else{
             builder.append("V");
             num = num - 5;
             builder = intToRomeBelowFive(num,builder);
         }
        return builder;
    }
    //10~50不包含50
    private static StringBuilder intToRomeBetweenTenToFifty(int num,StringBuilder builder){
        int temp = num/10;
        if(temp == 4){
            builder.append("XL");
        }else{
            for(int i = 0 ; i < temp ; i++){
                builder.append("X");
            }
        }
            num = num - 10 * temp;
            if(num >= 5){
                builder = intToRomeBetweenFiveToTen(num,builder);
            }else{
                builder = intToRomeBelowFive(num,builder);
            }

        return builder;
    }
    //50~100不包含100
    private static StringBuilder intToRomeBetweenFiftyToHundred(int num,StringBuilder builder){
        int temp = num/10;
        if(temp == 9){
            builder.append("XC");
            num = num - 90;
        }else{
            builder.append("L");
            num = num - 50;
        }

        if(num >= 10){
            builder = intToRomeBetweenTenToFifty(num,builder);
        }else if(num >= 5){
            builder = intToRomeBetweenFiveToTen(num,builder);
        }else{
            builder = intToRomeBelowFive(num,builder);
        }
        return builder;
    }
    //100~500 不包含500
    private static StringBuilder intToRomeBetweenHundredToFiveHundred(int num,StringBuilder builder){
        int temp = num/100;
        if(temp == 4){
            builder.append("CD");
        }else{
            for(int i = 0 ; i < temp ; i++){
                builder.append("C");
            }
        }
        num = num - 100 * temp;
        if (num >= 50) {
            intToRomeBetweenFiftyToHundred(num,builder);
        }else{
            if(num >= 10){
                intToRomeBetweenTenToFifty(num,builder);
            }else{
                if(num >= 5){
                    intToRomeBetweenFiveToTen(num,builder);
                }else{
                    intToRomeBelowFive(num,builder);
                }
            }
        }
        return builder;
    }
    //500~1000 不包含1000
    private static StringBuilder intToRomeBetweenFiveHundredToThousand(int num,StringBuilder builder){
        int temp = num/100;
        if(temp == 9){
            builder.append("CM");
            num = num - 900;
        }else{
            builder.append("D");
            num = num - 500;
        }
        if(num >= 100){
            builder = intToRomeBetweenHundredToFiveHundred(num,builder);
        }else if(num >= 50){
            builder = intToRomeBetweenFiftyToHundred(num,builder);
        }else if(num >= 10){
            builder = intToRomeBetweenTenToFifty(num,builder);
        }else if(num >= 5){
           builder = intToRomeBetweenFiveToTen(num,builder);
        }else{
           builder = intToRomeBelowFive(num,builder);
        }
        return builder;
    }
    //1000+ 包含1000
    private static StringBuilder intToRomeAboveThousand(int num,StringBuilder builder){
        int temp = num/1000;
        for(int i = 0 ; i < temp ; i++){
            builder.append("M");
        }
        num = num - temp * 1000;
        if(num >= 500){
            builder = intToRomeBetweenFiveHundredToThousand(num,builder);
        }else{
            if(num >= 100){
                builder = intToRomeBetweenHundredToFiveHundred(num,builder);
            }else {
                if(num >= 50){
                    builder = intToRomeBetweenFiftyToHundred(num,builder);
                }else{
                    if(num >= 10){
                        builder = intToRomeBetweenTenToFifty(num,builder);
                    }else {
                        if(num >= 5){
                            builder = intToRomeBetweenFiveToTen(num,builder);
                        }else{
                            builder = intToRomeBelowFive(num,builder);
                        }
                    }
                }
            }
        }
        return builder;
    }
    public static void main(String[] args) {
        //"III"
//        int num = 3;
        //"IV"
//        int num = 4;
        //"V"
//        int num = 5;
        //""VI
//        int num = 8;
        //"IX"
//        int num = 9;
        //"X"
//        int num = 10;
        //"XIV"
//        int num = 14;
        //"XXXIX"
//        int num = 39;
        //"XLIV"
//        int num = 44;
        //"XLIX"
//        int num = 49;
        //"LVIII"
//        int num = 58;
        //"XCIV"
//        int num = 94;
        //"C"
//        int num = 100;
        //"CCCLXXXIX"
//        int num = 389;
        //"CCCXCIX"
//        int num = 399;
        //"CDXXXIV"
//        int num = 434;
        //"CDLXXIX"
//        int num = 479;
        //"DXLV"
//        int num = 545;
        //"MCMXCIV"
        int num = 1994;
        String s = intToRoman(num);
        System.out.println(s);
//        System.out.println(96%50);
    }

}

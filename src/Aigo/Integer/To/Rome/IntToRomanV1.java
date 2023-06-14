package Aigo.Integer.To.Rome;

import java.util.HashMap;
import java.util.Map;

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
public class IntToRomanV1 extends IntToRomeSuper{
    //
    public String intToRoman(int num) {
        return intToRomeAboveThousand(num,new StringBuilder()).toString();
    }
    //1~5不包含5
    private StringBuilder intToRomeBelowFive(int num,StringBuilder builder){
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
    private StringBuilder intToRomeBetweenFiveToTen(int num,StringBuilder builder){
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
    private StringBuilder intToRomeBetweenTenToFifty(int num,StringBuilder builder){
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
    private StringBuilder intToRomeBetweenFiftyToHundred(int num,StringBuilder builder){
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
    private StringBuilder intToRomeBetweenHundredToFiveHundred(int num,StringBuilder builder){
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
    private StringBuilder intToRomeBetweenFiveHundredToThousand(int num,StringBuilder builder){
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
    private StringBuilder intToRomeAboveThousand(int num,StringBuilder builder){
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

    /**
     * 整体放入map
     */
    public String intToRome2(int num){
        Map<Integer,String> map = generateRomeIntMap();
        StringBuilder builder = new StringBuilder();
        String result = "";
        int ge =  num/10;
        int shi =  num/100;
        int bai =  num/1000;
        int qian =  num/10000;
        result = handleQian(qian,map,num,result);
        result = handleBai(bai,map,num,result);
        result = handleShi(shi,map,num,result);
        result = handleGe(ge,map,num,result);
        String[]results = result.split(",");
        return results[0];

    }

    /**
     * 处理个位数字
     * @param ge
     * @param map
     * @param num
     * @param result
     * @return
     */
    private String handleGe(int ge,Map<Integer,String>map,int num,String result) {
        StringBuilder builder = new StringBuilder();
        if(result.length() > 0){
            String[]strings = result.split(",");
            builder.append(strings[0]);
            num = Integer.parseInt(strings[1]);
        }
        if(ge > 0){
            if(ge == 9){
                builder.append(map.get(9));
                num = num -9;
            }else if (ge >= 5 && ge < 9){
                builder.append(map.get(5));
                num = num - 5;
                ge = ge -5;
                for(int i = 0 ; i < ge ; i++){
                    builder.append(map.get(1));
                }
                num = num - 1 * ge;
            }else if(ge == 4){
                builder.append(map.get(4));
                num = num - 4;
            }else if(ge < 4){
                for(int i = 0 ; i < ge ; i++){
                    builder.append(map.get(1));
                }
                num = num - 1 * ge;
            }
            builder.append(",");
            builder.append(num);
        }
        result = builder.toString();
        return result;
    }

    /**
     * 处理十位数字
     * @param shi
     * @param map
     * @param num
     * @param result
     * @return
     */
    private String handleShi(int shi,Map<Integer,String>map,int num,String result) {
        StringBuilder builder = new StringBuilder();
        if(result.length() > 0){
            String[]strings = result.split(",");
            builder.append(strings[0]);
            num = Integer.parseInt(strings[1]);
        }
        if(shi > 0){
            if(shi == 9){
                builder.append(map.get(90));
                num = num - 90;
            } else if (shi >= 5 && shi < 9) {
                builder.append(map.get(50));
                num = num - 50;
                shi = shi - 5;
                for(int i = 0 ; i < shi ; i++){
                    builder.append(map.get(10));
                }
                num = num - 10 * shi;
            } else if ( shi == 4 ) {
                builder.append(map.get(40));
                num = num - 40;
            } else if ( shi < 4 ) {
                for(int i = 0 ; i < shi ; i++){
                    builder.append(map.get(10));
                }
                num = num - 10 * shi;
            }
            builder.append(",");
            builder.append(num);
        }
        result = builder.toString();
        return result;
    }

    /**
     * 处理百威数字
     * @param bai
     * @param map
     * @param num
     * @param result
     * @return
     */
    private String handleBai(int bai,Map<Integer,String>map,int num,String result) {
        StringBuilder builder = new StringBuilder();
        if(result.length() > 0){
            String[]strings = result.split(",");
            builder.append(strings[0]);
            num =Integer.parseInt(strings[1]);
        }
        if( bai > 0){
            if(bai == 9){
                builder.append(map.get(900));
                num = num - 900;
            } else if (bai >= 5 && bai < 9) {
                builder.append(map.get(500));
                num = num - 500;
                bai = bai - 5;
                for(int i = 0 ; i < bai ; i++){
                    builder.append(map.get(100));
                }
                num = num - 100 * bai;
            }else if( bai == 4 ) {
                builder.append(map.get(400));
                num = num -400;
            }else if( bai < 4 ){
                for(int i = 0 ; i < bai ; i++){
                    builder.append(map.get(100));
                }
                num = num - 100 * bai;
            }
            builder.append(",");
            builder.append(num);
        }
        result = builder.toString();
        return result;
    }

    /**
     * 处理前卫数字
     * @param qian
     * @param map
     * @param num
     * @param result
     * @return
     */
    private String handleQian(int qian,Map<Integer,String>map,int num,String result) {
        StringBuilder builder = new StringBuilder();
        if(qian > 0){
            for(int i = 0 ; i < qian ; i++){
                builder.append(map.get(1000));
            }
            builder.append(",");
            num = num - 1000 * qian;
            builder.append(num);
        }
        String s = builder.toString();
        return s;
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
        IntToRomanV1 intToRomanV1 = new IntToRomanV1();
        String s = intToRomanV1.intToRoman(num);
        System.out.println(s);
    }

}
